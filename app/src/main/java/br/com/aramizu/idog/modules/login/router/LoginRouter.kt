package br.com.aramizu.idog.modules.login.router

import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.modules.login.presenter.LoginPresenter


class LoginRouter {

    companion object {
        fun assembleModule(view: LoginContract.View) {

            val presenter = LoginPresenter(view)
            view.presenter = presenter
        }
    }
}
