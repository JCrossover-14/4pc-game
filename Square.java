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

    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.validity = false;
        this.piece = null;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public void setPiece()
    {
        this.piece = null;
    }

    
    
}
