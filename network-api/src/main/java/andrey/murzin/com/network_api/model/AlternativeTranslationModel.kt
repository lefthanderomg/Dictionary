package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class AlternativeTranslationModel(
    @SerializedName("text")
    val text: String?,
    @SerializedName("translation")
    val translation: TranslationModel?
)