package ar.com.wolox.android.example.ui.signup

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentSignUpBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class SignUpFragment private constructor() : WolmoFragment<FragmentSignUpBinding, SignUpPresenter>() {

    override fun init() {
    }

    override fun layout() = R.layout.fragment_sign_up

    companion object {
        fun newInstance() = SignUpFragment()
    }
}