package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.model.LoginBody
import ar.com.wolox.android.example.network.services.LoginService
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkRequestHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LogInRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    private val service: LoginService
        get() = retrofitServices.getService(LoginService::class.java)

    suspend fun doLogin(loginBody: LoginBody) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { service.doLogin(loginBody) }
    }
}