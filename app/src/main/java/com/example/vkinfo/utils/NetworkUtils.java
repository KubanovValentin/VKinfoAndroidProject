package com.example.vkinfo.utils;

import android.net.Uri;
import com.example.vkinfo.MainActivity;
import java.net.MalformedURLException;
import java.net.URL;

//здесь будут статические методы которые будут работать с сетью
public class NetworkUtils {
    private static final String VK_API_BASE_URL = "https://api.vk.com/";
    private static final String VK_USERS_GET = "/method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_VERSION = "v";

    public static URL generateURL(String userId) {
        //url улица пушкина
        Uri builUri = Uri.parse(VK_API_BASE_URL + VK_USERS_GET)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_ID, userId)
                .appendQueryParameter(PARAM_VERSION, "5.8")
                .build();
        URL url = null;
        try {
            url=new URL(builUri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }
}
