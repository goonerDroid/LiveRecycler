package test.com.liverecycler.view.adapter;


import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.liverecycler.R;
import test.com.liverecycler.service.model.RandomUser;
import test.com.liverecycler.view.customview.CircleButton;

import static test.com.liverecycler.utils.CommonUtils.capitalize;

/**
 * Created by william on 23-09-2018.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {


    private List<RandomUser> projectList;
    private RequestOptions defaultOptions = new RequestOptions();

    public void setProjectList(final List<RandomUser> projectList) {
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
        RandomUser randomUser = projectList.get(pos);


        userViewHolder.tvUserName.setText(capitalize(randomUser.getRandomUserName().getFirstName().concat(" ")
                .concat(randomUser.getRandomUserName().getLastName())));

        userViewHolder.tvUserAge.setText(randomUser.getRandomUserAge().getRandomUserAge() + " yrs");
        userViewHolder.tvUserLocation.setText(capitalize(randomUser.getRandomUserLocation().getCity().concat(", ")
                .concat(randomUser.getRandomUserLocation().getState())));
        userViewHolder.tvUserEmail.setText(randomUser.getEmail());
        userViewHolder.tvUserPhone.setText(randomUser.getPhone());



        defaultOptions = defaultOptions
                .priority(Priority.IMMEDIATE)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(userViewHolder.ivUserImg.getContext())
                .load(randomUser.getRandomUserPicture().getLargeSizePic())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(userViewHolder.ivUserImg);


        userViewHolder.cbUserCancel.setOnClickListener(view -> cancelClick(userViewHolder,userViewHolder.getAdapterPosition()));
        userViewHolder.cbUserAccept.setOnClickListener(view -> acceptClick(userViewHolder,userViewHolder.getAdapterPosition()));
    }

    private void acceptClick(UserViewHolder userViewHolder, int adapterPosition) {
        Snackbar snackbar = Snackbar
                .make(userViewHolder.cbUserAccept, "Congrats " + capitalize(projectList.get(adapterPosition)
                        .getRandomUserName().getFirstName()) + " has been matched!", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void cancelClick(UserViewHolder userViewHolder, int adapterPosition) {
        final RandomUser deletedItem = projectList.get(userViewHolder.getAdapterPosition());
        final int deletedIndex = userViewHolder.getAdapterPosition();
        Snackbar snackbar = Snackbar
                .make(userViewHolder.cbUserCancel, capitalize(projectList.get(adapterPosition)
                        .getRandomUserName().getFirstName()) + " has been removed from the list!", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", view -> {
            // undo is selected, restore the deleted item
            restoreItem(deletedItem, deletedIndex);
        });
        snackbar.show();

        removeItem(userViewHolder.getAdapterPosition());
    }

    public void restoreItem(RandomUser randomUser, int position) {
        projectList.add(position, randomUser);
        notifyItemInserted(position);
    }

    public void removeItem(int adapterPosition) {
        projectList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        notifyItemRangeChanged(adapterPosition, projectList.size());
    }

    @Override
    public int getItemCount() {
        return projectList == null ? 0 : projectList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_image)
        ImageView ivUserImg;
        @BindView(R.id.user_name)
        TextView tvUserName;
        @BindView(R.id.user_age)
        TextView tvUserAge;
        @BindView(R.id.user_location)
        TextView tvUserLocation;
        @BindView(R.id.user_email)
        TextView tvUserEmail;
        @BindView(R.id.user_phone)
        TextView tvUserPhone;
        @BindView(R.id.user_cancel)
        CircleButton cbUserCancel;
        @BindView(R.id.user_accept)
        CircleButton cbUserAccept;


        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
