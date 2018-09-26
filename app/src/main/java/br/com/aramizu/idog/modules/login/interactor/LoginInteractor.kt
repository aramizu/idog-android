package br.com.aramizu.idog.modules.login.interactor

import android.accounts.NetworkErrorException
import br.com.aramizu.idog.config.IDogApplication
import br.com.aramizu.idog.errors.EmptyFieldsError
import br.com.aramizu.idog.errors.InvalidFieldsFieldsError
import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.network.utils.NetworkUtils
import br.com.aramizu.idog.utils.ValidationUtils
import io.reactivex.Single

class LoginInteractor(
        private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    override fun login(email: String): Single<User> {
        if (NetworkUtils.isNetworkNotConnected(IDogApplication.applicationContext())) {
            return Single.error(NetworkErrorException())
        }
        if (email.isEmpty()) {
            return Single.error(EmptyFieldsError())
        }
        if (!ValidationUtils.isEmailValid(email)) {
            return Single.error(InvalidFieldsFieldsError())
        }
        return repository.login(email)
    }

}
