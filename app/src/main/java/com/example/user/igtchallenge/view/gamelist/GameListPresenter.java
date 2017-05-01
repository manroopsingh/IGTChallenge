package com.example.user.igtchallenge.view.gamelist;

import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.GameList;
import com.example.user.igtchallenge.model.Player;
import com.example.user.igtchallenge.utility.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 4/26/2017.
 */

public class GameListPresenter implements GameListContract.Presenter {
    private static final String TAG = "GAMELISTACTIVITY";
    GameListContract.View view;
    List<Game> gamesList = new ArrayList<>();


    @Override
    public void getGameList() {

        Observable<GameList> gameListObservable = RetrofitHelper.createGameListObs();
        gameListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GameList>() {
                    @Override
                    public void onCompleted() {
                        view.updateGameList(gamesList);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(GameList gameList) {
                        gamesList.addAll(gameList.getData());
                    }
                });


    }

    @Override
    public void getPlayerInfo() {
        Observable<Player> playerObservable = RetrofitHelper.createPlayerObs();
        playerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Player>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(Player player) {
                        view.updatePlayerInfo(player);

                    }
                });

    }


    @Override
    public void addView(GameListContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {

        this.view = null;
    }
}
