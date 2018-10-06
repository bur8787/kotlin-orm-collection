package orm.repository

import orm.domain.Task

interface TaskRepository {
    fun create(projectId: Int, task: Task): Task

    fun findById(taskId: Long): Task

    fun findByProjectId(projectId: Int): List<Task>
}