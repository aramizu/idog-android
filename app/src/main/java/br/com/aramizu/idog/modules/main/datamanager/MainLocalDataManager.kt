package br.com.aramizu.idog.modules.main.datamanager

import br.com.aramizu.idog.manager.SessionManager
import br.com.aramizu.idog.modules.main.contracts.MainContract

class MainLocalDataManager(
        private val sessionManager: SessionManager
) : MainContract.Local {

    override fun getEmailFromUserSession(): String {
        val userSession = sessionManager.userSession
        return userSession.email ?: String()
    }

}
