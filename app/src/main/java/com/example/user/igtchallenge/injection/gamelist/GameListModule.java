package com.example.user.igtchallenge.injection.gamelist;

import com.example.user.igtchallenge.view.gamelist.GameListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 4/26/2017.
 */
@Module
public class GameListModule {

    @Provides
    public GameListPresenter provideGameListPresenter() {
        return new GameListPresenter();
    }
}
