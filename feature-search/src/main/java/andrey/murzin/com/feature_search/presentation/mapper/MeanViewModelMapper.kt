package andrey.murzin.com.feature_search.presentation.mapper

import andrey.murzin.com.feature_search.domain.entity.MeaningEntity
import andrey.murzin.com.feature_search.presentation.model.MeaningViewModel
import javax.inject.Inject

class MeanViewModelMapper @Inject constructor() {

    fun toViewModel(list: List<MeaningEntity>) =
        list.map { itemEntity ->
            toViewModel(itemEntity)
        }

    private fun toViewModel(itemEntity: MeaningEntity) =
        MeaningViewModel(
            itemEntity.id,
            itemEntity.value
        )
}