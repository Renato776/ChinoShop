package com.edd;

import rgui.Printing;

import javax.swing.*;
import java.awt.*;

public class Product extends RData {
    public Code code;
    public String name;
    public double price;
    public String category;
    public Product(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = new Code();
        if(Main.categories.search(this.category)!=null){
            if(((Category)Main.categories.search(this.category)).products.search(this.code.get_key())==null){
                //Hasn't been registered yet.
                ((Category)Main.categories.search(this.category)).products.sorted_insert(this);
            }
        }
    }
    public Product(Code c, String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = c;
        if(Main.categories.search(this.category)!=null){
            if(((Category)Main.categories.search(this.category)).products.search(this.code.get_key())==null){
                //Hasn't been registered yet.
                ((Category)Main.categories.search(this.category)).products.sorted_insert(this);
            }
        }
    }
    public Product(String code, String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = new Code(code);
        if(Main.categories.search(this.category)!=null){
            if(((Category)Main.categories.search(this.category)).products.search(this.code.get_key())==null){
                //Hasn't been registered yet.
                ((Category)Main.categories.search(this.category)).products.sorted_insert(this);
            }
        }
    }
    @Override
    public String get_visualization() {
        //style = "width: 500px;//style="width:700px">
        //return "Codigo: "+code.get_key()+" Nombre: "+name+" Precio: "+price+" Categoria: "+category;
        return "<html><table style=\"width:800px\"><tr><td>"+ Printing.get_formatted_text(code.get_key(),10)+"</td><td>"+Printing.get_formatted_text(name,10)
                +"</td><td>"+Printing.get_formatted_text(""+price,10)+"</td><td>"+Printing.get_formatted_text(category,10)+"</td></tr></table><html>";
    }

    @Override
    public String get_key() {
        return code.get_key();
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public String string_field(int field) {
        if(field == 0)return name;
        if(field == 1)return category;
        if(field == 2)return  code.get_key();
        if(field == 3)return  get_visualization();
        return code.get_key();
    }

    @Override
    public double numeric_field(int field) {
        return price;
    }

    @Override
    public Component[][] get_editable_fields() {
        var res =  new Component[3][2];
        res[0] = new Component[]{new JLabel("Nombre: "),new JTextField(name)};
        res[1] = new Component[]{new JLabel("Categoria: "),new JTextField(category)};
        res[2] = new Component[]{new JLabel("Precio: "),new JTextField(""+this.price)};
        return res;
    }

    @Override
    public Component[][] get_non_editable_fields() {
        var res =  new Component[1][2];
        var t = new JTextField(code.get_key());
        t.setEditable(false);
        res[0] = new Component[]{new JLabel("Codigo: "),t};
        return res;
    }

    @Override
    public String get_visualization_as_node() {
        return "Codigo: "+code.get_key()+" \\n Nombre: "+name;
    }

}
