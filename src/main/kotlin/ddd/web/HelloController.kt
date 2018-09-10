package ddd.web

import com.example.jooq.tables.Authors.AUTHORS
import org.jooq.DSLContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController(private val create: DSLContext) {

    @GetMapping("/")
    fun hello(): HelloResponse {
        return create.selectFrom(AUTHORS).where(AUTHORS.ID.eq(1)).fetchOne().let {
            HelloResponse(
                    name = it.name
            )
        }
    }
//    fun hello() = HelloResponse(name = "suzuki")
}

class HelloResponse(
        val name: String
)
