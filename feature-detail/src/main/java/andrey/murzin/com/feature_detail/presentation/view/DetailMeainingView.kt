package andrey.murzin.com.feature_detail.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface DetailMeainingView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showInfo(model: andrey.murzin.com.feature_detail.presentation.model.DetailMeaningViewModel)

    @StateStrategyType(SkipStrategy::class)
    fun showError(error: String)

    @StateStrategyType(SkipStrategy::class)
    fun showLoader(flag: Boolean)
}