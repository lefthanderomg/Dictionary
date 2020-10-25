package andrey.murzin.com.feature_detail.domain.entity

data class DetailMeaningEntity(
    val id: Long,
    val text: String,
    val transcription: String,
    val translate: String,
    val imageUrl: String,
    val definition: String
)