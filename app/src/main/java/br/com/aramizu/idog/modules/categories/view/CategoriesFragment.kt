package br.com.aramizu.idog.modules.categories.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.aramizu.idog.R
import br.com.aramizu.idog.commons.BaseFragment
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.modules.categories.adapters.CategoryListAdapter
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.modules.categories.router.CategoryRouter
import kotlinx.android.synthetic.main.fragment_categories.*

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
        val categoryListAdapter = CategoryListAdapter(this, categoryList)
        recyclerViewCategories.apply {
            adapter = categoryListAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onCategoryTapped(category: String) {
        presenter.onCategoryTapped(category)
    }
}
