package kg.flaterlab.book;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
  @GET("books/v1/volumes")
  Observable<SearchRequest> search(@Query("q") String query);



}