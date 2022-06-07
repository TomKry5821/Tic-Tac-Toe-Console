/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame.view;

import pl.polsl.tictactoegame.controller.GameController;
import pl.polsl.tictactoegame.exception.TooLongNameException;
import pl.polsl.tictactoegame.model.Board;
import pl.polsl.tictactoegame.model.Player;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a view in MVC model
 */
public class GameView {

    /**
     * View Constructor
     */
    public GameView() {
    }

    /**
     * clearConsole clears a console view
     */
    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * printBoard prints actual game board
     *
     * @param board game board
     */
    public void printBoard(Board board) {
        board.getBoard().forEach(row -> {
            row.forEach(System.out::print);
            System.out.println();
        });
    }

    /**
     * takeFirstPlayerNAme takes a name from first player
     *
     * @param gameController game controller
     * @return String players name
     */
    public String takeFirstPlayerName(GameController gameController) {
        System.out.println("Set first player name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        try {
            if (name.length() > 15) {
                throw new TooLongNameException("Provided name is too long! We will set special name to you...");
            }
        } catch (TooLongNameException x) {
            name = gameController.setSpecialPlayerName();
        } finally {
            return name;
        }

    }

    /**
     * takeSecondPlayerNAme takes a name from second player
     *
     * @param gameController game controller
     * @return String players name
     */
    public String takeSecondPlayerName(GameController gameController) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Set second player name, if you would like to play with computer press 1: ");
        String name = scan.nextLine();
        try {
            if (name.length() > 15) {
                throw new TooLongNameException("Provided name is too long! We will set special name to you...");
            }
        } catch (TooLongNameException x) {
            name = gameController.setSpecialPlayerName();
        } finally {
            return name;
        }
    }

    /**
     * takePosition takes a position from player
     *
     * @return String position
     */
    public String takePosition() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select place to put sign(from 1 to 9)");
        return scan.next();
    }

    /**
     * winnerOfTheGame writes on the console output winners name
     *
     * @param player winner of the game
     */
    public void printWinnerOfTheGame(Player player) {
        System.out.println("Winner - " + player.getPlayerName());
        System.out.println("Congratulations!!");
    }

    /**
     * tie writes on the console output information when no one wins
     *
     * @return String information about tie
     */
    public String tie() {
        return "Tie!";
    }

    /**
     * printActualPlayer prints the name of actual player
     *
     * @param playerName actual player name
     */
    public void printActualPlayer(String playerName) {
        System.out.println("Actual player: " + playerName);
    }

    /**
     * @return boolean true if players want to play again
     */
    public boolean playNextGame() {
        System.out.println("Would you like to play again?\n If yes press 1");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (Objects.equals("1", answer)) {
            clearConsole();
            return true;
        }
        return false;
    }
}
