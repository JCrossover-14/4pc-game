public class Pawn extends Piece
{
    private int value = 1;
    
    public Pawn(int color)
    {
        super(color);
    }
    
    public int getValue()
    {
        return this.value;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
