import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(char symbol) {
        super(symbol);
        random = new Random();
    }

    // Metoda wykonująca ruch komputera
    public void makeMove(Board board) {
        int[][] availableMoves = board.getAvailableMoves();
        int moveIndex = random.nextInt(availableMoves.length);
        int row = availableMoves[moveIndex][0];
        int col = availableMoves[moveIndex][1];
        board.placeMove(row, col, getSymbol());
        System.out.println("Komputer wykonał ruch: (" + (row + 1) + ", " + (col + 1) + ")");
    }
}