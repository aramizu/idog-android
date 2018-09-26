package br.com.aramizu.idog.modules.login.contracts

import io.reactivex.Completable


interface LoginContract {

    interface View {
        var presenter: LoginContract.Presenter
    }

    interface Presenter {
        fun login()
    }

    interface Interactor {
        fun login(): Completable
    }

    interface Remote {
        fun login(): Completable
    }
}
