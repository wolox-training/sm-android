package ar.com.wolox.android.example.ui.login

import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
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

    // For test
    override fun showSuccessMessage() {
        Toast.makeText(context, getString(R.string.success), Toast.LENGTH_SHORT).show()
    }

    override fun setCredentials(username: String, password: String) {
        binding.edtEmail.setText(username)
        binding.edtPassword.setText(password)
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
