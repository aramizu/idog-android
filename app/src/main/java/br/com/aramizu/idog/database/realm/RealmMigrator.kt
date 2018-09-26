package br.com.aramizu.idog.database.realm

import io.realm.DynamicRealm
import io.realm.RealmMigration

class RealmMigrator(val instance: RealmInstance) : RealmMigration {

    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {

    }

    override fun equals(other: Any?): Boolean {
        return other is RealmMigrator
    }

    override fun hashCode(): Int {
        return instance.hashCode()
    }
}