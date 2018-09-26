package br.com.aramizu.idog.modules.login.datamanager

import br.com.aramizu.idog.models.User
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.network.UserService
import br.com.aramizu.idog.network.request.LoginRequest
import br.com.aramizu.idog.network.response.UserSessionResponse
import br.com.aramizu.idog.network.service.UserServiceContract
import io.reactivex.Single

class LoginRemoteDataManager(
        private val service: UserServiceContract = UserService()
) : LoginContract.Remote {

    override fun login(email: String): Single<User> {
        val loginRequest = LoginRequest(email)
        return service.login(loginRequest)
                .map {
                    User(
                        it.user?.token ?: String(),
                        it.user?.email ?: String()
                    )
                }
    }

}
