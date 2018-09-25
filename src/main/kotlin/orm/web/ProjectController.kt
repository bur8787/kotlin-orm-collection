package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import orm.repository.ProjectRepository

@RestController
class ProjectController(private val projectRepository: ProjectRepository) {

    @GetMapping("/projects")
    fun getAuthor(): OwnProjectsResponse {
        return projectRepository.findByUserId(1).let {
            OwnProjectsResponse(
                    projects = it.map {
                        ProjectModel(id = it.id, name = it.name)
                    }
            )
        }
    }
}

class OwnProjectsResponse(
        val projects: List<ProjectModel>
)

class ProjectModel(
        val id: Int,
        val name: String
)
