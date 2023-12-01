public class Main {
    public static void main(String[] args){
        Game game = Game.openGame();
        game.login();
        game.start();
    }
}
