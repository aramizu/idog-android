package br.com.aramizu.idog.manager

import br.com.aramizu.idog.database.realm.RealmHelper
import br.com.aramizu.idog.database.realm.model.UserSession
import br.com.aramizu.idog.models.User

class SessionManager(
        private val realmHelper: RealmHelper = RealmHelper()
) : SessionManagerContracts {

    override fun saveUserSession(user: User) {
        val userSession = UserSession(user)
        realmHelper.save(userSession)
    }

    override val userSession: UserSession
        get() = realmHelper.findFirst() ?: UserSession()

    override fun clearUserSession() {
        realmHelper.deleteAll<UserSession>()
    }

}
