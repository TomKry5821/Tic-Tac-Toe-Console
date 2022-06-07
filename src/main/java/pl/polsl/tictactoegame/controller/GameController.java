/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame.controller;

import pl.polsl.tictactoegame.model.*;

import java.util.Objects;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a game controller in mvc model
 */
public class GameController {

    /**
     * Controller constructor
     */
    public GameController() {
    }

    /**
     * checkIfEmpty checks that actual position is avaible for player to put
     * sign on
     *
     * @param position that players wants to put sign on
     * @return boolean true if positon is empty
     */
    public boolean isEmpty(Character position) {
        return Objects.equals(' ', position);
    }

    /**
     * calculateColumn calculates depending on chosen by the player position
     *
     * @param position that players want to put sign on
     * @return int the column on the game board
     */
    public int calculateColumn(int position) {
        return switch (position) {
            case 1, 4, 7 -> 0;
            case 2, 5, 8 -> 2;
            case 3, 6, 9 -> 4;
            default -> -1;
        };
    }

    /**
     * updateBoard puts on a board sign in the chosen by player position
     *
     * @param board  game board
     * @param player actual player
     * @param position     chosen by the player board element
     * @return boolean if update has been finished succesful
     */
    public boolean updateBoard(Board board, Player player, int position) {
        boolean result;
        int row, column;
        if (position <= 3 && position >= 1) {
            row = 0;
            column = this.calculateColumn(position);
            if (isEmpty(board.getBoard().get(row).get(column))) {
                board.getBoard().get(row).set(column, player.getSign());
                result = true;
            } else {
                result = false;
            }
        } else if (position <= 6 && position >= 4) {
            row = 2;
            column = this.calculateColumn(position);
            if (isEmpty(board.getBoard().get(row).get(column))) {
                board.getBoard().get(row).set(column, player.getSign());
                result = true;
            } else {
                result = false;
            }
        } else if (position <= 9 && position >= 7) {
            row = 4;
            column = this.calculateColumn(position);
            if (isEmpty(board.getBoard().get(row).get(column))) {
                board.getBoard().get(row).set(column, player.getSign());
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * checkWinConditions checks that actual player sign positions are winning
     * positions
     *
     * @param player            actual player
     * @param winningConditions list of the winning positions
     * @return boolean if positions of actual player meet the winning conditions
     */
    public boolean isWinner(Player player, WinningConditions winningConditions) {
        return winningConditions.getWinningPositions().stream().anyMatch(wp -> player.getPositions().containsAll(wp));
    }

    /**
     * getPlayerName gets a name of the player
     *
     * @param player that name we need
     * @return String players name
     */
    public String getPlayerName(Player player) {
        return player.getPlayerName();
    }

    /**
     * addPlayerPosition adds a position to list of actual player position
     *
     * @param player   that made a move
     * @param position that player has put sign on
     */
    public void addPlayerPosition(Player player, int position) {
        player.addPosition(position);
    }

    /**
     * createPlayer creates a object of the player
     *
     * @param playerName name of the player
     * @param playerSign sign of the player(X or O)
     * @return Player instance
     */
    public Player createPlayer(String playerName, char playerSign) {

        if ("Cpu".equals(playerName)) {
            return new ComputerPlayer(playerSign);
        }
        return new HumanPlayer(playerName, playerSign);
    }

    /**
     * clearBoard clears a board for new game
     *
     * @param board from last game
     */
    public void clearBoard(Board board) {
        board.clearBoard();
    }

    /**
     * clearPositionsList removes all saved moves of the player
     *
     * @param player actual player
     */
    public void clearPositionsList(Player player) {
        player.setPositions();
    }

    /**
     * handleException handles my own exception thrown during the game
     *
     * @return String players name
     */
    public String setSpecialPlayerName() {
        return "Anonim";
    }
}
