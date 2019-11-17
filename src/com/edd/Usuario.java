package com.edd;

public class Usuario extends RData {
    public RList history;
    public String name;
    public String password;

    public Usuario(String name,String password){
        this.name = name;
        this.password = password;
        history = new RList();
    }
    public String get_key(){
        return name;
    }
    public int getHash(){
        char[] charList = name.toCharArray();
        int aux = 0;
        for (char ren: charList ) {
            aux = aux + ren;
        }
        return aux;
    }
    @Override
    public String get_visualization() {
        return "Name: "+name+"; Pass: "+password;
    }
}
