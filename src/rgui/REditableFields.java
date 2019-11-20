package rgui;

import com.edd.Client;
import com.edd.RData;

import javax.swing.*;

import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class REditableFields extends JPanel {

    Component[][] fields;
    Component[][] non_editable_fields;

    public REditableFields(RData data){
        super();
        fields = data.get_editable_fields();
        non_editable_fields = data.get_non_editable_fields();
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        var horizontalGroup = layout.createParallelGroup(CENTER);
        var verticalGroup = layout.createSequentialGroup();
        if(data.getClass().equals(Client.class)){
            layout.linkSize(fields[0][1],fields[1][1],fields[2][1],fields[3][1]);
            layout.linkSize(fields[0][0],fields[1][0],fields[2][0],fields[3][0]);
        }
        for (var f: non_editable_fields) {
           horizontalGroup.addGroup(layout.createSequentialGroup()
                   .addComponent(f[0])
                   .addComponent(f[1])
           );
            verticalGroup.addGroup(layout.createParallelGroup()
                    .addComponent(f[0])
                    .addComponent(f[1])
            );
        }
        for (var f: fields) {
            horizontalGroup.addGroup(layout.createSequentialGroup()
                    .addComponent(f[0])
                    .addComponent(f[1])
            );
            verticalGroup.addGroup(layout.createParallelGroup()
                    .addComponent(f[0])
                    .addComponent(f[1])
            );
        }
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(horizontalGroup)
        );
        layout.setVerticalGroup(verticalGroup);
    }

    public REditableFields() {

    }

    public String[] retrieve_data(){
        String[] result = new String[fields.length];
        int i = 0;
        for (var c: fields) {
            result[i] = ((JTextField)c[1]).getText();
            i++;
        }
        return result;
    }
    public void replace_data(RData data){
        var new_fields = data.get_editable_fields();
        var new_non_editable_fields = data.get_non_editable_fields();
        int i = 0;
        for (var c: new_fields) {
            ((JTextField)fields[i][1]).setText(((JTextField)c[1]).getText());
            i++;
        }
        i = 0;
        for (var c: new_non_editable_fields) {
            ((JTextField)non_editable_fields[i][1]).setText(((JTextField)c[1]).getText());
            i++;
        }
    }
}
