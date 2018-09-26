package br.com.aramizu.idog.modules.login.router

import br.com.aramizu.idog.manager.SessionManager
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.modules.login.datamanager.LoginRemoteDataManager
import br.com.aramizu.idog.modules.login.interactor.LoginInteractor
import br.com.aramizu.idog.modules.login.presenter.LoginPresenter
import br.com.aramizu.idog.modules.login.repository.LoginRepository
import br.com.aramizu.idog.modules.login.view.LoginActivity
import com.kizitonwose.android.disposebag.DisposeBag


class LoginRouter {

    companion object {
        fun assembleModule(view: LoginActivity) {

            val remote = LoginRemoteDataManager()
            val sessionManager = SessionManager()
            val repository = LoginRepository(remote, sessionManager)
            val interactor = LoginInteractor(repository)
            val presenter = LoginPresenter(view, interactor, DisposeBag(view))
            view.presenter = presenter
        }
    }

}
