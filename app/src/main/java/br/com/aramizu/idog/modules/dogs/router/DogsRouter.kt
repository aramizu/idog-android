package br.com.aramizu.idog.modules.dogs.router

import android.graphics.drawable.Drawable
import android.os.Bundle
import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import br.com.aramizu.idog.modules.dogs.datamanager.DogsRemoteDataManager
import br.com.aramizu.idog.modules.dogs.interactor.DogsInteractor
import br.com.aramizu.idog.modules.dogs.presenter.DogsPresenter
import br.com.aramizu.idog.modules.dogs.view.DogDetails
import br.com.aramizu.idog.modules.dogs.view.DogsActivity
import br.com.aramizu.idog.network.service.FeedService
import com.kizitonwose.android.disposebag.DisposeBag

class DogsRouter(
        private val view: DogsActivity
) : DogsContract.Router {

    companion object {

        const val CATEGORY_EXTRA = "CATEGORY_EXTRA"
        const val CATEGORY_VALUE_EXTRA = "CATEGORY_VALUE_EXTRA"

        fun assembleModule(view: DogsActivity) {

            val category = view.intent.extras.getBundle(CATEGORY_EXTRA).getString(CATEGORY_VALUE_EXTRA)

            val service = FeedService()
            val remote = DogsRemoteDataManager(service)
            val interactor = DogsInteractor(remote)
            val router = DogsRouter(view)
            val presenter = DogsPresenter(view, interactor, router, category, DisposeBag(view))
            view.presenter = presenter
        }

        fun assembleModuleData(category: String): Bundle {
            val bundle = Bundle()
            bundle.putString(CATEGORY_VALUE_EXTRA, category)
            return bundle
        }
    }

    override fun goToImageDetails(image: Drawable) {
        val dialog = DogDetails(view, image)
        dialog.show()
    }
}
