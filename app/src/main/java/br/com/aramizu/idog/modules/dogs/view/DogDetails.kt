package br.com.aramizu.idog.modules.dogs.view

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.Window
import br.com.aramizu.idog.R
import kotlinx.android.synthetic.main.view_dog_details_dialog.*

class DogDetails(
        private val activity: Activity,
        private val image: Drawable
) : Dialog(activity) {

    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.view_dog_details_dialog)

        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setupImage()
    }

    private fun setupImage() {
        imageViewDogThumb.setImageDrawable(image)
    }

}