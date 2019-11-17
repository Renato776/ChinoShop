package rgui;

import com.edd.Main;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class EditarCliente extends JPanel {
    public JLabel title;
    public JLabel clients_text;
    public JLabel detalles_text;
    public JScrollPane scrollPane;
    public JPanel aux;
    public JPanel detalles;
    public RButton back_button;
    public EditarCliente(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Initialization of components to use
        title = new JLabel("Chino Shop");
        clients_text = new JLabel("Clients:");
        detalles_text  = new JLabel("Detalles:");
        aux = new JPanel();
        var head = Main.clients.head;
        while(head!=null){
            aux.add(new JLabel(head.data.get_key()));
            head = head.next;
        }
        detalles = new JPanel();
        scrollPane = new JScrollPane(aux);
        scrollPane.setPreferredSize(new Dimension(600,400));
        back_button = new RButton("Back",110);
        back_button.addActionListener(new RButton_Listener(this));
        //endregion

        //region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(clients_text)
                                        .addComponent(scrollPane)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(detalles_text)
                                        .addComponent(detalles)
                                )
                        )
                )
        );
        //endregion

        //region set Horizontal grouping:
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(clients_text)
                                .addComponent(scrollPane)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(detalles_text)
                                .addComponent(detalles)
                        )
                )
        );
        //endregion
    }

}
