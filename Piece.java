public class Piece implements Cloneable
{
    private int color;

    public Piece(int color)
    {
        this.color = color;
    }

    public int getColor()
    {
        return this.color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
}
