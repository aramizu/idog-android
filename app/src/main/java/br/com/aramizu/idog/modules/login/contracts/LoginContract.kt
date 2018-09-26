package br.com.aramizu.idog.modules.login.contracts

import br.com.aramizu.idog.commons.BaseContracts
import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.network.response.UserSessionResponse
import io.reactivex.Completable
import io.reactivex.Single


interface LoginContract {

    interface View : BaseContracts.View {
        var presenter: LoginContract.Presenter
        fun showFormMessageError(message: String)
    }

    interface Presenter {
        fun login(email: String)
    }

    interface Interactor {
        fun login(email: String): Single<User>
    }

    interface Repository {
        fun login(email: String): Single<User>
    }

    interface Remote {
        fun login(email: String): Single<User>
    }

    interface Router {
        fun goToMainScreen()
    }
}
