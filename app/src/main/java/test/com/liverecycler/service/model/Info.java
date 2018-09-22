package test.com.liverecycler.service.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by william on 22-09-2018.
 */

public class Info {
	@SerializedName("seed")
	private String seed;
	@SerializedName("page")
	private String page;
	@SerializedName("results")
	private String results;
	@SerializedName("version")
	private String version;
}