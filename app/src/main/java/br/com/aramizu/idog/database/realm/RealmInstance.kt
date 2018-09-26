package br.com.aramizu.idog.database.realm

sealed class RealmInstance {
    class InMemory: RealmInstance()
    class Default: RealmInstance()
    class Custom(val value: String): RealmInstance()

    val fileName: String
        get() {
            when (this) {
                is InMemory -> return "IN_MEMORY"
                is Custom -> return "CUSTOM_$value"
                else -> return "DEFAULT"
            }
        }

    val schemaVersion: Long
        get() {
            when (this) {
                is InMemory -> return 1
                is Custom -> return 1 //TODO: Trocar para build variants
                else -> return 1 //TODO: Trocar para build variants
            }
        }
}