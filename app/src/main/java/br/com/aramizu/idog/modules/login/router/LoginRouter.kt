package br.com.aramizu.idog.modules.login.router

import android.content.Intent
import android.support.v4.app.FragmentActivity
import br.com.aramizu.idog.manager.SessionManager
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.modules.login.datamanager.LoginRemoteDataManager
import br.com.aramizu.idog.modules.login.interactor.LoginInteractor
import br.com.aramizu.idog.modules.login.presenter.LoginPresenter
import br.com.aramizu.idog.modules.login.repository.LoginRepository
import br.com.aramizu.idog.modules.login.view.LoginActivity
import br.com.aramizu.idog.modules.main.view.MainActivity
import com.kizitonwose.android.disposebag.DisposeBag


class LoginRouter(
        private val view: FragmentActivity
) : LoginContract.Router {

    companion object {
        fun assembleModule(view: LoginActivity) {

            val remote = LoginRemoteDataManager()
            val sessionManager = SessionManager()
            val repository = LoginRepository(remote, sessionManager)
            val interactor = LoginInteractor(repository)
            val router = LoginRouter(view)
            val presenter = LoginPresenter(view, interactor, router, DisposeBag(view))
            view.presenter = presenter
        }
    }

    override fun goToMainScreen() {
        view.startActivity(Intent(view, MainActivity::class.java))
        view.finish()
    }

}
