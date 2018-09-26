package br.com.aramizu.idog.extensions

import br.com.aramizu.idog.network.RetrofitClient
import br.com.aramizu.idog.network.api.LoginApi

val RetrofitClient.Companion.loginApi: LoginApi
    get() = RetrofitClient.instance
                .create(LoginApi::class.java)
