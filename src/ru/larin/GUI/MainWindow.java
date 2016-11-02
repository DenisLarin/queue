package ru.larin.GUI;

import com.sun.org.apache.regexp.internal.RE;
import ru.larin.main.Main;
import ru.larin.main.People;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mrden on 30.10.2016.
 */
public class MainWindow extends JFrame {
    private JTable table;
    private TableModel tableModel;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JButton buttonShowFront;
    private JScrollPane scrollPane;
    public MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(640,480);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        /*scroll pane*/
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10,10,480,430);
        getContentPane().add(scrollPane);

        /*таблица*/
        tableModel = new TableModel();
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        /*кнопки*/
        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(500,10,130,20);
        getContentPane().add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                People people = new People();
                do{
                    people.setName(JOptionPane.showInputDialog("Enter name"));
                    if(people.getName().isEmpty()){
                        JOptionPane.showMessageDialog(null,"No name input");
                    }
                }while (people.getName().isEmpty());
                do{
                    String temp = JOptionPane.showInputDialog("Enter age");
                    int age;
                    try {
                        age = Integer.parseInt(temp);
                        people.setAge(age);
                    }catch (Exception err){
                        JOptionPane.showMessageDialog(null,"Enter number");
                    }
                    if(people.getAge() == 0){
                        JOptionPane.showMessageDialog(null,"No age input");
                    }
                }while (people.getAge() == 0);
                Main.queue.push(people);
                table.updateUI();
            }
        });

        buttonRemove = new JButton("Remove first");
        buttonRemove.setBounds(500,40,130,20);
        getContentPane().add(buttonRemove);
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() == -1 || Main.queue.size()==0){
                    return;
                }
                if(table.getSelectedRow() == 0){
                    Main.queue.pop();
                }
                else {
                    JOptionPane.showMessageDialog(null,"You can remove first element only");
                }
                table.updateUI();
            }
        });
        buttonShowFront = new JButton("Show front");
        buttonShowFront.setBounds(500,70,130,20);
        getContentPane().add(buttonShowFront);
        buttonShowFront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,Main.queue.front().toString());
            }
        });
        setVisible(true);
    }
}
