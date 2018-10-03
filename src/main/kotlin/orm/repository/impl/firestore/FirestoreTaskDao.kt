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

    override fun create(task: Task): Task {
        val docRef = fireStore.collection("users").document(task.name)
        val data = HashMap<String, Any>()
        data["first"] = task.name
        data["last"] = "Lovelace"
        data["born"] = 1815
        val result = docRef.set(data)
        return Task(name = task.name)
    }

    override fun findById(taskId: Long): Task {
        TODO()
    }

    override fun findByProjectId(projectId: Int): List<Task> {
        TODO()
    }
}