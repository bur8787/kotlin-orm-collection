package orm.repository

import orm.domain.Author

interface AuthorRepository {
    fun findById(id :Int): Author
}