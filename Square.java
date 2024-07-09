public class Square 
{
    private static int x;
    private static int y;
    private boolean validity;
    private Piece piece;
    
    public Square(int x, int y, Piece piece)
    {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.validity= true;
    }

    public Square(int x, int y, boolean valid)
    {
        this.x = x;
        this.y = y;
        this.validity = valid;
        this.piece = null;
    }

    public Piece getPiece()
    {
        return this.piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public void setPiece()
    {
        this.piece = null;
    }

    public boolean getValidity()
    {
        return this.validity;
    }
}
