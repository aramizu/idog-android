package br.com.aramizu.idog.modules.dogs.datamanager

import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import br.com.aramizu.idog.network.service.FeedService
import br.com.aramizu.idog.network.service.FeedServiceContract
import io.reactivex.Single

class DogsRemoteDataManager(
        private val service: FeedServiceContract = FeedService()
) : DogsContract.Remote {

    override fun getDogList(category: String): Single<ArrayList<String>> {
        return service.getDogs(category.toLowerCase())
                .map {
                    return@map it.list as ArrayList
                }
    }

}
