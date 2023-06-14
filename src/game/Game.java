package game;

import gui.Menu;
import util.ApplicationConstants;
import util.Colours;
import util.Stack;
import util.Utils;

import java.util.*;

public class Game {

    private int turn;
    private final Stack<Card> drawDeck;
    private final List<Player> players;
    private Card playCard;

    public Game(){
        this.turn = 0;
        playCard = null;
        players = new LinkedList<>();
        drawDeck = Utils.shuffleCards();
    }

    public void startGame(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            Player player = new Player(i +1);
            List<Card> playerDeck = new ArrayList<>();
            for(int j = 0; j < ApplicationConstants.NUM_INITIAL_CARDS; j++){
                playerDeck.add(drawDeck.pop().getElement());
            }
            player.setPlayerDeck(playerDeck);
            players.add(player);
        }
        playCard = drawDeck.pop().getElement();
        turn(players.iterator());
    }

    public void turn(Iterator<Player> playerId){
        turn++;
        Player player = playerId.next();
        Menu.playerMenu(player, playCard);
        Card playerAction = playerAction(player.getPlayerDeck());
       while (!Rules.checkPlayerAction(playerAction)){
           System.out.println("Action not permitted");
       }
       playCard = playerAction;
       if (Rules.checkVictory(player))
           Menu.victoryMenu();
       turn(playerId);
    }

    private static Card playerAction(List<Card> playerDeck){
        int playerChoice = Utils.getPositionOfLetter(Utils.getCharUserInput());
        int deckSize = playerDeck.size();
        if(playerChoice <= deckSize)
            return playerDeck.get(playerChoice);
        if(playerChoice == deckSize + 1)
            return new Card(ApplicationConstants.DRAW_1, Colours.BLACK);
        if(playerChoice == deckSize + 2)
            return new Card(ApplicationConstants.UNO, Colours.BLACK);
        return null;
    }
}
