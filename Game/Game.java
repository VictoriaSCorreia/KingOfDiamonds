import java.util.ArrayList;
import java.lang.Math;
public class Game{
    public int numPlayers;
    public int rounds;
    public int scores;

    ArrayList<Player> playersList = new ArrayList<Player>(); 

    public void register(){
        for (int i = 0; i < 2; i++){
            Player player = new Player();
            playersList.add(player);
            player.enterName();
        }
    }
    public void game(){
        double total = 0;
        for(Player player : playersList){
            player.enterMove();
            total += player.getMove();
            player.setScore(player.getScore() - 1);
        }
        total = total / playersList.size() * 0.8;
        int winnerMove = closer(total);
        System.out.println("Resultado: " + total);
        System.out.println("Closer move: " + winnerMove);
        if (playersList.size() == 5){
            fivePlayers(winnerMove);
        }
        else if (playersList.size() == 4){
            fourPlayers(winnerMove);
        }
        else if (playersList.size() == 3){
            threePlayers(winnerMove, total);
        }
        else if (playersList.size() == 2){
            twoPlayers(winnerMove, total);
        }
        /* else if (playersList.size() == 1){

        } */
    }
    public int closer(double average){
        double difference, closer = 0;
        int winner = 0;
        for(Player player : playersList){
            if (average > player.getMove()){
                difference = average - player.getMove();
            }
            else{
                difference = player.getMove() - average;
            }
            if (playersList.indexOf(player) == 0){
                closer = difference;
                winner = player.getMove();
            }
            else{
                if (difference <= closer){
                    closer = difference;
                    winner = player.getMove();
                }}}
        return winner;
    }
    public void fivePlayers(int winnerMove){
        addingPoints(winnerMove);
    }
    public void fourPlayers(int winnerMove){
        if (winners(winnerMove) == 1){
            addingPoints(winnerMove);
        }
    }
    public void threePlayers(int winnerMove, double total){
        fourPlayers(winnerMove);
        for (Player player : playersList){
            if (player.getMove() == Math.round(total)){
                if (winners(winnerMove) > 1){
                    player.setScore(player.getScore() - 1);
                }
                else{
                    player.setScore(player.getScore() - 2);
                }
            }}
    }
    public void twoPlayers(int winnerMove, double total){
        boolean lastRule = false;
        for (Player player1 : playersList){
            for (Player player2 : playersList){
                if (player1.getMove() == 0){
                    if (player2.getMove() == 100){
                        lastRule = true;
                    }}}}
        if (lastRule){
            for (Player player : playersList){
                if (player.getMove() == 100){
                    player.setScore(player.getScore() + 1);
                }}}
        else{
            threePlayers(winnerMove, total);
        }   
    }
    /* public void onePlayer(){

    } */
    public void addingPoints(int winnerMove){
        for (Player player : playersList){
            if (player.getMove() == winnerMove){
                player.setScore(player.getScore() + 1);
            }}
    }
    public int winners(int winnerMove){
        int winners = 0;
        for (Player player : playersList){
            if (player.getMove() == winnerMove){
                winners += 1;
            }}
        return winners;
    }
    public void printPlayers(){
        for(Player player : playersList){
            System.out.println(" ");
            System.out.print("Player: " + player.getName());;
            System.out.print("  Move: " + player.getMove());
            System.out.print("  Score: " + player.getScore());
        }
    }
    public int getNumPlayers(){
        return this.numPlayers;
    }
    public void setNumPlayers(int numPlayers){
        this.numPlayers = numPlayers;
    }
    public int getRounds(){
        return this.rounds;
    }
    public void setRounds(int rounds){
        this.rounds = rounds;
    }
    public int getScores(){
        return this.scores;
    }
    public void setScores(int scores){
        this.scores = scores;
    }
}
