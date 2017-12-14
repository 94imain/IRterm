package com.example.woojinkim.irproto.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by woojinkim on 2017. 12. 12..
 */

public class NewData {
    @SerializedName("newmessage")
    @Expose
    public String newmessage;

    @SerializedName("emotion")
    @Expose
    public String emotion;


}
