package com.skyzone18.demo1stchoise.RestClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.skyzone18.demo1stchoise.Model.Datum;

import java.util.List;

/**
 * Created by kevalt on 08-08-2017.
 */

public class Responce {
    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
