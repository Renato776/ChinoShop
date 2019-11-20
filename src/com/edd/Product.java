package com.edd;

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
        return "Codigo: "+code.get_key()+" Nombre: "+name+" Precio: "+price+" Categoria: "+category;
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

}
