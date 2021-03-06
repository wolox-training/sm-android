package ar.com.wolox.android.example.utils

import android.app.Activity
import android.content.SharedPreferences
import androidx.fragment.app.Fragment

/**
 * Util class to store keys to use with [SharedPreferences] or as argument between
 * [Fragment] or [Activity].
 */
object Extras {

    object UserLogin {
        const val USERNAME = "username"
        const val PASSWORD = "password"
    }

    object ViewPager {
        const val FAVOURITE_COLOR_KEY = "FAVOURITE_COLOR_KEY"
    }

    object Const {
        const val URL_WOLOX = "https://www.wolox.com.ar"
    }
}
