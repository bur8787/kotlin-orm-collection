package orm.domain

data class Version(
        val id: String? = null,
        val name: String = "",
        val tasks: List<Task> = emptyList()
)
