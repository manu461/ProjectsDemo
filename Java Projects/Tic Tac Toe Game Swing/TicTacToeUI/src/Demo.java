import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by staLker on 26-01-2016.
 */
public class Demo {

    public static void main(String[] args) {
        JFrame jframe1 = new JFrame();
        jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameScreen gamePanel = new GameScreen();

        gamePanel.setPreferredSize(new Dimension(940, 940));

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.addKeyListener(gamePanel);
        gamePanel.addMouseListener(gamePanel);

        jframe1.add(gamePanel);

        jframe1.setResizable(false);
        jframe1.pack();
        jframe1.setVisible(true);
        BufferedImage scrUnP2 = GameScreen.loadImage("screen2.png");
        BufferedImage scrUnP1 = GameScreen.loadImage("screen1.png");


        BufferedImage screenImages[] = {scrUnP1,scrUnP2};
        int counter = 0;
        int count= 0;
        while(true){

                if(gamePanel.isPaused) {
                    counter++;
                    counter = counter % 2;
                    gamePanel.screenUnP = screenImages[counter];
                }


            gamePanel.repaint();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
