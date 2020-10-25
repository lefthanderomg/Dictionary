package andrey.murzin.com.network_api

import andrey.murzin.com.network_api.model.MeaningInfoModel
import andrey.murzin.com.network_api.model.WordModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyengApi {

    @GET("words/search")
    fun searchWords(
        @Query("search") searchQuery: String,
        @Query("page") page: Int? = null,
        @Query("pageSize") pageSize: Int? = null
    ): Single<List<WordModel>>

    @GET("meanings")
    fun getMeans(
        @Query("ids") id: Long,
    ): Single<List<MeaningInfoModel>>
}