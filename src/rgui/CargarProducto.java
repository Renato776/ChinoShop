package rgui;

import com.edd.Category;
import com.edd.Code;
import com.edd.Main;
import com.edd.Product;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class CargarProducto extends JPanel {
    JLabel title ;
    JLabel name_text;
    JLabel price_text;
    JLabel code_text;
    JLabel category_text;
    JTextField name;
    JTextField price;
    JTextField code;
    JPanel category;
    JButton cargar_button;
    JButton back_button;
    String selected_category;

    public CargarProducto (){
        selected_category = "";
        setBackground(Color.yellow);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("Chino Shop");
        name_text = new JLabel("Nombre: ");
        price_text = new JLabel("Precio: ");
        code_text = new JLabel("Codigo: ");
        category_text = new JLabel("Categoria: ");
        name = new JTextField();
        name.setColumns(20);
        price = new JTextField();
        price.setColumns(20);
        code = new JTextField();
        code.setColumns(20);
        category = getAvailableCategories();
        back_button = new RButton("Cancelar",110);
        cargar_button = new RButton("Cargar",109);
        back_button.addActionListener(new RButton_Listener(this));
        cargar_button.addActionListener(new RButton_Listener(this));
        layout.linkSize(SwingConstants.HORIZONTAL, back_button,cargar_button);
        layout.linkSize(SwingConstants.HORIZONTAL, price_text, category_text, name_text, code_text);
        //endregion

//region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(name_text)
                                .addComponent(name)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(price_text)
                                .addComponent(price)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(code_text)
                                .addComponent(code)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(category_text)
                                .addComponent(category)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(cargar_button)
                                .addComponent(back_button)
                        )
                )
        );
//endregion

//region set Vertical Grouping
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addComponent(name_text)
                        .addComponent(name)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(price_text)
                        .addComponent(price)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(code_text)
                        .addComponent(code)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(category_text)
                        .addComponent(category)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(cargar_button)
                        .addComponent(back_button)
                )
        );
//endregion
    }
    public JPanel getAvailableCategories(){
        JPanel res = new JPanel();
        ButtonGroup group = new ButtonGroup();
        var aux = Main.categories.head;
        while(aux!=null){
            JRadioButton jRadioButton = new JRadioButton(aux.data.get_key());
            jRadioButton.addActionListener(new RButton_Listener(this));
            group.add(jRadioButton);
            res.add(jRadioButton);
            aux = aux.next;
        }
        return res;
    }
    public void cargar(){
        if(selected_category == ""){
            Printing.alert("Debes seleccionar alguna categoria. Si no te gusta ninguna, puedes seleccionar \"otros\".");
            return;
        }
        String n = name.getText();
        double p = 0;
        try{
            p = Double.parseDouble(price.getText());
        }catch (Exception ex){
            Printing.alert("Debes ingresar un precio numerico valido. No debes utilizar simbolos monetarios.");
            return;
        }
        Code c = null;
        if(code.getText().equals("")){
            c = new Code();
        }else{
            c = new Code(code.getText());
        }
        //Alright build the new Product!
        Product product = new Product(c,n,p,selected_category);
        Main.products.sorted_insert(product);
        var cat = Main.categories.search(selected_category);
        Category category1 = (Category)cat;
        category1.products.sorted_insert(product);
        Printing.alert("Producto ingresado con exito!");
    }
    public void select_category(String category){
        selected_category = category;
    }
}
