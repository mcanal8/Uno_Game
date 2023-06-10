package game;

import gui.Menu;
import util.ApplicationConstants;
import util.Stack;
import util.Utils;

import java.util.*;

public class Game {

    private int turn;
    private Stack<Card> drawDeck;
    private List<Player> players;
    private Card playCard;

    public Game(){
        this.turn = 0;
        playCard = null;
        players = new LinkedList<>();
        drawDeck = Utils.shuffleCards();
    }

    public void startGame(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            Player player = new Player();
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
    }
}
