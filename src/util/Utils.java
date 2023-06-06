package util;

import game.Card;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Card> createCards(){
        ArrayList<Card> cards = new ArrayList<>();

        for(Colours color : Colours.values()){
            if(color.equals(Colours.BLACK)){
                for(int i = 0; i < ApplicationConstants.NUM_BLACK_CARDS; i++){
                    cards.add(new Card(ApplicationConstants.COLOUR_CHANGE, color));
                    cards.add(new Card(ApplicationConstants.DRAW_4, color));
                }
                continue;
            }
            for(int i = 0; i <= ApplicationConstants.NUM_COLOUR_CARDS; i++){
                cards.add(new Card(i, color));
                if(i != 0)
                    cards.add(new Card(i, color));
            }
        }
        return cards;
    }
}
