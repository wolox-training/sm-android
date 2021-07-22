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
        const val ACCESS_TOKEN = "access_token"
        const val UID = "uid"
        const val CLIENT = "client"
    }

    object ViewPager {
        const val FAVOURITE_COLOR_KEY = "FAVOURITE_COLOR_KEY"
    }

    object Const {
        const val URL_WOLOX = "https://www.wolox.com.ar"
    }

    object Headers {
        const val ACCESS_TOKEN = "Access-Token"
        const val CLIENT = "Client"
        const val UID = "Uid"
    }
}
