package br.com.aramizu.idog.network.service

import br.com.aramizu.idog.network.request.LoginRequest
import br.com.aramizu.idog.network.response.UserResponse
import br.com.aramizu.idog.network.response.UserSessionResponse
import io.reactivex.Single

interface UserServiceContract {
    fun login(loginRequest: LoginRequest): Single<UserResponse>
}