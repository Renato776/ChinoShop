package rgui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RIcon_Handler  extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        RLabel label = (RLabel)e.getSource();
        int index = label.index;
        if(label.context.getClass().equals(EditarCliente.class)){
            EditarCliente context = (EditarCliente)label.context;
            context.setSelectedClient(index);
        }else if(label.context.getClass().equals(EditarProducto.class)){
            ((EditarProducto)label.context).setSelected_product(index);
        }
    }
}
