package com.edd;

import rgui.Login;

import javax.swing.*;

public class Main {

    public static int w_unit = 50;
    public static int h_unit = 50;
    public  static JFrame frame = null;
    public static Usuario usuario = null;
    public static RList usuarios = new RList();
    public static RList categories = new RList();
    public static RList products = new RList();
    public static RList clients = new RList();
    public static Client selectedClient = null;

    public static void load_sample_data(){
        //region load users:
        usuarios.add(new Usuario("Renato","Flores"));
        usuarios.add(new Usuario("Javi","Flores"));
        usuarios.add(new Usuario("Alex","Flores"));
        usuarios.add(new Usuario("Alejandra","Gomez"));
        //endregion
        //region load Categories
        new Category("Higiene");
        new Category("Dulces");
        new Category("Alcohol");
        new Category("Cigarros");
        new Category("Chucherias");
        new Category("Panes");
        //endregion
        //region load Products
        products.add(new Product("cerveza",12.5,"Higiene"));
        products.add(new Product("Chicle",2.00,"Dulces"));
        products.add(new Product("Bonbon",1.20,"Dulces"));
        products.add(new Product("Chocolate",7.78,"Dulces"));
        products.add(new Product("Pan con mantequilla",5.5,"Panes"));
        products.add(new Product("Papel higienico",3.5,"Higiene"));
        //endregion
        //region Load Clients
        clients.add(new Client("Kayle"));
        clients.add(new Client("Morgana"));
        clients.add(new Client("Syndra"));
        clients.add(new Client("Lissandra"));
        clients.add(new Client("Lulu"));
        clients.add(new Client("Karma"));
        clients.add(new Client("Irelia"));
        //endregion
    }
    public static void main(String[] args) {
	// write your code here
        load_sample_data();
    Usuario admin = new Usuario("admin","admin");
        usuarios.add(admin);
        new Category("otros");
        frame = new JFrame();
        frame.setTitle("EDD");
        var vessel = frame.getContentPane();
        vessel.add(new Login());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
