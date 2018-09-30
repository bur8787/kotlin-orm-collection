package orm.repository.jooq

import org.springframework.stereotype.Repository
import orm.domain.Author
import orm.repository.AuthorRepository

@Repository
class AuthorDao : AuthorRepository {
    override fun findById(id: Int): Author {
        TODO()
    }
}