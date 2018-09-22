package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 21-09-2018.
 */
public class RandomUserAge {

    @SerializedName("age")
    private int randomUserAge;

    public int getRandomUserAge() {
        return randomUserAge;
    }
}
