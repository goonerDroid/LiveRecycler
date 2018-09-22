package test.com.liverecycler.service.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 21-09-2018.
 */
public class RandomUserPicture {

    @SerializedName("large")
    private String largeSizePic;
    @SerializedName("medium")
    private String mediumSizePic;
    @SerializedName("thumbnail")
    private String thumbmailPic;


    public String getLargeSizePic() {
        return largeSizePic;
    }

    public String getMediumSizePic() {
        return mediumSizePic;
    }

    public String getThumbmailPic() {
        return thumbmailPic;
    }
}
