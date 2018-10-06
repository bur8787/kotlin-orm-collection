package orm.repository.impl.firestore

import com.google.cloud.firestore.Firestore
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import orm.domain.Task
import orm.repository.TaskRepository
import java.util.*

@Primary
@Repository
class FirestoreTaskDao(private val fireStore: Firestore) : TaskRepository {

    override fun create(projectId: Int, task: Task): Task {
        fireStore.collection("projectCollection")
                .document(projectId.toString())
                .collection("tasks")
                .add(task)
        return task
    }

    override fun findById(taskId: Long): Task {
        TODO()
    }

    override fun findByProjectId(projectId: Int): List<Task> {
        TODO()
    }
}