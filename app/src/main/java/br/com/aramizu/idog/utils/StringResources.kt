package br.com.aramizu.idog.utils

import br.com.aramizu.idog.config.IDogApplication

class StringResources {

    companion object {
        fun get(identifier: Int): String {
            return IDogApplication.applicationContext()?.getString(identifier) ?: String()
        }
    }
}