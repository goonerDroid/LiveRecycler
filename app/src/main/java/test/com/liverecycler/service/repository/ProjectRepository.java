package test.com.liverecycler.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.com.liverecycler.service.model.UserResponse;
import test.com.liverecycler.service.repository.UserService;

/**
 * Created by william on 22-09-2018.
 */

@Singleton
public class ProjectRepository {

    private UserService userService;
    private final MutableLiveData<UserResponse> data = new MutableLiveData<>();

    @Inject
    public ProjectRepository(UserService gitHubService) {
        this.userService = gitHubService;
    }

    public LiveData<UserResponse> getRandomUsers(String resultSize) {
        userService.getRandomUsers(resultSize).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
