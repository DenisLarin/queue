package ru.larin.main;

import ru.larin.GUI.MainWindow;
import ru.larin.queue.Queue;

/**
 * Created by mrden on 30.10.2016.
 */
public class Main {
    public static Queue<People> queue;
    private static MainWindow mainWindow;
    public static void main(String[] args) {
        queue = new Queue<People>();
        mainWindow = new MainWindow();

    }
}
