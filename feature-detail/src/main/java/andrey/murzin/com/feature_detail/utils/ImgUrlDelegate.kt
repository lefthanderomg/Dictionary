package andrey.murzin.com.feature_detail.utils

import javax.inject.Inject

class ImgUrlDelegate @Inject constructor() {

    fun toHttps(imgUrl: String) = "https://$imgUrl"
}