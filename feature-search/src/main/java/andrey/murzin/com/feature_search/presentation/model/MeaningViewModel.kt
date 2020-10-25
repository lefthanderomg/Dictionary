package andrey.murzin.com.feature_search.presentation.model

import andrey.murzin.com.core.base.AdapterItem

data class MeaningViewModel(
    override val id: Long,
    val value: String
) : AdapterItem {
    override fun content(): Any = this
}