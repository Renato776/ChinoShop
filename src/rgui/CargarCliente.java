package rgui;

import com.edd.Category;
import com.edd.Client;
import com.edd.Main;
import com.edd.RList;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;
/*
*
    public RList likes;
    public String name;
    public String last_name;
    public String address;
    public String NIT;
* */
public class CargarCliente extends JPanel {
    JLabel title ;
    JLabel name_text;
    JLabel last_name_text;
    JLabel address_text;
    JLabel NIT_text;
    JLabel Likes_text;
    JTextField name;
    JTextField last_name;
    JTextField address;
    JTextField NIT;
    JPanel Likes;
    JButton cargar_button;
    JButton add_category_button;
    JButton back_button;

    public CargarCliente(){

        setBackground(Color.yellow);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("Chino Shop");
        name_text = new JLabel("Nombre: ");
        last_name_text = new JLabel("Apellido: ");
        address_text = new JLabel("Direccion: ");
        NIT_text = new JLabel("NIT: ");
        Likes_text = new JLabel("Gustos: ");
        name = new JTextField();
        name.setColumns(20);
        last_name = new JTextField();
        last_name.setColumns(20);
        address = new JTextField();
        address.setColumns(20);
        NIT = new JTextField();
        NIT.setColumns(20);
        Likes = getAvailableCategories();
        back_button = new RButton("Back",107);
        cargar_button = new RButton("Cargar",106);
        add_category_button = new RButton("Agregar Categoria",105);
        back_button.addActionListener(new RButton_Listener(this));
        cargar_button.addActionListener(new RButton_Listener(this));
        add_category_button.addActionListener(new RButton_Listener(this));
        layout.linkSize(SwingConstants.HORIZONTAL, back_button, add_category_button,cargar_button);
        layout.linkSize(SwingConstants.HORIZONTAL, address_text, last_name_text,name_text, NIT_text);
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
                                .addComponent(last_name_text)
                                .addComponent(last_name)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(address_text)
                                .addComponent(address)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(NIT_text)
                                .addComponent(NIT)
                        )
                        .addComponent(Likes_text)
                        .addComponent(Likes)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(add_category_button)
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
                        .addComponent(last_name_text)
                        .addComponent(last_name)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(address_text)
                        .addComponent(address)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(NIT_text)
                        .addComponent(NIT)
                )
                .addComponent(Likes_text)
                .addComponent(Likes)
                .addGroup(layout.createParallelGroup()
                        .addComponent(add_category_button)
                        .addComponent(cargar_button)
                        .addComponent(back_button)
                )
        );
//endregion
    }
    public JPanel getAvailableCategories(){
        JPanel res =  new JPanel();
        var aux = Main.categories.head;
        while(aux != null){
            JCheckBox checkBox = new JCheckBox(aux.data.get_key(),false);
            res.add(checkBox);
            aux = aux.next;
        }
        return res;
    }

    public void add_category() {
        String[] data = Printing.request_data(new String[][]{{"Categoria:","otros"}});
        if(data==null)return;
        String category_name = data[0];
        if(Category.register(category_name)!=null){
            Printing.alert("Nueva Categoria Ingresada con exito!");
            Main.frame.getContentPane().remove(0);
            Main.frame.getContentPane().add(new CargarCliente());
            Main.frame.pack();
        }else{
            Printing.alert("Ya existe una Categoria con este nombre.");
        }
    }

    public void cargar() {
        var options = Likes.getComponents();
        RList true_likes = new RList();
        for ( var c:options) {
            if(((JCheckBox)c).isSelected()){
                true_likes.sorted_insert(Main.categories.search(((JCheckBox) c).getText()));
            }
        }
        Client client = Client.register(name.getText());
        if(client == null){Printing.alert("Ya existe un cliente con este nombre");return;}
        client.NIT = NIT.getText();
        client.address = address.getText();
        client.last_name = last_name.getText();
        client.likes = true_likes;
        Main.clients.sorted_insert(client);
        Printing.alert("Cliente registrado con exito!");
    }
}
