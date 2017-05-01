package com.example.user.igtchallenge.view.gamedetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.igtchallenge.R;
import com.example.user.igtchallenge.injection.gamedetail.DaggerGameDetailComponent;
import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameDetailActivity extends AppCompatActivity implements GameDetailContract.View{


    private static final String TAG = "DetailActivity";
    @BindView(R.id.imgPlayer)
    ImageView imgPlayer;

    @BindView(R.id.tvPlayerName)
    TextView tvPlayerName;

    @BindView(R.id.tvBalance)
    TextView tvBalance;

    @BindView(R.id.tvGameName)
    TextView tvGameName;

    @BindView(R.id.tvJackpot)
    TextView tvJackpot;

    @BindView(R.id.tvDate)
    TextView tvDate;



    @Inject
    GameDetailPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        ButterKnife.bind(this);
        DaggerGameDetailComponent.create().inject(this);

        presenter.addView(this);
        presenter.getGameInfo(getIntent());
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateGameInfo(Game game) {

        tvGameName.setText(game.getName());

        tvDate.setText(game.getDate());

        tvJackpot.setText(game.getJackpotString());

    }

    @Override
    public void updatePlayerInfo(Player player) {


        tvPlayerName.setText(player.getName());
        tvBalance.setText(String.valueOf(player.getBalanceString()));
        Glide.with(this).load(player.getAvatarLink()).into(imgPlayer);

    }
}
