/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tictactoegame.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a tictactoe game board
 */
public class Board {

    /**
     * char[][] game board
     */
    List<List<Character>> board;

    /**
     * Board constructor
     */
    public Board() {
        this.board = Arrays.asList(
                Arrays.asList(' ', '|', ' ', '|', ' '),
                Arrays.asList('-', '+', '-', '+', '-'),
                Arrays.asList(' ', '|', ' ', '|', ' '),
                Arrays.asList('-', '+', '-', '+', '-'),
                Arrays.asList(' ', '|', ' ', '|', ' '));
    }

    /**
     * getBoard gets a game board
     *
     * @return char[][] game board
     */
    public List<List<Character>> getBoard() {
        return this.board;
    }

    /**
     * clearBoard sets a clear board
     */
    public void clearBoard() {
        this.board = Arrays.asList(
                Arrays.asList(' ', '|', ' ', '|', ' '),
                Arrays.asList('-', '+', '-', '+', '-'),
                Arrays.asList(' ', '|', ' ', '|', ' '),
                Arrays.asList('-', '+', '-', '+', '-'),
                Arrays.asList(' ', '|', ' ', '|', ' '));
    }
}
