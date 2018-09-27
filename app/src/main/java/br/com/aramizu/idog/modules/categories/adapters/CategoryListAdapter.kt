package br.com.aramizu.idog.modules.categories.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.aramizu.idog.R
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import kotlinx.android.synthetic.main.item_category.view.*

import java.util.ArrayList

class CategoryListAdapter(
        private val parentView: CategoriesContract.View,
        private val categoryList: ArrayList<CategoryItem>
) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val drawerMenuItem = categoryList[position]
        holder.populate(drawerMenuItem)
    }

    inner class CategoryViewHolder internal constructor(val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var categoryItem: CategoryItem

        init {
            setListeners()
        }

        fun populate(categoryItem: CategoryItem) {
            this.categoryItem = categoryItem
            view.imageViewCategoryIcon.setImageDrawable(categoryItem.icon)
            view.textViewCategoryName.text = categoryItem.category
        }

        private fun setListeners() {
            view.cardContainer.setOnClickListener { parentView.onCategoryTapped(categoryItem.category) }
        }
    }
}