package br.com.aramizu.idog.modules.categories.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.aramizu.idog.R
import br.com.aramizu.idog.commons.BaseFragment
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.modules.categories.router.CategoryRouter

class CategoriesFragment : BaseFragment(), CategoriesContract.View {

    override lateinit var presenter: CategoriesContract.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_categories, container, false)

        CategoryRouter.assembleModule(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.onCreate()
    }

    override fun showCategories(categoryList: ArrayList<CategoryItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
