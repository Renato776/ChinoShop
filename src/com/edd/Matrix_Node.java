package com.edd;

public class Matrix_Node {
    public int max_height;
    public int max_width;
    public int x;
    public int y;
    public String c;
    public int up_x;
    public int up_y;
    public int down_x;
    public int down_y;
    public int right_x;
    public int right_y;
    public int left_x;
    public int left_y;
    public String name;
    public String signature;

    public Matrix_Node(int m_x, int m_y, int pos_x, int pos_y, String c) {
        max_height = m_y;
        max_width = m_x;
        x = pos_x;
        y = pos_y;
        this.c = c;
        up_x = x;
        up_y = y;
        down_x = x;
        down_y = y;
        right_x = x;
        right_y = y;
        left_x = x;
        left_y = y;
        name = "node_"+x+"_"+y;
        signature = "[";
        signature = signature + "label = \""+c+"\" " ;
        if(c.equals("0")){
            signature = signature+"style = invis ";
        }
        signature = signature+" pos=\""+(x*2.5)+","+(-y*2.5)+"!\"]";
    }

    public static String get_matrix_graph(String[][] base){
        Matrix_Node[] matrix = Matrix_Node.to_linear(base);
        String graph = "digraph G { rankdir=TB; node [shape=record]; ";
        graph+=("node [style = filled];");
        for (Matrix_Node current:matrix
        ) {
            graph+=(current.name+" "+current.signature);
            graph+=(current.get_partners());
        }
        graph+=("}");
        return graph;
    }

    public void calculate_partners() {
        up_x = x;
        up_y = y-1;
        down_x = x;
        down_y = y+1;
        right_x = x+1;
        right_y = y;
        left_x = x-1;
        left_y = y;
    }

    public String get_partners(){
        calculate_partners();
        String res = "";
        if(up_y>=0){
            res = res+name+"->"+"node_"+(up_x)+"_"+(up_y);
            res = res +"\n";
        }
        if(right_x<max_width){
            res = res+name+"->"+"node_"+(right_x)+"_"+(right_y)+"\n";
        }
        if(left_x>=0){
            res = res+name+"->"+"node_"+(left_x)+"_"+(left_y)+"\n";
        }
        if(down_y<max_height){
            res = res+name+"->"+"node_"+(down_x)+"_"+(down_y)+"\n";
        }
        return res;
    }

    public String get_linear_partners() {
        return "";
    }

    public static Matrix_Node[] to_linear(String[][] content) {
        int x = content.length;
        int y = content[0].length;
        int c = 0;
        int cc = 0;
        Matrix_Node[] linear_content = new Matrix_Node[x * y];
        while (c < y) {
            int c4 = 0;
            while (c4 < x) {
                linear_content[cc] = new Matrix_Node(x,y,c4,c,content[c4][c]);
                cc++;
                c4++;
            }
            c++;
        }
        /*
        while (c < x) {
            int c4 = 0;
            while (c4 < y) {
                linear_content[cc] = new Matrix_Node(x, y, c, c4, content[c][c4]);
                c4++;
                cc++;
            }
            c++;
        }
        */
        return linear_content;
    }
}
