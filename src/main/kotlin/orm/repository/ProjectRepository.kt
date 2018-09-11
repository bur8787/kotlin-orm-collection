package orm.repository

import orm.domain.Project

interface ProjectRepository {
    fun findByUserId(userId: Int): List<Project>
}