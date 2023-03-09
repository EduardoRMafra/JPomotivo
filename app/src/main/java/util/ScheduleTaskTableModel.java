/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ScheduleTask;

/**
 *
 * @author Eduardo
 */
public class ScheduleTaskTableModel extends AbstractTableModel {

    //Nome de todas as colunas que a tabela terá
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<ScheduleTask> scheduleTasks = new ArrayList();//quais dados terá

    @Override
    public int getRowCount() {
        return scheduleTasks.size();
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
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if(scheduleTasks.isEmpty()){
            return Object.class;
        }
        
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return scheduleTasks.get(rowIndex).getSchTask().getName();
            case 1:
                return scheduleTasks.get(rowIndex).getSchTask().getDescription();
            case 2:
                if(scheduleTasks.get(rowIndex).getSchTask().getDeadline() != null){
                    //alterar o formato para dd//MM/yyyy
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    return dateFormat.format(scheduleTasks.get(rowIndex).getSchTask().getDeadline());
                }
                return null;
            case 3:
                return scheduleTasks.get(rowIndex).getSchTask().isCompleted();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        scheduleTasks.get(rowIndex).getSchTask().setCompleted((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<ScheduleTask> getScheduleTasks() {
        return scheduleTasks;
    }

    public void setScheduleTasks(List<ScheduleTask> scheduleTasks) {
        this.scheduleTasks = scheduleTasks;
    }
}
