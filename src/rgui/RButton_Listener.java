package rgui;

import com.edd.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RButton_Listener implements ActionListener {
    JPanel context;
    public RButton_Listener(JPanel panel){
        this.context = panel;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().equals(JRadioButton.class) ){
            JRadioButton jRadioButton = (JRadioButton) e.getSource();
            ((CargarProducto) context).select_category(jRadioButton.getText());
            return;
        }
        RButton button = (RButton)e.getSource();
        JFrame frame = Main.frame;
        var vessel = frame.getContentPane();
        switch (button.code){
            case 0: //Actual login
                Login parent = (Login)context;
                parent.login();
                break;
            case 1: //GOTO register
                vessel.remove(0);
                vessel.add(new Register());
                frame.pack();
                break;
            case 2://Actual register action
                Register register_parent = (Register)context;
                register_parent.register();
                break;
            case 3: //goto login
            case 4:
            case 104:
                vessel.remove(0);
                vessel.add(new Login());
                frame.pack();
                break;
            case 103: //GOTO editar producto
                vessel.remove(0);
                vessel.add(new EditarProducto());
                frame.pack();
                return;
            case 201: //GOTO History
                vessel.remove(0);
                vessel.add(new History());
                frame.pack();
                return;
            case 107: //GOTO home
            case 110:
            case 401:
                vessel.remove(0);
                vessel.add(new Home());
                frame.pack();
                return;
            case 109: //Cargar Producto
                ((CargarProducto)context).cargar();
                return;
            case 100:
                vessel.remove(0);
                vessel.add(new CargarProducto());
                frame.pack();
                return;
            case 105:
                CargarCliente cargarCliente_parent = (CargarCliente) context;
                cargarCliente_parent.add_category();
                return;
            case 106:
                ((CargarCliente)context).cargar();
                return;
            case 101: //GOto cargar cliente
                vessel.remove(0);
                vessel.add(new CargarCliente());
                frame.pack();
                return;
            case 102: //GOTO editar cliente
            case 501:
                vessel.remove(0);
                vessel.add(new EditarCliente());
                frame.pack();
                return;
            case 301: //Editar Cliente
                ((EditarCliente)context).edit();
                return;
            case 302: //Editar producto
                ((EditarProducto)context).edit();
                return;
            case 400: //GOTO shop
                vessel.remove(0);
                vessel.add(new Shop());
                frame.pack();
                return;
            case 403:
                ((Shop)context).facturar();
                return;
            case 404:
                ((Shop)context).ordenarPorCliente();
                return;
            case 405:
                ((Shop)context).odenarPorPrecioUp();
                return;
            case 406:
                ((Shop)context).ordenarPorPrecioDown();
                return;
            case 407:
                ((Shop)context).filtrarPorPrecio();
                return;
            case 408:
                ((Shop)context).filtrarPorCategoria();
                return;
            case 409:
                ((Shop)context).buscarProducto();
                return;
            case 500:
                if(Main.selectedClient==null)return;
                vessel.remove(0);
                vessel.add(new History());
                frame.pack();
            default:
                System.out.println("Not sure, which action was pressed...");
        }
    }
}
