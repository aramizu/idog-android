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
                            StringResources.get(R.string.husky_category),
                            DrawableResources.get(R.drawable.ic_husky)
                    )
            )
            items.add(
                    CategoryItem(
                            StringResources.get(R.string.pug_category),
                            DrawableResources.get(R.drawable.ic_pug)
                    )
            )
            items.add(
                    CategoryItem(
                            StringResources.get(R.string.hound_category),
                            DrawableResources.get(R.drawable.ic_hound)
                    )
            )
            items.add(
                    CategoryItem(
                            StringResources.get(R.string.labrador_category),
                            DrawableResources.get(R.drawable.ic_labrador)
                    )
            )
            return items
        }

    override fun onCreate() {
        view.showCategories(categoryList)
    }

    override fun onCategoryTapped(category: String) {
        router.goToDogListByCategory(category)
    }

}
