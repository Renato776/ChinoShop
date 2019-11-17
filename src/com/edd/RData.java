package com.edd;

public abstract class  RData {
    public abstract String get_visualization();
    public abstract String get_key();
    public abstract int getHash();
    public abstract String string_field(int field);
    public abstract double numeric_field(int field);
}
