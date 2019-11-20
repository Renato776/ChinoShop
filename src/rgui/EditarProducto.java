package rgui;

import com.edd.Main;
import com.edd.Product;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class EditarProducto extends JPanel {

    public JLabel title;
    public JLabel products_text;
    public JLabel detalles_text;
    public RDisplayList products;
    public JPanel aux;
    public REditableFields detalles;
    public RButton back_button;
    public RButton edit_button;
    public int selected_product;

    public EditarProducto(){
        selected_product = 0;
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Initialization of components to use
        title = new JLabel("Chino Shop");
        products_text = new JLabel("Productos:");
        detalles_text  = new JLabel("Detalles:");
        products = RDisplayList.getInstance(Main.products,130,500,this,false);
        if(Main.products.head!=null){
            detalles = new REditableFields(Main.products.head.data);
        }else{
            detalles = new REditableFields();
        }
        back_button = new RButton("Back",110);
        back_button.addActionListener(new RButton_Listener(this));
        edit_button = new RButton("Editar",302);
        edit_button.addActionListener(new RButton_Listener(this));
        //endregion

        //region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(products_text)
                                        .addComponent(products)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(detalles_text)
                                        .addComponent(detalles)
                                )
                        )
                        .addComponent(back_button)
                        .addComponent(edit_button)
                )
        );
        //endregion

        //region set Vertical grouping:
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(products_text)
                                .addComponent(products)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(detalles_text)
                                .addComponent(detalles)
                        )
                )
                .addComponent(back_button)
                .addComponent(edit_button)
        );
        //endregion
    }


    public void setSelected_product(int index){
        selected_product = index;
        detalles.replace_data(products.get_element_data(index));
        products.color_element(index);
    }
    public void edit(){
        var new_data = detalles.retrieve_data();
        Product old_data = (Product) products.get_element_data(selected_product);
        old_data.name = new_data[0];
        if(Main.categories.search(new_data[1])==null){
            Printing.alert("La categoria: "+new_data[1]+" No existe. Operacion cancelada.");
            return;
        }else{
            old_data.category = new_data[1];
        }
        try{
            old_data.price = Double.parseDouble(new_data[2]);
        }catch (Exception ex){
            Printing.alert("Porfavor, ingresa un precio valido.");
            Printing.alert("No utilice simbolos monetarios.");
            return;
        }
        Printing.alert("Producto editado con exito!");
    }
}
