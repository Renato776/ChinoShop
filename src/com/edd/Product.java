package com.edd;

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
    }
    public Product(String code, String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = new Code(code);
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
}