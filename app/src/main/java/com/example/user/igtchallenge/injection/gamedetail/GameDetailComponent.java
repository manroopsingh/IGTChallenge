package com.example.user.igtchallenge.injection.gamedetail;

import com.example.user.igtchallenge.view.gamedetail.GameDetailActivity;

import dagger.Component;

/**
 * Created by User on 4/26/2017.
 */

@Component(modules = GameDetailModule.class)
public interface GameDetailComponent {

    void inject(GameDetailActivity gameDetailActivity);




}
