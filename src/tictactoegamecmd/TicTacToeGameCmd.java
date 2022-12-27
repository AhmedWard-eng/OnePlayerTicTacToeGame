/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegamecmd;

import java.util.Random;
import java.util.Scanner;
import javafx.scene.layout.Border;

/**
 *
 * @author AhmedWard
 */
public class TicTacToeGameCmd {

    /**
     * @param args the command line arguments
     */
    private char[][] board;
    private Scanner scanner;

    @SuppressWarnings("empty-statement")
    public TicTacToeGameCmd() {

        board = new char[3][3];
        intializeBoard();
        scanner = new Scanner(System.in);

    }

    private void intializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGameCmd cmd = new TicTacToeGameCmd();

        cmd.printBoard();

        while (!cmd.isGameFinished()) {
            cmd.playerTurn();
            if (cmd.isGameFinished()) {
                break;
            }
            int computerMove = cmd.ComputerTurn();
            System.out.println("The Computer choose " + computerMove);
            cmd.printBoard();
        }

        cmd.printBoard();
    }

    public boolean isGameFinished() {
        boolean isFinished = false;
        if (isGameFull()) {
            System.out.println("game over");
            isFinished = true;
        } else if (isPlayerWon('X')) {
            System.out.println("Player has won");
            isFinished = true;
        } else if (isPlayerWon('O')) {
            System.out.println("Computer has won");
            isFinished = true;
        }
        return isFinished;
    }

    public void printBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public void playerTurn() {
        System.out.println("where would you like to play? (1-9)");
        String userInput = scanner.nextLine();
        boolean checkValidInput = checkValidInput(userInput);
        while (!checkValidInput) {
            System.out.println("wrong choice!!!");
            System.out.println("where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            checkValidInput = checkValidInput(userInput);
        }
        placeMove(userInput, 'X');
    }

    public int ComputerTurn() {
        int computerMove = chooseValidInput(new Random().nextInt(9) + 1);
        placeMove(String.valueOf(computerMove), 'O');
        return computerMove;
    }

    public boolean checkValidInput(String cell) {

        switch (cell) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
        }
        return false;
    }

    public void placeMove(String cell, char symbol) {

        switch (cell) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }

    }

    public int chooseValidInput(int computerMove) {
        boolean isValid = checkValidInput(String.valueOf(computerMove));

        while (!isValid) {
            computerMove = new Random().nextInt(9) + 1;
            isValid = checkValidInput(String.valueOf(computerMove));
        }
        return computerMove;
    }

    public boolean isGameFull() {
        for (int i = 1; i < 10; i++) {
            if (checkValidInput(String.valueOf(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean isPlayerWon(char symbol) {
        if (board[0][0] == symbol && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        } else if (board[1][0] == symbol && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        } else if (board[2][0] == symbol && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        } else if (board[0][0] == symbol && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        } else if (board[0][1] == symbol && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        } else if (board[0][2] == symbol && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        } else if (board[0][0] == symbol && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        } else if (board[0][2] == symbol && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        } else {
            return false;
        }

    }

}
