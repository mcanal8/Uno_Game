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
        setPlayCard();
        turn(players.iterator());
    }

    public void turn(Iterator<Player> playerId){
        turn++;
        if(!playerId.hasNext())
            playerId = players.iterator();
        Player player = playerId.next();
        Menu.playerMenu(player, playCard);
        gameLogic(player);
       if (Rules.checkVictory(player))
           Menu.victoryMenu();
       turn(playerId);
    }

    private void cardAction(Player player, Iterator<Player> nextPlayer){
        switch (this.playCard.getValue()){
            case ApplicationConstants.DRAW_2:
                draw(2, player);
                break;
            case ApplicationConstants.PASS_TURN:
                System.out.println("Turn for Player " + player.getId() + " skipped!");
                turn(nextPlayer);
                break;
        }
    }

    private void gameLogic(Player player){
        Card playerAction = playerAction(player.getPlayerDeck());
        switch (playerAction.getValue()){
            case ApplicationConstants.UNO:
                if(player.getPlayerDeck().isEmpty()) {
                    player.setUno(true);
                }else{
                    System.out.println("Action not permitted, you have more than one card!");
                    gameLogic(player);
                }
                break;
            case ApplicationConstants.COLOUR_CHANGE:
                Menu.colourChangeMenu();
                break;
            case ApplicationConstants.DRAW_1:
                draw(1, player);
                Menu.playerMenu(player, playCard);
                gameLogic(player);
            default:
                if(!Rules.checkPlayerAction(playerAction, playCard)){
                    System.out.println("Action not permitted");
                    gameLogic(player);
                }
                playCard = playerAction;
                break;
        }
    }
    private void draw(int numCards, Player player){
        List<Card> playerDeck = player.getPlayerDeck();
        for(int i = 0; i < numCards; i++){
            playerDeck.add(drawDeck.pop().getElement());
        }
        player.setPlayerDeck(playerDeck);
    }
    private void setPlayCard(){
        Card playCard;
        List<Card> discardedCards = new ArrayList<>();
        do{
            playCard = drawDeck.pop().getElement();
            discardedCards.add(playCard);
        }while (playCard.getValue() > 9);
        for(Card card : discardedCards){
            if(!card.equals(playCard))
                drawDeck.push(card);
        }
        this.playCard = playCard;
    }

    private static Card playerAction(List<Card> playerDeck){
        int playerChoice = Utils.getPositionOfLetter(Utils.getCharUserInput());

        int deckSize = playerDeck.size();
        if(playerChoice < deckSize)
            return playerDeck.remove(playerChoice);
        if(playerChoice == deckSize)
            return new Card(ApplicationConstants.DRAW_1, Colours.BLACK);
        if(playerChoice == deckSize + 1)
            return new Card(ApplicationConstants.UNO, Colours.BLACK);
        return null;
    }
}
