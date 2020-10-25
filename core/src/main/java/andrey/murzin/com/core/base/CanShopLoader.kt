package andrey.murzin.com.core.base

import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CanShopLoader {
    @StateStrategyType(SkipStrategy::class)
    fun showLoader(flag: Boolean)
}