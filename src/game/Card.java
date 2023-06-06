package game;

import util.Colours;

public class Card {


    private final int value;
    private final Colours colour;

    public Card(int value, String colour) {
        if(value > 12 && (!colour.equals(Colours.BLACK.name())))
            throw new IndexOutOfBoundsException("Colour Card value cannot be higher than 12");
        this.value = value;
        this.colour = Colours.valueOf(colour);
    }

    public Card(int value, Colours colour) {
        if(value > 12 && colour != Colours.BLACK)
            throw new IndexOutOfBoundsException("Colour Card value cannot be higher than 12");
        this.value = value;
        this.colour = colour;
    }

    public int getValue() {
        return value;
    }

    public Colours getColour() {
        return colour;
    }
}
