package rgui;

import javax.swing.*;

public class EditarProducto extends JPanel {
    public int selected_product;
    public EditarProducto(){
        selected_product = 0;
    }
    public void setSelected_product(int index){
        this.selected_product= index;
    }
}
