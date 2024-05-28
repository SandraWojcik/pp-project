public abstract class ComputerPlayer extends Player {

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    public abstract void makeMove(Board board);
}