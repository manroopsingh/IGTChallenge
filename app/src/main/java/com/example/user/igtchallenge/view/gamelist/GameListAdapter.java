package com.example.user.igtchallenge.view.gamelist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.igtchallenge.R;
import com.example.user.igtchallenge.model.Game;
import com.example.user.igtchallenge.model.Player;
import com.example.user.igtchallenge.view.gamedetail.GameDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 4/26/2017.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {

    List<Game> gameList = new ArrayList<>();
    Player player;

    public GameListAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvGameName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGameName = (TextView) itemView.findViewById(R.id.tvGameName);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Game game = gameList.get(position);
        holder.tvGameName.setText(game.getName());

        holder.tvGameName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (player == null) {
                    Toast.makeText(v.getContext(), "Player data loading..", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(v.getContext(), GameDetailActivity.class);
                    intent.putExtra("Game", game);
                    intent.putExtra("Player", player);
                    v.getContext().startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }


    public void setPlayerInfo(Player player) {
        this.player = player;

    }


}
