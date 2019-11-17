package rgui;

import com.edd.Main;
import com.edd.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

import static com.edd.Main.*;
import static javax.swing.GroupLayout.Alignment.*;

public class Login extends JPanel {
    JLabel title ;
    JLabel user_name_text;
    JLabel password_text ;
    JTextField user_name;
    JPasswordField password;
    JButton login_button;
    JButton register_button;

    public Login(){

        setBackground(Color.cyan);
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
        password = new JPasswordField();
        password.setColumns(15);
        login_button = new RButton("Login",0);
        register_button = new RButton("Register",1);
        login_button.addActionListener(new RButton_Listener(this));
        register_button.addActionListener(new RButton_Listener(this));
        layout.linkSize(SwingConstants.HORIZONTAL, login_button, register_button);
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
                        .addComponent(login_button)
                        .addComponent(register_button)
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
                .addComponent(login_button)
                .addComponent(register_button)
        );
//endregion
    }

    public void login(){
        String user__name = user_name.getText();
        String user__password = password.getText();
        var vessel = Main.frame.getContentPane();
        Usuario logged_in_user = (Usuario) usuarios.search(user__name);
        if(logged_in_user == null){
            Printing.alert("The User you're trying to login with does not exist.");
            Printing.alert("Try registering first.");
            usuario = null;
            return;
        }
        if(logged_in_user.password.equals(user__password)){
            vessel.remove(0);
            vessel.add(new Home());
            usuario = logged_in_user;
        }else{
            Printing.alert("Wrong credentials. User name and password does not match.");
            usuario = null;
            return;
        }
        Main.frame.pack();
    }
}
