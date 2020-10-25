package andrey.murzin.com.network_api.di

import andrey.murzin.com.network_api.SkyengApi

interface NetworkApi {
    fun skyengApi(): SkyengApi
}