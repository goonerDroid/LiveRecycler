package test.com.liverecycler.view.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.liverecycler.R;
import test.com.liverecycler.service.model.RandomUser;

/**
 * Created by william on 23-09-2018.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {


    private List<? extends RandomUser> projectList;

    public void setProjectList(final List<? extends RandomUser> projectList) {
        this.projectList = projectList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int pos) {
        int position = userViewHolder.getAdapterPosition();
        RandomUser discoverShow = projectList.get(position);
        userViewHolder.tvRandomUsername.setText(discoverShow.getRandomUserName().getFirstName());
    }

    @Override
    public int getItemCount() {
        return projectList == null ? 0 : projectList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView tvRandomUsername;


        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
