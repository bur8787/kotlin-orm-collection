package orm.domain

data class User(
        val id: String,
        val name: String,
        val email: String
)

data class Auth(
        val auth: Int = 0
)

data class UserAuth(
        val user: User,
        val auth: Auth
)

