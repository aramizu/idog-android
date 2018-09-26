package br.com.aramizu.idog.database.realm.model

import br.com.aramizu.idog.models.User
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required

@RealmClass
open class UserSession() : RealmObject() {

    constructor(user: User) : this() {
        token = user.token
        email = user.email
    }

    @PrimaryKey
    @Required
    var token: String? = null
    var email: String? = null
}