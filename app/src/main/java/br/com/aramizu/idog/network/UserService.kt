package br.com.aramizu.idog.network

import br.com.aramizu.idog.extensions.loginApi
import br.com.aramizu.idog.network.request.LoginRequest
import br.com.aramizu.idog.network.response.UserResponse
import br.com.aramizu.idog.network.response.UserSessionResponse
import br.com.aramizu.idog.network.service.UserServiceContract
import io.reactivex.Single

class UserService : UserServiceContract {

    override fun login(loginRequest: LoginRequest): Single<UserResponse> {
        return RetrofitClient.loginApi
                .login(loginRequest)
    }

}
