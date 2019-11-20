package rgui;

import com.edd.Main;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class History extends JPanel{
    public JLabel title;
    public RDisplayList content;
    public RButton back_button;
    public History(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //region Initialization of components to use
        title = new JLabel("Historial");
        content = RDisplayList.getInstance(Main.selectedClient.history,800,400,this,false);
        back_button = new RButton("Back",501);
        back_button.addActionListener(new RButton_Listener(this));
        //endregion

        //region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addComponent(content)
                        .addComponent(back_button)
                )
        );
        //endregion

        //region set Horizontal grouping:
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addComponent(content)
                .addComponent(back_button)
        );
        //endregion
    }
}
