package br.com.aramizu.idog.modules.categories.presenter

import br.com.aramizu.idog.R
import br.com.aramizu.idog.enums.DrawerMenuType
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.models.DrawerMenuItem
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.utils.DrawableResources
import br.com.aramizu.idog.utils.StringResources

import java.util.ArrayList

class CategoriesPresenter(
        private val view: CategoriesContract.View,
        private val router: CategoriesContract.Router
) : CategoriesContract.Presenter {

    private val categoryList: ArrayList<CategoryItem>
        get() {
            val items = ArrayList<CategoryItem>()
            items.add(
                    CategoryItem(
                            StringResources.get(R.string.drawer_menu_logout),
                            DrawableResources.get(R.drawable.ic_pawprint)
                    )
            )
            return items
        }

    override fun onCreate() {
        view.showCategories(categoryList)
    }

}
