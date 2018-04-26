import GUI.LoginAsPanel;
import GUI.MainFrame;

import javax.swing.*;

/**
 * Created by staLker on 22-07-2017.
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = MainFrame.createFrame();
        JPanel panel = LoginAsPanel.getPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);


        frame.setVisible(true);

    }

}
