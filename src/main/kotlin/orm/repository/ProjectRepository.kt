package orm.repository

import orm.domain.Project

interface ProjectRepository {
    fun getProjects(userId: Int): List<Project>
}