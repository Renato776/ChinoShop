package com.edd;

import java.awt.*;

public abstract class  RData {
    public abstract String get_visualization();
    public abstract String get_key();
    public abstract int getHash();
    public abstract String string_field(int field);
    public abstract double numeric_field(int field);
    public abstract Component[][] get_editable_fields();
    public abstract Component[][] get_non_editable_fields();
    public abstract String get_visualization_as_node();
}
