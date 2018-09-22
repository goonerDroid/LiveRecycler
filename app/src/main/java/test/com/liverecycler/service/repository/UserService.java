package test.com.liverecycler.service.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.com.liverecycler.service.model.UserResponse;

/**
 * Created by william on 21-09-2018.
 */
public interface UserService {

    String HTTPS_API_URL = "https://randomuser.me/";

    @GET("api/")
    Call<UserResponse> getRandomUsers(@Query("results") String results);
}
