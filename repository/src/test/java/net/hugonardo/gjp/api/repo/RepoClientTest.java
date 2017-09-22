package net.hugonardo.gjp.api.repo;

import net.hugonardo.gjp.api.ApiResponse;
import net.hugonardo.gjp.api.infra.di.DaggerUnitTestComponent;
import net.hugonardo.gjp.api.infra.util.Streams;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.BufferedSource;
import retrofit2.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class RepoClientTest {

    @Inject RepoClient mRepoClient;
    @Inject MockWebServer mMockWebServer;
    @Inject Streams mStreams;

    @Before public void setUp() throws Exception {
        DaggerUnitTestComponent.create().inject(this);
    }

    @After
    public void stopService() throws IOException {
        mMockWebServer.shutdown();
    }

    @Test public void getJavaPopRepos() throws Exception {
        final String header = "<https://api.github.com/search/repositories?q=foo&page=2>; rel=\"next\","
                + " <https://api.github.com/search/repositories?q=foo&page=34>; rel=\"last\"";
        BufferedSource source = mStreams.loadResourceFile("api-response/getJavaPopRepos.json");
        mMockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(source.readUtf8())
                .addHeader("link", header)
        );

        // RecordedRequest request = mMockWebServer.takeRequest();
        // assertThat(request.getMethod(), is("GET"));
        // assertThat(request.getPath(), is("search/repositories"));

        Response<RepoSearchResponse> response = mRepoClient.getJavaPopRepos(1).execute();
        ApiResponse<RepoSearchResponse> apiResponse = new ApiResponse<>(response);

        assertThat(apiResponse, notNullValue());
        assertThat(apiResponse.body().total(), is(3635125L));
        assertThat(apiResponse.body().items().size(), is(30));
        assertThat(apiResponse.links().get("next"), is("https://api.github.com/search/repositories?q=foo&page=2"));
        assertThat(apiResponse.nextPage(), is(2));
    }
}