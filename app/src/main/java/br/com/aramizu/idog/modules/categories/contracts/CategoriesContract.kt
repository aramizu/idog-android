package br.com.aramizu.idog.modules.categories.contracts

import br.com.aramizu.idog.commons.BaseContracts
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.network.response.UserSessionResponse
import io.reactivex.Completable
import io.reactivex.Single


interface CategoriesContract {

    interface View : BaseContracts.View {
        var presenter: CategoriesContract.Presenter
        fun showCategories(categoryList: ArrayList<CategoryItem>)
        fun onCategoryTapped(category: String)
    }

    interface Presenter {
        fun onCreate()
    }

    interface Router {
        fun goToDogListByCategory(category: String)
    }
}
