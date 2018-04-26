package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by staLker on 22-07-2017.
 */
public class UserVerificationPanel {
    public static JPanel getPanel(){
        JPanel panel = new JPanel();
        JButton button = new JButton("Click new button");
        panel.setBounds(0,0,600,600);
        panel.add(button);
        return panel;
    }
}
