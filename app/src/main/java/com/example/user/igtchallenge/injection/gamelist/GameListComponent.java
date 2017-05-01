package com.example.user.igtchallenge.injection.gamelist;

import com.example.user.igtchallenge.view.gamelist.GameListActivity;

import dagger.Component;

/**
 * Created by User on 4/26/2017.
 */

@Component(modules = GameListModule.class)
public interface GameListComponent {

    void inject (GameListActivity gameListActivity);
}
