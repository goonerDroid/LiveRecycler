package test.com.liverecycler.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import test.com.liverecycler.service.repository.ProjectRepository;
import test.com.liverecycler.service.model.UserResponse;

/**
 * Created by william on 21-09-2018.
 */
public class UserViewModel extends AndroidViewModel {

    private LiveData<UserResponse> liveData;
    private MutableLiveData<String> resultSizeReq;


    @Inject
    public UserViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);
        this.resultSizeReq = new MutableLiveData<>();
        liveData = Transformations.switchMap(resultSizeReq,input -> {
            return projectRepository.getRandomUsers(resultSizeReq.getValue());
        });
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<UserResponse> getRandomUsersObservable() {
        return liveData;
    }


    public void setResultRequestSize(String requestSize) {
        this.resultSizeReq.setValue(requestSize);
    }
}
