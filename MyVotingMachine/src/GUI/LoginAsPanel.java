package GUI;

import Listeners.LoginAsListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by staLker on 22-07-2017.
 */
public class LoginAsPanel {
    public static JPanel getPanel(){
        JPanel panel = new JPanel();

        JLabel loginAsLabel = new JLabel("Login As :");
        JButton voterButton = new JButton("Voter");
        JButton electionCommissionButton = new JButton("Election Commission");
        JButton infoButton = new JButton("Info");
        JButton exitButton = new JButton("EXIT");

        JPanel footerPanel = new JPanel();
        footerPanel.add(infoButton);footerPanel.add(exitButton);
        

        JPanel optionPanel = new JPanel();
        optionPanel.add(loginAsLabel);optionPanel.add(voterButton);optionPanel.add(electionCommissionButton);


        panel.add(loginAsLabel);
        panel.add(voterButton);
        panel.add(electionCommissionButton);
        panel.add(infoButton);
        panel.add(exitButton);

        panel.setBounds(0,0,600,600);

        LoginAsListener.listen(voterButton,electionCommissionButton,infoButton,exitButton);

        return panel;
    }
}
