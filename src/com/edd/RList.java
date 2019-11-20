package com.edd;

import rgui.Printing;

import javax.swing.*;

public class RList {
    public Node head;
    public Node tail;
    public RList(){
        head = null;
        tail = null;
    }
    public Node get(int index){
        int i = 0;
        Node aux = head;
        while(aux != null){
            if(i==index){
                return aux;
            }
            aux = aux.next;
            i++;
        }
        //throw new Exception
        System.out.println("Catastrofic error has occurred! Failed to get Node index: "+index+"Index does not exist in this list.");
        return null;
    }
    public void push(RData data){
        Node new_node = new Node(data);
        if(head == null){
            head = tail = new_node;
            return;
        }
        head.prev = new_node;
        new_node.next = head;
        head = new_node;
    }
    public String get_formatted_list_of_elements(){
        Node aux = head;
        String res = "";
        while (aux!=null){
            res += aux.data.get_visualization()+"<br>";
            aux = aux.next;
        }
        return res;
    }
    public int get_index(String key){
        var aux = head;
        int i = 0;
        while(aux != null){
            if(aux.data.get_key().equals(key)){
                return i;
            }
            aux = aux.next;
            i++;
        }
        return -1;
    }
    public RData search(String key){
        var aux = head;
        int i = 0;
        while(aux != null){
            if(aux.data.get_key().equals(key)){
                return aux.data;
            }
            aux = aux.next;
            i++;
        }
        return null;
    }
    public boolean exists(String key){
        int i = get_index(key);
        return i != -1;
    }
    public void delete(String key){
        var aux = head;
        while(aux != null){
            if(aux.data.get_key().equals(key)){
                //This node must be deleted:
                if(tail == head){
                    //This is the only node:
                    head = tail = null;
                    return;
                }else if(head.data.get_key().equals(key)){
                    //Is the head node so we delete as appropriate:
                    head.next.prev = null;
                    head = head.next;
                    return;
                }else if(tail.data.get_key().equals(key)){
                    //Is the tail node the one we must delete:
                    tail.prev.next = null;
                    tail = tail.prev;
                    return;
                }else{
                    //Is a node in between:
                    aux.next.prev = aux.prev;
                    aux.prev.next = aux.next;
                    return;
                }
            }
            aux = aux.next;
        }
    }
    public RData pop(){
        if(head == null){
            Printing.alert("Fatal error! Underflow Exception when attempting to pop from stack.");
            return null;
        }
        if(head.next==null){
            //Head is the only element
            var aux = head.data;
            head = tail = null;
            return aux;
        }
        var aux = head.data;
        head.next.prev = null;
        head = head.next;
        return aux;
    }
    public void sorted_insert(RData data){
        //This method only works for inserting into a sorted list
        Node new_node = new Node(data);
        if(head == null){
            head = tail = new_node;
            return;
        }
        if (head.data.get_key().compareTo(data.get_key()) >= 0)
        {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            Node current = head;
            /* Locate the node before the point of insertion */
            while (current.next != null)
            {
                if(current.next.data.get_key().compareTo(new_node.data.get_key()) < 0){
                    current = current.next;
                }else{
                    break;
                }
            }
            new_node.next = current.next;
            if(current.next==null){
                tail = new_node;
            }else{
                current.next.prev = new_node;
            }
            new_node.prev = current;
            current.next = new_node;
        }
    }

    public void string_sorted_insert(RData data, int field){
        //This method only works for inserting into a sorted list
        Node new_node = new Node(data);
        if(head == null){
            head = tail = new_node;
            return;
        }
        if (head.data.string_field(field).compareTo(data.string_field(field)) >= 0)
        {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            Node current = head;
            /* Locate the node before the point of insertion */
            while (current.next != null)
            {
                if(current.next.data.string_field(field).compareTo(new_node.data.string_field(field)) < 0){
                    current = current.next;
                }else{
                    break;
                }
            }
            new_node.next = current.next;
            if(current.next==null){
                tail = new_node;
            }else{
                current.next.prev = new_node;
            }
            new_node.prev = current;
            current.next = new_node;
        }
    }

    public void numeric_sorted_insert(RData data, int field){
        //This method only works for inserting into a sorted list
        Node new_node = new Node(data);
        if(head == null){
            head = tail = new_node;
            return;
        }
        if (head.data.numeric_field(field) >= (data.numeric_field(field)))
        {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            Node current = head;
            /* Locate the node before the point of insertion */
            while (current.next != null)
            {
                if(current.next.data.numeric_field(field) < (new_node.data.numeric_field(field))  ){
                    current = current.next;
                }else{
                    break;
                }
            }
            new_node.next = current.next;
            if(current.next==null){
                tail = new_node;
            }else{
                current.next.prev = new_node;
            }
            new_node.prev = current;
            current.next = new_node;
        }
    }

    public void add(RData data){ //Adds the node to the end of the list
        Node new_node = new Node(data);
        if(head == null){
            head = tail = new_node;
        }else{
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }
    public int get_size(){
        int i = 0;
        var aux = head;
        while(aux != null){
            i++;
            aux = aux.next;
        }
        return i;
    }
    public void string_order(int field){
        var lista_aux = new RList();
        var aux = head;
        while(aux != null){
            lista_aux.string_sorted_insert(aux.data,field);
            aux = aux.next;
        }
        head = lista_aux.head;
        tail = lista_aux.tail;
    }
    public void numeric_order(int field){
        var lista_aux = new RList();
        var aux = head;
        while(aux != null){
            lista_aux.numeric_sorted_insert(aux.data,field);
            aux = aux.next;
        }
        head = lista_aux.head;
        tail = lista_aux.tail;
    }
    public RList filter(int field, double filter){
        //Returns all elements with numeric field <= filter.
        RList res = new RList();
        Node aux = head;
        while(aux!=null){
            if(aux.data.numeric_field(field)<=filter)res.numeric_sorted_insert(aux.data,field);
            aux = aux.next;
        }
        return res;
    }
    public RList filter_by_name(int field, String filter){
        //Returns all elements with numeric field <= filter.
        RList res = new RList();
        Node aux = head;
        while(aux!=null){
            if(aux.data.string_field(field).toLowerCase().contains(filter.toLowerCase()))res.string_sorted_insert(aux.data,field);
            aux = aux.next;
        }
        return res;
    }
    public RList to_visual(){
        Node aux = this.head;
        RList list = new RList();
        while(aux!=null){
            list.add(new RVisualization(aux.data.get_visualization()));
            aux = aux.next;
        }
        return list;
    }
    public void reverse(){
        RList res = new RList();
        Node aux = this.tail;
        while(aux!=null){
            res.add(aux.data);
            aux = aux.prev;
        }
        this.head = res.head;
        this.tail = res.tail;
    }

    public JLabel report(String name){
        var list_to_report = this;
        var aux = list_to_report.head;
        var resultado = "digraph foo { rankdir=TB; node [shape=record];"+"\n";
        int c = 0;
        while(aux != null){
            resultado = resultado + "s"+c +"[label=\" "+aux.data.get_visualization_as_node()+"\"];"+"\n";
            if(aux.next != null){
                resultado = resultado + "s"+c+" -> s"+(c+1)+" [arrowhead=vee, tailclip=false, arrowtail = vee];"+"\n";
            }
            else{
                // resultado = resultado + "s"+(list_to_report.get_size()-1)+" -> n2      [arrowhead=vee, tailclip=false,arrowtail = vee];" + "\n";
            }
            c += 1;
            aux = aux.next;
        }
        resultado = resultado +"}";
        System.out.println("Dot code to graph: ");
        System.out.println(resultado);
        Printing.print_archive(name+".dot",resultado);
        JLabel report = Printing.compile_image_dot(name);
        return report;
    }
}
