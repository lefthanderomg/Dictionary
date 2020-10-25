package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("url")
    val url: String?
)