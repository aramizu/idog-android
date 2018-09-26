package br.com.aramizu.idog.utils

import android.graphics.drawable.Drawable
import br.com.aramizu.idog.config.IDogApplication

class DrawableResources {

    companion object {
        fun get(identifier: Int): Drawable? {
            return IDogApplication.applicationContext()?.getDrawable(identifier)
        }
    }
}