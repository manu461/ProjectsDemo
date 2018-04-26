package GUI;

import javax.swing.*;

/**
 * Created by staLker on 23-07-2017.
 */
public class MainFrame {
    private static JFrame frame;
    public static JFrame createFrame(){
        frame = new JFrame("MyVotingMachine");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600,600);
        return frame;
    }

    public static JFrame getFrame() {
        return frame;
    }
}
