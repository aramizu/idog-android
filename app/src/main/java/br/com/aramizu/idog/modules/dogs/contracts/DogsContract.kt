package br.com.aramizu.idog.modules.dogs.contracts

import android.graphics.drawable.Drawable
import br.com.aramizu.idog.commons.BaseContracts
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.network.response.UserSessionResponse
import io.reactivex.Completable
import io.reactivex.Single


interface DogsContract {

    interface View : BaseContracts.View {
        var presenter: DogsContract.Presenter
        fun showDogs(dogList: ArrayList<String>)
        fun onDogTapped(image: Drawable)
        fun setupScreenTitle(category: String)
    }

    interface Presenter {
        fun onCreate()
        fun onDogTapped(image: Drawable)
    }

    interface Interactor {
        fun getDogList(category: String): Single<ArrayList<String>>
    }

    interface Remote {
        fun getDogList(category: String): Single<ArrayList<String>>
    }

    interface Router {
        fun goToImageDetails(image: Drawable)
    }
}
