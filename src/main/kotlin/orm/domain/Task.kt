package orm.domain

data class Task(
        val id: String? = "",
        val name: String ="",
        val assignedTo: Int = 0,
        val status: Int = 0
)