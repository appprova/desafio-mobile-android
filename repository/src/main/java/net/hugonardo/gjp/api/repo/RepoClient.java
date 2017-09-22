package net.hugonardo.gjp.api.repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoClient {
    @GET("search/repositories?q=language:Java&sort=stars")
    Call<RepoSearchResponse> getJavaPopRepos(@Query("page") int page);
}
