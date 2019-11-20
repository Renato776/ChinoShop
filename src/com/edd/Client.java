package com.edd;

import javax.swing.*;
import java.awt.*;

public class Client extends RData {
    public RList likes;
    public String name;
    public String last_name;
    public String address;
    public String NIT;
    public RList history;

    public Client(String name){
        this.name = name;
        likes = null;
        last_name = "";
        address = "";
        NIT = "";
        history = new RList();
    }
    public static Client register(String name){
        if(Main.clients.search(name)!=null){
            return null;
        }
        return new Client(name);
    }
    @Override
    public String get_visualization() {
        return "Nombre: "+name+" <br>" +
                "Apellido: "+last_name+"<br>" +
                "Direccion: "+address+"<br>" +
                "NIT: "+NIT+" <br>" +
                likes.get_formatted_list_of_elements();
    }

    @Override
    public String get_key() {
        return name;
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public String string_field(int field) {
        if(field == 0)return name;
        if(field == 1)return last_name;
        if(field == 2)return address;
        if(field == 3)return NIT;
        return name;
    }

    @Override
    public double numeric_field(int field) {
        return 0;
    }

    @Override
    public Component[][] get_editable_fields() {
        var res =  new Component[4][2];
        var n = new JLabel("Nombre: ");
        var nf = new JTextField(name);;
        var a = new JLabel("Apellido: ");
        var af = new JTextField(last_name);;
        var d = new JLabel("Direccion: ");
        var df = new JTextField(address);;
        var nit = new JLabel("NIT: ");
        var nitf = new JTextField(NIT);
        res[0] = new Component[]{n,nf};
        res[1] = new Component[]{a,af};
        res[2] = new Component[]{d,df};
        res[3] = new Component[]{nit,nitf};
        return res;
    }

    @Override
    public Component[][] get_non_editable_fields() {
        return new Component[0][];
    }

    @Override
    public String get_visualization_as_node() {
        return "Nombre: "+name+"\\n"+" Apellido: "+last_name+" \\n Direccion: "+address+"\\n NIT: "+NIT;
    }
}
