package util;

public class Stack<T> {

    private StackItem<T> stackItem;

    public StackItem<T> pop(){
        assert stackItem != null;

        StackItem<T> poppedItem = stackItem;
        stackItem = stackItem.getNext();
        return poppedItem;
    }

    public void push(T pushedItem){
        StackItem<T> newStackItem = new StackItem<>(pushedItem);
        newStackItem.setNext(stackItem);
        stackItem = newStackItem;
    }

    public T peek(){
        assert stackItem != null;
        return stackItem.getElement();
    }

    public boolean isEmpty(){
        return stackItem == null;
    }
}
