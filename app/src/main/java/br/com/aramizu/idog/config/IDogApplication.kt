package br.com.aramizu.idog.config

import android.app.Application
import android.content.Context

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
    }
}