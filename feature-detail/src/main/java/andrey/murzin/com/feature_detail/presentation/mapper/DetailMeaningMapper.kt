package andrey.murzin.com.feature_detail.presentation.mapper

import andrey.murzin.com.core.delegate.RecourseDelegate
import andrey.murzin.com.feature_detail.R
import andrey.murzin.com.feature_detail.domain.entity.DetailMeaningEntity
import andrey.murzin.com.feature_detail.presentation.model.DetailMeaningViewModel
import andrey.murzin.com.feature_detail.utils.ImgUrlDelegate
import javax.inject.Inject

class DetailMeaningMapper @Inject constructor(
    private val recourseDelegate: RecourseDelegate,
    private val imgUrlDelegate: ImgUrlDelegate
) {

    fun toViewModel(model: DetailMeaningEntity) =
        DetailMeaningViewModel(
            model.id,
            recourseDelegate.getString(R.string.mean_value, model.text, model.transcription),
            recourseDelegate.getString(R.string.translate, model.translate),
            imgUrlDelegate.toHttps(model.imageUrl),
            recourseDelegate.getString(R.string.definition,  model.definition)
        )
}