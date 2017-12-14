package com.example.woojinkim.irproto.data.remote;

/**
 * Created by woojinkim on 2017. 10. 24..
 */


import com.example.woojinkim.irproto.data.model.NewData;
import com.example.woojinkim.irproto.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/users/signup")
    @FormUrlEncoded
    Call<Post> savePost(@Field("inputmessage") String inputmessage);

    @POST("/users/newdata")
    @FormUrlEncoded
    Call<NewData> saveNewdata(@Field("newmessage") String newmessage,
                              @Field("emotion") String emotion);
}