package com.example.user.igtchallenge.view.gamedetail;

import android.content.Intent;

import com.example.user.igtchallenge.BasePresenter;
import com.example.user.igtchallenge.BaseView;
import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;

/**
 * Created by User on 4/26/2017.
 */

public interface GameDetailContract {

    interface View extends BaseView{

        void updateGameInfo(Game game);
        void updatePlayerInfo(Player player);
    }


    interface Presenter extends BasePresenter<View>{
        void getGameInfo(Intent intent);
    }



}