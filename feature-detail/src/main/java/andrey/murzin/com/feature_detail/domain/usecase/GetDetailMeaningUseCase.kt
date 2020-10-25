package andrey.murzin.com.feature_detail.domain.usecase

import andrey.murzin.com.core.base.SingleUseCase
import andrey.murzin.com.feature_detail.domain.entity.DetailMeaningEntity
import andrey.murzin.com.feature_detail.domain.repository.DetailRepository
import io.reactivex.Single
import javax.inject.Inject

class GetDetailMeaningUseCase @Inject constructor(
    private val repositoryImpl: DetailRepository
) : SingleUseCase<Long, DetailMeaningEntity>() {
    override fun build(parameters: Long): Single<DetailMeaningEntity> =
        repositoryImpl.getMeaning(parameters)
}