package br.com.aramizu.idog.database.realm

import br.com.aramizu.idog.models.User


interface RealmDataManagerContract {
    fun saveUserSession(user: User)
    fun retrieveUserSession(): User
    fun clearUserSession()
}
