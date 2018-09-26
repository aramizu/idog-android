package br.com.aramizu.idog.modules.main.presenter

import br.com.aramizu.idog.R
import br.com.aramizu.idog.enums.DrawerMenuType
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.models.DrawerMenuItem
import br.com.aramizu.idog.utils.StringResources

import java.util.ArrayList

class MainPresenter(
        private val view: MainContract.View,
        private val interactor: MainContract.Interactor,
        private val router: MainContract.Router
) : MainContract.Presenter {

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
        getEmailFromUserSession()
    }

    override fun onLogoutTapped() {
        router.goToLogin()
    }

    override fun getEmailFromUserSession() {
        view.showEmailOnGreeting(interactor.getEmailFromUserSession())
    }

}
