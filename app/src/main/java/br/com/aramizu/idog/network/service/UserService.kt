package br.com.aramizu.idog.network.service

import br.com.aramizu.idog.extensions.loginApi
import br.com.aramizu.idog.network.RetrofitClient
import br.com.aramizu.idog.network.request.LoginRequest
import br.com.aramizu.idog.network.response.UserResponse
import io.reactivex.Single

class UserService : UserServiceContract {

    override fun login(loginRequest: LoginRequest): Single<UserResponse> {
        return RetrofitClient.loginApi
                .login(loginRequest)
    }

}
