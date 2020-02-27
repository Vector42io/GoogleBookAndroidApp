package kg.flaterlab.book.models

data class SearchRequest (
    val kind : String,
    val totalItems : Int,
    val items :ArrayList<Book>
)