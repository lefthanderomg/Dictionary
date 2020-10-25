package andrey.murzin.com.network_api.model

import com.google.gson.annotations.SerializedName

data class WordModel(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("meanings")
    val meanings: List<MeaningModel>?,
    @SerializedName("text")
    val text: String?
)