package rgui;

import com.edd.Main;
import com.edd.RData;
import com.edd.Usuario;

import javax.swing.*;
import java.awt.*;

import static com.edd.Main.*;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class Register extends JPanel {
    JLabel title;
    JLabel user_name_text;
    JLabel password_text;
    JTextField user_name ;
    JTextField password;
    JButton register_button;
    JButton back_button;
    public Register(){

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("EDD Drive");
        user_name_text = new JLabel("Username: ");
        password_text = new JLabel("Password: ");
        user_name = new JTextField();
        user_name.setColumns(15);
        password = new JTextField();
        password.setColumns(15);
        register_button = new RButton("Register",2);
        back_button = new RButton("Go Back",3);

        register_button.addActionListener(new RButton_Listener(this));
        back_button.addActionListener(new RButton_Listener(this));

        layout.linkSize(SwingConstants.HORIZONTAL, back_button, register_button);
        layout.linkSize(SwingConstants.HORIZONTAL, user_name_text, password_text);
        //endregion

//region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(user_name_text)
                                .addComponent(user_name)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(password_text)
                                .addComponent(password)
                        )
                        .addComponent(register_button)
                        .addComponent(back_button)
                )
        );
//endregion

//region set Vertical Grouping
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addComponent(user_name_text)
                        .addComponent(user_name)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(password_text)
                        .addComponent(password)
                )
                .addComponent(register_button)
                .addComponent(back_button)
        );
//endregion
    }
    public void register(){
        String user__name = user_name.getText();
        String pass = password.getText();
        RData og = usuarios.search(user__name);
        if(og!=null){
            Printing.alert("Another user with this user name already exists. Operation failed.");
            return;
        }
        Usuario new_user = new Usuario(user__name,pass);
        usuarios.add(new_user);
        Printing.alert("You have been registered successfully!");
    }
}
