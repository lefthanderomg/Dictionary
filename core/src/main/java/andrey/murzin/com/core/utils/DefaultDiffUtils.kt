package andrey.murzin.com.core.utils

import andrey.murzin.com.core.base.AdapterItem
import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DefaultDiffUtils<T : AdapterItem> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.id == newItem.id


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.content() == newItem.content()
}