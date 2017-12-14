package com.example.woojinkim.irproto.data.model;

/**
 * Created by woojinkim on 2017. 10. 24..
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("inputmessage")
    @Expose
    public String inputmessage;
}