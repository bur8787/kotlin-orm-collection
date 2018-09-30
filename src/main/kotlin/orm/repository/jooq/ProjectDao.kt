package orm.repository.jooq

import org.springframework.stereotype.Repository
import orm.domain.Project
import orm.repository.ProjectRepository

@Repository
class ProjectDao : ProjectRepository {

    override fun create(project: Project): Project {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByUserId(userId: Int): List<Project> {
        TODO()
    }
}
