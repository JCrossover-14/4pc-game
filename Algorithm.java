import java.util.*;

public class Algorithm {
    public static int[] algorithm(Board board, int color) {
        // Generate a random move from the list of possible moves.
        List<int[]> possibleMoves = board.getLegalMoves(color); // Get legal moves for the given color
        Random random = new Random();
        return possibleMoves.get(random.nextInt(possibleMoves.size()));
    }
}