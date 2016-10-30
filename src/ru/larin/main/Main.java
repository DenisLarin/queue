package ru.larin.main;

import ru.larin.queue.Queue;

/**
 * Created by mrden on 30.10.2016.
 */
public class Main {
    private static Queue<People> queue;
    public static void main(String[] args) {
        queue = new Queue<People>();
        queue.push(new People("Денис",20));
        queue.push(new People("Антон",17));
        queue.push(new People("Александр",45));
        System.out.println(queue.front().toString());
        System.out.println(queue.pop().toString());
        System.out.println(queue.pop().toString());
        System.out.println(queue.pop().toString());
    }
}
