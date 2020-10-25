package andrey.murzin.com.feature_search.domain.repository

import io.reactivex.Single

interface SearchRepository {
    fun searchMeaning(searchQuery: String): Single<List<andrey.murzin.com.feature_search.domain.entity.MeaningEntity>>
}