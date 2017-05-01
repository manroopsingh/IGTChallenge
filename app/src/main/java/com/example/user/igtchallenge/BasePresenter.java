package com.example.user.igtchallenge;

import android.view.View;

/**
 * Created by User on 4/26/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void addView(V view);
    void removeView();

}
