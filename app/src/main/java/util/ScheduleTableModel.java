/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Schedule;

/**
 *
 * @author Eduardo
 */
public class ScheduleTableModel extends AbstractTableModel{

    //Nome de todas as colunas que a tabela terá
    String[] columns = {"Nome", "Descrição", "Editar", "Excluir"};
    List<Schedule> schedules = new ArrayList();//quais dados terá

    @Override
    public int getRowCount() {
        return schedules.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if(schedules.isEmpty()){
            return Object.class;
        }
        
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return schedules.get(rowIndex).getName();
            case 1:
                return schedules.get(rowIndex).getDescription();
            case 2:
                return "";
            case 3:
                return "";
            default:
                return "Dados não encontrados";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    
}
