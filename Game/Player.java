import java.util.InputMismatchException;
import java.util.Scanner;
public class Player{
    public String name;
    public int move;
    public int score;
    public Player(){
        this.score = 0;
    }
    Scanner input = new Scanner(System.in);
    public void enterName(){
        System.out.print("- Nickname: ");
        String userName = input.nextLine();
        this.setName(userName);
    }
    public void enterMove(){
        System.out.println("---------------");
        boolean invalidMove = true;
        while (invalidMove){
            System.out.print(this.getName().toUpperCase() + " move: ");
            try {
                int move = input.nextInt();
                if (move >= 0 && move <= 100) {
                    this.setMove(move);
                    invalidMove = false; }
                else {
                    System.out.println("! INVALID MOVE ! Please enter a number between 0 and 100.");
                }}
            catch (InputMismatchException valueError) {
                System.out.println("! INVALID MOVE ! Please enter a valid integer.");
                input.nextLine();
            }}
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getMove(){
        return this.move;
    }
    public void setMove(int move){
        this.move = move;
    }    
    public int getScore(){
        return this.score;
    } 
    public void setScore(int score){
        this.score = score;
    }
}
