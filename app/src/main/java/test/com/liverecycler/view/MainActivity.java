package test.com.liverecycler.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import test.com.liverecycler.R;
import test.com.liverecycler.view.adapter.UserListAdapter;
import test.com.liverecycler.viewmodel.UserViewModel;
import test.com.liverecycler.di.Injectable;
import test.com.liverecycler.service.model.UserResponse;

/**
 * Created by william on 22-09-2018.
 */

public class MainActivity extends AppCompatActivity implements Injectable {
    private UserListAdapter userListAdapter;

    @BindView(R.id.rv_user_list)
    RecyclerView rvEpisodes;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setViews();
        UserViewModel mUserViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        getRandomUsers(mUserViewModel);
    }

    private void getRandomUsers(UserViewModel mUserViewModel){
        mUserViewModel.setResultRequestSize("30");
        observeViewModel(mUserViewModel);
    }

    private void setViews() {
        userListAdapter = new UserListAdapter();
        rvEpisodes.setLayoutManager(new LinearLayoutManager(this));
        rvEpisodes.setHasFixedSize(true);
        rvEpisodes.setAdapter(userListAdapter);
    }

    private void observeViewModel(UserViewModel viewModel) {
        viewModel.getRandomUsersObservable().observe(this, this::setData);
    }

    private void setData(UserResponse userResponse) {
        Log.wtf("List Resource","List Resource"+userResponse.getRandomUserList().size());
        userListAdapter.setProjectList(userResponse.getRandomUserList());
    }
}
