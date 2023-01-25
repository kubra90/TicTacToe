public class tictactoeAI {

    public static String[] board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static final char X_Player = 'X';
    public static final char O_Player = 'O';


    public static String[] BestMove(char computer) {

        if (board[0].equals("X") && board[1].equals("X")) {
             board[2] = String.valueOf(computer);
        } else if (board[1].equals("X") && board[2].equals("X")) {
            board[0] = String.valueOf(computer);
        } else if (board[0].equals("O") && board[1].equals("O")) {
            board[2] = String.valueOf(computer);
        } else if (board[1].equals("O") && board[2].equals("O")) {
            board[0] = String.valueOf(computer);

            //second row
        } else if (board[3].equals("X") && board[4].equals("X")) {
            board[5] = String.valueOf(O_Player);
        } else if (board[4].equals("X") && board[5].equals("X")) {
            board[3] = String.valueOf(O_Player);
        } else if (board[3].equals("O") && board[4].equals("O")) {
            board[5] = String.valueOf(X_Player);
        } else if (board[4].equals("O") && board[5].equals("O")) {
            board[3] = String.valueOf(X_Player);

            //third row

        } else if (board[6].equals("X") && board[7].equals("X")) {
            board[8] = String.valueOf(O_Player);
        } else if (board[7].equals("X") && board[8].equals("X")) {
            board[6] = String.valueOf(O_Player);
        } else if (board[6].equals("O") && board[7].equals("O")) {
            board[8] = String.valueOf(X_Player);
        } else if (board[7].equals("O") && board[8].equals("O")) {
            board[6] = String.valueOf(X_Player);

        }
        return board;
    }

    public static void printBoard(String[] board) {

        System.out.println("|-" + board[0] + "-|-" + board[1] + "-|-" + board[2] + "-|");
        System.out.println("----+---+----");
        System.out.println("|-" + board[3] + "-|-" + board[4] + "-|-" + board[5] + "-|");
        System.out.println("----+---+----");
        System.out.println("|-" + board[6] + "-|-" + board[7] + "-|-" + board[8] + "-|");
    }
}
