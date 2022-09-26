package com.example.vkinfo.utils;

import android.net.Uri;

import com.example.vkinfo.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

//здесь будут статические методы которые будут работать с сетью
public class NetworkUtils {
    private static final String VK_API_BASE_URL = "https://api.vk.com/";
    private static final String VK_USERS_GET = "/method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_VERSION = "v";
    private static final String ACCESS_TOKEN="access_token";
    public static URL generateURL(String userIds) {
        //url улица пушкина
        Uri builUri = Uri.parse(VK_API_BASE_URL + VK_USERS_GET)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_ID, userIds)
                .appendQueryParameter(PARAM_VERSION, "5.81")
                .appendQueryParameter(ACCESS_TOKEN,"c7efabefc7efabefc7efabef60c4ff7b7ccc7efc7efabefa4c1118bfdf3ac46bb4d9a99")
                .build();
        URL url = null;
        try {
            url = new URL(builUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (UnknownHostException e){
            return null;
        }finally {
            urlConnection.disconnect();
        }

    }
}
