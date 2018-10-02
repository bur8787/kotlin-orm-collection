package orm.domain

data class Task(
        val id: Long = 0,
        val projectId: Int = 0,
        val name: String,
        val assignedTo: Int = 0,
        val status: Int = 0
)