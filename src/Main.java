import game.Game;
import gui.Menu;

public class Main {
    public static void main(String[] args) {
        int playerNum = Menu.mainMenu();
        Game game = new Game();
        game.startGame(playerNum);
    }
}