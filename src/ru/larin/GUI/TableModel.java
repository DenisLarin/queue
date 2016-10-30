package ru.larin.GUI;

import ru.larin.main.Main;

import javax.swing.event.TableModelListener;

/**
 * Created by mrden on 30.10.2016.
 */
public class TableModel implements javax.swing.table.TableModel {
    @Override
    public int getRowCount() {
        return Main.queue.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String returnSTR = null;
        switch (columnIndex){
            case 0:
                returnSTR = "Name";
                break;
            case 1:
                returnSTR = "Age";
                break;
        }
        return returnSTR;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class retClass = null;
        switch (columnIndex){
            case 0:
                retClass = String.class;
                break;
            case 1:
                retClass = Integer.class;
                break;
        }
        return retClass;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retObj = null;
        switch (columnIndex){
            case 0:
                retObj = Main.queue.get(rowIndex).getName();
                break;
            case 1:
                retObj = Main.queue.get(rowIndex).getAge();
                break;
        }
        return retObj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                Main.queue.get(rowIndex).setName((String) aValue);
                break;
            case 1:
                Main.queue.get(rowIndex).setAge((Integer) aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
