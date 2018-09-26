package br.com.aramizu.idog.modules.login.repository

import br.com.aramizu.idog.manager.SessionManagerContracts
import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import io.reactivex.Single

class LoginRepository(
        private val remote: LoginContract.Remote,
        private val sessionManager: SessionManagerContracts
) : LoginContract.Repository {

    override fun login(email: String): Single<User> {
        return remote.login(email)
                .doOnSuccess {
                    sessionManager.clearUserSession()
                    sessionManager.saveUserSession(it)
                }
    }

}
