import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {1
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void playTurn(int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X')? 'O' : 'X';
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0]!= '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i]!= '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0]!= '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2]!= '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.displayBoard();

        while (!game.checkWin()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Player " + game.currentPlayer + ", enter your move (row column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.playTurn(row, col);
            game.displayBoard();
        }

        System.out.println("Game Over Player " + game.currentPlayer + " wins!");
    }
}
