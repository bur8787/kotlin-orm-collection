package orm

import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean


@SpringBootApplication
class Application : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.sources(Application::class.java)
    }

    @Bean
    fun cloudDatastoreService(): DatastoreService {
        return DatastoreServiceFactory.getDatastoreService()
    }


    @Bean
    fun firestoreService(): Firestore {
        val firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                .setProjectId("orm-test-218215")
                .build()
        return firestoreOptions.service
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}