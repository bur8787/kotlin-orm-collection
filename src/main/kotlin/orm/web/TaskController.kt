package orm.web

import org.springframework.web.bind.annotation.*
import orm.domain.Task
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

    @PostMapping("/projects/{projectId}/tasks")
    fun getTask(
            @PathVariable("projectId") projectId: Int,
            @RequestBody req: TaskRequest
    ): TaskModel {
        return taskRepository.create(
                Task(
                        name = req.name,
                        projectId = projectId
                )
        ).let {
            TaskModel(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    assignedTo = it.assignedTo
            )
        }
    }
}

class TaskResponse(
        val tasks: List<TaskModel>
)

class TaskRequest(
        val name: String
)

class TaskModel(
        val id: Long,
        val name: String,
        val status: Int,
        val assignedTo: Int
)
