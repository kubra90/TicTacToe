import java.util.Scanner;
import java.util.*;
public class TicTacToe {
    public static String[] board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static final char X_Player = 'X';
    public static final char O_Player ='O';

    // next step add min-max algorithm

    public static void main(String[] args) {
        System.out.println("----Enjoy TicTacToe Game----");

        Scanner scanner = new Scanner(System.in);
        char[] players = startGame(scanner);  // return X or O

        System.out.print("How many rounds do you want to play? ");
        String roundNumber = scanner.nextLine();
        int num = Integer.parseInt(roundNumber);
        int winCaseOfComputer = 0;
        int winOfPlayer =0;
        int drawCase =0;
        for (int i = 0; i < num; i++) {
            board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            System.out.println("TicTacToe Board");
            printBoard(board);
            while (true) {
                //
                PlayerTurn(players[0]);
                if (winningCase(board)) {
                    System.out.println("you're winner!" + "\n" + "-------------");
                    winOfPlayer++;
                    break;
                }

                //there is a draw case!
                if (drawCheck(board, X_Player, O_Player)) {
                    System.out.println("there is a draw!");
                    drawCase++;
                    break;
                }
                ComputerTurn(players[1]);
                if (winningCase(board)) {
                    System.out.println("you're winner!");
                    winCaseOfComputer++;
                    break;
                }

            }
        }
        if(winOfPlayer > winCaseOfComputer){
            System.out.print(players[0] + " Player " +  "has won!");
        }else if((winCaseOfComputer > winOfPlayer)){
            System.out.println(players[1] +" player, computer " +  "has won!");
        }else{
            System.out.println("there is a draw!");
        }
    }



    public static char[] startGame(Scanner scan) {


        char[] players = new char[2];
        System.out.println("Choose one of X or O:  ");
        String input = scan.nextLine();
        if (input.charAt(0) == O_Player) {

            players[0] = O_Player;
            players[1] = X_Player;
        } else if (input.charAt(0) == X_Player) {

            players[0] = X_Player;
            players[1] = O_Player;
        }
        return players;
    }


    // bug is here the computer should understand which number X player choose.
    public static void ComputerTurn(char computer) {
        Random randomNumber = new Random();
        int computerMove;
        while(true){
            computerMove = randomNumber.nextInt(9) + 1;
            if(isValidMove(board, Integer.toString(computerMove))){
                //you can add one if statement to make the game more complex to make computer move more complex.
                int index = computerMove -1;
                board[index] = Character.toString(computer);
                break;
            }
        }
        System.out.println("-----------------");
        System.out.println("Computer chose " + computerMove);
        System.out.println("-----------------");

        printBoard( board);

    }



    public static void PlayerTurn(char player) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose one number to put " + player + ": ");
        String playerNumber = scanner.nextLine();
        if (isValidMove(board, playerNumber)) {
            for (int i = 0; i < board.length; i++) {
                if (playerNumber.equals(board[i])) {
                    board[i] = Character.toString(player);
                    printBoard(board);
                }
            }
        }else {

            // is it good way to use recursion here????
            System.out.println("Not valid number! Choose one available number: ");
            PlayerTurn(player);
        }
    }

    public static void printBoard(String[] board) {

        System.out.println("|-" + board[0] + "-|-" + board[1] + "-|-" + board[2] + "-|");
        System.out.println("----+---+----");
        System.out.println("|-" + board[3] + "-|-" + board[4] + "-|-" + board[5] + "-|");
        System.out.println("----+---+----");
        System.out.println("|-" + board[6] + "-|-" + board[7] + "-|-" + board[8] + "-|");
    }

    public static  boolean isValidMove(String[] board, String position){

        for (int i = 0; i < 9; i++) {
            if(position.equals(board[i])){
                return true;
            }

        }
        return false;

    }

    public static boolean drawCheck(String[] board,char a, char b) {
        boolean result = false;
        int num = 0;
        for (String each : board) {
            if (each.equals(Character.toString(a)) || each.equals(Character.toString(b))) {
                num++;
            }
        }
        if (num == 9) {
            result = true;
        }
        return result;
    }






    public static boolean winningCase(String[] board) {

        String[] winningPosition = new String[8];
        winningPosition[0] = board[0] + board[1] + board[2];
        winningPosition[1] = board[3] + board[4] + board[5];
        winningPosition[2] = board[6] + board[7] + board[8];
        winningPosition[3] = board[0] + board[3] + board[6];
        winningPosition[4] = board[1] + board[4] + board[7];
        winningPosition[5] = board[2] + board[5] + board[8];
        winningPosition[6] = board[2] + board[4] + board[6];
        winningPosition[7] = board[0] + board[4] + board[8];

        for (String eachOption : winningPosition) {
            if (eachOption.equals("XXX")) {
                return true;
            } else if (eachOption.equals("OOO")) {
                return true;
            }
        }
        return false;
    }
}