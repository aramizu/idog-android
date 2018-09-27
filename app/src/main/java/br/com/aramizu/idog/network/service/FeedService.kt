package br.com.aramizu.idog.network.service

import br.com.aramizu.idog.extensions.feedApi
import br.com.aramizu.idog.network.RetrofitClient
import br.com.aramizu.idog.network.response.DogsResponse
import io.reactivex.Single

class FeedService : FeedServiceContract {

    override fun getDogs(category: String): Single<DogsResponse> {
        return RetrofitClient.feedApi
                .getDogs(category)
    }

}
