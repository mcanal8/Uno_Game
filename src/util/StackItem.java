package util;

public class StackItem<T> {

    private T element;
    private StackItem<T> next;

    public StackItem(T element) {
        this.element = element;
    }

    public T getElement() { return element; }

    public void setElement(T element) { this.element = element; }

    public StackItem<T> getNext() { return next; }

    public void setNext(StackItem<T> next) {
        if(next != null && !next.equals(this))
            this.next = next;
    }
}
