package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import orm.repository.AuthorRepository

@RestController
class AuthorController(private val authorRepository: AuthorRepository) {

    @GetMapping("/author/{authorId}")
    fun getAuthor(@PathVariable("authorId") authorId: Int): AuthorResponse {
        return authorRepository.getAuthor(authorId).let {
            AuthorResponse(
                    id = it.id,
                    name = it.name,
                    books = it.books.map {
                        BookModel(id = it.id, name = it.name)
                    }
            )
        }
    }
}

class AuthorResponse(
        val id: Int,
        val name: String,
        val books: List<BookModel>
)

class BookModel(
        val id: Int,
        val name: String
)
