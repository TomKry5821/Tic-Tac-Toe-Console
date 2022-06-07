/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame;

import pl.polsl.tictactoegame.controller.ProgramFlowController;
import pl.polsl.tictactoegame.view.GameView;
import pl.polsl.tictactoegame.controller.GameController;
import pl.polsl.tictactoegame.model.GameStatus;
import pl.polsl.tictactoegame.exception.TooLongNameException;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Simple console tic tac toe game
 */
public class TicTacToeGame {

    /**
     * main method in the program
     *
     * @param args from the command line, but in this case there are no
     * arguments passed to main
     * @throws TooLongNameException
     */
    public static void main(String[] args) throws TooLongNameException {
        ProgramFlowController programFlowController = new ProgramFlowController();
        programFlowController.setStatus(GameStatus.STARTED);
        GameController gameController = new GameController();
        GameView gameView = new GameView();
        programFlowController.begin(gameController, gameView);
    }
}
