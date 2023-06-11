package gui;

import game.Card;
import game.Player;
import util.PrintCard;
import util.Utils;

public class Menu {

    public static int mainMenu(){
        System.out.println("Welcome to the UNO game! \n Select number of players and press ENTER: ");
        int playerNum = Utils.getIntUserInput();

        System.out.println("Game Started");
        return playerNum;
    }

    public static void playerMenu(Player player, Card playCard){
        System.out.println("*************************");
        System.out.println("    Play Card:          ");
        PrintCard.printCard(playCard);
        System.out.println("*************************");
        System.out.println("    Your Deck:          ");
        PrintCard.printCards(player.playerDeck);
    }


}
