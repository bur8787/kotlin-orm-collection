package orm.repository.impl.jooq

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import orm.domain.Task
import orm.jooq.Tables.TASKS
import orm.jooq.tables.records.TasksRecord
import orm.repository.TaskRepository

@Repository
class TaskDao(private val create: DSLContext) : TaskRepository {

    override fun create(task: Task): Task {
        return create.insertInto(TASKS)
                .set(TASKS.NAME, task.name)
                .returning()
                .fetchOne()
                .let{
                    fromRow(it)
                }
    }

    override fun findById(taskId: Long): Task {
        return create.selectFrom(TASKS)
                .where(TASKS.PROJECT_ID.eq(taskId.toInt()))
                .fetchOne { fromRow(it) }
    }

    override fun findByProjectId(projectId: Int): List<Task> {
        return create.selectFrom(TASKS)
                .where(TASKS.PROJECT_ID.eq(projectId))
                .fetch { fromRow(it) }
    }

    private fun fromRow(r: TasksRecord) = Task(id = r.id.toLong(), name = r.name, status = r.status, assignedTo = r.assignedTo)
}
