package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import orm.domain.Project
import orm.repository.ProjectRepository

@RestController
class ProjectController(private val projectRepository: ProjectRepository) {

    @GetMapping("/projects")
    fun getProjects(): GetProjectsResponse {
        return projectRepository.findByUserId(1).let {
            GetProjectsResponse(
                    projects = it.map {
                        ProjectModel(id = it.id!!, title = it.title)
                    }
            )
        }
    }

    @PostMapping("/projects")
    fun postProjects(@RequestBody request: PostProjectsRequest): PostProjectsResponse {
        return projectRepository.create(
                request.toProject()
        ).let {
            PostProjectsResponse(
                    id = it.id!!,
                    title = it.title,
                    subTitle = it.subTitle,
                    logoUrl = it.logoUrl
            )
        }
    }
}

class PostProjectsRequest(
        val title: String = "フカル",
        val subTitle: String = "個人向けプロダクト管理ツール",
        val logoUrl: String = ""
) {
    fun toProject() = Project(
            title = title,
            subTitle = subTitle,
            logoUrl = logoUrl
    )
}

class PostProjectsResponse(
        val id: Int = 1,
        val title: String = "フカル",
        val subTitle: String = "個人向けプロダクト管理ツール",
        val logoUrl: String = ""
)

class GetProjectsResponse(
        val projects: List<ProjectModel>
)

class ProjectModel(
        val id: Int = 1,
        val title: String = "フカル",
        val subTitle: String = "個人向けプロダクト管理ツール",
        val logoUrl: String = ""
)
