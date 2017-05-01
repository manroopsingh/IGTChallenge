package com.example.user.igtchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by User on 4/26/2017.
 */

public class Game implements Serializable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("jackpot")
    @Expose
    private Integer jackpot;
    @SerializedName("date")
    @Expose
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJackpot() {
        return jackpot;
    }

    public String getJackpotString(){
        String num = NumberFormat.getInstance(Locale.getDefault()).format(jackpot);
        String currency = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        return num + " " + currency;

    }

    public void setJackpot(Integer jackpot) {
        this.jackpot = jackpot;
    }

    public String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ssZ");
        df.setTimeZone(TimeZone.getTimeZone("BST"));
        Date oldDate = null;
        try {
            oldDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz", Locale.getDefault());

        String newDate = df2.format(oldDate);
        return newDate;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
