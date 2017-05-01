package com.example.user.igtchallenge.injection.gamedetail;

import com.example.user.igtchallenge.view.gamedetail.GameDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 4/26/2017.
 */

@Module
public class GameDetailModule {

    @Provides
    public GameDetailPresenter provideGameDetailPresenter() {
        return new GameDetailPresenter();
    }

}
