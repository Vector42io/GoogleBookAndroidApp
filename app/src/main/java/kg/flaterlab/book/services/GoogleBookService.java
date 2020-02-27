package kg.flaterlab.book.services;

import io.reactivex.Observable;
import kg.flaterlab.book.models.SearchRequest;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBookService {
  @GET("books/v1/volumes")
  Observable<SearchRequest> search(@Query("q") String query);

}