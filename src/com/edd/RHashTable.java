package com.edd;

import rgui.Printing;
import rgui.Report_Display;

import javax.swing.*;

public class RHashTable {
    /*
    * Hash Table implementation which manages collisions by
    * position + n. With n = 1,2,3,4 ....
    * Rehashing is needed.
    * */
    private int size;
    public RData[] content;

    public static boolean isPrime(int n){
        if(n%2==0)return false;
        for (int i = 3; i*i<=n; i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    public static int getNextPrime(int n){
        int nextPrime = n+1;
        if(isPrime(nextPrime)) return nextPrime;
        return getNextPrime(nextPrime);
    }
    public RHashTable(int s){
        if(isPrime(s))size = s;
        else {
            System.out.println("Warning!! Hash Table size is not prime.");
            System.out.println("The next closest prime will be used instead.");
            size = getNextPrime(s);
        }
        content = new RData[size];
    }

    public int hashFunction(int hashCode){
        return hashCode % size;
    }

    public double getUsageFactor (){
        double i = 0;
        for (RData n: content ) {
            if(n != null)i++;
        }
        return i/(double)size;
    }

    public void resize(){
        size = getNextPrime(size);
        RData[] old = content;
        content = new RData[size];
        for (RData n: old ) {
            if(n!=null){
                //Insert the new Node in the table
                insert(n);
            }
        }
    }
    public RData search(String key){
        int hash__code = get_hash_code(key);
        int hash___code = hashFunction(hash__code);
        int index = hash___code;
        int spacing = 1;
        int stop = 0;
        while(stop<size*6){
            RData result = content[hash___code];
            if(result!=null){
                if(result.get_key().equals(key)){
                    return result;
                }
            }
            hash___code = (index + (int)Math.pow(spacing,2)) % size;
            spacing ++;
            stop++;
            //If I end up checking size*6 buckets the key is not present at all.
        }
        return null;
    }
    public int get_hash_code(String s){
        char[] charList = s.toCharArray();
        int aux = 0;
        for (char ren: charList ) {
            aux = aux + ren;
        }
        return aux;
    }
    public void insert(RData val){
        //First of all, resize the table if needed!
        //Max usage factor supported: 75%
        if(getUsageFactor()>0.75){
            resize();
        }
        RData n = (val);
        int hashCode = hashFunction(n.getHash());
        int spacing = 1;
        int stop = 0;
        int index = hashCode;
        while(content[index]!=null&&(stop <= size*6)){
            index = (hashCode + (int)Math.pow(spacing,2)) % size;
            spacing ++;
            stop++;
            //If I end up checking size*6 buckets there must be no space left whatsoever.
        }
        if(stop>=size*6){
            System.out.println("There's no space left in the hashtable for inserting value: "+val.toString());
            return;
        }
        content[index]  = n;
        System.out.println("Node inserted successfully!");
    }
    public void visualize(){
        int i = 0;
        for (RData n: content ) {
            String res;
            if(n==null)res = i+". null;";
            else res = i+". "+n.get_visualization()+";";
            System.out.println(res);
            i++;
        }
    }
    public void graph(){
        String header = "{index | value }";
        String graph = "digraph foo {rankdir=LR; node [shape=record];"+'\n';
        graph += "result [ label = \"";
        graph+=header+'\n';
        int i = 0;
        while(i<size){
        if(content[i]==null){
            graph+=" | "+"{"+i+" | null }"+"\n";
        }else{
            graph+=" | {"+i+" | "+content[i].get_visualization()+"}"+"\n";
        }
        i++;
        }
        graph += "\"]; \n }";
        System.out.println("Dot Code: "+graph);
        Printing.print_archive("hash_report.dot",graph);
        JLabel report = Printing.compile_image_dot("hash_report");
        var vessel = Main.frame.getContentPane();
        var frame = Main.frame;
        vessel.remove(0);
        vessel.add(new Report_Display(report));
        frame.pack();
    }


}
