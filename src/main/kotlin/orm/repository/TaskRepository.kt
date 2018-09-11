package orm.repository

import orm.domain.Task

interface TaskRepository {
    fun getTasks(userId: Int, projectId: Int): List<Task>
}