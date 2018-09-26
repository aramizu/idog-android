package br.com.aramizu.idog.database.realm

import br.com.aramizu.idog.database.realm.model.UserSession
import br.com.aramizu.idog.models.User


interface RealmDataManagerContract {
    fun saveUserSession(user: User)
    fun retrieveUserSession(): UserSession
}
