package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class MeaningInfoModel(
    @SerializedName("alternativeTranslations")
    val alternativeTranslations: List<AlternativeTranslationModel>?,
    @SerializedName("definition")
    val definition: DefinitionModel?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("images")
    val images: List<ImageModel>?,
    @SerializedName("soundUrl")
    val soundUrl: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("transcription")
    val transcription: String?,
    @SerializedName("translation")
    val translation: TranslationModel?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("wordId")
    val wordId: Int?
)