package orm.web

import org.springframework.web.bind.annotation.*
import orm.domain.Project
import orm.domain.Task
import orm.domain.Version
import orm.repository.ProjectRepository

@RestController
class ProjectController(private val projectRepository: ProjectRepository) {

    /**
     * プロジェクトの一覧を取得する
     */
    @GetMapping("/projects")
    fun getProjects(): GetProjectsResponse {
        return projectRepository.findByUserId(1).let {
            GetProjectsResponse(
                    projects = it.map {
                        //                        ProjectModel(id = it?.id ?: 0, name = it.name)
                        ProjectSummaryModel(
                                id = it?.id ?: "",
                                title = it.name,
                                logoUrl = it.logoUrl,
                                catchPhrase = it.catchPhrase
                        )
                    }
            )
        }
    }

    /**
     * プロジェクトの情報を取得する
     */
    @GetMapping("/projects/{projectId}")
    fun getProject(@PathVariable("projectId") projectId: String): ProjectModel {
        return projectRepository.findByProjectId(projectId).let {
            ProjectModel(
                    id = it?.id ?: throw IllegalStateException(),
                    catchPhrase = it.catchPhrase,
                    logoUrl = it.logoUrl,
                    name = it.name,
                    versions = it.versions
            )
        }
    }

    /**
     * プロジェクトを作成する
     */
    @PostMapping("/projects")
    fun postProjects(@RequestBody request: PostProjectsRequest): PostProjectsResponse {
        return projectRepository.createProject(
                request.toProject()
        ).let {
            PostProjectsResponse(
                    id = it?.id ?: throw IllegalStateException(),
                    name = it.name,
                    catchPhrase = it.catchPhrase,
                    logoUrl = it.logoUrl
            )
        }
    }

    /**
     * バージョンを作成する
     */
    @PostMapping("/projects/{projectId}/versions")
    fun postProjects(
            @PathVariable("projectId") projectId: String,
            @RequestBody request: PostVersionsRequest
    ): PostVersionsResponse {
        return projectRepository.createVersion(
                projectId = projectId,
                versionName = request.name
        ).let {
            PostVersionsResponse(
                    id = it?.id ?: throw IllegalStateException(),
                    name = it.name
            )
        }
    }

    /**
     * タスクを作成する
     */
    @PostMapping("/projects/{projectId}/versions/{versionId}/tasks")
    fun postProjects(
            @PathVariable("projectId") projectId: String,
            @PathVariable("versionId") versionId: String,
            @RequestBody request: PostTasksRequest
    ): PostTasksResponse {
        return projectRepository.createTask(
                projectId = projectId,
                versionName = versionId,
                task = request.toTask()
        ).let {
            PostTasksResponse(
                    id = it?.id ?: throw IllegalStateException(),
                    name = it.name
            )
        }
    }
}

class PostProjectsRequest(
        val name: String,
        val catchPhrase: String,
        val logoUrl: String
) {
    fun toProject() = Project(
            name = name,
            catchPhrase = catchPhrase,
            logoUrl = logoUrl
    )
}

class PostProjectsResponse(
        val id: String,
        val name: String,
        val catchPhrase: String,
        val logoUrl: String
)

class PostVersionsRequest(
        val name: String
)

class PostVersionsResponse(
        val id: String,
        val name: String
)

class PostTasksRequest(
        val name: String
) {
    fun toTask() = Task(
            name = name
    )
}

class PostTasksResponse(
        val id: String,
        val name: String
)

class GetProjectsResponse(
        val projects: List<ProjectSummaryModel>
)

class ProjectSummaryModel(
        val id: String,
        val title: String,
        val catchPhrase: String,
        val logoUrl: String
)

class ProjectModel(
        val id: String,
        val name: String,
        val catchPhrase: String,
        val logoUrl: String,
        val versions: List<Version> = emptyList()
)
