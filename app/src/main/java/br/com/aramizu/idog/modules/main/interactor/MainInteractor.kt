package br.com.aramizu.idog.modules.main.interactor

import br.com.aramizu.idog.modules.main.contracts.MainContract

class MainInteractor(
        private val local: MainContract.Local
) : MainContract.Interactor {

    override fun getEmailFromUserSession(): String {
        return local.getEmailFromUserSession()
    }

}
