package com.edd;

import java.awt.*;

public class RVisualization extends  RData{
    public String content;
    public RVisualization(String content){
        this.content = content;
    }

    @Override
    public String get_visualization() {
        return content;
    }

    @Override
    public String get_key() {
        return content;
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public String string_field(int field) {
        return content;
    }

    @Override
    public double numeric_field(int field) {
        return 0;
    }

    @Override
    public Component[][] get_editable_fields() {
        return new Component[0][];
    }

    @Override
    public Component[][] get_non_editable_fields() {
        return new Component[0][];
    }
}
