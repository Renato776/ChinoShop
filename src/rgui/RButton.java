package rgui;

import javax.swing.*;

public class RButton extends JButton {
    public int code;
    public RButton(String title, int code){
        super(title);
        this.code = code;
    }
}
