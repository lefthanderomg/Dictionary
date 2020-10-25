package andrey.murzin.com.core.delegate

import android.content.res.Resources
import androidx.annotation.StringRes
import javax.inject.Inject

class RecourseDelegateImpl @Inject constructor(
    private val res: Resources
) : RecourseDelegate {

    override fun getString(@StringRes id: Int): String = res.getString(id)
    override fun getString(id: Int, vararg values: Any): String = res.getString(id, *values)
}
