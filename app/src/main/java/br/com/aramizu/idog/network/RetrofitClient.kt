package br.com.aramizu.idog.network

import br.com.aramizu.idog.BuildConfig
import br.com.aramizu.idog.network.interceptors.LoggingInterceptor
import br.com.aramizu.idog.network.interceptors.UserAuthInterceptor
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {

    companion object {

        val instance: Retrofit
            get() {

                val baseUrl = BuildConfig.BASE_URL

                val maxIdleConnections = 5
                val keepAliveDuration = 1L

                val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                        .addInterceptor(UserAuthInterceptor())
                        .addNetworkInterceptor(LoggingInterceptor.LoggingInterceptor().interceptor)
                        .connectTimeout(2, TimeUnit.MINUTES)
                        .writeTimeout(2, TimeUnit.MINUTES)
                        .readTimeout(2, TimeUnit.MINUTES)
                        .connectionPool(ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS))

                return Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(JacksonConverterFactory.create())
                        .baseUrl(baseUrl)
                        .client(builder.build())
                        .build()
            }
    }
}
