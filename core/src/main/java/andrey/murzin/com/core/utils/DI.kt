@file:Suppress("UNCHECKED_CAST")

package andrey.murzin.com.core.utils

import andrey.murzin.com.core.base.ComponentProvider
import android.app.Activity
import androidx.fragment.app.Fragment

fun <T> Activity.getAppComponent() =
    (application as ComponentProvider<T>).provideComponent()

fun <T> Fragment.getActivityComponent() =
    (requireActivity() as ComponentProvider<T>).provideComponent()

fun <T> Fragment.getParentFragmentComponent() =
    (requireParentFragment() as ComponentProvider<T>).provideComponent()