public class Rook extends Piece
{
    private int value = 5;
    
    public Rook(int color)
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
