package ar.com.wolox.android.example.ui.home

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.android.example.utils.Extras
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo

class HomeActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, HomeFragment.newInstance())
    }

    companion object {
        fun start(context: Context) = context.jumpTo(
            HomeActivity::class.java)
    }
}