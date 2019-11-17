package rgui;

import com.edd.Main;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class History extends JPanel{
    public JLabel title;
    public JLabel content;
    public JScrollPane scrollPane;
    public JPanel aux;
    public RButton back_button;
    public History(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Initialization of components to use
        title = new JLabel("Historial");
        content = new JLabel(get_formatted_history());
        aux = new JPanel();
        aux.add(content);
        scrollPane = new JScrollPane(aux);
        scrollPane.setPreferredSize(new Dimension(600,400));
        back_button = new RButton("Back",6);
        back_button.addActionListener(new RButton_Listener(this));
        //endregion

        //region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addComponent(scrollPane)
                        .addComponent(back_button)
                )
        );
        //endregion

        //region set Horizontal grouping:
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addComponent(scrollPane)
                .addComponent(back_button)
        );
        //endregion
    }
    public String get_formatted_history(){
        String res = "<html>";
        var aux = Main.usuario.history.head;
        while (aux != null){
            var true_aux = aux.data;
            res+=true_aux.get_visualization()+"<br>";
            aux = aux.next;
        }
        res+="</html>";
        return res;
    }
}
