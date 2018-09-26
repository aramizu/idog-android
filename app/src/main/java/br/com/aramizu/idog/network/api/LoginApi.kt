package br.com.aramizu.idog.network.api

import br.com.aramizu.idog.network.request.LoginRequest
import br.com.aramizu.idog.network.response.UserSessionResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Retrofit service methods
 */
interface LoginApi {

    @POST("signup")
    fun login(@Body request: LoginRequest): Single<UserSessionResponse>

}


