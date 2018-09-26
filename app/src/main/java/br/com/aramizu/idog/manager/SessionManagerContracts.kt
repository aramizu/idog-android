package br.com.aramizu.idog.manager

import br.com.aramizu.idog.database.realm.model.UserSession
import br.com.aramizu.idog.models.User

interface SessionManagerContracts {

    fun saveUserSession(user: User)
    val userSession: UserSession
    fun clearUserSession()
}
