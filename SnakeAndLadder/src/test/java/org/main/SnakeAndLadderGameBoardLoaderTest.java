package org.main;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderGameBoardLoaderTest {

    @Test
    void loadGameboard() throws FileNotFoundException {
        GameFilePathManager gameFilePathManager = new GameFilePathManager();
        gameFilePathManager.validateAndSetFilePath("src/main/resources/SankeAndLadderGameInput.txt");
        GameBoard gameBoard = new SnakeAndLadderGameBoard(gameFilePathManager, new Dice(4));
        SnakeAndLadderGameBoardLoader snakeAndLadderGameBoardLoader = new SnakeAndLadderGameBoardLoader(gameBoard);
        snakeAndLadderGameBoardLoader.LoadGameboard();
    }
}