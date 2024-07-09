public class Pawn extends Piece
{
    private int value = 1;
    
    public Pawn(String color)
    {
        super(color);
    }
    
    public int getValue()
    {
        return this.value;
    }
}
