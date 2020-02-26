package kg.flaterlab.book

data class Book(
    val kind : String,
    val id: String,
    val etag : String  ,
    val selfLink : String,
    val volumeInfo : VolumeInfo,
    val saleInfo : SaleInfo,
    val accessInfo: AccessInfo,
    val searchInfo : SearchInfo
) {

}
