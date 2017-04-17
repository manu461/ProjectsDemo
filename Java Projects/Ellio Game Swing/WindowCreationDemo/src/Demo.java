import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by cerebro on 23/11/15.
 */
public class Demo {

    public static void main(String[] args) {

        JFrame jframe1 = new JFrame();
//        jframe1.setSize(800, 800);
        jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jfield = new JTextField();
       //JLabel jlable = new JLabel();







        //add stuff to window here

        Stage2Screen mainPanel = new Stage2Screen();

        mainPanel.setPreferredSize(new Dimension(800, 450));
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();

        mainPanel.addKeyListener(mainPanel);
        mainPanel.addMouseListener(mainPanel);

            jframe1.add(mainPanel);
            mainPanel.add(jfield);
        jfield.setSize(1000,2000);


            jframe1.setResizable(false);
            jframe1.pack();




//        JButton button1 = new JButton("Click Me!");
//        mainPanel.add(button1);
//
//        JButton button2 = new JButton("And me as well!");
//        mainPanel.add(button2);
//
//        JTextField textField1 = new JTextField("enter text here");
//        mainPanel.add(textField1);

        jframe1.setVisible(true);



        int velocityX = 5;
        int velocityY = 5;

        BufferedImage imageD = Stage2Screen.loadImage("duck.png");
        BufferedImage imageJ = Stage2Screen.loadImage("jump.png");
        BufferedImage image1 = Stage2Screen.loadImage("run_anim1.png");
        BufferedImage image2 = Stage2Screen.loadImage("run_anim2.png");
        BufferedImage image3 = Stage2Screen.loadImage("run_anim3.png");
        BufferedImage image4 = Stage2Screen.loadImage("run_anim4.png");
        BufferedImage image5 = Stage2Screen.loadImage("run_anim5.png");
        BufferedImage sun1 = Stage2Screen.loadImage("sun1.png");
        BufferedImage sun2 = Stage2Screen.loadImage("sun2.png");
        BufferedImage sun3 = Stage2Screen.loadImage("sun3.png");
        BufferedImage sun4 = Stage2Screen.loadImage("sun4.png");
        BufferedImage sun5 = Stage2Screen.loadImage("sun5.png");
        BufferedImage sun6 = Stage2Screen.loadImage("sun6.png");
        BufferedImage sun7 = Stage2Screen.loadImage("sun7.png");
        BufferedImage sun8 = Stage2Screen.loadImage("sun8.png");
        BufferedImage sun9 = Stage2Screen.loadImage("sun9.png");
        BufferedImage cloud11  = Stage2Screen.loadImage("cloud11.png");
        BufferedImage cloud12  = Stage2Screen.loadImage("cloud12.png");
        BufferedImage cloud13  = Stage2Screen.loadImage("cloud13.png");
        BufferedImage cloud14  = Stage2Screen.loadImage("cloud14.png");
        BufferedImage cloud21  = Stage2Screen.loadImage("cloud21.png");
        BufferedImage cloud22  = Stage2Screen.loadImage("cloud22.png");
        BufferedImage cloud23  = Stage2Screen.loadImage("cloud23.png");
        BufferedImage cloud24  = Stage2Screen.loadImage("cloud24.png");
        BufferedImage sun10 = Stage2Screen.loadImage("sun10.png");

        BufferedImage playerImages[] = {image1, image2, image3, image4, image5, image4, image3, image2};
        BufferedImage sunImages[] = {sun1,sun1,sun1,sun1,sun1,sun1,sun2,sun2,sun2,sun2,sun2,sun2,sun3,sun3,sun3,sun3,sun3,sun3,sun4,sun4,sun4,sun4,sun4,sun4,sun5,sun5,sun5,sun5,sun5,sun5,sun6,sun6,sun6,sun6,sun6,sun6,sun7,sun7,sun7,sun7,sun7,sun7,sun8,sun8,sun8,sun8,sun8,sun8,sun9,sun9,sun9,sun9,sun9,sun9,sun10,sun10,sun10,sun10,sun10,sun10,sun9,sun9,sun9,sun9,sun9,sun9,sun8,sun8,sun8,sun8,sun8,sun8,sun7,sun7,sun7,sun7,sun7,sun7,sun6,sun6,sun6,sun6,sun6,sun6,sun5,sun5,sun5,sun5,sun5,sun5,sun4,sun4,sun4,sun4,sun4,sun4,sun3,sun3,sun3,sun3,sun3,sun3,sun2,sun2,sun2,sun2,sun2,sun2};
        BufferedImage duckImages[] = {imageD, imageD, imageD};
        BufferedImage jumpImages[] = {imageJ, imageJ, imageJ};
        BufferedImage cloud1Images[] = {cloud11,cloud11,cloud11,cloud11,cloud11,cloud12,cloud12,cloud12,cloud12,cloud12,cloud13,cloud13,cloud13,cloud13,cloud13,cloud14,cloud14,cloud14,cloud14,cloud14,cloud13,cloud13,cloud13,cloud13,cloud13,cloud12,cloud12,cloud12,cloud12,cloud12};
        BufferedImage cloud2Images[] = {cloud21,cloud21,cloud21,cloud21,cloud21,cloud22,cloud22,cloud22,cloud22,cloud22,cloud23,cloud23,cloud23,cloud23,cloud23,cloud24,cloud24,cloud24,cloud24,cloud24,cloud23,cloud23,cloud23,cloud23,cloud23,cloud22,cloud22,cloud22,cloud22,cloud22};


        int count = 0;
        int playerCount = 0;
        int sunCount = 0;
        int cloud1Count = 0;
        int cloud2Count = 0;
        Random generator = new Random();

        while(true) {
            if(mainPanel.closeFrame){
                jframe1.dispose();
            }



            sunCount++;
            sunCount = sunCount % (18*6);
            mainPanel.sunImage = sunImages[sunCount];

            cloud1Count++;
            cloud1Count = cloud1Count % 30;
            mainPanel.cloud1Image = cloud1Images[cloud1Count];

            cloud2Count++;
            cloud2Count = cloud2Count % 30;
            mainPanel.cloud2Image = cloud2Images[cloud2Count];

            if(!mainPanel.isPaused) {

                    count++;

                    count = count % 3;

                    mainPanel.duckImage = duckImages[count];




                        playerCount++;

                       playerCount = playerCount % 8;

                        mainPanel.playerImage = playerImages[playerCount];



                    count++;

                    count = count % 3;

                    mainPanel.jumpImage = jumpImages[count];






                mainPanel.playerVelocityY += mainPanel.playerAccY;
                mainPanel.playerY += mainPanel.playerVelocityY;

                if (mainPanel.playerY >= 450 - 45 - 90) {
                    mainPanel.playerY = 450 - 45 - 90;
                    mainPanel.playerVelocityY = 0;
                    mainPanel.playerAccY = 0;
                }

                if (mainPanel.cloud1X <= -129) {
                    mainPanel.cloud1Y = generator.nextInt(190) + 20 ;
                    mainPanel.cloud1X = 900;
                    mainPanel.cloud1Visible = true;
                }

                if (mainPanel.cloud2X <= -130) {
                    mainPanel.cloud2Y = generator.nextInt(190) + 20;
                    mainPanel.cloud2X = 900;
                    mainPanel.cloud1Visible = true;
                }
                if(mainPanel.block1X <= -2){
                    mainPanel.blockYRandom = generator.nextInt(3);
                    if(mainPanel.blockYRandom == 1)
                    {
                        mainPanel.block1Y = 450-45-85;
                    }
                    else if(mainPanel.blockYRandom == 2)
                    {
                        mainPanel.block1Y = 450-45-50;
                    }
                    else{
                        mainPanel.block1Y = 450-45-125;
                    }
                    mainPanel.block1X =802;
                    mainPanel.block1Visible = true;

                }
                if(mainPanel.block2X <= -2){
                    mainPanel.blockYRandom = generator.nextInt(3);
                    if(mainPanel.blockYRandom == 1)
                    {
                        mainPanel.block2Y = 450-45-85;
                    }
                    else if(mainPanel.blockYRandom == 2)
                    {
                        mainPanel.block2Y = 450-45-50;
                    }
                    else{
                        mainPanel.block2Y = 450-45-125;
                    }
                    mainPanel.block2X =802;
                    mainPanel.block2Visible = true;
                }
                if(mainPanel.block3X <= -2){
                    mainPanel.blockYRandom = generator.nextInt(3);
                    if(mainPanel.blockYRandom == 1)
                    {
                        mainPanel.block3Y = 450-45-85;
                    }
                    else if(mainPanel.blockYRandom == 2)
                    {
                        mainPanel.block3Y = 450-45-50;
                    }
                    else{
                        mainPanel.block3Y = 450-45-125;
                    }
                    mainPanel.block3X =802;
                    mainPanel.block3Visible = true;

                }

                mainPanel.cloud1X -= 3;
                mainPanel.cloud2X -= 3;
                mainPanel.block1X -= 8;
                mainPanel.block2X -= 8;
                mainPanel.block3X -= 8;

                Rectangle playerDRectangle = new Rectangle(mainPanel.playerX,mainPanel.playerY+20,72,45);
                Rectangle playerRectangle = new Rectangle(mainPanel.playerX, mainPanel.playerY, 72, 90);

                Rectangle block1Rectangle = new Rectangle(mainPanel.block1X, mainPanel.block1Y, 20, 50);
                Rectangle block2Rectangle = new Rectangle(mainPanel.block2X, mainPanel.block2Y, 20, 50);
                Rectangle block3Rectangle = new Rectangle(mainPanel.block3X, mainPanel.block3Y, 20, 50);


                    if(playerDRectangle.intersects(block1Rectangle) && mainPanel.isDuck) {
                        mainPanel.block1Visible = false;
                        mainPanel.playerX -= 2;
                    }
                    if(playerDRectangle.intersects(block2Rectangle) && mainPanel.isDuck){
                       mainPanel.block2Visible = false;
                        mainPanel.playerX -= 2;
                    }
                    if(playerDRectangle.intersects(block3Rectangle) && mainPanel.isDuck){
                        mainPanel.block3Visible = false;
                        mainPanel.playerX -= 2;
                    }
                    if(playerRectangle.intersects(block1Rectangle) && (mainPanel.playerVisible||mainPanel.isJump) ) {
                        mainPanel.block1Visible = false;
                        mainPanel.playerX -= 2;
                    }
                    if(playerRectangle.intersects(block2Rectangle) && (mainPanel.playerVisible||mainPanel.isJump)){
                       mainPanel.block2Visible = false;
                       mainPanel.playerX -= 2;
                    }
                    if(playerRectangle.intersects(block3Rectangle) && (mainPanel.playerVisible||mainPanel.isJump)){
                       mainPanel.block3Visible = false;
                       mainPanel.playerX -= 2;
                    }
                if(mainPanel.playerX <= -15){
                    mainPanel.gameOver = true;
                }





            }
            mainPanel.repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
