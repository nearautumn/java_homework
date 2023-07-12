package by.aleksandrov.api.homework4;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedQueue {

    private LinkedList elements;
    private int startIndex = 0;

    public LinkedQueue(LinkedList<Integer> linkedList) {
        this.elements = linkedList;
    }

    public void enqueue(Object a) {
        elements.addLast(a);
    }

    public Object dequeue() {
        if (elements.isEmpty()) throw new EmptyStackException();
        return elements.get(startIndex++);
    }

    public Object first() {
        if (elements.isEmpty()) throw new EmptyStackException();
        return elements.get(startIndex);
    }
}

