import java.util.Scanner;
public class main {
    private boolean gamestate= true;
    private Scanner scanner;
    private boolean turn;
    private int color;
    private String str;
    //turn is true if it is the person's turn
    public Main(){
        scanner = new Scanner(System.in);
    while (str.toLowerCase!="ry"&& str.toLowerCase!="bg"){
        System.out.println("Choose your team! Type 'RY' to play as red-yellow, or 'BG' to play as blue-green.");
        String str = scanner.nextLine();
        if (str.toLowerCase().equals("ry")) {
            turn = true;
            color = 1;
        }
        if (str.toLowerCase().equals("bg")) {
            turn = false;
            color = 2;
        }
        if (!str.toLowerCase().equals("ry")&& !str.toLowerCase().equals("bg")){
            System.out.println("That is not a valid team. Please input your team again.");
        }
    }

    while (gamestate){
        if (turn){
            System.out.println("Input your next move as four numbers: x1 y1 x2 y2 separated by spaces");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
                for(int i = 1; i< getMoves(color).size(); i++){
                    if ({[x1],[y1],[x2],[y2]}!=getMoves(color)(i)){
                        System.out.println("That is an invalid move");
                            break;
                    }
                }
            if (isMate({[x1],[y1],[x2],[y2]})){
                System.out.println("Congratulations! You win!");
            }
            else if(isMate(algorithm({[x1],[y1],[x2],[y2]}))){
                System.out.println("You just got beaten by the Chloblot!");
            }
            else{
                System.out.println("My next move is: "+ algorithm({[x1],[y1],[x2],[y2]}));
                color = color%4;
                color++;
            }
        }
        else{
            System.out.println("My next move is: "+ algorithm({[x1],[y1],[x2],[y2]}));
                color = color%4;
                color++;
                turn =true;
        }
    }
}
}