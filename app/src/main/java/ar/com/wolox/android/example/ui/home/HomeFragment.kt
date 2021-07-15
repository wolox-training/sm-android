package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentHomeBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class HomeFragment private constructor() : WolmoFragment<FragmentHomeBinding, HomePresenter>() {

    override fun init() {
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }
}