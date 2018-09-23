package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 23-09-2018.
 */
public class RandomUserLocation {

    @SerializedName("street")
    private String street;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
