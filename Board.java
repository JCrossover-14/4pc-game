
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
}