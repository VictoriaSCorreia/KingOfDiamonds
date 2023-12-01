import java.util.Scanner;

public class Player implements Interface{
    private String name;
    private int move;
    private int score;

    Scanner input = new Scanner(System.in);

    public Player(){
        this.score = -1;
    }
    
    public void enterName(){
        System.out.print("- Nickname: ");
        setName(input.nextLine());
    }

    public void enterMove(){
        boolean invalidMove = true;

        System.out.println("---------------");
        while (invalidMove){
            System.out.print(getName().toUpperCase() + " move: ");
            int value = input.nextInt();
            invalidMove = invalid(value);
            if (!invalidMove)
                setMove(value);
        }}

    public boolean invalid(int move){
            if (move >= 0 && move <= 100) {
                return false; 
            }
            else {
                System.out.println("! INVALID MOVE ! Please enter a number between 0 and 100.");
                return true;
            }};

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