package org.main;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SnakeAndLadderGamePlayers implements GamePlayers{
    private ArrayList<Player> players;

    public SnakeAndLadderGamePlayers() {
        this.players = new ArrayList<>();
    }

    public void LoadPlayers (ArrayList<String> players) {
        for (String name : players) {
            this.players.add(new Player(name));
        }
    }
}
