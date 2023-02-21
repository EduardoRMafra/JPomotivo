/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Eduardo
 */
public class ButtonColumnCellRender extends DefaultTableCellRenderer{
    
    public ButtonColumnCellRender(String buttonType){
        setButtonType(buttonType);
    }
    //definir o botão que quer renderizar
    private String buttonType;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, column);
        
        //centralizando o prazo
        label.setHorizontalAlignment(CENTER);
        
        //pega o caminho da pasta resources e pega a imagem que tenha o nome
        label.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/" + buttonType + ".png")));
        
        return label;
    }
}