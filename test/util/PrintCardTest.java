package util;

import game.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintCardTest {

    @Test
    public void printCardTest(){
        Card card = new Card(0, Colours.YELLOW);
        Card card2 = new Card(1, Colours.RED);
        Card card3 = new Card(2, Colours.BLUE);
        Card card4 = new Card(3, Colours.GREEN);
        PrintCard.printCard(card);
        PrintCard.printCard(card2);
        PrintCard.printCard(card3);
        PrintCard.printCard(card4);

        Card card5 = new Card(10, Colours.YELLOW);
        Card card6 = new Card(11, Colours.RED);
        Card card7 = new Card(12, Colours.BLUE);
        Card card8 = new Card(13, Colours.BLACK);
        Card card9 = new Card(14, Colours.BLACK);
        PrintCard.printCard(card5);
        PrintCard.printCard(card6);
        PrintCard.printCard(card7);
        PrintCard.printCard(card8);
        PrintCard.printCard(card9);
    }

    @Test
    public void printCardsTest(){
        Stack<Card> cardStack = Utils.shuffleCards();
        List<Card> cardList = new ArrayList<>();
        do{
            cardList.add(cardStack.pop().getElement());
        }while (!cardStack.isEmpty());

        PrintCard.printCards(cardList);
    }
}
