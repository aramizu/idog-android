package br.com.aramizu.idog.modules.main.router

import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.modules.main.presenter.MainPresenter

class MainRouter {

    companion object {
        fun assembleModule(view: MainContract.View) {

            val presenter = MainPresenter(view)
            view.presenter = presenter
        }
    }
}
