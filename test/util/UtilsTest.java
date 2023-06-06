package util;

import game.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UtilsTest {

    @Test
    public void createCardsTest(){

        ArrayList<Card> cards = Utils.createCards();

        Assertions.assertEquals(cards.size(), 108);

        //Sort Cards
        ArrayList<Card> yellowCards = new ArrayList<>();
        ArrayList<Card> blueCards = new ArrayList<>();
        ArrayList<Card> greenCards = new ArrayList<>();
        ArrayList<Card> redCards = new ArrayList<>();
        ArrayList<Card> blackCards = new ArrayList<>();

        for(Card card : cards){
            switch (card.getColour()){
                case YELLOW:
                    yellowCards.add(card);
                    break;
                case BLUE:
                    blueCards.add(card);
                    break;
                case GREEN:
                    greenCards.add(card);
                    break;
                case RED:
                    redCards.add(card);
                    break;
                case BLACK:
                    blackCards.add(card);
            }
        }
        Assertions.assertTrue(checkColourCards(yellowCards));
        Assertions.assertTrue(checkColourCards(blueCards));
        Assertions.assertTrue(checkColourCards(greenCards));
        Assertions.assertTrue(checkColourCards(redCards));
        Assertions.assertTrue(checkSpecialCards(blackCards));
      }
      private boolean checkColourCards(ArrayList<Card> cards) {
          int[] cardCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
          for (Card card : cards) {
              cardCounter[card.getValue()]++;
          }
          for (int i = 0; i < cardCounter.length; i++) {
              if(i == 0){
                  if(cardCounter[i] != 1)
                      return false;
              }else {
                  if (cardCounter[i] != 2)
                      return false;
              }
          }
          return true;
      }
    private boolean checkSpecialCards(ArrayList<Card> cards){
        int numColourChange = 0;
        int numDraw4 = 0;
        for(Card card : cards){
            if(card.getValue() == ApplicationConstants.COLOUR_CHANGE)
                ++numColourChange;
            if(card.getValue() == ApplicationConstants.DRAW_4)
                ++numDraw4;
        }
        return numColourChange == ApplicationConstants.NUM_BLACK_CARDS && numDraw4 == ApplicationConstants.NUM_BLACK_CARDS;
    }
}
