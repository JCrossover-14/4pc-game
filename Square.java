public class Square implements Cloneable
{
    private static int x;
    private static int y;
    private boolean validity;
    private Piece piece;

    private int attackedByR;
    private int attackedByB;


    
    public Square(int x, int y, Piece piece)
    {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.validity= true;
        this.attackedByR = 0;
        this.attackedByB = 0;
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
    public void addAttacker(int color)
    {
        if(color%2==0) this.attackedByR++;
        else this.attackedByB++;
    }

    public void removeAttacker(int color)
    {
        if(color%2==0) this.attackedByR--;
        else this.attackedByB--;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException 
    {
        // Perform a shallow copy of the Square
        Square clonedSquare = (Square) super.clone();
        
        // Deep clone the Piece object
        if (this.piece != null) {
            clonedSquare.piece = (Piece) this.piece.clone();
        }
        
        return clonedSquare;
    }
    
}
