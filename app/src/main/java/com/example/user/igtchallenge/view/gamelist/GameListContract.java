package com.example.user.igtchallenge.view.gamelist;

import com.example.user.igtchallenge.BasePresenter;
import com.example.user.igtchallenge.BaseView;
import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;

import java.util.List;

/**
 * Created by User on 4/26/2017.
 */

public interface GameListContract {

    interface View extends BaseView{
        void updateGameList(List<Game> gameList);
        void updatePlayerInfo(Player player);

    }

    interface Presenter extends BasePresenter<View>{
        void getGameList();
        void getPlayerInfo();
    }
}
