package Controllers;

import GUI.MainFrame;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by staLker on 23-07-2017.
 */
public class LoginAsController {
    private JButton exitButton;
    private JButton infoButton;
    private JButton voterButton;
    private JButton electionCommissionButton;
    private JFrame jFrame;

    public void control(ActionEvent e) {
        jFrame = MainFrame.getFrame();
        if(e.getSource().equals(voterButton)){
            System.out.println("it works show voter panel");
        }
        else if(e.getSource().equals(electionCommissionButton)){
            System.out.println("it works show admin panel");
        }
        else if(e.getSource().equals(infoButton)){
            System.out.println("it works show info panel");
        }
        else if(e.getSource().equals(exitButton)){
            jFrame.dispose();
        }
    }

    public LoginAsController(JButton voterButton, JButton electionCommissionButton, JButton infoButton, JButton exitButton) {
        this.voterButton = voterButton;
        this.electionCommissionButton = electionCommissionButton;
        this.infoButton = infoButton;
        this.exitButton = exitButton;
    }
}
