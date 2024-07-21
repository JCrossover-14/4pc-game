public class Bishop extends Piece 
{
    private int value = 5;
    
    public Bishop(int color)
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
