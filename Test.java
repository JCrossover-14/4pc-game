import java.util.*;

public class Test 
{
    public static int getRandomNumber(int n)
    {
        Random random = new Random();
        return random.nextInt(n);
    }
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);    
        Board gameboard = new Board();
        gameboard.initialize_board();
        System.out.println(gameboard.toString());
        //ArrayList<int[]> moves = gameboard.getLegalMoves(1);
        //for(int[] move: moves)
        //{
            //System.out.println(Integer.toString(move[0])+" "+Integer.toString(move[1])+" "+Integer.toString(move[2])+" "+Integer.toString(move[3]));
        //}
        int turn = 0;
        while(true)
        {
            System.out.println(gameboard.toString());
            turn = (turn)%4 +1;
            ArrayList<int[]> legalMoves = new ArrayList<int[]>();
            if(turn==1)
            {
                ArrayList<int[]> rmoves = gameboard.getLegalMoves(1);
                for(int[] x:rmoves) legalMoves.add(x);
            }
            else if(turn==2)
            {
                ArrayList<int[]> bmoves = gameboard.getLegalMoves(2);
                for(int[] x:bmoves) legalMoves.add(x);
            }
            else if(turn==3)
            {
                ArrayList<int[]> ymoves = gameboard.getLegalMoves(3);
                for(int[] x:ymoves) legalMoves.add(x);
            }
            else if(turn==4)
            {
                ArrayList<int[]> gmoves = gameboard.getLegalMoves(4);
                for(int[] x:gmoves) legalMoves.add(x);
            }
            boolean yes = false;
            System.out.println("Legal moves are: ");
            for(int[] x:legalMoves)
            {
                System.out.println(Integer.toString(x[0])+" "+Integer.toString(x[1])+" "+Integer.toString(x[2])+" "+Integer.toString(x[3]));
            }
            while(!yes)
            {
                String userInput = input.nextLine();
                String [] nums = userInput.split(" ");

                int x1 = Integer.parseInt(nums[0]);
                int y1 = Integer.parseInt(nums[1]);
                int x2 = Integer.parseInt(nums[2]);
                int y2 = Integer.parseInt(nums[3]);

                for(int[] x:legalMoves)
                {
                    if(x[0]==x1&&x[1]==y1&&x2==x[2]&&y2==x[3])
                    {
                        yes = true;
                        gameboard.move(x1,y1,x2,y2);
                        break;
                    }
                }
            }
        }
    }    
}
