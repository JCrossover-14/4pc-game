


public class Knight extends Piece
{
    private int value = 3;

    public Knight(int color)
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
