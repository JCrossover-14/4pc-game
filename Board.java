
import java.util.*;

public class Board
{
    private Square[][] board;

    public Board()
    {
        this.board = new Square[14][14];
        initialize_board();

    }

    public void initialize_board()
    {
        for(int i=0;i<14;i++)
        {
            for(int j=0;j<14;j++)
            {
                if(i<3||i>10)
                {
                    if(j<3||j>10)
                    {
                        board[i][j] = new Square(i,j,false);
                    }
                }
            }
        }
        
        int[] ry = {1,2,3,4,5,3,2,1};
        for(int col = 3;col<11;col++)
        {
            //consider [0][col] to be the redd piece
            //consider board[13][13-col] to be the yellow piece
            //rook
            if(ry[col-3]==1)
            {
                Piece piece = new Rook(1);
                Square square = new Square(0,col,piece);
                board[0][col]= square;
                
                Piece piece1 = new Rook(3);
                Square square1 = new Square(13,13-col,piece1);
                board[13][13-col] = square1;
                
                Piece piece2 = new Rook(2);
                Square square2 = new Square(col,0,piece2);
                board[col][0]= square2;
                
                Piece piece3 = new Rook(4);
                Square square3 = new Square(13-col,13,piece3);
                board[13-col][13] = square3;
            }
            //knight
            else if(ry[col-3]==2)
            {
                Piece piece = new Knight(1);
                Square square = new Square(0,col,piece);
                board[0][col]= square;

                Piece piece1 = new Knight(3);
                Square square1 = new Square(13,13-col,piece1);
                board[13][13-col] = square1;
                
                Piece piece2 = new Knight(2);
                Square square2 = new Square(col,0,piece2);
                board[col][0]= square2;
                
                Piece piece3 = new Knight(4);
                Square square3 = new Square(13-col,13,piece3);
                board[13-col][13] = square3;
            }
            //bishop
            else if(ry[col-3]==3)
            {
                Piece piece = new Bishop(1);
                Square square = new Square(0,col,piece);
                board[0][col]= square;

                Piece piece1 = new Bishop(3);
                Square square1 = new Square(13,13-col,piece1);
                board[13][13-col] = square1;
                
                Piece piece2 = new Bishop(2);
                Square square2 = new Square(col,0,piece2);
                board[col][0]= square2;
                
                Piece piece3 = new Bishop(4);
                Square square3 = new Square(13-col,13,piece3);
                board[13-col][13] = square3;
            }
            //queen
            else if(ry[col-3]==4)
            {
                Piece piece = new Queen(1);
                Square square = new Square(0,col,piece);
                board[0][col]= square;

                Piece piece1 = new Queen(3);
                Square square1 = new Square(13,13-col,piece1);
                board[13][13-col] = square1;
                
                Piece piece2 = new Queen(2);
                Square square2 = new Square(col,0,piece2);
                board[col][0]= square2;
                
                Piece piece3 = new Queen(4);
                Square square3 = new Square(13-col,13,piece3);
                board[13-col][13] = square3;
            }
            //king
            else
            {
                Piece piece = new King(1);
                Square square = new Square(0,col,piece);
                board[0][col]= square;

                Piece piece1 = new King(3);
                Square square1 = new Square(13,13-col,piece1);
                board[13][13-col] = square1;
                
                Piece piece2 = new King(2);
                Square square2 = new Square(col,0,piece2);
                board[col][0]= square2;
                
                Piece piece3 = new King(4);
                Square square3 = new Square(13-col,13,piece3);
                board[13-col][13] = square3;
            }
        }

        //initialize pawns:

        for(int i=3;i<=10;i++)
        {
            Piece piece = new Pawn(1);
            Square square = new Square(1,i,piece);
            board[1][i]=square;

            Piece piece1 = new Pawn(3);
            Square square1 = new Square(12,i,piece1);
            board[12][i]=square1;

            Piece piece2 = new Pawn(2);
            Square square2 = new Square(i,1,piece2);
            board[i][1]= square2;

            Piece piece3 = new Pawn(4);
            Square square3 = new Square(i,12,piece3);
            board[i][12]= square3;
        }

        //Initialize rest of empty squares

        for(int i=3;i<=10;i++)
        {
            for(int j=3;j<=10;j++)
            {
                Square square = new Square(i,j,true);
                board[i][j]=square;
            }
        }
    }

    public ArrayList<int[]> getKnightMoves(int i,int j)
    {
        int[][] knightMoves = {{1,2},{1,-2},{2,1},{2,-1},{-2,-1},{-2,1},{-1,2},{-1,-2}};
        ArrayList<int[]> moves = new ArrayList<int[]>();
        Piece curPiece = this.board[i][j].getPiece();
        for(int[] move:knightMoves)
        {
            Square moveSquare = this.board[i+move[0]][j+move[1]];
            if(moveSquare.getValidity())
            {
                Piece movePiece = moveSquare.getPiece();
                if(movePiece==null)
                {
                    int[] toAdd = {i,j,i+move[0],j+move[1]};
                    moves.add(toAdd);
                }
                else
                {
                    if(movePiece.getColor()%2!=curPiece.getColor()%2)
                    {
                        int[] toAdd = {i,j,i+move[0],j+move[1]};
                        moves.add(toAdd);
                    }
                }
            }
        }
        return moves;
        
    }
    //Get moves for player (color)
    public ArrayList<int[]> getMoves(int color)
    {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        
        for(int i=0;i<14;i++)
        {
            for(int j=0;j<14;j++)
            {
                Square curSquare = this.board[i][j];
                Piece curPiece = curSquare.getPiece();
                if(curSquare.getValidity()&&curPiece!=null&&curPiece.getColor()==color)
                {
                    if(curPiece instanceof Knight)
                    {
                        // check 1 2, 1 -2, 2 1, 2 -1, -2 -1, -2 1, -1,2, -1, -2
                        
                        
                    }
                    else if(curPiece instanceof Queen || curPiece instanceof Bishop )
                    {
                        // check up right diagonal 
                        for(int dist = 1;dist<=13;dist++)
                        {
                            //check +x and +y
                            if(i+dist>13||j+dist>13)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i+dist][j+dist];
                            Piece movePiece = curSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i+dist,j+dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd={i,j,i+dist,j+dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }

                        for(int dist = 1;dist<=13;dist++)
                        {
                            //check +x and -y
                            if(i+dist>13||j-dist<0)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i+dist][j-dist];
                            Piece movePiece = curSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i+dist,j-dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd={i,j,i+dist,j-dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }

                        for(int dist = 1;dist<=13;dist++)
                        {
                            //check -x and +y
                            if(i-dist<0||j+dist>13)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i-dist][j+dist];
                            Piece movePiece = curSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i-dist,j+dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd={i,j,i-dist,j+dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }

                        for(int dist = 1;dist<=13;dist++)
                        {
                            //check -x and -y
                            if(i-dist<0||j-dist<0)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i-dist][j-dist];
                            Piece movePiece = curSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i-dist,j-dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd={i,j,i-dist,j-dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }

                    }

                    else if(curPiece instanceof Rook||curPiece instanceof Queen)
                    {
                        for(int dist = 1;dist<=13;dist++)
                        {
                            //move up 
                            if(i+dist>13)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i+dist][j];
                            Piece movePiece = moveSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i+dist,j};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd = {i,j,i+dist,j};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }
                        for(int dist = 1;dist<=13;dist++)
                        {
                            //move right
                            if(j+dist>13)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i][j+dist];
                            Piece movePiece = moveSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i,j+dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd = {i,j,i,j+dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }

                        for(int dist = 1;dist<=13;dist++)
                        {
                            //move down
                            if(i-dist<0)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i-dist][j];
                            Piece movePiece = moveSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i-dist,j};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd = {i,j,i-dist,j};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }
                        
                        for(int dist = 1;dist<=13;dist++)
                        {
                            //move lefft
                            if(j-dist<0)
                            {
                                break;
                            }
                            Square moveSquare = this.board[i][j-dist];
                            Piece movePiece = moveSquare.getPiece();
                            if(movePiece==null)
                            {
                                int[] toAdd = {i,j,i,j-dist};
                                moves.add(toAdd);
                            }
                            else
                            {
                                if(movePiece.getColor()%2!=curPiece.getColor()%2)
                                {
                                    int[] toAdd = {i,j,i,j-dist};
                                    moves.add(toAdd);
                                }
                                break;
                            }
                        }
                        
                        
                    }
                    else if(curPiece instanceof King)
                    {

                    }
                    else if(curPiece instanceof Pawn)
                    {
                        //check forward
                        int curColor = curPiece.getColor();
                        if(curColor==1)
                        {
                            //direction is i+1 for red
                            Square moveSquare = this.board[i+1][j];
                            if(moveSquare.getPiece()==null)
                            {
                                int[] toAdd = {i,j,i+1,j};
                                moves.add(toAdd);
                                if(i==1)
                                {
                                    moveSquare = this.board[i+2][j];
                                    if(moveSquare.getPiece()==null)
                                    {
                                        toAdd[2]+=1;
                                        moves.add(toAdd);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i+1][j-1].getPiece();
                            Piece capPiece2 = this.board[i+1][j+1].getPiece();
                            
                            if(capPiece1!=null && capPiece1.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j-1};
                                moves.add(toAdd);
                            }
                            if(capPiece2!=null && capPiece2.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j+1};
                                moves.add(toAdd);
                            }
                            //Handle Enpassant 
                        }
                        else if(curColor==2)
                        {
                            //direction is j+1 for blue
                            Square moveSquare = this.board[i][j+1];
                            if(moveSquare.getPiece()==null)
                            {
                                int[] toAdd = {i,j,i,j+1};
                                moves.add(toAdd);
                                if(j==1)
                                {
                                    moveSquare = this.board[i][j+2];
                                    if(moveSquare.getPiece()==null)
                                    {
                                        toAdd[3]+=1;
                                        moves.add(toAdd);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            //check for captures
                            Piece capPiece1 = this.board[i+1][j+1].getPiece();
                            Piece capPiece2 = this.board[i-1][j+1].getPiece();
                            
                            if(capPiece1!=null && capPiece1.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j+1};
                                moves.add(toAdd);
                            }
                            if(capPiece2!=null && capPiece2.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i-1,j+1};
                                moves.add(toAdd);
                            }
                        }
                        else if(curColor==3)
                        {
                            // direction is i-1 for yellow 
                            Square moveSquare = this.board[i-1][j];
                            if(moveSquare.getPiece()==null)
                            {
                                int[] toAdd = {i,j,i-1,j};
                                moves.add(toAdd);
                                if(i==12)
                                {
                                    moveSquare = this.board[i-2][j];
                                    if(moveSquare.getPiece()==null)
                                    {
                                        toAdd[2]-=1;
                                        moves.add(toAdd);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i-1][j-1].getPiece();
                            Piece capPiece2 = this.board[i-1][j+1].getPiece();
                            
                            if(capPiece1!=null && capPiece1.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j-1};
                                moves.add(toAdd);
                            }
                            if(capPiece2!=null && capPiece2.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j+1};
                                moves.add(toAdd);
                            }
                        }
                        else
                        {
                            // direction is j-1 for green
                            Square moveSquare = this.board[i][j-1];
                            if(moveSquare.getPiece()==null)
                            {
                                int[] toAdd = {i,j,i,j-1};
                                moves.add(toAdd);
                                if(j==12)
                                {
                                    moveSquare = this.board[i][j-2];
                                    if(moveSquare.getPiece()==null)
                                    {
                                        toAdd[3]-=1;
                                        moves.add(toAdd);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i+1][j-1].getPiece();
                            Piece capPiece2 = this.board[i-1][j-1].getPiece();
                            
                            if(capPiece1!=null && capPiece1.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i+1,j-1};
                                moves.add(toAdd);
                            }
                            if(capPiece2!=null && capPiece2.getColor()%2!=curColor%2)
                            {
                                int[] toAdd = {i,j,i-1,j-1};
                                moves.add(toAdd);
                            }
                        }

                    }

                }
            }
        }
        return moves;
    }
}