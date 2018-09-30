package orm.repository.jooq

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import orm.domain.Task
import orm.jooq.Tables.TASKS
import orm.jooq.tables.records.TasksRecord
import orm.repository.TaskRepository

@Repository
class TaskDao(private val create: DSLContext) : TaskRepository {
    override fun findByProjectId(projectId: Int): List<Task> {
        return create.selectFrom(TASKS)
                .where(TASKS.PROJECT_ID.eq(projectId))
                .fetch { fromRow(it) }
    }

    private fun fromRow(r: TasksRecord) = Task(id = r.id, name = r.name, status = r.status, assignedTo = r.assignedTo)
}
