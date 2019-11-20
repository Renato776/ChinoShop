package com.edd;

import java.awt.*;

public class Code extends RData{
    public static RList taken_codes = new RList();
    public String code;
    private static int code_count = 0;
    public Code(){
        code_count++;
        this.code = "P"+code_count;
        var aux = taken_codes.search(this.code);
        while(aux!=null){
            code_count++;
            this.code = "P"+code_count;
            aux = taken_codes.search(this.code);
        }
    }
    public Code(String code){
        code_count++;
        this.code = code;
        var aux = taken_codes.search(this.code);
        while(aux!=null){
            code_count++;
            this.code = code+code_count;
            aux = taken_codes.search(this.code);
        }
    }
    @Override
    public String get_visualization() {
        return this.code;
    }

    @Override
    public String get_key() {
        return this.code;
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public String string_field(int field) {
        return code;
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

    @Override
    public String get_visualization_as_node() {
        return get_visualization();
    }
}
