package ddd.repository

import com.example.jooq.tables.records.AuthorsRecord

interface AuthorRepository {
    fun getAuthor(): AuthorsRecord
}