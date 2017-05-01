package com.example.user.igtchallenge.view.gamelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.igtchallenge.R;
import com.example.user.igtchallenge.injection.gamelist.DaggerGameListComponent;
import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameListActivity extends AppCompatActivity implements GameListContract.View {


    private static final String TAG = "GAME_LIST_ACTIVITY";
    @BindView(R.id.tvPlayerName)
    TextView tvPlayerName;

    @BindView(R.id.tvBalance)
    TextView tvBalance;

    @BindView(R.id.tvLastLogin)
    TextView tvLastLogin;

    @BindView(R.id.imgPlayer)
    ImageView imgPlayer;

    @BindView(R.id.rvGameList)
    RecyclerView rvGameList;


    @Inject
    GameListPresenter presenter;

    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator defaultItemAnimator;
    private GameListAdapter adapter;
    private List<Game> gamesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        ButterKnife.bind(this);
        DaggerGameListComponent.create().inject(this);
        presenter.addView(this);
        presenter.getPlayerInfo();
        presenter.getGameList();

        adapter = new GameListAdapter(gamesList);
        layoutManager = new LinearLayoutManager(this);
        defaultItemAnimator = new DefaultItemAnimator();
        rvGameList.setAdapter(adapter);
        rvGameList.setLayoutManager(layoutManager);
        rvGameList.setItemAnimator(defaultItemAnimator);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateGameList(List<Game> gameList) {

        gamesList.addAll(gameList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updatePlayerInfo(Player player) {

        adapter.setPlayerInfo(player);
        tvPlayerName.setText(player.getName());
        tvBalance.setText(String.valueOf(player.getBalanceString()));
        tvLastLogin.setText(player.getLastLogindate());
        Glide.with(this).load(player.getAvatarLink()).into(imgPlayer);

    }
}
