package orm.repository.jooq

import org.jooq.DSLContext
import org.springframework.stereotype.Component
import orm.domain.Task
import orm.jooq.Tables.TASKS
import orm.jooq.tables.records.TasksRecord
import orm.repository.TaskRepository

@Component
class TaskDao(private val create: DSLContext) : TaskRepository {
    override fun getTasks(userId: Int, projectId: Int): List<Task> {
        return create.selectFrom(TASKS)
                .where(TASKS.ASSIGNED_TO.eq(userId).and(TASKS.PROJECT_ID.eq(projectId)))
                .fetch { fromRow(it) }
    }

    private fun fromRow(r: TasksRecord) = Task(id = r.id, name = r.name, status = r.status)
}
