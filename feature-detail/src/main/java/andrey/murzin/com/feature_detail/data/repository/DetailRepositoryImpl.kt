package andrey.murzin.com.feature_detail.data.repository

import andrey.murzin.com.feature_detail.data.mapper.DetailMeaningMapper
import andrey.murzin.com.feature_detail.domain.entity.DetailMeaningEntity
import andrey.murzin.com.feature_detail.domain.repository.DetailRepository
import andrey.murzin.com.network_api.SkyengApi
import io.reactivex.Single
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val api: SkyengApi,
    private val meaningMapper: DetailMeaningMapper
) : DetailRepository {

    override fun getMeaning(id: Long): Single<DetailMeaningEntity> =
        api.getMeans(id)
            .map { it.first() }
            .map { meaningMapper.toInfoEntity(it) }

}