package ar.com.wolox.android.example.ui.login

import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class LoginFragment private constructor() : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    override fun init() {
        presenter.checkUserSession()
    }

    override fun layout() = R.layout.fragment_login

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun setListeners() {
        with(binding) {
            buttonLogIn.setOnClickListener {
                presenter.onLoginButtonClicked(edtEmail.text.toString(), edtPassword.text.toString())
            }
        }
    }

    override fun showErrorEmptyFields() {
        Toast.makeText(context, getString(R.string.fields_requerided), Toast.LENGTH_SHORT).show()
    }

    override fun showErrorEmail() {
        binding.edtEmail.setError(getString(R.string.incorrect_format_email))
    }

    // For testing we send a String colour
    override fun goToViewPager() {
        ViewPagerActivity.start(requireContext(), getString(R.string.test_color_blue))
    }
}