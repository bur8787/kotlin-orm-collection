package orm.repository.impl.datastore

import com.google.appengine.api.datastore.*
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import orm.domain.Project
import orm.domain.Task
import orm.repository.TaskRepository

@Primary
@Repository
class TaskRepositoryDao(private val datastore: DatastoreService) : TaskRepository {

    private val kind = "Task"

    override fun create(task: Task): Task {
        return datastore.put(taskToEntity(task = task)).let {
            findById(it.id)
        }
    }

    override fun findById(taskId: Long): Task {
        return datastore.get(KeyFactory.createKey(kind, taskId.toLong())).let {
            fromEntity(it)
        }
    }

    override fun findByProjectId(projectId: Int): List<Task> {
        val query = Query(kind)
        query.addSort(Project::id.name, Query.SortDirection.ASCENDING)

        val prepare = datastore.prepare(query)
        val results = prepare.asQueryResultIterator()

        return results.asSequence().map { fromEntity(it) }.toList()
    }

    private fun taskToEntity(key: Key? = null, task: Task): Entity {
//        val entity = if (key != null) Entity(key) else Entity(kind, task.id.toLong())
        val entity = Entity(kind)
        entity.let {
            it.setProperty(Task::projectId.name, task.projectId)
            it.setProperty(Task::name.name, task.name)
        }
        return entity
    }

    private fun fromEntity(entity: Entity): Task {
        return Task(
                id = entity.key.id,
                name = entity.getProperty(Task::name.name) as String,
                assignedTo = 0,
                status = 0
        )
    }
}