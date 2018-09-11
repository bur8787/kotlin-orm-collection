package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import orm.repository.TaskRepository

@RestController
class TaskController(private val taskRepository: TaskRepository) {

    @GetMapping("/projects/{projectId}/tasks")
    fun getTask(@PathVariable("projectId") projectId: Int): TaskResponse {
        return taskRepository.findByProjectId(projectId).let {
            TaskResponse(
                    tasks = it.map {
                        TaskModel(id = it.id, name = it.name, status = it.status, assignedTo = it.assignedTo)
                    }
            )
        }
    }
}

class TaskResponse(
        val tasks: List<TaskModel>
)

class TaskModel(
        val id: Int,
        val name: String,
        val status: Int,
        val assignedTo: Int
)
