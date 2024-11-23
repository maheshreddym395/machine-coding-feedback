package org.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Setter
@Getter
@ToString
public class SnakeAndLadderGameBoard implements GameBoard {
    private GameFilePathManager gameFilePathManager;
    private HashMap<Integer, Integer> SnakesMap;
    private HashMap<Integer, Integer> LadderMap;
    private Dice dice;

    public SnakeAndLadderGameBoard(GameFilePathManager gameFilePathManager, Dice dice) {
        this.gameFilePathManager = gameFilePathManager;
        SnakesMap = new HashMap<>();
        LadderMap = new HashMap<>();
        this.dice = dice;
    }

    public Integer caughtBySnake(Integer curPosition) {
        return SnakesMap.getOrDefault(curPosition, -1);
    }

    public Integer gotLadder(Integer curPosition) {
        return LadderMap.getOrDefault(curPosition, -1);
    }

}
