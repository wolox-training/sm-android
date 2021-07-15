package ar.com.wolox.android.example.ui.login

interface LoginView {

    fun showErrorEmail()

    fun showErrorEmptyUsername()

    fun showErrorEmptyPassword()

    fun showSuccessMessage()

    fun setCredentials(username: String, password: String)
}