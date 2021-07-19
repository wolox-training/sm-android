package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.model.LoginBody
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.LogInRepository
import ar.com.wolox.android.example.utils.Extras
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val userSession: UserSession,
    private val loginRepository: LogInRepository
) : CoroutineBasePresenter<LoginView>() {

    /**
     * Chequea si el usarname y password cumplen las condiciones para ir a la siguiente pantalla.
     * En caso negativo informa a la vista los mensajes de error correspondientes
     */
    fun onLoginButtonClicked(user: String, password: String) {
        if (user.isNotEmpty()) {
            if (isValidEmail(user)) {
                if (password.isNotEmpty()) {

                    doLogin(LoginBody(user, password))

                } else view?.showErrorEmptyPassword()
            } else view?.showErrorEmail()
        } else view?.showErrorEmptyUsername()
    }

    fun doLogin(loginBody: LoginBody) = launch {
        networkRequest(loginRepository.doLogin(loginBody)) {
            onResponseSuccessful { body, headers ->

                userSession.username = loginBody.email
                userSession.password = loginBody.password
                userSession.accessToken = headers.get(Extras.Headers.ACCESS_TOKEN)
                userSession.uid = headers.get(Extras.Headers.CLIENT)
                userSession.client = headers.get(Extras.Headers.UID)

                view?.goToHome()

                // For test to get data
                val nickName = body?.data?.nickname
            }
            onResponseFailed { responseBody, i -> }
            onCallFailure { }
        }
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