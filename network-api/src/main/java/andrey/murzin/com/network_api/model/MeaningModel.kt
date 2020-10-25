package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class MeaningModel(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("partOfSpeechCode")
    val partOfSpeechCode: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("soundUrl")
    val soundUrl: String?,
    @SerializedName("transcription")
    val transcription: String?,
    @SerializedName("translation")
    val translation: TranslationModel?
)