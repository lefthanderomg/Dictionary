package andrey.murzin.com.translate

import andrey.murzin.com.core.base.BaseFragment
import andrey.murzin.com.translate.main.MainFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity() {

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.appContainer) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: coldStart()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    private fun coldStart() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.appContainer, MainFragment())
            .commitNow()
    }
}