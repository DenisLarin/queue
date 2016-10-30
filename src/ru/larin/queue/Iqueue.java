package ru.larin.queue;

/**
 * Created by mrden on 30.10.2016.
 */
public interface Iqueue<E> {
    public void push(E data);
    public E pop();
    public E front();
    public int size();
    public boolean isEmpty();
    public E get(int rowIndex);
}
