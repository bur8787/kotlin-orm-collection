package orm.domain

data class Project(
        val id: String? = null,
        val name: String = "",
        val catchPhrase: String = "",
        val logoUrl: String = "",
        val versions: List<Version> = emptyList(),
        val userAuths: List<UserAuth> = emptyList()
)
