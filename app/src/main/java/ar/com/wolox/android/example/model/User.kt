package ar.com.wolox.android.example.model

/**
 * Class User para almacenar los datos en referencia a los obtenidos por el endpoint
 */
data class User(
    val id: Int,
    val email: String,
    val provider: String,
    val uid: String,
    val allowPasswordChange: Boolean,
    val name: String,
    val nickname: String,
    val image: String
)