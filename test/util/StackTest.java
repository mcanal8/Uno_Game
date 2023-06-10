package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {
    
    @Test
    public void stackTest(){
        //Prepare
        Stack<String> stack = new Stack<>();
        StackItem<String> stackItem = new StackItem<>("test");
        
        //Act
        stack.push("firstElement");
        stack.push("secondElement");
        stack.push("thirdElement");
        stack.push("forthElement");

        //Assert
        Assertions.assertTrue(stack.pop().getClass().isInstance(stackItem));
        Assertions.assertEquals(stack.peek(), "thirdElement");
        stack.pop();
        stack.pop();
        stack.pop();
        Assertions.assertThrows(AssertionError.class, stack::pop);
        Assertions.assertTrue(stack.isEmpty());

    }
}
