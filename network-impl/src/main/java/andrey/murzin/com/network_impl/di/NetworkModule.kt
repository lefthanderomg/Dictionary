package andrey.murzin.com.network_impl.di

import andrey.murzin.com.core.scope.AppScope
import andrey.murzin.com.network_api.SkyengApi
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://dictionary.skyeng.ru/api/public/v1/"

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    @AppScope
    @Provides
    fun providesHttpLoggingInterceptor(): LoggingInterceptor =
        LoggingInterceptor
            .Builder()
            .setLevel(Level.BODY)
            .log(Log.INFO)
            .request("Request")
            .response("Response")
            .build()

    @AppScope
    @Provides
    fun provideOkHttpClientUpload(
        loggingInterceptor: LoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
        connectTimeout(30, TimeUnit.SECONDS)
    }.build()

    @AppScope
    @Provides
    fun provideSkyengApi(httpClient: OkHttpClient): SkyengApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .baseUrl(BASE_URL)
            .build()
            .create(SkyengApi::class.java)
    }
}
