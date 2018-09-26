package br.com.aramizu.idog.modules.main.contracts

import br.com.aramizu.idog.model.DrawerMenuItem
import java.util.ArrayList

interface MainContract {

    interface View {
        var presenter: MainContract.Presenter
        fun setUpDrawerMenuList(items: ArrayList<DrawerMenuItem>)
        fun onDrawerMenuListClick(drawerMenuItem: DrawerMenuItem)
    }

    interface Presenter {
        fun onCreate()
    }
}
