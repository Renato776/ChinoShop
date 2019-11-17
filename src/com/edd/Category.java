package com.edd;

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
}
