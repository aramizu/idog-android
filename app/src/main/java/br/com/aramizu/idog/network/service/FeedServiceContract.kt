package br.com.aramizu.idog.network.service

import br.com.aramizu.idog.network.response.DogsResponse
import io.reactivex.Single

interface FeedServiceContract {
    fun getDogs(category: String): Single<DogsResponse>
}