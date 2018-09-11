package orm.domain

data class Task(
        val id: Int,
        val name: String,
        val assignedTo: Int,
        val status: Int
)