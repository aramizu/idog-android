package br.com.aramizu.idog.modules.dogs.view


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.aramizu.idog.R
import br.com.aramizu.idog.commons.BaseActivity
import br.com.aramizu.idog.commons.BaseFragment
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.modules.categories.adapters.CategoryListAdapter
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.modules.categories.router.CategoryRouter
import br.com.aramizu.idog.modules.dogs.adapters.DogListAdapter
import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import br.com.aramizu.idog.modules.dogs.router.DogsRouter
import br.com.aramizu.idog.modules.main.router.MainRouter
import kotlinx.android.synthetic.main.app_toolbar.*
import kotlinx.android.synthetic.main.fragment_categories.*

class DogsActivity : BaseActivity(), DogsContract.View {

    override lateinit var presenter: DogsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs)

        DogsRouter.assembleModule(this)

        presenter.onCreate()
    }

    override fun setupScreenTitle(category: String) {
        toolbarTitle.text = category
        imageViewDrawerIcon.visibility = View.GONE
    }

    override fun showDogs(dogList: ArrayList<String>) {
        val dogListAdapter = DogListAdapter(this, dogList)
        recyclerViewCategories.apply {
            adapter = dogListAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onDogTapped(image: Drawable) {
        presenter.onDogTapped(image)
    }
}
