package br.com.aramizu.idog.modules.main.router

import android.content.Intent
import br.com.aramizu.idog.manager.SessionManager
import br.com.aramizu.idog.modules.login.view.LoginActivity
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.modules.main.datamanager.MainLocalDataManager
import br.com.aramizu.idog.modules.main.interactor.MainInteractor
import br.com.aramizu.idog.modules.main.presenter.MainPresenter
import br.com.aramizu.idog.modules.main.view.MainActivity

class MainRouter(
        private val view: MainActivity
) : MainContract.Router {

    companion object {
        fun assembleModule(view: MainActivity) {

            val sessionManager = SessionManager()
            val local = MainLocalDataManager(sessionManager)
            val interactor = MainInteractor(local)
            val router = MainRouter(view)
            val presenter = MainPresenter(view, interactor, router)
            view.presenter = presenter
        }
    }

    override fun goToLogin() {
        val intent = Intent(view, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK and Intent.FLAG_ACTIVITY_CLEAR_TOP
        view.startActivity(intent)
        view.finish()
    }
}
