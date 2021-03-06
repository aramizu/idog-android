package br.com.aramizu.idog.modules.categories.router

import android.content.Intent
import br.com.aramizu.idog.manager.SessionManager
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.modules.categories.presenter.CategoriesPresenter
import br.com.aramizu.idog.modules.categories.view.CategoriesFragment
import br.com.aramizu.idog.modules.dogs.router.DogsRouter
import br.com.aramizu.idog.modules.dogs.view.DogsActivity
import br.com.aramizu.idog.modules.login.view.LoginActivity
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.modules.main.datamanager.MainLocalDataManager
import br.com.aramizu.idog.modules.main.interactor.MainInteractor
import br.com.aramizu.idog.modules.main.presenter.MainPresenter
import br.com.aramizu.idog.modules.main.view.MainActivity

class CategoryRouter(
        private val view: CategoriesFragment
) : CategoriesContract.Router {

    companion object {
        fun assembleModule(view: CategoriesFragment) {

            val router = CategoryRouter(view)
            val presenter = CategoriesPresenter(view, router)
            view.presenter = presenter
        }
    }

    override fun goToDogListByCategory(category: String) {
        val bundle = DogsRouter.assembleModuleData(category)
        val intent = Intent(view.context, DogsActivity::class.java)
        intent.putExtra(DogsRouter.CATEGORY_EXTRA, bundle)
        view.startActivity(intent)
    }
}
