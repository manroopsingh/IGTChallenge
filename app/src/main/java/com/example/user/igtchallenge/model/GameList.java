package com.example.user.igtchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 4/26/2017.
 */

public class GameList {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("data")
    @Expose
    private List<Game> data = null;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Game> getData() {
        return data;
    }

    public void setData(List<Game> data) {
        this.data = data;
    }
}
