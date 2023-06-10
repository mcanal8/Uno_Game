package util;

import game.Card;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static ArrayList<Card> createCards(){
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

    public static Stack<Card> shuffleCards(){
        ArrayList<Card> cards = createCards();
        Stack<Card> cardStack = new Stack<>();
        Random rand = new Random();
        do {
            int randomNum = rand.nextInt(cards.size());
            cardStack.push(cards.remove(randomNum));
        }while (!cards.isEmpty());
        return cardStack;
    }

    public static int getIntUserInput(){
        Scanner input = new Scanner(System.in);
        int inputNumber = 0;
        try{
            inputNumber = input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input, please enter a valid integer");
            getIntUserInput();
        }
        return inputNumber;
    }

    public static String getColourCodes(Colours colour){
        switch (colour){
            case BLACK: return "\u001B[30m";
            case YELLOW: return "\u001B[33m";
            case BLUE: return "\u001B[34m";
            case RED: return "\u001B[31m";
            case GREEN: return "\u001B[32m";
            default: return "";
        }
    }
}
