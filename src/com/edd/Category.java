package com.edd;

import java.awt.*;

public class Category extends RData {
    public String name;
    public RList products;
    public Category(String name){
        this.name = name;
        products = new RList();
        Main.categories.add(this);
    }
    public static Category register(String name){
        if(Main.categories.search(name)!=null){
            //Another category already exists with this name.
            //Cannot register category.
            return null;
        }
        return new Category(name);
    }

    @Override
    public String get_visualization() {
        return "Nombre: "+name+" <br>" +
                "Productos: <br>" +
                products.get_formatted_list_of_elements();
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
        return name;
    }

    @Override
    public double numeric_field(int field) {
        return field;
    }

    @Override
    public Component[][] get_editable_fields() {
        return new Component[0][];
    }

    @Override
    public Component[][] get_non_editable_fields() {
        return new Component[0][];
    }
    public String get_matrix_node_info(){
        if(this.products.get_size()==0)return "-";
        if(this.products.get_size()==1){
            return this.products.head.data.get_visualization_as_node();
        }
        var aux = this.products.head.next;
        String res = "{"+products.head.data.get_visualization_as_node();
        while(aux!=null){
            res+="|"+aux.data.get_visualization_as_node();
            aux = aux.next;
        }
        res+="}";
        return res;
    }
    @Override
    public String get_visualization_as_node() {
        return name;
    }
}
