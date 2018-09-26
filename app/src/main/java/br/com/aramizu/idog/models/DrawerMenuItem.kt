package br.com.aramizu.idog.models

import android.graphics.drawable.Drawable
import br.com.aramizu.idog.enums.DrawerMenuType

data class DrawerMenuItem(
        var itemDescription: String,
        var type: DrawerMenuType,
        var icon: Drawable?
)