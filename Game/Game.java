import java.util.ArrayList;
import java.lang.Math;
public class Game implements Interface{
    private int rounds;
    private String winner;

    ArrayList<Player> playersList1 = new ArrayList<Player>(); 
    ArrayList<Player> playersList2 = new ArrayList<Player>(); 

    public Game(){
        this.rounds = 5; }
    public void log(){
        for (int i = 0; i < 5; i++){
            Player player = new Player();
            playersList1.add(player);
            player.enterName();
        }}
    public void game(){
        for(Player player : playersList1){
            playersList2.add(player);}     
        while (this.getRounds() > 1){
            double total = 0;
            playersList1.clear();
            for(Player player : playersList2){
                playersList1.add(player);}   
            for(Player player : playersList1){
                player.enterMove();
                total += player.getMove();
                player.setScore(player.getScore() - 1);
            }
            total = total / this.getRounds() * 0.8;
            int winnerMove = closer(total);

            System.out.println("\n==== " + total + " ====");
            System.out.println("Closer move: " + winnerMove);
            if (this.getRounds() == 5){
                fivePlayers(winnerMove);}
            else if (this.getRounds() == 4){
                fourPlayers(winnerMove);}
            else if (this.getRounds() == 3){
                threePlayers(winnerMove, total);}
            else if (this.getRounds() == 2){
                twoPlayers(winnerMove, total);}
            else if (this.getRounds() == 1){
                break;}
            printPlayers();
            playersNumb();
        }
        for (Player player : playersList2){
            this.winner = player.getName(); }
        System.out.println("\n*  Winner: " + this.winner.toUpperCase() + "  *");
    }
    private int closer(double total){
        double difference, closer = 0;
        int winner = 0;
        for(Player player : playersList1){
            if (total > player.getMove()){
                difference = total - player.getMove();}
            else{
                difference = player.getMove() - total;}
            if (playersList1.indexOf(player) == 0){
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
    private void fivePlayers(int winnerMove){
        addingPoints(winnerMove);
    }
    private void fourPlayers(int winnerMove){
        if (winnersNumb(winnerMove) == 1){
            addingPoints(winnerMove);}
    }
    private void threePlayers(int winnerMove, double total){
        boolean rule2 = false;
        fourPlayers(winnerMove);
        for (Player player : playersList1){
            if (player.getMove() == Math.round(total)){
                rule2 = true; }}
        if (rule2){
            for (Player player : playersList1){
                if(player.getMove() != winnerMove){
                    player.setScore(player.getScore() - 1);
                }}}
    }
    private void twoPlayers(int winnerMove, double total){
        boolean lastRule = false;
        for (Player player1 : playersList1){
            for (Player player2 : playersList1){
                if (player1.getMove() == 0){
                    if (player2.getMove() == 100){
                        lastRule = true;
                    }}}}
        if (lastRule){
            for (Player player : playersList1){
                if (player.getMove() == 100){
                    player.setScore(player.getScore() + 1);
                }}}
        else{
            threePlayers(winnerMove, total); }   
    }
    private void addingPoints(int winnerMove){
        for (Player player : playersList1){
            if (player.getMove() == winnerMove){
                player.setScore(player.getScore() + 1);
            }}
    }
    private int winnersNumb(int winnerMove){
        int winners = 0;
        for (Player player : playersList1){
            if (player.getMove() == winnerMove){
                winners += 1;
            }}
        return winners;
    }
    private void playersNumb(){
        boolean losers = false;
        for(Player player : playersList1){
            if (player.getScore() <= -10){
                playersList2.remove((Object) player);
                this.setRounds(getRounds() - 1); 
                losers = true;
            }}
        if (losers && getRounds() > 1){
            rules(); }
    }
    private void rules(){
        if (this.getRounds() <= 4){
            System.out.println("\n - (If 2 players or more choose the same number, they'll lose a point even if the number is the closest)"); }
        if (this.getRounds() <= 3){
            System.out.println(" - (If a player chooses the exact correct number, the loser penalty is doubled)");
        }
        if (this.getRounds() <= 2){
            System.out.println(" - (If someone chooses 0, the player who chooses 100 is the winner)");
        }
    }
    public void printPlayers(){
        System.out.println("");
        for(Player player : playersList1){
            System.out.print("|| " + player.getName().toUpperCase() + ": " + player.getScore() + " ");
        }
        System.out.println(" ||");
    }
    private int getRounds(){
        return this.rounds;
    }
    private void setRounds(int rounds){
        this.rounds = rounds;
    }
}
