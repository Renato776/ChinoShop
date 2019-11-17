package com.edd;

public class Client extends RData {
    public RList likes;
    public String name;
    public String last_name;
    public String address;
    public String NIT;

    public Client(String name){
        this.name = name;
        likes = new RList();
        last_name = "";
        address = "";
        NIT = "";
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
}
