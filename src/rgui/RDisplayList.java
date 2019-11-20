package rgui;

import com.edd.Main;
import com.edd.RData;
import com.edd.RList;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class RDisplayList extends JScrollPane {
    /*
    * This class takes an RList as parameter and returns A JPanel properly layout and with one
    * RLabel per entry in the RList.
    * */
    RList list;
    JPanel vessel;

    public RDisplayList(RList list, JPanel wrapper){
        super(wrapper);
        this.list = list;
        vessel = wrapper;
    }
    public static  RDisplayList getInstance(RList l, int w, int h, JPanel context){
        JPanel result = new JPanel();
        GroupLayout layout = new GroupLayout(result);
        result.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        var horizontalGroup = layout.createParallelGroup(CENTER); //This is the group that we must add all list elements
        var verticalGroup = layout.createSequentialGroup();
        var aux = l.head;
        int index = 0;
        while(aux!=null){
            var element = new RLabel(index,aux.data.get_key(),context,w/15);
            element.addMouseListener(new RIcon_Handler());
            horizontalGroup.addComponent(element);
            verticalGroup.addComponent(element);
            aux = aux.next;
            index++;
        }
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(horizontalGroup)
        );
        layout.setVerticalGroup(verticalGroup);
        RDisplayList displayList = new RDisplayList(l,result);
        displayList.setPreferredSize(new Dimension(w,h));
        return displayList;
    }
    public JPanel getWrapper(){
        return vessel;
    }
    public void color_element(int index){
        JPanel vessel = getWrapper();
        for (var c:vessel.getComponents()) {
            if(c.getClass().equals(RLabel.class)){
                RLabel element = (RLabel)c;
                if(element.index==index){
                    element.setBackground(Color.cyan);
                }else{
                    element.setBackground(null);
                }
            }
        }
        Main.frame.pack();
    }
    public RData get_element_data(int index){
        return this.list.get(index).data;
    }
}
