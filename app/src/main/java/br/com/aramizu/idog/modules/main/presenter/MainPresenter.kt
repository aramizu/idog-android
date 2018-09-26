package br.com.aramizu.idog.modules.main.presenter

import br.com.aramizu.idog.R
import br.com.aramizu.idog.enums.DrawerMenuType
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.model.DrawerMenuItem
import br.com.aramizu.idog.utils.StringResources

import java.util.ArrayList

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    private val drawerMenuList: ArrayList<DrawerMenuItem>
        get() {
            val items = ArrayList<DrawerMenuItem>()
            items.add(
                    DrawerMenuItem(
                            StringResources.get(R.string.drawer_menu_logout),
                            DrawerMenuType.LOGOUT,
                            null
                    )
            )
            return items
        }

    override fun onCreate() {
        view.setUpDrawerMenuList(drawerMenuList)
    }
}
