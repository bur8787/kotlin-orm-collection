package orm.repository.impl.jooq

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import orm.domain.Project
import orm.jooq.Tables.*
import orm.jooq.tables.records.ProjectsRecord
import orm.jooq.tables.records.UsersRecord
import orm.repository.ProjectRepository

@Repository
class ProjectDao(private val create: DSLContext) : ProjectRepository {

    override fun create(project: Project): Project {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByUserId(userId: Int): List<Project> {
        return create.select(PROJECTS.fields().asList())
                .select(USERS.fields().asList())
                .from(PROJECTS)
                .join(USER_TO_PROJECT).on(PROJECTS.ID.eq(USER_TO_PROJECT.PROJECT_ID))
                .join(USERS).on(USERS.ID.eq(USER_TO_PROJECT.USER_ID))
                .where(USERS.ID.eq(userId))
                .fetchGroups(
                        { r -> r.into(USERS) },
                        { r -> r.into(PROJECTS) }
                ).entries.first().let {
            fromRow(it)
        }
    }

    private fun fromRow(m: Map.Entry<UsersRecord, List<ProjectsRecord>>): List<Project> {
        return m.value.map {
            Project(
                    id = it.id,
                    title = it.name,
                    subTitle = "",
                    logoUrl = ""
            )
        }
    }
}
