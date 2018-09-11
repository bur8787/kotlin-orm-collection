package orm.repository.jooq

import org.jooq.DSLContext
import org.springframework.stereotype.Component
import orm.domain.Author
import orm.domain.Book
import orm.jooq.Tables.AUTHORS
import orm.jooq.Tables.BOOKS
import orm.jooq.tables.records.AuthorsRecord
import orm.jooq.tables.records.BooksRecord
import orm.repository.AuthorRepository

@Component
class AuthorDao(private val create: DSLContext) : AuthorRepository {

    override fun getAuthor(id: Int): Author {
        return create.select(AUTHORS.fields().asList())
                .select(BOOKS.fields().asList())
                .from(AUTHORS)
                .join(BOOKS).on(AUTHORS.ID.eq(BOOKS.AUTHOR_ID))
                .where(AUTHORS.ID.eq(id))
                .fetchGroups(
                        { r -> r.into(AUTHORS) },
                        { r -> r.into(BOOKS) }
                ).entries.first().let {
            fromRow(it)
        }
    }

    private fun fromRow(m: Map.Entry<AuthorsRecord, List<BooksRecord>>) = Author(
            id = m.key.id,
            name = m.key.name,
            books = m.value.map { Book(id = it.id, name = it.name) }
    )
}