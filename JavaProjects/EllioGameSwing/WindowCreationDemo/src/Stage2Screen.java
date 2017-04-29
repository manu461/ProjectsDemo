import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by cerebro on 23/11/15.
 */
public class Stage2Screen extends JPanel implements KeyListener, MouseListener {
    public int cloud1X = 400;
    public int cloud1Y = 150;
    public int cloud2X = 900;
    public int cloud2Y = 70;

    public int block1X = 560+800+50+50;
    public int block1Y = 450-100;

    public int block3X = 830+800+50+50;
    public int block3Y = 450-45-85;

    public int block2X = 290+800+50+50;
    public int block2Y = 290;

    public int blockYRandom;

    public int flag = 0;
    public int score = 0;
    public int j;


    public int playerVelocityY = 0;
    public int playerAccY = 0;
    public int playerY = 450 - 45 -90;
    public int playerX = 100;


    public int co = 0;
    public int num,p,q,r;
    public int nu[] = {0,0,0,0};


    public boolean cloud1Visible = true;
    public boolean cloud2Visible = true;
    public boolean block1Visible = true;
    public boolean block2Visible = true;
    public boolean block3Visible = true;
    public boolean pauseButtonVisible = false;

    public boolean isPaused = true;
    public boolean isloadPaused = true;
    public boolean isDuck = false;
    public boolean isJump = false;
    public boolean playerVisible = true;
    public boolean isPausedScr = false;
    public boolean gameOver = false;
    public boolean restart = false;

    //BufferedImage playerDuck = Stage2Screen.loadImage("duck.png");
    BufferedImage resume = Stage2Screen.loadImage("resumeButton.png");
    BufferedImage pauseButton = Stage2Screen.loadImage("pauseButton.png");
    BufferedImage mainButton = Stage2Screen.loadImage("MainMenu.png");

    BufferedImage zero = Stage2Screen.loadImage("0.png");
    BufferedImage one = Stage2Screen.loadImage("1.png");
    BufferedImage two = Stage2Screen.loadImage("2.png");
    BufferedImage three = Stage2Screen.loadImage("3.png");
    BufferedImage four = Stage2Screen.loadImage("4.png");
    BufferedImage five = Stage2Screen.loadImage("5.png");
    BufferedImage six = Stage2Screen.loadImage("6.png");
    BufferedImage seven = Stage2Screen.loadImage("7.png");
    BufferedImage eight = Stage2Screen.loadImage("8.png");
    BufferedImage nine = Stage2Screen.loadImage("9.png");



    BufferedImage sunImage = Stage2Screen.loadImage("sun1.png");
    BufferedImage welcomeScr = Stage2Screen.loadImage("welcome.png");
    BufferedImage playerImage = Stage2Screen.loadImage("run_anim1.png");
    BufferedImage jumpImage = Stage2Screen.loadImage("jump.png");
    BufferedImage duckImage = Stage2Screen.loadImage("duck.png");
    BufferedImage blockImage = Stage2Screen.loadImage("block.png");
    BufferedImage grassImage = Stage2Screen.loadImage("grass.png");
    BufferedImage gameOverImage = Stage2Screen.loadImage("gameOver.png");
    BufferedImage gameOver1Image = Stage2Screen.loadImage("gameOver3.png");
    BufferedImage cloud1Image = Stage2Screen.loadImage("cloud11.png");
    BufferedImage cloud2Image = Stage2Screen.loadImage("cloud21.png");
    public Color skyBlueColor = new Color(208, 244, 247);
    public Boolean closeFrame = false;

    @Override
    protected void paintComponent(Graphics g) {



        if(this.gameOver){
            g.setColor(Color.cyan);

            //g.fillRect(400-150,222-175,300,150);

            g.drawImage(gameOverImage,112,120,null);
            g.drawImage(gameOver1Image,400-250,222-125,null);

        }
        else if(this.isPausedScr)
        {


            g.drawImage(resume, 400-50-18, 222-44-20, null);
            g.drawImage(mainButton, 400-36-50,222+20,null);
        }

        else if(!this.isPaused) {
            super.paintComponent(g);


            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 800, 450);





            g.drawImage(sunImage,350,5,null);
            if (this.cloud1Visible) {
                g.drawImage(cloud1Image, cloud1X, cloud1Y, null);
            }
            if (this.cloud2Visible) {
                g.drawImage(cloud2Image, cloud2X, cloud2Y, null);
            }
            if (this.block1Visible) {
                g.drawImage(blockImage, block1X, block1Y, null);
            }
            if (this.block2Visible) {
                g.drawImage(blockImage, block2X, block2Y, null);
            }
            if (this.block3Visible) {
                g.drawImage(blockImage, block3X, block3Y, null);

            }
            if(this.playerVisible){
                g.drawImage(playerImage, playerX, playerY, null);

            }
            else if(this.isJump){
                g.drawImage(jumpImage, playerX, playerY, null);

            }
            else if(this.isDuck){
                g.drawImage(duckImage, playerX, playerY, null);

            }
            g.drawImage(grassImage, 0, 450 - 45, null);
            g.drawImage(pauseButton,800-49-10,10,null);

            /*while(co <= 9999)
            {
                q=co;

                p=3;
                for(p=3;q!=0;q=q/10){
                    num = q%10;
                    nu[p] = num;
                    p--;


                }
                    if(nu[0]==0) {
                        g.drawImage(zero, 10, 10, null);
                    }
                if(nu[0]==1){
                    g.drawImage(one,10,10,null);
                }
                if(nu[0]==2){
                    g.drawImage(two,10,10,null);
                }
                if(nu[0]==3){
                    g.drawImage(three,10,10,null);
                }
                if(nu[0]==4){
                    g.drawImage(four,10,10,null);
                }
                if(nu[0]==5){
                    g.drawImage(five,10,10,null);
                }
                if(nu[0]==6){
                    g.drawImage(six,10,10,null);
                }
                if(nu[0]==7){
                    g.drawImage(seven,10,10,null);
                }
                if(nu[0]==8){
                    g.drawImage(eight,10,10,null);
                }
                if(nu[0]==9){
                    g.drawImage(nine,10,10,null);
                }



                for(r=0;r<90000000;r++){


                }
                co++;



            }*/


        }
        else if(this.isPaused){

            g.drawImage(welcomeScr,0,0,800,450,null);

            

        }

    }


    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Stage2Screen.class
                    .getResourceAsStream("/" + filename));
        } catch (IOException e) {
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W && this.playerY >= 450 - 45 -90) {
            this.isJump = true;
            this.playerVisible=false;
            this.playerVelocityY = -18;
            this.playerAccY = 1;


        }
        else if(e.getKeyCode() == KeyEvent.VK_S && this.isJump){
            this.isDuck = true;
            this.playerVisible = false;

            if(this.isJump){
                this.playerVelocityY = 18;
                this.playerAccY = 0;

            }
            this.isJump = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            this.isDuck = true;
            this.playerVisible = false;

        }
        else {
            System.out.println("some other key pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_S ){
            this.isDuck = false;
            this.playerVisible = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W  && this.playerY >= 450 - 45 -120){
            this.isJump = false;
            this.playerVisible = true;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getX() > 800-49-10 && e.getY() < 10+49 && !this.isPaused) {
            this.isPaused = !this.isPaused;
            this.isPausedScr = true;
        }
        if(e.getX() > 374 && e.getX() < (374+108) && e.getY() > 245 && e.getY() < (245+35) && !(this.isPausedScr)){
            this.isPaused = false;
        }
        if(e.getX() > 374 && e.getX() < (374+108) && e.getY() > (245+35+19) && e.getY() < (245+35+19+33) && this.isPaused && !this.isPausedScr ){
            this.closeFrame = true;
        }
        if(e.getX() > 400-50-18 && e.getX() < 400+50+18 && e.getY() > 222-44-20 && e.getY() < 222-20 && this.isPausedScr){
            this.isPausedScr = false;
            this.isPaused = false;
        }
        if(e.getX() > 400-36-50 && e.getX()<400+36+50 && e.getY() > 222+20 && e.getY()< 222+20+44 && this.isPausedScr){
            this.isPaused = true;
            this.isPausedScr = false;
            this.restart = true;

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
}
