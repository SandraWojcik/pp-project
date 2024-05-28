import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isSinglePlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        setupPlayers();
        currentPlayer = player1;
    }

    // Konfiguracja graczy
    private void setupPlayers() {
        System.out.println("Wybierz tryb gry:");
        System.out.println("1. Gracz vs Gracz");
        System.out.println("2. Gracz vs Komputer");
        int choice = scanner.nextInt();

        player1 = new Player('X');
        if (choice == 1) {
            isSinglePlayer = false;
            player2 = new Player('O');
        } else {
            isSinglePlayer = true;
            player2 = new ComputerPlayer('O');
        }
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
        if (player instanceof ComputerPlayer) {
            ((ComputerPlayer) player).makeMove(board);
        } else {
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
    }

    // Metoda zmieniająca aktualnego gracza
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}