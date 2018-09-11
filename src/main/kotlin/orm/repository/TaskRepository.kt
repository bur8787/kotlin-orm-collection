package orm.repository

import orm.domain.Task

interface TaskRepository {
    fun findByUserIdAndProjectId(userId: Int, projectId: Int): List<Task>
}