package orm.repository.impl.firestore

import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.SetOptions
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import orm.domain.Project
import orm.domain.Task
import orm.domain.Version
import orm.repository.ProjectRepository

@Primary
@Repository
class FirestoreProjectDao(private val fireStore: Firestore) : ProjectRepository {

    val projectCollection = "projects"
    val versionCollection = "versions"
    val taskCollection = "tasks"

    override fun createProject(project: Project): Project {
        return fireStore.collection(projectCollection).document().apply {
            set(projectToDocument(project), SetOptions.merge())
        }.let {
            project.copy(id = it.id)
        }
    }

    override fun createVersion(projectId: String, versionName: String): Version {
        return fireStore.collection(projectCollection).document(projectId)
                .collection(versionCollection).document().apply {
                    set(VersionDocument(name = versionName), SetOptions.merge())
                }.let {
                    Version(name = versionName, id = it.id)
                }
    }

    override fun createTask(projectId: String, versionId: String, task: Task): Task {
        return fireStore.collection(projectCollection).document(projectId)
                .collection(versionCollection).document(versionId)
                .collection(taskCollection).document().apply {
                    set(taskToDocument(task), SetOptions.merge())
                }.let {
                    task.copy(id = it.id)
                }
    }

    override fun findByProjectId(projectId: String): Project? {
        return fireStore.collection(projectCollection)
                .document(projectId)
                .let { projectRef ->
                    val project = projectRef.get().get().toObject(Project::class.java)
                    project?.copy(
                            id = projectRef.id,
                            versions = projectRef.collection(versionCollection)
                                    .get().get().documents
                                    .map { versionRef ->
                                        val version = versionRef.toObject(Version::class.java)
                                        version.copy(
                                                id = versionRef.id,
                                                tasks = fireStore.collection(projectCollection).document(projectRef.id)
                                                        .collection(versionCollection).document(versionRef.id)
                                                        .collection(taskCollection)
                                                        .get().get().documents.map { taskRef ->
                                                    val task = taskRef.toObject(Task::class.java)
                                                    task.copy( id = taskRef.id)
                                                }
                                        )
                                    })
                }
    }

    override fun findByUserId(userId: Int): List<Project> {
        return fireStore.collection(projectCollection)
                .get()
                .get()
                .documents
                .map { document ->
                    val project = document.toObject(Project::class.java)
                    project.copy(id = document.id)
                }
    }

    class ProjectDocument(
            val name: String = "",
            val subTitle: String = "",
            val logoUrl: String = ""
    )

    fun projectToDocument(p: Project): ProjectDocument {
        return ProjectDocument(
                name = p.name,
                subTitle = p.catchPhrase,
                logoUrl = p.logoUrl
        )
    }

    class VersionDocument(
            val name: String = ""
    )

    fun versionToDocument(v: Version): VersionDocument {
        return VersionDocument(
                name = v.name
        )
    }

    class TaskDocument(
            val name: String = "",
            val status: Int = 0
    )

    fun taskToDocument(t: Task): TaskDocument {
        return TaskDocument(
                name = t.name,
                status = t.status
        )
    }

//    fun toProject(d: ProjectDocument): Project{
//
//    }
}
