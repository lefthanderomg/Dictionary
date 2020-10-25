package andrey.murzin.com.core.utils

class ComponentCreator<T> {

    var component: T? = null
        private set

    fun create(init: () -> T): T {
        var featureComponent = component
        if (featureComponent == null) {
            featureComponent = init.invoke()
        }

        return featureComponent!!.also {
            component = it
        }
    }

    fun clear() {
        component = null
    }
}