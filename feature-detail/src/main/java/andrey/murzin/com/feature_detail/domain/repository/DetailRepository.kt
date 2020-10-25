package andrey.murzin.com.feature_detail.domain.repository

import andrey.murzin.com.feature_detail.domain.entity.DetailMeaningEntity
import io.reactivex.Single

interface DetailRepository {
    fun getMeaning(id: Long): Single<DetailMeaningEntity>
}