package orm.repository

import orm.jooq.Tables.AUTHORS
import orm.jooq.tables.records.AuthorsRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class AuthorDao(private val create: DSLContext) : AuthorRepository {

    override fun getAuthor(): AuthorsRecord {
        return create.selectFrom(AUTHORS).where(AUTHORS.ID.eq(1)).fetchOne()
    }
}