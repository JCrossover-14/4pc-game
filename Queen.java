public class Queen extends Piece 
{
    private int value = 12;
    
    public Queen(int color)
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
