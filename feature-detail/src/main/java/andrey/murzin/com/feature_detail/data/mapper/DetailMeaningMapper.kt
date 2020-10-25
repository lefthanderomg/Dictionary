package andrey.murzin.com.feature_detail.data.mapper

import andrey.murzin.com.feature_detail.domain.entity.DetailMeaningEntity
import andrey.murzin.com.network_api.model.MeaningInfoModel
import javax.inject.Inject

class DetailMeaningMapper @Inject constructor() {

    fun toInfoEntity(model: MeaningInfoModel): DetailMeaningEntity =
        DetailMeaningEntity(
            id = model.id ?: 0,
            text = model.text.orEmpty(),
            transcription = model.transcription.orEmpty(),
            translate = model.translation?.text.orEmpty(),
            imageUrl = model.images?.firstOrNull()?.url.orEmpty(),
            definition = model.definition?.text.orEmpty()
        )
}