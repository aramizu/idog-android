package br.com.aramizu.idog.modules.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import br.com.aramizu.idog.R
import br.com.aramizu.idog.enums.DrawerMenuType
import br.com.aramizu.idog.extensions.pushFragment
import br.com.aramizu.idog.modules.main.adapters.DrawerMenuAdapter
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.modules.main.router.MainRouter
import br.com.aramizu.idog.model.DrawerMenuItem
import br.com.aramizu.idog.modules.categories.view.CategoriesFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_toolbar.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainRouter.assembleModule(this)

        setUpToolbar()
        setUpListeners()
        setupMainFragment()
    }

    private fun setUpListeners() {
        imageViewDrawerIcon.setOnClickListener {
            drawerLayout.openDrawer(Gravity.END)
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        toolbarTitle.text = getString(R.string.app_name)

        supportActionBar?.let {
            it.setDisplayShowTitleEnabled(false)
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
        }
    }

    private fun setupMainFragment() {
        pushFragment(CategoriesFragment(), R.id.contentFrame)
    }

    override fun setUpDrawerMenuList(items: ArrayList<DrawerMenuItem>) {
        val drawerMenuAdapter = DrawerMenuAdapter(this, items)
        recyclerViewDrawerMenu.apply {
            adapter = drawerMenuAdapter
            layoutManager = LinearLayoutManager(MainActivity@context)
        }
    }

    override fun onDrawerMenuListClick(drawerMenuItem: DrawerMenuItem) {
        when (drawerMenuItem.type) {
            DrawerMenuType.LOGOUT -> finish()
            else -> drawerLayout.closeDrawer(drawerContainer)
        }
    }
}
