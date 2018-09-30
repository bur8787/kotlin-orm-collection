package orm.repository.jooq

import org.springframework.stereotype.Repository
import orm.domain.Task
import orm.repository.TaskRepository

@Repository
class TaskDao() : TaskRepository {
    override fun findByProjectId(projectId: Int): List<Task> {
        TODO()
    }
}
