package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 23-09-2018.
 */
public class RandomUserID {

    @SerializedName("name")
    private String randomUserIDName;

    @SerializedName("value")
    private String randomUserIDValue;

    public String getRandomUserIDName() {
        return randomUserIDName;
    }

    public String getRandomUserIDValue() {
        return randomUserIDValue;
    }
}
