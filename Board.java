public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Metoda drukująca planszę z opisem pól
    public void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sprawdzenie, czy ruch jest prawidłowy
    public boolean isValidMove(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            return true;
        }
        return false;
    }

    // Umieszczenie symbolu na planszy
    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Sprawdzenie, czy jest wygrana
    public boolean checkWin() {
        // Sprawdzanie wierszy i kolumn
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        // Sprawdzanie przekątnych
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }

    // Sprawdzenie, czy plansza jest pełna
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Pobranie dostępnych ruchów
    public int[][] getAvailableMoves() {
        int[][] availableMoves = new int[SIZE * SIZE][2];
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    availableMoves[count][0] = i;
                    availableMoves[count][1] = j;
                    count++;
                }
            }
        }
        int[][] result = new int[count][2];
        System.arraycopy(availableMoves, 0, result, 0, count);
        return result;
    }

    // Sprawdzenie, czy ruch jest wygrywający
    public boolean isWinningMove(int row, int col, char symbol) {
        // Umieść symbol na planszy
        board[row][col] = symbol;
        boolean isWin = checkWin();
        // Cofnij ruch
        board[row][col] = '-';
        return isWin;
    }
}