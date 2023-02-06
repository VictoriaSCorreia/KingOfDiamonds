import java.util.Scanner;
public class Player{
    public String name;
    public int move;
    public int score;
    public Player(){
        this.score = 0;
    }
    public void enterName(){
        Scanner names = new Scanner(System.in);
            System.out.print("Nome: ");
            String userName = names.nextLine();
            this.setName(userName);
    }
    public void enterMove(){
        Scanner moves = new Scanner(System.in);
            System.out.print("Jogada: ");
            int move = moves.nextInt();
            this.setMove(move);
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
