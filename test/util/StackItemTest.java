package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackItemTest {

    @Test
    public void StackItemsTest(){
        //Prepare
        Integer firstElement = 1;
        Integer secondElement = 2;
        Integer thirdElement = 3;
        StackItem<Integer> integerStackItem = new StackItem<>(firstElement);
        StackItem<Integer> integerStackItem2 = new StackItem<>(secondElement);
        //Act
        integerStackItem.setNext(integerStackItem2);
        integerStackItem2.setNext(integerStackItem2);
        integerStackItem2.setElement(thirdElement);
        //Assert
        Assertions.assertEquals(integerStackItem.getElement(), firstElement);
        Assertions.assertEquals(integerStackItem.getNext(), integerStackItem2);
        Assertions.assertEquals(integerStackItem2.getElement(), thirdElement);
        Assertions.assertNull(integerStackItem2.getNext());
    }

}
