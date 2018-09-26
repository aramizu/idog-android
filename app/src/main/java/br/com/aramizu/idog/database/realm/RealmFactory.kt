package br.com.aramizu.idog.database.realm

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

class RealmFactory {

    companion object {

        private var migrations: MutableMap<RealmInstance, RealmMigration> = HashMap()

        private fun migratorBy(instance: RealmInstance): RealmMigration {
            var migrator = migrations[instance]
            if (migrator != null) {
                return  migrator
            }

            migrator = RealmMigrator(instance)
            migrations[instance] = migrator
            return migrator
        }

        fun make(instance: RealmInstance): Realm {
            val config = RealmConfiguration.Builder()
            config.name(instance.fileName)
            config.schemaVersion(instance.schemaVersion)
            config.deleteRealmIfMigrationNeeded()

            if (instance is RealmInstance.InMemory) {
                config.inMemory()
            } else {
                config.migration(migratorBy(instance))
            }

            val realmConfiguration = config.build()
            return Realm.getInstance(realmConfiguration)
        }

    }

}