import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by staLker on 26-01-2016.
 */
public class GameScreen extends JPanel implements KeyListener,MouseListener {
    BufferedImage screenUnP = GameScreen.loadImage("screen1.png");
    BufferedImage playButton = GameScreen.loadImage("playButton.png");
    BufferedImage xImage = GameScreen.loadImage("X.png");
    BufferedImage oImage = GameScreen.loadImage("O.png");
    BufferedImage currentImage;
    BufferedImage image11;
    BufferedImage image12;
    Boolean editable11 = true;
    Boolean editable12 = true;
    Boolean visible11 = false;
    Boolean visible12 = false;
    int counter = 0;

    BufferedImage tst[];

    public void turn(int t){

        counter++;
        counter  = counter % 2;
        if(counter == 1){
            this.tst[t] = xImage;
        }
        else if(counter == 0){
            this.tst[t] = oImage;
        }

    }

    public boolean isPaused = false;


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(!this.isPaused){
            g.drawImage(screenUnP, 0, 0, 940, 940, null);

            g.drawImage(playButton, 470 - 100, 470 - 50, null);

        }
        else if (this.isPaused) {
            g.drawImage(screenUnP, 0, 0, 940, 940, null);
            if(this.visible11 ){
                //image11 =  currentImage;
                g.drawImage(tst[0], 0, 0, null);

            }
            if(this.visible12 ){
                //image12 = currentImage;
                g.drawImage(tst[1], 320, 0, null);
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=470-100 && e.getX()<=470+100 && e.getY()>=470-50 && e.getY()<=470+50 && !this.isPaused){
            this.isPaused = true;
        }
        if(e.getX()<=300 && e.getY()<=300 && this.isPaused && !this.visible11){
            this.turn(0);
            this.visible11 = true;



        }
        if(e.getX()<=620 && e.getX()>=320 && e.getY()<=300 && this.isPaused && !this.visible12){
            this.turn(1);
            this.visible12 = true;


        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try{
            img = ImageIO.read(GameScreen.class
                .getResourceAsStream("/" + filename));
        } catch (IOException e) {
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
        }

    }

