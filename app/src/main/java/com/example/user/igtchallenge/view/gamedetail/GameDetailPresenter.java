package com.example.user.igtchallenge.view.gamedetail;

import android.content.Intent;

import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;

/**
 * Created by User on 4/26/2017.
 */

public class GameDetailPresenter implements GameDetailContract.Presenter {

    GameDetailContract.View view;


    @Override
    public void addView(GameDetailContract.View view) {

        this.view = view;
    }

    @Override
    public void removeView() {

        this.view = null;
    }

    @Override
    public void getGameInfo(Intent intent) {

        Game game = (Game) intent.getSerializableExtra("Game");
        Player player = (Player) intent.getSerializableExtra("Player");
        view.updateGameInfo(game);
        view.updatePlayerInfo(player);
    }
}
