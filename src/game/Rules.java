package game;

import util.Colours;

public class Rules {

    public static boolean checkPlayerAction(Card card, Card playCard){
        return card.getColour().equals(playCard.getColour()) ||
                card.getValue() == playCard.getValue() ||
                card.getColour().equals(Colours.BLACK);
    }

    public static boolean checkVictory(Player player){
        return player.getPlayerDeck().isEmpty();
    }
}
