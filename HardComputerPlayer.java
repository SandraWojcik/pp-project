public class HardComputerPlayer extends ComputerPlayer {

    public HardComputerPlayer(char symbol) {
        super(symbol);
    }

    // Metoda wykonująca ruch komputera na trudnym poziomie (strategiczne ruchy)
    public void makeMove(Board board) {
        int[][] availableMoves = board.getAvailableMoves();

        // Sprawdzenie, czy komputer może wygrać
        for (int[] move : availableMoves) {
            int row = move[0];
            int col = move[1];
            if (board.isWinningMove(row, col, getSymbol())) {
                board.placeMove(row, col, getSymbol());
                System.out.println("Komputer wykonał ruch: (" + (row + 1) + ", " + (col + 1) + ")");
                return;
            }
        }

        // Sprawdzenie, czy gracz może wygrać i zablokowanie go
        char opponentSymbol = getSymbol() == 'X' ? 'O' : 'X';
        for (int[] move : availableMoves) {
            int row = move[0];
            int col = move[1];
            if (board.isWinningMove(row, col, opponentSymbol)) {
                board.placeMove(row, col, getSymbol());
                System.out.println("Komputer wykonał ruch: (" + (row + 1) + ", " + (col + 1) + ")");
                return;
            }
        }

        // Jeśli nie można wygrać ani nie trzeba blokować, wybierz losowy ruch
        int moveIndex = (int) (Math.random() * availableMoves.length);
        int row = availableMoves[moveIndex][0];
        int col = availableMoves[moveIndex][1];
        board.placeMove(row, col, getSymbol());
        System.out.println("Komputer wykonał ruch: (" + (row + 1) + ", " + (col + 1) + ")");
    }
}