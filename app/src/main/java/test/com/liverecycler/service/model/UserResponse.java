package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import test.com.liverecycler.service.model.Info;
import test.com.liverecycler.service.model.RandomUser;

/**
 * Created by william on 22-09-2018.
 */
public class UserResponse {
    @SerializedName("results")
    private List<RandomUser> randomUserList;

    @SerializedName("info")
    private Info info;

    public List<RandomUser> getRandomUserList() {
        return randomUserList;
    }
    public Info getInfo() {
        return info;
    }
}
