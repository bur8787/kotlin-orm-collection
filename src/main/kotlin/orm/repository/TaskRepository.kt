package orm.repository

import orm.domain.Task

interface TaskRepository {
    fun findByProjectId(projectId: Int): List<Task>
}