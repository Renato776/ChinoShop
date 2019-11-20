package rgui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Home extends JPanel {
    JLabel title ;
    JButton cargar_product;
    JButton cargar_client;
    JButton edit_client;
    JButton edit_product;
    JButton back_button;
    JButton shop_button;

    public Home(){
        setBackground(Color.cyan);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("Chino Shop");
        cargar_client = new RButton("Cargar Cliente",101);
        cargar_product = new RButton("Cargar Producto",100);
        edit_client = new RButton("Editar Cliente",102);
        edit_product = new RButton("Editar Producto",103);
        shop_button = new RButton("Shop",400);
        back_button = new RButton("Back",104);
        cargar_client.addActionListener(new RButton_Listener(this));
        cargar_product.addActionListener(new RButton_Listener(this));
        edit_product.addActionListener(new RButton_Listener(this));
        edit_client.addActionListener(new RButton_Listener(this));
        back_button.addActionListener(new RButton_Listener(this));
        shop_button.addActionListener(new RButton_Listener(this));
        layout.linkSize(SwingConstants.HORIZONTAL, cargar_client, cargar_product,edit_client,edit_product,shop_button);
        //endregion

//region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addComponent(cargar_client)
                        .addComponent(edit_client)
                        .addComponent(cargar_product)
                        .addComponent(edit_product)
                        .addComponent(shop_button)
                        .addComponent(back_button)
                )
        );
//endregion

//region set Vertical Grouping
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addComponent(cargar_client)
                .addComponent(edit_client)
                .addComponent(cargar_product)
                .addComponent(edit_product)
                .addComponent(shop_button)
                .addComponent(back_button)
        );
//endregion

    }

}
