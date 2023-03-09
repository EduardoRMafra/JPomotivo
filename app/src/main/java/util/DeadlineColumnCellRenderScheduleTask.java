/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.ScheduleTask;
import model.Task;

/**
 *
 * @author Eduardo
 */
public class DeadlineColumnCellRenderScheduleTask extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, column);
        
        //centralizando o prazo
        label.setHorizontalAlignment(CENTER);
        
        ScheduleTaskTableModel scheduleTaskModel = (ScheduleTaskTableModel)table.getModel();
        ScheduleTask scheduleTask = scheduleTaskModel.getScheduleTasks().get(row);
        
        //verifica se possui deadline e se ele está depois da data atual
        if(scheduleTask.getSchTask().getDeadline() != null){
            if(scheduleTask.getSchTask().getDeadline().after(new Date())){
                label.setBackground(Color.GREEN);
            }else{
                label.setBackground(Color.RED);
            } 
        }else{
            //sem cor de fundo caso não possua prazo
            label.setBackground(null);
        }
        return label;
    }
}
