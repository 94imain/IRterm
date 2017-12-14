package com.example.woojinkim.irproto.data.remote;

/**
 * Created by woojinkim on 2017. 10. 24..
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://35.201.250.189:9999";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}