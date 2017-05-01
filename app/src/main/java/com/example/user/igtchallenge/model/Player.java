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

public class Player implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("avatarLink")
    @Expose
    private String avatarLink;
    @SerializedName("lastLogindate")
    @Expose
    private String lastLogindate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {


        return balance;
    }

    public String getBalanceString(){
        String num =NumberFormat.getInstance(Locale.getDefault()).format(balance);
        String currency = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        return num + " " + currency;

    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getLastLogindate() {
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy'T'HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("BST"));
        Date oldDate = null;
        try {
            oldDate = df.parse(lastLogindate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz", Locale.getDefault());

        String newDate = df2.format(oldDate);
        return newDate;
    }

    public void setLastLogindate(String lastLogindate) {
        this.lastLogindate = lastLogindate;
    }

    public String getLastLoginDateLocale() {


        DateFormat df = new SimpleDateFormat("mm/dd/yyyy'T'HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("BST"));
        Date oldDate = null;
        try {
            oldDate = df.parse(lastLogindate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz", Locale.getDefault());

        String newDate = df2.format(oldDate);
        return newDate;

    }
}
