package andrey.murzin.com.feature_search.presentation.view

import andrey.murzin.com.feature_search.presentation.model.MeaningViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SearchWordView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showTranslateList(list: List<MeaningViewModel>)

    @StateStrategyType(SkipStrategy::class)
    fun showError(error: String)
}