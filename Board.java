
import java.util.*;

public class Board implements Cloneable {
    private Square[][] board;
    /**
 * Creates the chess board
 */
    public Board() {
        this.board = new Square[14][14];
    }

    public void initialize_board() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                board[i][j] = new Square(i, j, true);
            }
        }
        
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                if (i < 3 || i > 10) {
                    if (j < 3 || j > 10) {
                        board[i][j] = new Square(i, j, false);
                    }
                }
            }
        }
        
        int[] ry = {1, 2, 3, 4, 5, 3, 2, 1};
        for (int col = 3; col < 11; col++) {
            //consider [0][col] to be the redd piece
            //consider board[13][13-col] to be the yellow piece
            //rook
            if (ry[col - 3] == 1) {
                Piece piece = new Rook(3);
                Square square = new Square(0, col, piece);
                board[0][col] = square;
                
                Piece piece1 = new Rook(1);
                Square square1 = new Square(13, 13 - col, piece1);
                board[13][13 - col] = square1;
                
                Piece piece2 = new Rook(2);
                Square square2 = new Square(col, 0, piece2);
                board[col][0] = square2;
                
                Piece piece3 = new Rook(4);
                Square square3 = new Square(13 - col, 13, piece3);
                board[13 - col][13] = square3;
            } else if (ry[col - 3] == 2) {
                //knight
                Piece piece = new Knight(3);
                Square square = new Square(0, col, piece);
                board[0][col] = square;

                Piece piece1 = new Knight(1);
                Square square1 = new Square(13, 13 - col, piece1);
                board[13][13 - col] = square1;
                
                Piece piece2 = new Knight(2);
                Square square2 = new Square(col, 0, piece2);
                board[col][0] = square2;
                
                Piece piece3 = new Knight(4);
                Square square3 = new Square(13 - col, 13, piece3);
                board[13 - col][13] = square3;
            } else if (ry[col - 3] == 3) {
                //bishop
                Piece piece = new Bishop(3);
                Square square = new Square(0, col, piece);
                board[0][col] = square;

                Piece piece1 = new Bishop(1);
                Square square1 = new Square(13, 13 - col, piece1);
                board[13][13 - col] = square1;
                
                Piece piece2 = new Bishop(2);
                Square square2 = new Square(col, 0, piece2);
                board[col][0] = square2;
                
                Piece piece3 = new Bishop(4);
                Square square3 = new Square(13 - col, 13, piece3);
                board[13 - col][13] = square3;
            } else if (ry[col - 3] == 4) {
                //queen
                Piece piece = new Queen(3);
                Square square = new Square(0, col, piece);
                board[0][col] = square;

                Piece piece1 = new Queen(1);
                Square square1 = new Square(13, 13 - col, piece1);
                board[13][13 - col] = square1;
                
                Piece piece2 = new Queen(2);
                Square square2 = new Square(col, 0, piece2);
                board[col][0] = square2;
                
                Piece piece3 = new Queen(4);
                Square square3 = new Square(13 - col, 13, piece3);
                board[13 - col][13] = square3;
            } else {
                //king
                Piece piece = new King(3);
                Square square = new Square(0, col, piece);
                board[0][col] = square;

                Piece piece1 = new King(1);
                Square square1 = new Square(13, 13 - col, piece1);
                board[13][13 - col] = square1;
                
                Piece piece2 = new King(2);
                Square square2 = new Square(col, 0, piece2);
                board[col][0] = square2;
                
                Piece piece3 = new King(4);
                Square square3 = new Square(13 - col, 13, piece3);
                board[13 - col][13] = square3;
            }
        }

        //initialize pawns:

        for (int i = 3; i <= 10; i++) {
            Piece piece = new Pawn(3);
            Square square = new Square(1, i, piece);
            board[1][i] = square;

            Piece piece1 = new Pawn(1);
            Square square1 = new Square(12, i, piece1);
            board[12][i] = square1;

            Piece piece2 = new Pawn(2);
            Square square2 = new Square(i, 1, piece2);
            board[i][1] = square2;

            Piece piece3 = new Pawn(4);
            Square square3 = new Square(i, 12, piece3);
            board[i][12] = square3;
        }

        //Initialize rest of empty squares

        for (int i = 3; i <= 10; i++) {
            for (int j = 3; j <= 10; j++) {
                Square square = new Square(i, j, true);
                board[i][j] = square;
            }
        }


    }

    public ArrayList<int[]> getKnightMoves(int i, int j) {
        int[][] knightMoves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}};
        ArrayList<int[]> moves = new ArrayList<int[]>();
        Piece curPiece = this.board[i][j].getPiece();
        for (int[] move:knightMoves) {
            //System.out.println("Considering "+Integer.toString(i+move[0])
            //+" "+Integer.toString(j+move[1])+" as a move ");
            if ((i + move[0]) < 0 || (i + move[0]) >= 14 || (j + move[1]) < 0 || (j + move[1]) >= 14) {
                continue;
            }
            Square moveSquare = this.board[i + move[0]][j + move[1]];
            if (moveSquare.getValidity()) {
                Piece movePiece = moveSquare.getPiece();
                if (movePiece == null) {
                    int[] toAdd = {i, j, i + move[0], j + move[1]};
                    moves.add(toAdd);
                    //System.out.println("valid");
                } else {
                    if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                        int[] toAdd = {i, j, i + move[0], j + move[1]};
                        moves.add(toAdd);
                        System.out.println("valid");
                    }
                    //else System.out.println("cannot take own piece");
                }
            }
            //else System.out.println("Square invalid");
        }
        return moves;
    }

    public ArrayList<int[]> getBishopMoves(int i, int j) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        Piece curPiece = this.board[i][j].getPiece();
        for (int dist = 1; dist <= 13; dist++) {
            //check +x and +y
            if (i + dist > 13 || j + dist > 13) {
                break;
            }
            Square moveSquare = this.board[i + dist][j + dist];
            if (!moveSquare.getValidity()) { 
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i + dist, j + dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i + dist, j + dist};
                    moves.add(toAdd);
                }
                break;
            }
        }

        for (int dist = 1; dist <= 13; dist++) {
            //check +x and -y
            if (i + dist > 13 || j - dist < 0) {
                break;
            }
            Square moveSquare = this.board[i + dist][j - dist];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i + dist, j - dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i + dist, j - dist};
                    moves.add(toAdd);
                }
                break;
            }
        }

        for (int dist = 1; dist <= 13; dist++) {
            //check -x and +y
            if (i - dist < 0 || j + dist > 13) {
                break;
            }
            Square moveSquare = this.board[i - dist][j + dist];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i - dist, j + dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i - dist, j + dist};
                    moves.add(toAdd);
                }
                break;
            }
        }

        for (int dist = 1; dist <= 13; dist++) {
            //check -x and -y
            if (i - dist < 0 || j - dist < 0) {
                break;
            }
            Square moveSquare = this.board[i - dist][j - dist];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i - dist, j - dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i - dist, j - dist};
                    moves.add(toAdd);
                }
                break;
            }
        }

        return moves;
    }

    public ArrayList<int[]> getRookMoves(int i, int j) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        Piece curPiece = this.board[i][j].getPiece();
        for (int dist = 1; dist <= 13; dist++) {
            //move up 
            if (i + dist > 13) {
                break;
            }
            Square moveSquare = this.board[i + dist][j];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i + dist, j};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i + dist, j};
                    moves.add(toAdd);
                }
                break;
            }
        }
        for (int dist = 1; dist <= 13; dist++) {
            //move right
            if (j + dist > 13) {
                break;
            }
            Square moveSquare = this.board[i][j + dist];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i, j + dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i, j + dist};
                    moves.add(toAdd);
                }
                break;
            }
        }

        for (int dist = 1; dist <= 13; dist++) {
            //move down
            if (i - dist < 0) {
                break;
            }
            Square moveSquare = this.board[i - dist][j];
            Piece movePiece = moveSquare.getPiece();
            if (!moveSquare.getValidity()) {
                break;
            }
            if (movePiece == null) {
                int[] toAdd = {i, j, i - dist, j};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i - dist, j};
                    moves.add(toAdd);
                }
                break;
            }

        }
                        
        for (int dist = 1; dist <= 13; dist++) {
            //move lefft
            if (j - dist < 0) {
                break;
            }
            Square moveSquare = this.board[i][j - dist];
            if (!moveSquare.getValidity()) {
                break;
            }
            Piece movePiece = moveSquare.getPiece();
            if (movePiece == null) {
                int[] toAdd = {i, j, i, j - dist};
                moves.add(toAdd);
            } else {
                if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                    int[] toAdd = {i, j, i, j - dist};
                    moves.add(toAdd);
                }
                break;
            }
        }
        

        return moves;
    }
    

    public ArrayList<int[]> getKingMoves(int i, int j) {
        int[][] kingMoves = {{1, 1}, {1, -1}, {-1, 1}, {1, 0}, {-1, -1}, {-1, 0 }, {0, 1}, {0, -1}};
        ArrayList<int[]> moves = new ArrayList<int[]>();
        Piece curPiece = this.board[i][j].getPiece();
        for (int[] move:kingMoves) {
            if (i + move[0] < 0 || i + move[0] >= 14 || j + move[1] < 0 || j + move[1] >= 14) {
                continue;
            }
            Square moveSquare = this.board[i + move[0]][j + move[1]];
            if (moveSquare.getValidity()) {
                Piece movePiece = moveSquare.getPiece();
                if (movePiece == null) {
                    int[] toAdd = {i, j, i + move[0], j + move[1]};
                    moves.add(toAdd);
                } else {
                    if (movePiece.getColor() % 2 != curPiece.getColor() % 2) {
                        int[] toAdd = {i, j, i + move[0], j + move[1]};
                        moves.add(toAdd);
                    }
                }
            }
        }
        return moves;

    }
    
    //Get moves for player (color)
    public ArrayList<int[]> getMoves(int color) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                Square curSquare = this.board[i][j];
                Piece curPiece = curSquare.getPiece();
                if (curSquare.getValidity() && curPiece != null && curPiece.getColor()==color) {
                    if (curPiece instanceof Knight) {
                        
                        ArrayList<int[]> knightm = getKnightMoves(i, j);
                        for (int[] x:knightm) {
                            moves.add(x);
                        }
                        // check 1 2, 1 -2, 2 1, 2 -1, -2 -1, -2 1, -1,2, -1, -2
                    } else if (curPiece instanceof Bishop) {
                        // check up right diagonal 
                        ArrayList<int[]> bishopm = getBishopMoves(i, j);
                        for (int[] x:bishopm) {
                            moves.add(x);
                        }
                    } else if (curPiece instanceof Rook) {
                        ArrayList<int[]> rookm = getRookMoves(i, j);
                        for (int[] x: rookm) {
                            moves.add(x);
                        }
                    } else if (curPiece instanceof Queen) {
                        ArrayList<int[]> rookm = getRookMoves(i, j);
                        for (int[] x:rookm) {
                            moves.add(x);
                        }
                        ArrayList<int[]> bishopm = getBishopMoves(i, j);
                        for (int[] x:bishopm) {
                            moves.add(x);
                        }
                    } else if (curPiece instanceof King) {
                        ArrayList<int[]> kingm = getKingMoves(i, j);
                        for (int[]x:kingm) {
                            moves.add(x);
                        }
                    } else if (curPiece instanceof Pawn) {
                        //check forward
                        int curColor = curPiece.getColor();
                        if (curColor == 3) {
                            //direction is i+1 for red
                            Square moveSquare = this.board[i + 1][j];
                            if (moveSquare.getPiece() == null) {
                                int[] toAdd = {i, j, i + 1, j};
                                moves.add(toAdd);
                                if (i == 1) {
                                    moveSquare = this.board[i + 2][j];
                                    int[] toAdd1 = Arrays.copyOf(toAdd, toAdd.length);
                                    if (moveSquare.getPiece() == null) {
                                        toAdd1[2] += 1;
                                        moves.add(toAdd1);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i + 1][j - 1].getPiece();
                            Piece capPiece2 = this.board[i + 1][j + 1].getPiece();
                            
                            if (capPiece1 != null && capPiece1.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j - 1};
                                moves.add(toAdd);
                            }
                            if (capPiece2 != null && capPiece2.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j + 1};
                                moves.add(toAdd);
                            }
                            //Handle Enpassant 
                        } else if (curColor == 2) {
                            //direction is j+1 for blue
                            Square moveSquare = this.board[i][j + 1];
                            if (moveSquare.getPiece() == null) {
                                int[] toAdd = {i, j, i, j + 1};
                                moves.add(toAdd);
                                if (j == 1) {
                                    moveSquare = this.board[i][j + 2];
                                    
                                    if (moveSquare.getPiece() == null) {
                                        int[] toAdd1 = Arrays.copyOf(toAdd, toAdd.length);
                                        toAdd1[3] += 1;
                                        moves.add(toAdd1);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            //check for captures
                            Piece capPiece1 = this.board[i + 1][j + 1].getPiece();
                            Piece capPiece2 = this.board[i - 1][j + 1].getPiece();
                            
                            if (capPiece1 != null && capPiece1.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j + 1};
                                moves.add(toAdd);
                            }
                            if (capPiece2 != null && capPiece2.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i - 1, j + 1};
                                moves.add(toAdd);
                            }
                        } else if (curColor == 1) {
                            // direction is i-1 for yellow 
                            Square moveSquare = this.board[i - 1][j];
                            if (moveSquare.getPiece() == null) {
                                int[] toAdd = {i, j, i - 1, j};
                                moves.add(toAdd);
                                if (i == 12) {
                                    moveSquare = this.board[i - 2][j];
                                    int[] toAdd1 = Arrays.copyOf(toAdd, toAdd.length);
                                    if (moveSquare.getPiece() == null) {
                                        toAdd1[2] -= 1;
                                        moves.add(toAdd1);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i - 1][j - 1].getPiece();
                            Piece capPiece2 = this.board[i - 1][j + 1].getPiece();
                            
                            if (capPiece1 != null && capPiece1.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j - 1};
                                moves.add(toAdd);
                            } 
                            if (capPiece2 != null && capPiece2.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j + 1};
                                moves.add(toAdd);
                            }
                        } else {
                            // direction is j-1 for green
                            Square moveSquare = this.board[i][j - 1];
                            if (moveSquare.getPiece() == null) {
                                int[] toAdd = {i, j, i, j - 1};
                                moves.add(toAdd);
                                if (j == 12) {
                                    moveSquare = this.board[i][j - 2];
                                    if (moveSquare.getPiece() == null) {
                                        
                                        int[] toAdd1 = Arrays.copyOf(toAdd, toAdd.length);
                                        toAdd1[3] -= 1;
                                        moves.add(toAdd1);
                                    }
                                }
                            }
                            //check if pawn is on starting square
                            
                            //check for captures
                            Piece capPiece1 = this.board[i + 1][j - 1].getPiece();
                            Piece capPiece2 = this.board[i - 1][j - 1].getPiece();
                            
                            if (capPiece1 != null && capPiece1.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i + 1, j - 1};
                                moves.add(toAdd);
                            }
                            if (capPiece2 != null && capPiece2.getColor() % 2 != curColor % 2) {
                                int[] toAdd = {i, j, i - 1, j - 1};
                                moves.add(toAdd);
                            }
                        }

                    }

                }
            }
        }
        return moves;
    }
    /**
 * Checks if the specified color is in check.
 *
 * @param color the color to check (0 for black, 1 for white, etc.).
 * @return true if the color is in check, false otherwise.
 */
    public boolean isCheck(int color) {
        if (color % 2 == 0) {
            // look for r and y which is 1 and 3
            ArrayList<int[]> rmoves = getMoves(1);
            ArrayList<int[]> ymoves = getMoves(3);
            for (int[] x:rmoves) {
                Piece movePiece = board[x[2]][x[3]].getPiece();
                if (movePiece != null && movePiece instanceof King && movePiece.getColor() == color) {
                    return true;
                }
            }
            for (int[] x:ymoves) {
                Piece movePiece = board[x[2]][x[3]].getPiece();
                if (movePiece != null && movePiece instanceof King && movePiece.getColor() == color) {
                    return true;
                }
            }
        } else {
            ArrayList<int[]> bmoves = getMoves(2);
            ArrayList<int[]> gmoves = getMoves(4);
            for (int[] x:bmoves) {
                Piece movePiece = board[x[2]][x[3]].getPiece();
                if (movePiece != null && movePiece instanceof King && movePiece.getColor() == color) {
                    return true;
                }
            }
            for (int[] x:gmoves) {
                Piece movePiece = board[x[2]][x[3]].getPiece();
                if (movePiece != null && movePiece instanceof King && movePiece.getColor() == color) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void move(int x1, int y1, int x2, int y2) {
        Piece movePiece = this.board[x1][y1].getPiece();
        this.board[x2][y2].setPiece(movePiece);
        this.board[x1][y1].setPiece();
    }

    public ArrayList<int[]> getLegalMoves(int color) {
        ArrayList<int[]> moves = getMoves(color);
        ArrayList<int[]> legalMoves = new ArrayList<int[]>();
        for (int[] move:moves) {
            Board futureBoard = (Board) (this.clone());
            futureBoard.move(move[0], move[1], move[2], move[3]);
            if (!futureBoard.isCheck(color)) {
                legalMoves.add(move);
            }
        }
        return legalMoves;
    }
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public String toString() {
        String ans = "";
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                if (this.board[i][j].getPiece() == null) {
                    if (this.board[i][j].getValidity()){
                        ans += ".";
                    } else { 
                        ans += "+";
                    }
                } else {
                    Piece curPiece = this.board[i][j].getPiece();
                    if (curPiece.getColor() == 1) {
                        ans += RED;
                    }
                    if (curPiece.getColor() == 2) {
                        ans += BLUE;
                    }
                    if (curPiece.getColor() == 3) {
                        ans += YELLOW;
                    }
                    if (curPiece.getColor() == 4) {
                        ans += GREEN;
                    }
                    if (curPiece instanceof Pawn) {
                        ans += "P";
                    } else if (curPiece instanceof Knight) {
                        ans += "N";
                    } else if (curPiece instanceof Rook) {
                        ans += "R";
                    } else if (curPiece instanceof Queen) {
                        ans += "Q";
                    } else if (curPiece instanceof King) {
                        ans += "K";
                    } else if (curPiece instanceof Bishop) {
                        ans += "B";
                    }
                    ans += RESET;
                }
            }
            ans += '\n';
        }
        return ans;
    }

    @Override
    public Board clone() {
        Board cloned;
        try {
            cloned = (Board) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
        
        cloned.board = new Square[14][14]; // Initialize the new board array
        
        // Clone each Square in the board
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                try {
                    cloned.board[i][j] = (Square) (this.board[i][j].clone());
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException("No cloning available",e);
                } // Deep clone each Square
            }
        }
        return cloned;
    }
    private boolean isMate(int color) {
        if (isCheck(color) && getLegalMoves(color).size() == 0) {
            return true;
        }
        return false; 
    }
    private int[] algorithm(int color, Board board) {
        Random random = new Random();
        ArrayList<int[]> a = getLegalMoves(color);
        int x = random.nextInt(a.size());
        return a.get(x);
    }
    //private int[] algorithm1(int color) {
    //for (i =0; i<getLegalMoves(color).size(); i++){
    //  }
}
