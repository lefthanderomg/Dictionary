package andrey.murzin.com.feature_search.presentation.adapter


import andrey.murzin.com.core.utils.DefaultDiffUtils
import andrey.murzin.com.core.utils.inflate
import andrey.murzin.com.feature_search.R
import andrey.murzin.com.feature_search.presentation.model.MeaningViewModel
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_word.view.*

class SearchWordAdapter(
    private val clickCallback: (Long) -> Unit
) : ListAdapter<MeaningViewModel, SearchWordAdapter.SearchWordViewHolder>(DefaultDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchWordViewHolder =
        SearchWordViewHolder(parent.inflate(R.layout.item_word), clickCallback)

    override fun onBindViewHolder(holder: SearchWordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchWordViewHolder(override val containerView: View, clickCallback: (Long) -> Unit) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var id: Long = 0

        init {
            containerView.setOnClickListener {
                clickCallback.invoke(id)
            }
        }

        fun bind(item: MeaningViewModel) {
            id = item.id
            containerView.tvTranslate.text = item.value
        }
    }
}