package ar.com.wolox.android.example.ui.login

import android.content.Intent
import android.net.Uri
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.signup.SignUpActivity
import ar.com.wolox.android.example.utils.Extras
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class LoginFragment private constructor() : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    override fun init() {
        presenter.checkUserSession()
    }

    override fun layout() = R.layout.fragment_login

    override fun setListeners() {
        with(binding) {
            buttonLogIn.setOnClickListener {
                presenter.onLoginButtonClicked(edtEmail.text.toString().trim(), edtPassword.text.toString().trim())
            }
            textTermsAndConditions.setOnClickListener { presenter.onTermsAndConditionClicked() }
            buttonSignUp.setOnClickListener {
                presenter.onSignUpButtonClicked()
            }
        }
    }

    override fun showErrorEmail() {
        binding.edtEmail.error = getString(R.string.incorrect_format_email)
    }

    override fun showErrorEmptyUsername() {
        binding.edtEmail.error = getString(R.string.username_requerided)
    }

    override fun showErrorEmptyPassword() {
        binding.edtPassword.error = getString(R.string.passwrod_requerided)
    }

    override fun setCredentials(username: String, password: String) {
        binding.edtEmail.setText(username)
        binding.edtPassword.setText(password)
    }

    override fun showTermsAndConditions() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(Extras.Const.URL_WOLOX))
        startActivity(intent)
    }

    override fun goToHome() {
        val intent = Intent(context, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun goToSignUp() {
        val intent = Intent(context, SignUpActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
