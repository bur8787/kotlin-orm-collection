package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelthCheck {
    @GetMapping("/helth")
    fun hello() = Unit
}
