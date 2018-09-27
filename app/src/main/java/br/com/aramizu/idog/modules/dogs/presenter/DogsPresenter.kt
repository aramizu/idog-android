package br.com.aramizu.idog.modules.dogs.presenter

import android.accounts.NetworkErrorException
import android.graphics.drawable.Drawable
import br.com.aramizu.idog.R
import br.com.aramizu.idog.enums.DrawerMenuType
import br.com.aramizu.idog.errors.EmptyFieldsError
import br.com.aramizu.idog.errors.InvalidFieldsFieldsError
import br.com.aramizu.idog.extensions.getErrorMessage
import br.com.aramizu.idog.models.CategoryItem
import br.com.aramizu.idog.models.DrawerMenuItem
import br.com.aramizu.idog.modules.categories.contracts.CategoriesContract
import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import br.com.aramizu.idog.utils.DrawableResources
import br.com.aramizu.idog.utils.StringResources
import com.kizitonwose.android.disposebag.DisposeBag
import com.kizitonwose.android.disposebag.disposedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

import java.util.ArrayList

class DogsPresenter(
        private val view: DogsContract.View,
        private val interactor: DogsContract.Interactor,
        private val router: DogsContract.Router,
        private val category: String,
        private val disposeBag: DisposeBag
) : DogsContract.Presenter {

    override fun onCreate() {
        view.showLoading()
        interactor.getDogList(category)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.hideLoading()
                            view.showDogs(it)
                        },
                        onError = { error ->
                            view.hideLoading()
                            when (error) {
                                is NetworkErrorException -> view.showDialog(null, StringResources.get(R.string.no_network_error))
                                else -> view.showDialog(null, error.getErrorMessage())
                            }
                        }
                ).disposedBy(disposeBag)

        view.setupScreenTitle(category)
    }

    override fun onDogTapped(image: Drawable) {
        router.goToImageDetails(image)
    }

}
