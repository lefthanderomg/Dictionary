package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class DefinitionModel(
    @SerializedName("soundUrl")
    val soundUrl: String?,
    @SerializedName("text")
    val text: String?
)