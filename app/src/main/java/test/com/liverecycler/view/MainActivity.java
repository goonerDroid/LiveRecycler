package test.com.liverecycler.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import test.com.liverecycler.R;
import test.com.liverecycler.viewmodel.UserViewModel;
import test.com.liverecycler.di.Injectable;
import test.com.liverecycler.service.model.UserResponse;

public class MainActivity extends AppCompatActivity implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel mUserViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        mUserViewModel.setResultRequestSize("40");
        observeViewModel(mUserViewModel);
    }

    private void observeViewModel(UserViewModel viewModel) {
            viewModel.getRandomUsersObservable().observe(this, this::handleResponse);
    }

    private void handleResponse(UserResponse userResponse) {
            Log.wtf("List Resource","List Resource"+userResponse.getRandomUserList().size());
    }
}
