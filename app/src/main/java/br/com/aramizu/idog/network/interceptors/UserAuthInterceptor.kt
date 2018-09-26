package br.com.aramizu.idog.network.interceptors

import br.com.aramizu.idog.manager.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class UserAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val userSession = SessionManager().userSession

        val definitiveRequest = originalRequest.newBuilder()
                .addHeader("Content-Type", "application/json")

        userSession.token?.let {
            definitiveRequest.addHeader("Authorization", it )
        }

        return chain.proceed(definitiveRequest.build())
    }
}