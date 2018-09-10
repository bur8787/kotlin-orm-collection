package orm.domain

data class Author(
        val id: Int,
        val name: String,
        val books: List<Book>
)