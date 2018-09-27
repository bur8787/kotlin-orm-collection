package orm.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class ActivityController() {

    @GetMapping("/activities/me/latest")
    fun getAuthor(): ActivityResponse {
        return ActivityResponse(
                messages = emptyList(),
                activities = emptyList()
        )
    }
}

class ActivityResponse(
        val messages: List<MessageModel>,
        val activities: List<ActivityModel>
)

class MessageModel(
        val date: LocalDate,
        val comment: String
)

class ActivityModel(
        val date: LocalDate,
        val commitCount: Int
)

