package util;

import game.Card;

import java.util.ArrayList;
import java.util.List;

public class PrintCard {

    private static final String TOP = "╔═══╗";
    private static final String BOTTOM = "╚═══╝";
    private static final String LEFT_SIDE = "║ ";
    private static final String RIGHT_SIDE = "║";
    private static final String PADDING = "    ";

    public static void printCard(Card card){
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        printCards(cards);
    }

    public static void printCards(List<Card> cards){
        for (Card ignored : cards) {
            System.out.print(TOP + PADDING);
        }
        System.out.print("\n");
        for (Card card : cards) {

            String cardValue = getCardValue(card.getValue());
            String printedCard = LEFT_SIDE +
                    Utils.getColourCodes(card.getColour()) +
                    cardValue +
                    ApplicationConstants.RESET;
            if (cardValue.length() > 1) {
                printedCard += RIGHT_SIDE;
            } else {
                printedCard += " " + RIGHT_SIDE;
            }
            System.out.print(printedCard + PADDING);
        }
        System.out.print("\n");
        for(Card ignored : cards){
            System.out.print(BOTTOM + PADDING);
        }
        System.out.print("\n");
    }

    private static String getCardValue(int value) {
        if (value == ApplicationConstants.DRAW_2)
            return "+2";
        if(value == ApplicationConstants.CHANGE_WAY)
            return "\u21C6";
        if(value == ApplicationConstants.PASS_TURN)
            return "\u2349";
        if(value == ApplicationConstants.COLOUR_CHANGE)
            return "\u232C";
        if(value == ApplicationConstants.DRAW_4)
            return "+4";
        return String.valueOf(value);
    }
}
