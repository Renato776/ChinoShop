package rgui;

import com.edd.Client;
import com.edd.Main;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class EditarCliente extends JPanel {
    public JLabel title;
    public JLabel clients_text;
    public JLabel detalles_text;
    public RDisplayList clients;
    public JPanel aux;
    public REditableFields detalles;
    public RButton back_button;
    public RButton edit_button;
    public RButton history_button;
    public int selected_client;
    public EditarCliente(){
        selected_client = 0;
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        Main.selectedClient = null;
        //region Initialization of components to use
        title = new JLabel("Chino Shop");
        clients_text = new JLabel("Clients:");
        detalles_text  = new JLabel("Detalles:");
        clients = RDisplayList.getInstance(Main.clients,180,500,this,true);
        if(Main.clients.head!=null){
            detalles = new REditableFields(Main.clients.head.data);
        }else{
            detalles = new REditableFields();
        }
        back_button = new RButton("Back",110);
        back_button.addActionListener(new RButton_Listener(this));
        edit_button = new RButton("Editar",301);
        edit_button.addActionListener(new RButton_Listener(this));
        history_button = new RButton("Historial",500);
        history_button.addActionListener(new RButton_Listener(this));
        layout.linkSize(back_button,edit_button,history_button);
        //endregion

        //region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(clients_text)
                                        .addComponent(clients)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(detalles_text)
                                        .addComponent(detalles)
                                )
                        )
                        .addComponent(edit_button)
                        .addComponent(history_button)
                        .addComponent(back_button)
                )
        );
        //endregion

        //region set Vertical grouping:
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(clients_text)
                                .addComponent(clients)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(detalles_text)
                                .addComponent(detalles)
                        )
                )
                .addComponent(edit_button)
                .addComponent(history_button)
                .addComponent(back_button)
        );
        //endregion
    }
    public void setSelectedClient(int index){
        selected_client = index;
        detalles.replace_data(clients.get_element_data(index));
        Main.selectedClient = (Client)clients.get_element_data(index);
        clients.color_element(index);
    }
    public void edit(){
        var new_data = detalles.retrieve_data();
        Client old_data = (Client) clients.get_element_data(selected_client);
        if(Main.clients.search(new_data[0])==null){
            old_data.name = new_data[0];
        }else{
            if(!old_data.name.equals(new_data[0])){
                Printing.alert("Ya existe un cliente con este nombre.");
                Printing.alert("Operacion cancelada");
                return;
            }
        }
        old_data.last_name = new_data[1];
        old_data.address = new_data[2];
        old_data.NIT = new_data[3];
        Printing.alert("Cliente editado con exito!");
    }
}
