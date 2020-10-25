package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class TranslationModel(
    @SerializedName("text")
    val text: String?
)