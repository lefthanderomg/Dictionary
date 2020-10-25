package andrey.murzin.com.core.delegate

import androidx.annotation.StringRes

interface RecourseDelegate {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg values: Any): String
}