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
    public static void main(String[] args) {
	// write your code here
    Usuario admin = new Usuario("admin","admin");
        usuarios.add(admin);
        frame = new JFrame();
        frame.setTitle("EDD");
        var vessel = frame.getContentPane();
        vessel.add(new Login());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
