package orm

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun swaggerSpringMvcPlugin(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
    }

    private fun paths(): Predicate<String> {
        return Predicates.and(
                Predicates.not(Predicates.containsPattern("/error")),
                Predicates.containsPattern("/*")
        )
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "Task Manager Web API", // name
                "Task Manager Web API", // description
                "0.0.1", // version
                "", // terms of service url
                Contact("@_suzutt", "", ""),
                "",
                "",
                emptyList()
        )
    }
}