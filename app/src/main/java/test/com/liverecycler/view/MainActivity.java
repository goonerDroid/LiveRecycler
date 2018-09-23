package test.com.liverecycler.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import test.com.liverecycler.R;
import test.com.liverecycler.service.model.RandomUser;
import test.com.liverecycler.view.adapter.UserListAdapter;
import test.com.liverecycler.view.customview.RecyclerItemTouchHelper;
import test.com.liverecycler.viewmodel.UserViewModel;
import test.com.liverecycler.di.Injectable;
import test.com.liverecycler.service.model.UserResponse;

import static test.com.liverecycler.view.adapter.UserListAdapter.capitalize;

/**
 * Created by william on 22-09-2018.
 */

public class MainActivity extends AppCompatActivity implements Injectable, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    private UserListAdapter userListAdapter;

    @BindView(R.id.rv_user_list)
    RecyclerView rvEpisodes;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private List<RandomUser> randomUserList = new ArrayList<>();

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

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvEpisodes);
    }

    private void observeViewModel(UserViewModel viewModel) {
        viewModel.getRandomUsersObservable().observe(this, this::setData);
    }

    private void setData(UserResponse userResponse) {
        randomUserList.clear();
        randomUserList.addAll(userResponse.getRandomUserList());
        userListAdapter.setProjectList(randomUserList);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        final RandomUser deletedItem = randomUserList.get(viewHolder.getAdapterPosition());
        final int deletedIndex = viewHolder.getAdapterPosition();

        Snackbar snackbar = Snackbar
                .make(rvEpisodes, capitalize(randomUserList.get(position).getRandomUserName()
                        .getFirstName()) + " has been removed from the list!", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", view -> {
            // undo is selected, restore the deleted item
            userListAdapter.restoreItem(deletedItem, deletedIndex);
        });
        snackbar.show();

        userListAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}
