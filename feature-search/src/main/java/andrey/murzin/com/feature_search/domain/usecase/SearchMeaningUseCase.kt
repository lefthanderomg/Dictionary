package andrey.murzin.com.feature_search.domain.usecase

import andrey.murzin.com.core.base.SingleUseCase
import andrey.murzin.com.feature_search.domain.entity.MeaningEntity
import andrey.murzin.com.feature_search.domain.repository.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchMeaningUseCase @Inject constructor(
    private val repository: SearchRepository
) : SingleUseCase<String, List<MeaningEntity>>() {

    override fun build(parameters: String): Single<List<MeaningEntity>> =
        repository.searchMeaning(parameters)

}