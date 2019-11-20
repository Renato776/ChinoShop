package rgui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Printing {
    public static void alert(String i){
        JOptionPane.showMessageDialog(null, i, "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
    public static String[] request_data(String[][] data){
        /*
        data is a matrix because:
        data - List of
            name - placeHolder
         */
        int i = 0;
        JPanel myPanel = new JPanel();
        GroupLayout layout = new GroupLayout(myPanel);
        myPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        var horizontal_group = layout.createParallelGroup(CENTER);
        var vertical_group = layout.createSequentialGroup();
                        //layout.createParallelGroup(CENTER)
                        //.addGroup(layout.createSequentialGroup()
                        //                .addComponent(reportes_button)
                         //               .addComponent(sign_out_button)
                                //.addComponent(share_button)
                        //)
        for (String[] header: data
        ) {
            String title,placeholder;
            title = header[0];
            placeholder = header[1];
            var jt = new JTextField(placeholder.length()+5);
            jt.setText(placeholder);
            var label = new JLabel(title);
            horizontal_group.addGroup(layout.createSequentialGroup().addComponent(label).addComponent(jt));
            vertical_group.addGroup(layout.createParallelGroup().addComponent(label).addComponent(jt));
            myPanel.add(label);
            myPanel.add(jt);
            i++;
        }
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(horizontal_group));
        layout.setVerticalGroup(vertical_group);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "EDD", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String[] res = new String[i];
            i = 0;
            var aux = myPanel.getComponents();
            for (Component c: aux
                 ) {
                if(c.getClass().getName().equals(JTextField.class.getName())){
                    res[i] = ((JTextField)c).getText();
                    i++;
                }
            }
            return res;
        }
        alert("Operation Cancelled.");
        return null;
    }
    public static void print_archive(String name, String content){
        File file = new File(name);
        try{
            file.createNewFile();
            PrintWriter writer = new PrintWriter(name, "UTF-8");
            writer.println(content);
            writer.close();
        }catch (Exception e){
        }
    }
    private static String get_neato_command(String file_name){
       return "neato "+file_name+".neato -Tpng -o "+file_name+".png";
    }

    private static String get_dot_command(String file_name){
        return "dot "+file_name+".dot -Tpng -o "+file_name+".png";
    }

    public static String  get_formatted_text(String title, int maxChars){

        if(title.length()>maxChars){
            String res = "";
            char[] l = title.toCharArray();
            int i = 0;
            int ii = 0;
            for (char c: l
            ) {
                i++;
                res+=c;
                if(i%maxChars==0&&ii!=(l.length-1)){
                    res+="-<br>";
                }
                ii++;
            }
            return res;
        }else return title;
    }
    public static JLabel compile_image_neato(String file_name){
        //processBuilder.command("neato", file_name+".neato","-Tpng","-o", file_name+".png");
        try{
            Process p = Runtime.getRuntime().exec(get_neato_command(file_name));
            Thread.currentThread().sleep(10000);
        }catch (Exception ex){
            Printing.alert("An error occurred while trying to compile the dot code: "+ex.toString());
        }
        try{
            JLabel res = new JLabel();
            ImageIcon icon = new ImageIcon(file_name+".png");
            res.setIcon(icon);
            return res;
        }catch (Exception e){
            Printing.alert("Fatall error! The generated Image seems to be too big for an ImageIcon. \n Exact details: "+e.toString());
        return null;
        }

    }

    public static JLabel compile_image_dot(String file_name){
        //processBuilder.command("neato", file_name+".neato","-Tpng","-o", file_name+".png");
        try{
            Process p = Runtime.getRuntime().exec(get_dot_command(file_name));
            Thread.currentThread().sleep(4000);
        }catch (Exception ex){
            Printing.alert("An error occurred while trying to compile the dot code: "+ex.toString());
        }

        //Okay, at this point the Image should've been created, so let's read it and add it to a JLabel:
        JLabel res = new JLabel();
        ImageIcon icon = new ImageIcon(file_name+".png");
        res.setIcon(icon);
        return res;
    }
}
