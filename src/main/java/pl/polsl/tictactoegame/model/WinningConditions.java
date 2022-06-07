/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class that contains all possible ways to win a tictactoe game
 */
public class WinningConditions {

    /**
     *
     * winningPositions is a List of all possible positions that player has to
     * put a sign on to win a tictactoe game
     */
    List<List<Integer>> winningPositions;

    /**
     * WinningConditions constructor
     */
    public WinningConditions() {
        List<Integer> topRow = List.of(1, 2, 3);
        List<Integer> midRow = List.of(4, 5, 6);
        List<Integer> botRow = List.of(7, 8, 9);
        List<Integer> leftCol = List.of(1, 4, 7);
        List<Integer> midCol = List.of(2, 5, 8);
        List<Integer> rightCol = List.of(3, 6, 9);
        List<Integer> leftCross = List.of(1, 5, 9);
        List<Integer> rightCross = List.of(3, 5, 7);

        this.winningPositions = new ArrayList<>();
        this.winningPositions.add(topRow);
        this.winningPositions.add(midRow);
        this.winningPositions.add(botRow);
        this.winningPositions.add(leftCol);
        this.winningPositions.add(midCol);
        this.winningPositions.add(rightCol);
        this.winningPositions.add(leftCross);
        this.winningPositions.add(rightCross);
    }

    /**
     *
     * getWinningPositions gets a list of the winning positions
     *
     * @return List winning positions
     */
    public List<List<Integer>> getWinningPositions() {
        return this.winningPositions;
    }
}
