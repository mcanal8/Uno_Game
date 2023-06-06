package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Colours;

public class CardTest {

    @Test
    public void cardTest(){
        Card card1 = new Card(0, "YELLOW");
        Assertions.assertEquals(card1.getValue(), 0);
        Assertions.assertEquals(card1.getColour(), Colours.YELLOW);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Card(20, Colours.BLUE));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Card(1, "PURPLE"));

    }
}
