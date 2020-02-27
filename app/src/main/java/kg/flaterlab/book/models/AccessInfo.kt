package kg.flaterlab.book.models

data class AccessInfo (
    val country: String,
    val viewability: String,
    val embeddable: Boolean,
    val publicDomain: Boolean,
    val textToSpeechPermission:     String,
    val epub: Epub,
    val pdf: Epub,
    val webReaderLink: String,
    val accessViewStatus : String,
    val quoteSharingAllowed: Boolean
){

}
