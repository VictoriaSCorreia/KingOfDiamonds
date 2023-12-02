import java.util.ArrayList;

public class Round {
    private int roundNum;
    private int nPlayers; 
    protected ArrayList<Player> playersList = new ArrayList<Player>(); 
    protected ArrayList<Player> playersList2 = new ArrayList<Player>(); 
   
    public Round(){
        this.roundNum = 5;
    }

    public int getNPlayers(){
        return this.nPlayers;
    }
    public void setNPlayers(int nPlayers){
        this.nPlayers = nPlayers;
    }
    public int getRoundNum(){
        return this.roundNum;
    }
    public void setRoundNum(int round){
        this.roundNum = round;
    }
}

