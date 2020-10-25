package andrey.murzin.com.feature_search.data.mapper

import andrey.murzin.com.feature_search.domain.entity.MeaningEntity
import andrey.murzin.com.network_api.model.WordModel
import javax.inject.Inject

class WordModelMapper @Inject constructor() {

    fun toMeaningEntity(wordModel: List<WordModel>): List<MeaningEntity> =
        wordModel.map { word ->
            word.meanings?.map { meaningModel ->
                MeaningEntity(
                    meaningModel.id ?: 0,
                    meaningModel.translation?.text.orEmpty()
                )
            } ?: emptyList()
        }.flatten()
}