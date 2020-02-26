package kg.flaterlab.book

data class SearchRequest (
    val kind : String,
    val totalItems : Int,
    val items :ArrayList<Book>
)