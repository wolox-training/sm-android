package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    /**
     * Chequea si el usarname y password cumplen las condiciones para ir a la siguiente pantalla.
     * En caso negativo informa a la vista los mensajes de error correspondientes
     */
    fun onLoginButtonClicked(user: String, password: String) {
        if (user.isNotEmpty()) {
            if (isValidEmail(user)) {
                if (password.isNotEmpty()) {

                    userSession.username = user
                    userSession.password = password

                    view?.goToHome()
                } else view?.showErrorEmptyPassword()
            } else view?.showErrorEmail()
        } else view?.showErrorEmptyUsername()
    }

    /**
     * Chequea si el username se encuentra almacenado y setear las credenciales que el usuario
     * previamente ingresó
     */
    fun checkUserSession() {
        if (userSession.username != null) {
            view?.setCredentials(userSession.username.toString(), userSession.password.toString())
        }
    }

    /**
     * Retorna true si un email ingresado coincide con el patron example@domain.com
     */
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun onSignUpButtonClicked() {
        view?.goToSignUp()
    }

    fun onTermsAndConditionClicked() {
        view?.showTermsAndConditions()
    }
}