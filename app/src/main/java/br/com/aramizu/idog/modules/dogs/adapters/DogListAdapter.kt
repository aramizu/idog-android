package br.com.aramizu.idog.modules.dogs.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import br.com.aramizu.idog.R
import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import kotlinx.android.synthetic.main.item_dog.view.*
import java.util.*

class DogListAdapter(
        private val parentView: DogsContract.View,
        private val dogList: ArrayList<String>
) : RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val url = dogList[position]
        holder.populate(url)
    }

    inner class DogViewHolder internal constructor(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            setListeners()
        }

        fun populate(url: String) {
            Glide.with(view.context)
                    .load(url)
                    .thumbnail(1f)
                    .crossFade()
                    .error(R.drawable.ic_pawprint)
                    .listener(object : RequestListener<String, GlideDrawable> {
                        override fun onException(e: Exception, model: String, target: Target<GlideDrawable>, isFirstResource: Boolean): Boolean {
                            view.loading.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(resource: GlideDrawable, model: String, target: Target<GlideDrawable>, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
                            view.loading.visibility = View.GONE
                            return false
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(view.imageViewDogThumb)
        }

        private fun setListeners() {
            view.imageViewDogThumb.setOnClickListener { parentView.onDogTapped(view.imageViewDogThumb.drawable) }
        }
    }
}