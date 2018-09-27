package br.com.aramizu.idog.network.api

import br.com.aramizu.idog.network.response.DogsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit service methods
 */
interface FeedApi {

    @GET("feed")
    fun getDogs(@Query("category") category: String?): Single<DogsResponse>

}


