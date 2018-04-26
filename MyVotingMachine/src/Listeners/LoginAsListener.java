package Listeners;

import Controllers.LoginAsController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by staLker on 23-07-2017.
 */
public class LoginAsListener {
    public static void listen(JButton voterButton, JButton electionCommissionButton, JButton infoButton, JButton exitButton){
        LoginAsController controller = new LoginAsController(voterButton,electionCommissionButton,infoButton,exitButton);
        voterButton.addActionListener(controller::control);
        electionCommissionButton.addActionListener(controller::control);
        infoButton.addActionListener(controller::control);
        exitButton.addActionListener(controller::control);

    }
}
