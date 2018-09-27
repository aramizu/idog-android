package br.com.aramizu.idog.modules.main.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.aramizu.idog.R
import br.com.aramizu.idog.modules.main.contracts.MainContract
import br.com.aramizu.idog.models.DrawerMenuItem
import kotlinx.android.synthetic.main.item_drawer_menu.view.*

import java.util.ArrayList

class DrawerMenuAdapter(
        private val parentView: MainContract.View,
        private val menuList: ArrayList<DrawerMenuItem>
) : RecyclerView.Adapter<DrawerMenuAdapter.DrawerMenuItemViewHolder>() {

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerMenuItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drawer_menu, parent, false)
        return DrawerMenuItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrawerMenuItemViewHolder, position: Int) {
        val drawerMenuItem = menuList[position]
        holder.populate(drawerMenuItem)
    }

    inner class DrawerMenuItemViewHolder internal constructor(val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var drawerMenuItem: DrawerMenuItem

        init {
            setListeners()
        }

        fun populate(drawerMenuItem: DrawerMenuItem) {
            this.drawerMenuItem = drawerMenuItem
            view.textViewItemDescription.text = drawerMenuItem.itemDescription
            drawerMenuItem.icon?.let {
                view.textViewItemDescription.setCompoundDrawablesWithIntrinsicBounds(drawerMenuItem.icon, null, null, null)
            }
        }

        private fun setListeners() {
            view.textViewItemDescription.setOnClickListener { parentView.onDrawerMenuListClick(drawerMenuItem) }
        }
    }
}