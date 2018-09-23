package test.com.liverecycler.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.WindowManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.com.liverecycler.R;

/**
 * Created by william on 24-09-2018.
 */
public class CommonUtils {


    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(context,
                R.style.ProgressDialog);

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Fetching users....");
        progressDialog.show();
        return progressDialog;
    }


    public static  String capitalize(String capString){
        StringBuffer capBuffer = new StringBuffer();
        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
        while (capMatcher.find()){
            capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
        }

        return capMatcher.appendTail(capBuffer).toString();
    }
}
