package br.com.aramizu.idog.config

import android.app.Application
import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class IDogApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: IDogApplication? = null

        fun applicationContext(): Context? {
            return instance?.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    override fun onTerminate() {
        Realm.getDefaultInstance().close()
        super.onTerminate()
    }

    private fun initRealm() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder().build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}