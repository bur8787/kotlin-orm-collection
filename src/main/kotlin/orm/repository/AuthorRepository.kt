package orm.repository

import orm.jooq.tables.records.AuthorsRecord

interface AuthorRepository {
    fun getAuthor(): AuthorsRecord
}