package rgui;

import com.edd.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Shop extends JPanel {
    JLabel title ;

    JButton ordenar_por_cliente;
    JButton ordenar_por_precio_up;
    JButton ordenar_por_precio_down;
    JButton filtrar_por_precio;
    JButton filtrar_por_categoria;
    JButton buscar_producto;
    JLabel display_title;
    RDisplayList display;
    JButton facturar_button;
    JButton back_button;
    int selected_product;
    //JButton reports_button;

    public Shop(){
        selected_product = 0;
        //setBackground(Color.yellow);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("Chino Shop");
        back_button = new RButton("Back",401);
        ordenar_por_cliente = new RButton("Ordenar por cliente",404);
        ordenar_por_precio_up = new RButton("Ordenar por precio Ascendente",405);
        ordenar_por_precio_down = new RButton("Ordenar por precio Descendente",406);
        filtrar_por_precio = new RButton("Filtrar por precio",407);
        filtrar_por_categoria = new RButton("Filtrar por categoria",408);
        buscar_producto = new RButton("Buscar producto",409);
        facturar_button = new RButton("Facturar",403);
        back_button.addActionListener(new RButton_Listener(this));
        ordenar_por_precio_down.addActionListener(new RButton_Listener(this));
        ordenar_por_precio_up.addActionListener(new RButton_Listener(this));
        ordenar_por_cliente.addActionListener(new RButton_Listener(this));
        filtrar_por_precio.addActionListener(new RButton_Listener(this));
        filtrar_por_categoria.addActionListener(new RButton_Listener(this));
        buscar_producto.addActionListener(new RButton_Listener(this));
        facturar_button.addActionListener(new RButton_Listener(this));

        layout.linkSize(SwingConstants.HORIZONTAL, ordenar_por_precio_down,ordenar_por_precio_up);
        layout.linkSize(SwingConstants.HORIZONTAL, filtrar_por_categoria, filtrar_por_categoria);
        layout.linkSize(SwingConstants.HORIZONTAL, ordenar_por_cliente, buscar_producto);
        layout.linkSize(SwingConstants.HORIZONTAL, back_button, facturar_button);

        display_title = new JLabel("Codigo:         Nombre:         Categoria:          Precio:");
        display = RDisplayList.getInstance(Main.products.to_visual(),800,400,this,false);
        //endregion

//region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ordenar_por_cliente)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(ordenar_por_precio_up)
                                    .addComponent(ordenar_por_precio_down)
                                )
                                .addComponent(filtrar_por_precio)
                                .addComponent(filtrar_por_categoria)
                                .addComponent(buscar_producto)
                        )
                        .addComponent(display_title)
                        .addComponent(display)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(back_button)
                                .addComponent(facturar_button)
                        )
                )
        );
//endregion

//region set Vertical Grouping
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addComponent(ordenar_por_cliente)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ordenar_por_precio_up)
                                .addComponent(ordenar_por_precio_down)
                        )
                        .addComponent(filtrar_por_precio)
                        .addComponent(filtrar_por_categoria)
                        .addComponent(buscar_producto)
                )
                .addComponent(display_title)
                .addComponent(display)
                .addGroup(layout.createParallelGroup()
                        .addComponent(back_button)
                        .addComponent(facturar_button)
                )
        );
//endregion
    }

    public Shop(RDisplayList displayList){

        selected_product = 0;
        //setBackground(Color.yellow);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //region Declaration of components to use
        title = new JLabel("Chino Shop");
        back_button = new RButton("Back",401);
        ordenar_por_cliente = new RButton("Ordenar por cliente",404);
        ordenar_por_precio_up = new RButton("Ordenar por precio Ascendente",405);
        ordenar_por_precio_down = new RButton("Ordenar por precio Descendente",406);
        filtrar_por_precio = new RButton("Filtrar por precio",407);
        filtrar_por_categoria = new RButton("Filtrar por categoria",408);
        buscar_producto = new RButton("Buscar producto",409);
        facturar_button = new RButton("Facturar",403);
        back_button.addActionListener(new RButton_Listener(this));
        ordenar_por_precio_down.addActionListener(new RButton_Listener(this));
        ordenar_por_precio_up.addActionListener(new RButton_Listener(this));
        ordenar_por_cliente.addActionListener(new RButton_Listener(this));
        filtrar_por_precio.addActionListener(new RButton_Listener(this));
        filtrar_por_categoria.addActionListener(new RButton_Listener(this));
        buscar_producto.addActionListener(new RButton_Listener(this));
        facturar_button.addActionListener(new RButton_Listener(this));

        layout.linkSize(SwingConstants.HORIZONTAL, ordenar_por_precio_down,ordenar_por_precio_up);
        layout.linkSize(SwingConstants.HORIZONTAL, filtrar_por_categoria, filtrar_por_categoria);
        layout.linkSize(SwingConstants.HORIZONTAL, ordenar_por_cliente, buscar_producto);
        layout.linkSize(SwingConstants.HORIZONTAL, back_button, facturar_button);

        display_title = new JLabel("Codigo:         Nombre:         Categoria:          Precio:");
        display = displayList;
        //endregion

//region set Horizontal grouping:
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ordenar_por_cliente)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(ordenar_por_precio_up)
                                        .addComponent(ordenar_por_precio_down)
                                )
                                .addComponent(filtrar_por_precio)
                                .addComponent(filtrar_por_categoria)
                                .addComponent(buscar_producto)
                        )
                        .addComponent(display_title)
                        .addComponent(display)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(back_button)
                                .addComponent(facturar_button)
                        )
                )
        );
//endregion

//region set Vertical Grouping
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGroup(layout.createParallelGroup()
                        .addComponent(ordenar_por_cliente)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ordenar_por_precio_up)
                                .addComponent(ordenar_por_precio_down)
                        )
                        .addComponent(filtrar_por_precio)
                        .addComponent(filtrar_por_categoria)
                        .addComponent(buscar_producto)
                )
                .addComponent(display_title)
                .addComponent(display)
                .addGroup(layout.createParallelGroup()
                        .addComponent(back_button)
                        .addComponent(facturar_button)
                )
        );
//endregion
    }

    public void setSelected_product(int index){
        selected_product = index;
        display.color_element(index);
    }

    public void facturar() {
        Product product = (Product)(Main.products.filter_by_name(3,display.get_element_data(selected_product).get_key())).head.data;
        var data = Printing.request_data(new String[][]{{"Codigo: ",product.code.get_key()},{"Nombre del producto: ",product.name},{"Cliente: ",""},{"Precio: ",""+product.price},{"Efectivo: ",""}});
        if(data == null)return;
        if(Main.clients.search(data[2])==null){
            Printing.alert("Cliente no encontrado: "+data[1]);
            Printing.alert("Se registrara la compra anonima.");
        }
        Client customer = (Client)Main.clients.search(data[2]);
        if(Main.products.search(data[0])==null){
            Printing.alert("Producto no encontrado");
            Printing.alert("Operacion cancelada");
            return;
        }
        double price,effective;
        try{
            price = Double.parseDouble(data[3]);
            effective = Double.parseDouble(data[4]);
            if((price < 0 )||(effective < 0))throw new Exception();
        } catch (Exception ex){
            Printing.alert("Precio o efectivo no validos.");
            Printing.alert("No utilice simbolos monetarios.");
            Printing.alert("Operacion cancelada.");
            return;
        }
        if(price>effective){
            Printing.alert("El efectivo recibido: "+effective+" No es suficiente para realizar la compra.");
            Printing.alert("Precio total del producto: "+price);
            Printing.alert("Operacion cancelada.");
            return;
        }
        double cambio = effective - price;
        Printing.alert("Cambio: "+cambio);
        Printing.alert("Compra realizada con exito!");
        var formatter=  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        var timestamp = new Date();
        var date = formatter.format(timestamp);
        customer.history.push(new RVisualization(date+"  Compra de producto: "+product.name+" Codigo: "+product.code.get_key()+"" +
                " Efectivo: "+effective+" Cambio recibido: "+cambio));
    }

    public void ordenarPorCliente() {
        String[] data = null;
        if(Main.clients.head == null){
            data = Printing.request_data(new String[][]{{"Cliente: ",""}});
        }else{
            data = Printing.request_data(new String[][]{{"Cliente: ",Main.clients.head.data.get_key()}});
        }
        if(data == null){
            Printing.alert("Operation cancelled.");
            return;
        }
        String client_name = data[0];
        if(Main.clients.search(client_name)==null){
            Printing.alert("Cliente: "+client_name+" No encontrado.");
            return;
        }
        Client client = (Client) Main.clients.search(client_name);
        if(client.likes.head == null)return;
        var aux = client.likes.head;
        RList result = new RList();
        while(aux!=null){
            Category cat  = (Category) aux.data;
            var auxx = cat.products.head;
            while(auxx!=null){
                result.add(new RVisualization(auxx.data.get_visualization()));
                auxx = auxx.next;
            }
            aux = aux.next;
        }
        this.display = get_list_visualization(result);
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }

    public void odenarPorPrecioUp() {
        Main.products.numeric_order(0);
        this.display = get_list_visualization(Main.products.to_visual());
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }

    public void ordenarPorPrecioDown() {
        Main.products.numeric_order(0);
        Main.products.reverse();
        this.display = get_list_visualization(Main.products.to_visual());
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }

    public void filtrarPorPrecio() {
        String[] data = null;
        data = Printing.request_data(new String[][]{{"Precio: ",""}});
        if(data == null){
            return;
        }
        String s_price = data[0];
        double price = 0;
        try{
            price = Double.parseDouble(s_price);
            if(price < 0)throw new Exception();
        }catch (Exception ex){
            Printing.alert("Precio invalido.");
            Printing.alert("No utilice simbolos monetarios");
        }
        RList result = Main.products.filter(0,price);
        result.numeric_order(0);
        this.display = get_list_visualization(result.to_visual());
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }

    public void filtrarPorCategoria() {

        String[] data = null;
        data = Printing.request_data(new String[][]{{"Categoria: ",""}});
        if(data == null){
            return;
        }
        String category = data[0];
        if(Main.categories.search(category)==null){
            Printing.alert("Categoria no existe: "+category);
            Printing.alert("Operacion cancelada");
            return;
        }
        RList result = ((Category)Main.categories.search(category)).products;
        this.display = get_list_visualization(result.to_visual());
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }

    public void buscarProducto() {
        String[] data = null;
        data = Printing.request_data(new String[][]{{"Producto: ",""}});
        if(data == null){
            return;
        }
        String product = data[0];
        if(Main.products.filter_by_name(0,product).head==null){
            Printing.alert("Producto no existe: "+product);
            Printing.alert("Operacion cancelada");
            return;
        }
        this.display = get_list_visualization(Main.products.filter_by_name(0,product).to_visual());
        Main.frame.getContentPane().remove(0);
        Main.frame.getContentPane().add(new Shop(this.display));
        Main.frame.pack();
    }
    public RDisplayList get_list_visualization(RList list){
        return RDisplayList.getInstance(list,800,400,this,false);
    }
}
