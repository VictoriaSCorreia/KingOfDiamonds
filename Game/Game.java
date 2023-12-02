import java.util.ArrayList;

public class Game {
    private static Game game = null;
    private static String winner;
    private static Round round = new Round();
    private static Rules rules = new Rules();
    private static ArrayList<Integer> moves = new ArrayList<>();

    private Game(){

    };
    public static Game openGame(){
        if (game == null)
            game = new Game();
        return game;
    }

    public void login(){
        for (int i = 0; i < 5; i++){
            Player player = new Player();
            player.enterName();
            round.playersList.add(player);
        }
        for(Player player : round.playersList)
            round.playersList2.add(player);}

    public void start(){     
        while (round.getRoundNum() > 1){
                double result;
                int winnerMove, winnersNumb;

                round.playersList.clear();
                moves.clear();

                // so we can remove the players at runtime
                for(Player player : round.playersList2)
                    round.playersList.add(player);
        
                setMoves();
                result = calcTotal();
                winnerMove = winnerMove(result);
                winnersNumb = winnersNumb(winnerMove);
                
                rules.setResult(result);
                rules.setWinnerMove(winnerMove);
                rules.setWinnersNumb(winnersNumb);

                System.out.println("\n==== " + result + " ====");
                System.out.println("Closer move: " + winnerMove);
                
                rules.removingPoints(round.playersList);
                diretory();
                removingPlayers();
                printPlayers();
            }
        for (Player player : round.playersList2){
            winner = player.getName(); }
        System.out.println("\n*  Winner: " + winner.toUpperCase() + "  *");
    }

    public void setMoves(){
        for(Player player : round.playersList){
            player.enterMove();
            moves.add(player.getMove());  
        }
    }

    public double calcTotal(){
        double total;
        total = moves.stream().mapToInt(Integer::intValue).sum();
        total = total / round.getRoundNum() * 0.8;
        return total;
    }

    private int winnerMove(double result){
        double difference, closer = 0;
        int playerMove, winnerMove = 0;

        for(Player player : round.playersList){
            playerMove = player.getMove();
            difference = Math.abs(result - playerMove);

            if (round.playersList.indexOf(player) == 0){
                closer = difference;
                winnerMove = playerMove;
            }
            else{
                if (difference <= closer){
                    closer = difference;
                    winnerMove = playerMove;
                }}}
        return winnerMove;
    }

    public int winnersNumb(int winnerMove){
        int winners = 0;
        for (Player player : round.playersList){
            if (player.getMove() == winnerMove){
                winners += 1; 
            }}
        return winners;
    }

    private void removingPlayers(){
        boolean losers = false;

        for(Player player : round.playersList){
            if (player.getScore() <= -10){
                round.playersList2.remove((Object) player);
                round.setRoundNum(round.getRoundNum() - 1);
                rules.setRound(rules.getRound() - 1);
                losers = true;
            }}
        if (losers && round.getRoundNum() > 1)
            rules.rules(); 
    }

    public void diretory(){
        
        switch (round.getRoundNum()) {
            case 5:
                rules.fivePlayers(round.playersList);
                break;
            case 4:
                rules.fourPlayers(round.playersList);
                break;
            case 3:
                rules.threePlayers(round.playersList);
                break;
            case 2:
                rules.twoPlayers(round.playersList);
                break;
            case 1:
                break;
            default:
                break;
        }
    }

    public void printPlayers(){
        System.out.println("");
        for(Player player : round.playersList){
            System.out.print("|| " + player.getName().toUpperCase() + ": " + player.getScore() + " ");
        }
        System.out.println(" ||");
    }
}

