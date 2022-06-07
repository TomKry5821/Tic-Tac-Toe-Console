/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame.controller;

import pl.polsl.tictactoegame.model.*;
import pl.polsl.tictactoegame.view.GameView;

import java.util.Objects;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 class responsible for controlling program
 */
public class ProgramFlowController {
    GameStatus status;

    /**
     * ProgramFlowController Constructor
     */
    public ProgramFlowController() {
    }

    ;

    /**
     * setter of a game status
     */
    public void setStatus(GameStatus status) {
        this.status = status;
    }

    /**
     * begin is responsible for all actions related to chosing player names, creating players and start a game
     *
     * @param gameController in MVC model
     * @param gameView       in MVC model
     */
    public void begin(GameController gameController, GameView gameView) {
        Board board = new Board();
        String firstPlayerName = gameView.takeFirstPlayerName(gameController);
        String secondPlayerName = gameView.takeSecondPlayerName(gameController);
        if (Objects.equals("1", secondPlayerName)) {
            startGame(gameController, firstPlayerName, "Cpu", board, gameView);
        } else {
            startGame(gameController, firstPlayerName, secondPlayerName, board, gameView);
        }
    }

    private void startGame(GameController gameController, String firstPlayerName, String Cpu, Board board, GameView gameView) {
        Player player = gameController.createPlayer(firstPlayerName, 'O');
        Player bot = gameController.createPlayer(Cpu, 'X');
        while (true) {
            this.status = GameStatus.IN_GAME;
            startPlaying(player, bot, board, gameView, gameController);
            if (!gameView.playNextGame()) {
                this.status = GameStatus.FINISHED;
                break;
            }
            gameController.clearPositionsList(player);
            gameController.clearPositionsList(bot);
            gameController.clearBoard(board);
        }
    }

    /**
     * startGame is responsible for all actions made by players during the game,
     * catching errors and chose the winner of the game
     *
     * @param player1        first player
     * @param player2        second player
     * @param board          game board
     * @param gameView       in MVC model
     * @param gameController in MVC model
     */
    public void startPlaying(Player player1, Player player2, Board board, GameView gameView, GameController gameController) {
        WinningConditions winningConditions = new WinningConditions();
        int roundCount = 1;
        int player = 1;
        while (roundCount < 10) {
            switch (player) {
                case 1 -> {
                    if (isWinningMove(player1, board, gameView, gameController, winningConditions)) return;
                    player++;
                }
                case 2 -> {
                    if (isWinningMove(player2, board, gameView, gameController, winningConditions)) return;
                    player--;
                }
            }
            roundCount++;
        }
        gameView.printBoard(board);
        System.out.println(gameView.tie());
    }

    private boolean isWinningMove(Player player1, Board board, GameView gameView, GameController gameController, WinningConditions winningConditions) {
        gameView.printActualPlayer(gameController.getPlayerName(player1));
        gameView.printBoard(board);
        monitorMove(player1, board, gameView, gameController);
        if (gameController.isWinner(player1, winningConditions)) {
            gameView.printBoard(board);
            gameView.printWinnerOfTheGame(player1);
            return true;
        }
        return false;
    }

    /**
     * monitorMove is responsible actions related to moves made by the players and
     * checking correctness of these moves
     *
     * @param player         actual player
     * @param board          game board
     * @param gameView       in MVC model
     * @param gameController in MVC model
     */
    public void monitorMove(Player player, Board board, GameView gameView, GameController gameController) {
        int intPosition;
        if (player instanceof ComputerPlayer) {
            while (true) {
                intPosition = 1 + (int) (Math.random() * 9);
                if (gameController.updateBoard(board, player, intPosition)) {
                    gameController.addPlayerPosition(player, intPosition);
                    break;
                }
            }
        } else {
            String position;
            while (true) {
                position = gameView.takePosition();
                try {
                    intPosition = Integer.parseInt(position);
                } catch (NumberFormatException x) {
                    System.out.println("You put sign in wrong place!");
                    continue;
                }
                if (gameController.updateBoard(board, player, intPosition)) {
                    gameController.addPlayerPosition(player, intPosition);
                    break;
                }
                System.out.println("Something went wrong. Try again");
            }
        }
    }
}
