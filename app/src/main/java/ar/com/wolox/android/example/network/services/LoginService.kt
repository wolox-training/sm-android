package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.Data
import ar.com.wolox.android.example.model.LoginBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/auth/sign_in")
    suspend fun doLogin(@Body loginBody: LoginBody): Response<Data>
}