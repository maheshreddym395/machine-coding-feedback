package org.main;

public class SnakeAndLadderGameBoardPlay implements GamePlay {
    private SnakeAndLadderGameBoard snakeAndLadderGameBoard;
    private SnakeAndLadderGamePlayers snakeAndLadderGamePlayers;
    private boolean stopGame;

    public SnakeAndLadderGameBoardPlay(SnakeAndLadderGameBoard snakeAndLadderGameBoard, SnakeAndLadderGamePlayers snakeAndLadderGamePlayers) {
        this.snakeAndLadderGameBoard = snakeAndLadderGameBoard;
        this.snakeAndLadderGamePlayers = snakeAndLadderGamePlayers;
    }

    public void updatePlayersGameStart() {
        for (Player player : snakeAndLadderGamePlayers.getPlayers()) {
            player.setPlayerStatus(PlayerStatus.PLAYING);
            player.setPlayerStatus(PlayerStatus.PLAYING);
        }
    }

    public void StartGame() {
        stopGame = false;
        Integer diceVal;
        updatePlayersGameStart();

        while (!(stopGame)) {
            for (Player player : snakeAndLadderGamePlayers.getPlayers()) {
                if (stopGame) {
                    break;
                }
                diceVal = snakeAndLadderGameBoard.getDice().rollDice();
                movePlayerOnBoard(diceVal, player, MovementCause.DICE);
            }
        }
    }

    public void printMove(Integer newPos, Player player, MovementCause cause) {
        if (cause == MovementCause.DICE) {
            int diceVal = newPos - player.getCurPosition();
            System.out.println(player.getName()+ " rolled a "+diceVal+" and Moved From "+player.getCurPosition()+ " to "+newPos);
        } else {
            System.out.println(player.getName()+" "+cause.getDescription()+" and Moved From "+player.getCurPosition()+ " to "+newPos);
        }
    }

    public void updatePlayer(Integer newPos, Player player, MovementCause cause) {
        if (newPos <= 100) {
            printMove(newPos, player, cause);
            player.getMoves().add(new PlayerMove(player.getCurPosition(), newPos, cause));
            if (newPos == 100) {
                stopGame = true;
                player.setPlayerStatus(PlayerStatus.WON);
                System.out.println(player.getName()+" won!! ");
            }
            player.setCurPosition(newPos);
        }
    }

    public void movePlayerOnBoard(Integer diceVal, Player player, MovementCause cause) {
        Integer newPos;
        if (cause == MovementCause.DICE) {
            newPos = player.getCurPosition() + diceVal;
        } else {
            newPos = diceVal;
        }
        updatePlayer(newPos, player, cause);
        if (snakeAndLadderGameBoard.caughtBySnake(newPos)!=-1) {
            newPos = snakeAndLadderGameBoard.caughtBySnake(newPos);
            movePlayerOnBoard(newPos, player, MovementCause.SNAKE_BITE);
        } else if (snakeAndLadderGameBoard.gotLadder(newPos)!=-1) {
            newPos = snakeAndLadderGameBoard.gotLadder(newPos);
            movePlayerOnBoard(newPos, player, MovementCause.GOT_LADDER);
        }
    }
}
