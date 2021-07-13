package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    fun onLoginButtonClicked(user: String, password: String) {
        if (user.isNotEmpty() && password.isNotEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
                userSession.username = user
                view?.goToViewPager()
            } else {
                view?.showErrorEmail()
            }
        } else {
            view?.showErrorEmptyFields()
        }
    }

    // For testing we go to ViewPager
    fun checkUserSession() {
        if (userSession.username != null) {
            view?.goToViewPager()
        }
    }
}