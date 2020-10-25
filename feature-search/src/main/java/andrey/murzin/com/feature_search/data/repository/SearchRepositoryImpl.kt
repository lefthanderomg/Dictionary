package andrey.murzin.com.feature_search.data.repository

import andrey.murzin.com.feature_search.data.mapper.WordModelMapper
import andrey.murzin.com.feature_search.domain.entity.MeaningEntity
import andrey.murzin.com.feature_search.domain.repository.SearchRepository
import andrey.murzin.com.network_api.SkyengApi
import io.reactivex.Single
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: SkyengApi,
    private val wordMapper: WordModelMapper
) : SearchRepository {
    override fun searchMeaning(searchQuery: String): Single<List<MeaningEntity>> =
        api.searchWords(searchQuery)
            .map { wordMapper.toMeaningEntity(it) }

}