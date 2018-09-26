package br.com.aramizu.idog.modules.login.presenter

import android.accounts.NetworkErrorException
import br.com.aramizu.idog.R
import br.com.aramizu.idog.errors.EmptyFieldsError
import br.com.aramizu.idog.errors.InvalidFieldsFieldsError
import br.com.aramizu.idog.extensions.getErrorMessage
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.utils.StringResources
import com.kizitonwose.android.disposebag.DisposeBag
import com.kizitonwose.android.disposebag.disposedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginPresenter(
        private val view: LoginContract.View,
        private val interactor: LoginContract.Interactor,
        private val disposeBag: DisposeBag
) : LoginContract.Presenter {

    override fun login(email: String) {
        view.showLoading()
        interactor.login(email)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.hideLoading()
                        },
                        onError = { error ->
                            view.hideLoading()
                            when (error) {
                                is NetworkErrorException -> view.showDialog(null, StringResources.get(R.string.no_network_error))
                                is InvalidFieldsFieldsError -> view.showFormMessageError(StringResources.get(R.string.invalid_field_error))
                                is EmptyFieldsError -> view.showFormMessageError(StringResources.get(R.string.empty_field_error))
                                else -> view.showDialog(null, error.getErrorMessage())
                            }
                        }
                ).disposedBy(disposeBag)
    }

}