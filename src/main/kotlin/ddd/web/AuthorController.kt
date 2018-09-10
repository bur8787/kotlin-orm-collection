package ddd.web

import ddd.repository.AuthorRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthorController(private val authorRepository: AuthorRepository) {

    @GetMapping("/author")
    fun getAuthor(): AuthorResponse {
        return authorRepository.getAuthor().let {
            AuthorResponse(
                    id = it.id,
                    name = it.name
            )
        }
    }
}

class AuthorResponse(
        val id: Int,
        val name: String
)
