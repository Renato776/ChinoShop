package rgui;

import javax.swing.*;
import java.awt.*;

public class RLabel extends JLabel{
    public int index;
    JPanel context;

    public RLabel(int index, String name, JPanel context, int maxChars){
        super();
        this.setText(get_formatted_title(name, maxChars));
        double pf = maxChars*1.5 + 1;
        int r = (int)pf;
        this.setFont(new Font ("TimesRoman", Font.PLAIN, r));
        this.context = context;
        //This constructor must be call right after creating a directory icon.
        this.index = index;
        setOpaque(true);
    }
    public String get_formatted_title(String title){

        if(title.length()>11){
            String res = "<html>";
            char[] l = title.toCharArray();
            int i = 0;
            int ii = 0;
            for (char c: l
                 ) {
                i++;
                res+=c;
                if(i%18==0&&ii!=(l.length-1)){
                    res+="-<br>";
                }
                ii++;
            }
            res+="</html>";
            return res;
        }else return title;
    }

    public String get_formatted_title(String title, int maxChars){

        if(title.length()>maxChars){
            String res = "<html>";
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
            res+="</html>";
            return res;
        }else return title;
    }
}
