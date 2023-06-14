package gui;

import game.Card;
import game.Player;
import util.ApplicationConstants;
import util.Colours;
import util.PrintCard;
import util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private static final String TOP = "┌────────────────────────────────────────────────────────────┐";
    private static final String SEPARATOR = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String BOTTOM = "└───────────────────────────────────────────────────────────┘";
    private static final String PADDING = "                           ";
    private static final String VERTICAL_ARROW = "\u2BAC";
    private static final String HORIZONTAL_ARROW = "\u2BA9";
    private static final String PLAYER_ICON = "\uD83D\uDC64";
    private static final List<String> interactionLetters = new ArrayList<>();
    static {
        interactionLetters.add("\uD83C\uDD30");
        interactionLetters.add("\uD83C\uDD31");
        interactionLetters.add("\uD83C\uDD32");
        interactionLetters.add("\uD83C\uDD33");
        interactionLetters.add("\uD83C\uDD34");
        interactionLetters.add("\uD83C\uDD35");
        interactionLetters.add("\uD83C\uDD36");
        interactionLetters.add("\uD83C\uDD37");
        interactionLetters.add("\uD83C\uDD38");
    }


    public static int mainMenu(){
        System.out.println("Welcome to the UNO game! \n Select number of players and press ENTER: ");
        int playerNum = Utils.getIntUserInput();

        System.out.println("Game Started");
        return playerNum;
    }

    public static void playerMenu(Player player, Card playCard){
        printCurrentPlayer(player);
        System.out.println(TOP);
        System.out.print(PADDING);
        System.out.println("Play Card:");
        PrintCard.printCard(playCard);
        System.out.println(SEPARATOR);
        System.out.print(PADDING);
        System.out.println("Your Deck:");
        PrintCard.printCards(player.getPlayerDeck());
        printInteractionMenu(player.getPlayerDeck().size());
        System.out.println(SEPARATOR);
        System.out.println(PADDING + "DRAW " + HORIZONTAL_ARROW + " " + interactionLetters.get(player.getPlayerDeck().size()));
        System.out.println(PADDING + "UNO " + HORIZONTAL_ARROW + " " + interactionLetters.get(player.getPlayerDeck().size() + 1));
        System.out.println(BOTTOM);
    }
    public static void victoryMenu(){

    }
    private static void printInteractionMenu(int deckSize){
        String initialPadding = "  ";
        System.out.print(initialPadding);
        for(int i = 0; i < deckSize; i++){
            System.out.print(VERTICAL_ARROW + "        ");
        }
        System.out.print("\n" + initialPadding);

        for (int i = 0; i < deckSize; i++){
            if(i == 3 || i == 5)
                System.out.print(" ");
            System.out.print(interactionLetters.get(i) + "       ");

        }
        System.out.print("\n");
    }
    private static void printCurrentPlayer(Player player){
        int playerId = player.getId();
        String currentPlayer = PADDING + PLAYER_ICON + "  ";
        if(playerId == 1){
            currentPlayer += ApplicationConstants.BLUE_BACKGROUND;
        }else {
            currentPlayer += ApplicationConstants.RED_BACKGROUND;
        }
        currentPlayer += "Player " + playerId + ApplicationConstants.RESET + "  " + PLAYER_ICON;
        System.out.println(currentPlayer);
    }

}
