package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 21-09-2018.
 */
public class RandomUserName {

    @SerializedName("title")
    private String title;
    @SerializedName("first")
    private String firstName;
    @SerializedName("last")
    private String lastName;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
