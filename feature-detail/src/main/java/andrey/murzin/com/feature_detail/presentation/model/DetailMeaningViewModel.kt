package andrey.murzin.com.feature_detail.presentation.model

data class DetailMeaningViewModel(
    val id: Long,
    val value: String,
    val translate: String,
    val imageUrl: String,
    val definition: String
)