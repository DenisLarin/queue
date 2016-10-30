package ru.larin.queue;

/**
 * Created by mrden on 30.10.2016.
 */
public class Queue<E> implements Iqueue<E> {
    private Node<E> tail;
    private Node<E> head;
    private int size = 0;
    @Override
    public void push(E data) {
        Node<E> node = new Node<E>(data);
        node.setNextElementLink(tail);
        if(isEmpty())
            head = node;
        else
            tail.setNextElementLink(node);
        tail = node;
        size++;
    }

    @Override
    public E pop() {
        E removeObject = null;
        if(!isEmpty()){
            removeObject = head.getData();
            head = head.getNextElementLink();
            size--;
        }
        return removeObject;
    }

    @Override
    public E front() {
        return head.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
