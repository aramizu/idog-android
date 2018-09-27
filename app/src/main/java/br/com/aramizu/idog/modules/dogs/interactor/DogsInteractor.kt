package br.com.aramizu.idog.modules.dogs.interactor

import br.com.aramizu.idog.modules.dogs.contracts.DogsContract
import io.reactivex.Single

class DogsInteractor(
        private val remote: DogsContract.Remote
) : DogsContract.Interactor {

    override fun getDogList(category: String): Single<ArrayList<String>> {
        return remote.getDogList(category)
    }

}
