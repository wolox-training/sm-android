package ar.com.wolox.android.example.ui.signup

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo

class SignUpActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, SignUpFragment.newInstance())
    }

    companion object {
        fun start(context: Context) = context.jumpTo(
            SignUpActivity::class.java)
    }
}