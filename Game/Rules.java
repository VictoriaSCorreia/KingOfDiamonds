import java.util.ArrayList;

/* Completely done */
public class Rules {
    private int winnerMove;
    private double result;
    private int numberOfWinners;
    private int roundNumb = 5;

    // No rules
    public void fivePlayers(ArrayList<Player> playersList){ 
        addPoints(playersList);
    }
    // Rule N° 1
    public void fourPlayers(ArrayList<Player> playersList){
        if (numberOfWinners == 1){
            addPoints(playersList);}
    }
    // Rule N° 1 and N° 2
    public void threePlayers(ArrayList<Player> playersList){
        boolean ruleN2 = false;
        fourPlayers(playersList);

        for (Player player : playersList){
            if (player.getMove() == Math.round(result))
                ruleN2 = true; 
            }
        if (ruleN2){
            for (Player player : playersList){
                if(player.getMove() != winnerMove)
                    player.setScore(player.getScore() - 1);
                }}
    }
    // Rule N° 1, N° 2 and N°3
    public void twoPlayers(ArrayList<Player> playersList){
        boolean ruleN3 = false;

        for (Player player1 : playersList){
            for (Player player2 : playersList){
                if (player1.getMove() == 0){
                    if (player2.getMove() == 100)
                        ruleN3 = true;
                    }}}

        if (ruleN3){
            for (Player player : playersList){
                if (player.getMove() == 100){
                    player.setScore(player.getScore() + 1);
                }}}
        else
            threePlayers(playersList);   
    }
    private void addPoints(ArrayList<Player> playersList){
        for (Player player : playersList){
            if (player.getMove() == winnerMove){
                player.setScore(player.getScore() + 1);
            }}
    }
    public void removingPoints(ArrayList<Player> playersList){
        for (Player player : playersList)
            player.setScore(player.getScore() - 1);
    }
    public void rules(){
        if (roundNumb <= 4){
            System.out.println("\n - (If 2 players or more choose the same number, they'll lose a point even if the number is the closest)"); 
        }
        if (roundNumb <= 3){
            System.out.println(" - (If a player chooses the exact correct number, the loser penalty is doubled)");
        }
        if (roundNumb <= 2){
            System.out.println(" - (If someone chooses 0, the player who chooses 100 is the winner)");
        }
    }

    public void setWinnerMove(int move){
        this.winnerMove = move;
    }
    public void setResult(double result){
        this.result = result;
    }
    public void setnumberOfWinners(int numb){
        this.numberOfWinners = numb;
    }
    public void setRound(int roundNumb){
        this.roundNumb = roundNumb;
    }
    public int getRound(){
        return roundNumb;
    }
}
