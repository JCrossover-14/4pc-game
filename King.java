public class King extends Piece 
{
    private int value = 1;
    private boolean moved;
    public King(int color)
    {
        super(color);
        this.moved = false;
    }

    
    public int getValue()
    {
        return this.value;
    }

    public void setMoved(boolean moved)
    {
        this.moved= moved;
    }

    public boolean getMoved()
    {
        return this.moved;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
