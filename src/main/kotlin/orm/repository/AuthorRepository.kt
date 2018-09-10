package orm.repository

import orm.domain.Author

interface AuthorRepository {
    fun getAuthor(id :Int): Author
}