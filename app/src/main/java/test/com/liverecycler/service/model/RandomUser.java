package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 21-09-2018.
 */
public class RandomUser {

    @SerializedName("gender")
    private String gender;
    @SerializedName("name")
    private RandomUserName randomUserName;
    @SerializedName("location")
    private RandomUserLocation randomUserLocation;
    @SerializedName("email")
    private String email;
    @SerializedName("dob")
    private RandomUserAge randomUserAge;
    @SerializedName("phone")
    private String phone;
    @SerializedName("cell")
    private String cell;
    @SerializedName("id")
    private RandomUserID randomUserID;
    @SerializedName("picture")
    private RandomUserPicture randomUserPicture;
    @SerializedName("nat")
    private String randomUserNationality;


    public String getGender() {
        return gender;
    }

    public RandomUserName getRandomUserName() {
        return randomUserName;
    }

    public String getEmail() {
        return email;
    }

    public RandomUserAge getRandomUserAge() {
        return randomUserAge;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public RandomUserPicture getRandomUserPicture() {
        return randomUserPicture;
    }

    public String getRandomUserNationality() {
        return randomUserNationality;
    }

    public RandomUserID getRandomUserID() {
        return randomUserID;
    }

    public RandomUserLocation getRandomUserLocation() {
        return randomUserLocation;
    }
}
