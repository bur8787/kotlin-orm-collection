package orm.repository

import orm.domain.Project

interface ProjectRepository {
    fun create(project: Project): Project

    fun findByUserId(userId: Int): List<Project>
}