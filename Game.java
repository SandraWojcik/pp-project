import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    // Metoda startująca grę
    public void start() {
        System.out.println("Witamy w grze Kółko i Krzyżyk!");
        board.printBoard();
        while (true) {
            playerMove(currentPlayer);
            board.printBoard();
            if (board.checkWin()) {
                System.out.println("Gracz " + currentPlayer.getSymbol() + " wygrywa!");
                break;
            }
            if (board.isFull()) {
                System.out.println("Remis!");
                break;
            }
            switchPlayer();
        }
    }

    // Metoda obsługująca ruch gracza
    private void playerMove(Player player) {
        int row, col;
        while (true) {
            System.out.println("Gracz " + player.getSymbol() + ", podaj swój ruch (wiersz i kolumna 1-3): ");
            row = scanner.nextInt() - 1; // Konwersja na indeksowanie od 0
            col = scanner.nextInt() - 1; // Konwersja na indeksowanie od 0
            if (board.isValidMove(row, col)) {
                board.placeMove(row, col, player.getSymbol());
                break;
            } else {
                System.out.println("Ten ruch jest nieprawidłowy");
            }
        }
    }

    // Metoda zmieniająca aktualnego gracza
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}