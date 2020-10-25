package andrey.murzin.com.core.utils

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatEditText
import io.reactivex.Observable

fun AppCompatEditText.rxTextChangeListener(): Observable<String> =
    Observable.create { emitter ->
        val watcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable) {
                if (emitter.isDisposed.not()) {
                    emitter.onNext(editable.toString())
                }
            }
        }
        emitter.setCancellable {
            removeTextChangedListener(watcher)
        }
        addTextChangedListener(watcher)
    }