package ar.com.wolox.android.example.ui.login

interface LoginView {

    fun showErrorEmail()

    fun showErrorEmptyUsername()

    fun showErrorEmptyPassword()

    fun setCredentials(username: String, password: String)

    fun showTermsAndConditions()

    fun goToHome()

    fun goToSignUp()
}