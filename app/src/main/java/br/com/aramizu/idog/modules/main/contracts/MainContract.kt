package br.com.aramizu.idog.modules.main.contracts

import br.com.aramizu.idog.models.DrawerMenuItem
import java.util.ArrayList

interface MainContract {

    interface View {
        var presenter: MainContract.Presenter
        fun setUpDrawerMenuList(items: ArrayList<DrawerMenuItem>)
        fun onDrawerMenuListClick(drawerMenuItem: DrawerMenuItem)
        fun showEmailOnGreeting(email: String)
    }

    interface Presenter {
        fun onCreate()
        fun onLogoutTapped()
        fun getEmailFromUserSession()
    }

    interface Interactor {
        fun getEmailFromUserSession(): String
    }

    interface Local {
        fun getEmailFromUserSession(): String
    }

    interface Router {
        fun goToLogin()
    }
}
