package orm.repository

import orm.domain.Project
import orm.domain.Task
import orm.domain.Version

interface ProjectRepository {
    fun createProject(project: Project): Project

    fun createVersion(projectId: String, versionName: String): Version

    fun createTask(projectId: String, versionName: String, task: Task): Task

    fun findByProjectId(userId: String): Project?

    fun findByUserId(userId: Int): List<Project>
}