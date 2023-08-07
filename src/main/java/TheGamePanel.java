
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class TheGamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);//=1664
    final int DELAY =  Math.abs((int)(Double.parseDouble(getPropValue("Speed")))-200);  // 1 --> 200
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts ;
    boolean Open = true;
    int Door = 0;
    int applesEaten;
    int Lives ;
    int appleX;
    int appleY;
    int livesX;
    int livesY;
    boolean giveLiveChance = false;
    int ChanceAppear=15+ applesEaten;
    char direction = 'R';
    char ladirection = 'R';
    boolean running = false;
    String Level = "Medium";
    String Mode = "Forest";
    String Border = "On" ;
    Color bodyColor ;
    Color ObstacleColor;

    // Obstacles Declaration
    int[] ObstaclesX1 = {50,50,500,500,75,75};
    int[] ObstaclesY1 = {150,100,100,125,125,150};
    Polygon P1= new Polygon(ObstaclesX1,ObstaclesY1,6);
    int[] ObstaclesX2 = {800,800,1250,1250,1225,1225};
    int[] ObstaclesY2 = {125,100,100,250,250,125};
    Polygon P2 = new Polygon(ObstaclesX2,ObstaclesY2,6);
    int[] ObstaclesX3 = {1250,1250,1200,1200,1225,1225};
    int[] ObstaclesY3 = {300,700,700,675,675,300};
    Polygon P3 = new Polygon(ObstaclesX3,ObstaclesY3,6);
    int[] ObstaclesX4 = {1150,1150,725,725};
    int[] ObstaclesY4 = {700,675,675,700};
    Polygon P4 = new Polygon(ObstaclesX4,ObstaclesY4,4);
    int[] ObstaclesX5 = {550,550,75,75,50,50};
    int[] ObstaclesY5 = {700,675,675,350,350,700};
    Polygon P5 = new Polygon(ObstaclesX5,ObstaclesY5,6);
    int[] ObstaclesX6 = {100,400,400,250,250,100,100,275,275,375,375,100};
    int[] ObstaclesY6 = {150,150,525,525,275,275,250,250,500,500,175,175};
    Polygon P6 = new Polygon(ObstaclesX6,ObstaclesY6,12);
    int[] ObstaclesX7 = {1200,1200,1000,1000,1100,1100};
    int[] ObstaclesY7 = {250,225,225,275,275,250};
    Polygon P7 = new Polygon(ObstaclesX7,ObstaclesY7,6);
    int[] ObstaclesX8 ={1200,1200,1025,1025,1000,1000,1050,1050};
    int[] ObstaclesY8 ={375,400,400,350,350,325,325,375};
    Polygon P8 = new Polygon(ObstaclesX8,ObstaclesY8,8);
    int[] ObstaclesX9 ={725,725,550,550};
    int[] ObstaclesY9 ={550,575,575,550};
    Polygon P9 = new Polygon(ObstaclesX9,ObstaclesY9,4);
    int[] ObstaclesX10 ={500,500,500,500};
    int[] ObstaclesY10 ={100,100,125,125};
    Polygon P10 ;
    int[] ObstaclesX11 = {175,75,75,175,175,50,50,150,150,50,50,175};
    int[] ObstaclesY11 = {100,100,175,175,300,300,275,275,200,200,75,75};
    Polygon P11= new Polygon(ObstaclesX11,ObstaclesY11,12);
    int[] ObstaclesX12 = {550,550,725,725,700,700,575,575};
    int[] ObstaclesY12 = {300,75,75,300,300,100,100,300};
    Polygon P12= new Polygon(ObstaclesX12,ObstaclesY12,8);
    int[] ObstaclesX13 = {800,800,950,950,900,950,925,875,925,925,825,825};
    int[] ObstaclesY13 = {300,75,75,175,175,300,300,150,150,100,100,300};
    Polygon P13= new Polygon(ObstaclesX13,ObstaclesY13,12);
    int[] ObstaclesX14 = {200,50,50,200,200,75,75,200};
    int[] ObstaclesY14 = {450,450,600,600,575,575,475,475};
    Polygon P14= new Polygon(ObstaclesX14,ObstaclesY14,8);
    int[] ObstaclesX15 = {875,1000,1000,875};
    int[] ObstaclesY15 = {450,575,600,475};
    Polygon P15= new Polygon(ObstaclesX15,ObstaclesY15,4);
    int[] ObstaclesX16 = {1250,1075,1075,1250,1250,1150,1150,1175,1175,1225,1225,1100,1100,1250};
    int[] ObstaclesY16 = {450,450,600,600,500,500,550,550,525,525,575,575,475,475};
    Polygon P16= new Polygon(ObstaclesX16,ObstaclesY16,14);

    int seconds = 10;
    boolean LivesisDrawed=false;
    Timer MyTimer;
    Timer OpeningDoor;
    Timer mytimer= new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
        }});
    Random random;
    File audioStream ;
    AudioInputStream audios;
    Clip clip;
    File GameOverFile ;
    AudioInputStream GameOverStream;
    Clip GameOver;
    BufferedImage BackgroundImage ;
    BufferedImage RightImage ;
    BufferedImage LeftImage ;
    BufferedImage UpImage ;
    BufferedImage DownImage ;
    BufferedImage BodyImage ;
    BufferedImage AppleImage ;
    BufferedImage LivesImage ;
    static boolean paused = false;



    public TheGamePanel(int applesEtean ,int Lives  ) {
        this.bodyParts = applesEtean + 6;
        this.applesEaten = applesEtean;
        this.Lives = Lives;

        if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("Play-Music").equalsIgnoreCase("true")){
            try{

                audioStream = new File("src/main/audio/audio3.wav");
                audios = AudioSystem.getAudioInputStream(audioStream);
                clip = AudioSystem.getClip();
                clip.open(audios);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-30.0f);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            catch(Exception ex){
                System.out.println("i'm sorry");
            }}
        random = new Random();





        requestFocusInWindow();
        startGame();
        this.addKeyListener(new MyKeyAdapter());
        this.setFocusable(true);
    }

    public void startGame() {


        try {
            Level = getPropValue("Level");
            Mode = getPropValue("Mode");
            Border = getPropValue("Border");

            if("Forest".equals(Mode)){

                BackgroundImage = ImageIO.read(new File("src/main/images/Forest-background-2.jpg"));
                RightImage = ImageIO.read(new File("src/main/images/head/rightmouth ForestMode.png"));
                LeftImage = ImageIO.read(new File("src/main/images/head/leftmouth ForestMode.png"));
                UpImage = ImageIO.read(new File("src/main/images/head/upmouth ForestMode.png"));
                DownImage = ImageIO.read(new File("src/main/images/head/downmouth ForestMode.png"));
                bodyColor = new Color(54, 245, 10) ; //new Color(4,167,108);
                ObstacleColor =   new Color(159, 212, 155 );// new Color(24, 77, 23);

            }else if("Desert".equals(Mode)){

                BackgroundImage = ImageIO.read(new File("src/main/images/Desert-Background.jpg"));
                RightImage = ImageIO.read(new File("src/main/images/head/rightmouth DesertMode.png"));
                LeftImage = ImageIO.read(new File("src/main/images/head/leftmouth DesertMode.png"));
                UpImage = ImageIO.read(new File("src/main/images/head/upmouth DesertMode.png"));
                DownImage = ImageIO.read(new File("src/main/images/head/downmouth DesertMode.png"));
                bodyColor =  new Color(255,255, 0) ; //new Color(253,179,5);
                ObstacleColor = new Color(105, 102, 83);

            }else if ("Ocean".equals(Mode)){

                BackgroundImage = ImageIO.read(new File("src/main/images/Ocan-background.jpg"));
                RightImage = ImageIO.read(new File("src/main/images/head/rightmouth OceanMode.png"));
                LeftImage = ImageIO.read(new File("src/main/images/head/leftmouth OceanMode.png"));
                UpImage = ImageIO.read(new File("src/main/images/head/upmouth OceanMode.png"));
                DownImage = ImageIO.read(new File("src/main/images/head/downmouth OceanMode.png"));
                bodyColor =  new Color(1,174,237);
                ObstacleColor = new Color(109, 134, 140);

            }else{
                BackgroundImage = ImageIO.read(new File("src/main/images/space_background.jpeg"));
                RightImage = ImageIO.read(new File("src/main/images/head/rightmouth SpaceMode.png"));
                LeftImage = ImageIO.read(new File("src/main/images/head/leftmouth SpaceMode.png"));
                UpImage = ImageIO.read(new File("src/main/images/head/upmouth SpaceMode.png"));
                DownImage = ImageIO.read(new File("src/main/images/head/downmouth SpaceMode.png"));
                bodyColor = new Color(0, 4, 255); //new Color(2,35,129);
                ObstacleColor = new Color(94, 102, 140);

            }

            AppleImage = ImageIO.read(new File("src/main/images/fruit.png"));
            LivesImage = ImageIO.read(new File("src/main/images/star.png"));
        } catch (IOException ex) {
            System.out.println("it's not working");
        }

        running = true;

        MyTimer = new Timer(DELAY,this);

        MyTimer.start();
        if("Professional".equals(Level)){
            OpeningDoor = new Timer(150,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Door <= 0){ Open = true; }
                    if(Open){
                        Door = Door+3;
                        ObstaclesX10[1]= ObstaclesX10[1]+3;
                        ObstaclesX10[2]= ObstaclesX10[2]+3;
                    }
                    if(Door > 300){ Open = false; }
                    if(!Open){
                        Door= Door-3;
                        ObstaclesX10[1]= ObstaclesX10[1]-3;
                        ObstaclesX10[2]= ObstaclesX10[2]-3;
                    }
                }
            });
            OpeningDoor.start();
        }
        newApple();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if(paused){
            drawpause(g);
        }else{
            if("Easy".equals(Level)){
                drawEasy(g);
                if(running) drawSnake(g);
                else GameOver(g);
            }
            else if("Medium".equals(Level)) drawMedium(g);
            else if("Hard".equals(Level)) drawHard(g);
            else if("Professional".equals(Level)) drawProfessional(g);
            else if("Suicide".equals(Level)) drawSuicide(g);

        }

    }

    public void drawSnake(Graphics g){

        for(int i = 0; i< bodyParts;i++) {

            if(i == 0) {
                if(direction == 'R'){
                    g.drawImage(RightImage, x[i], y[i]+50, null);
                }else if(direction =='L'){
                    g.drawImage(LeftImage, x[i], y[i]+50, null);
                }else if (direction=='U'){
                    g.drawImage(UpImage, x[i], y[i]+50, null);
                }else{
                    g.drawImage(DownImage, x[i], y[i]+50, null);
                }




            }

            else {


                GradientPaint paint;



                if(x[i]>650){
                    paint = new GradientPaint(650,0,bodyColor,1300,0,new Color(0,0,0,150));
                }else{
                    paint = new GradientPaint(0,0,new Color(0,0,0,100),650,0, bodyColor);
                }
                g.setColor(bodyColor);
                //g2D.setPaint(paint);
                g.fillOval(x[i], y[i]+50, UNIT_SIZE, UNIT_SIZE);

            }

        }


    }

    public void drawEasy(Graphics g){


        g.setColor(new Color(0, 20, 36));
        g.fillRect(0, 0, 1300, 50);
        g.drawImage(BackgroundImage, 0, 50, null);
        g.setColor(Color.WHITE);
        g.drawLine(1, 50, 1300, 50);
        g.drawLine(1, 50, 1, 749);
        g.drawLine(1, 749, 1300, 749);
        g.drawLine(1300, 50, 1300, 749);


        g.setColor(Color.red);

        g.setFont( new Font("Ink Free",Font.BOLD, 40));

        FontMetrics metrics = getFontMetrics(g.getFont());

        g.drawString("Score: "+applesEaten , (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        g.setColor(Color.YELLOW);
        g.drawString("Lives: "+Lives, (SCREEN_WIDTH - metrics.stringWidth("Score: "+Lives)), g.getFont().getSize());
        g.drawImage(AppleImage, appleX, appleY, null);
        if(giveLiveChance){
            if(seconds>0){
                g.setColor(Color.BLUE);
                g.drawImage(LivesImage, livesX, livesY, null);
            } else {
                mytimer.stop();
                LivesisDrawed = false;
            }

        }

    }

    public void drawMedium(Graphics g){
        drawEasy(g);

        g.setColor(ObstacleColor);

        g.fillRect(100,225,25, 350);

        g.fillRect(1200,225,25, 350);

        g.fillRect(850,100,400, 25);

        g.fillRect(100,100,400, 25);

        g.fillRect(100,700,400, 25);

        g.fillRect(475, 400, 400, 25);

        g.fillRect(800,700,400, 25);

        if(running) {

            drawSnake(g);
        }

        else {

            GameOver(g);

        }
    }

    public void drawHard(Graphics g){
        drawEasy(g);
        g.setColor(ObstacleColor);
        g.fillPolygon(P11);
        g.fillPolygon(P12);
        g.fillPolygon(P13);
        g.fillPolygon(P14);
        g.fillPolygon(P15);
        g.fillPolygon(P16);
        g.fillRect(250, 75, 225, 25);
        g.fillRect(350, 100, 25, 200);
        g.fillRect(600, 200, 75, 25);
        g.fillRect(1025, 75, 225, 25);
        g.fillRect(1125, 100, 25, 200);
        g.fillOval(250, 450, 200, 150);
        g.fillRect(525, 450, 125, 25);
        g.fillRect(525, 450, 25, 150);
        g.fillRect(650, 450, 25, 150);
        g.fillRect(525, 575, 125, 25);
        g.fillRect(750, 450, 25, 150);
        g.fillRect(850, 450, 25, 150);
        g.fillRect(1000, 450, 25, 150);
        g.drawRoundRect(275, 320, UNIT_SIZE/2, 35 , 150, 90);
        g.fillRoundRect(755, 370, UNIT_SIZE/2, 35 , 150, 90);

        if(running) {

            drawSnake(g);
        }

        else {

            GameOver(g);

        }


    }

    public void drawProfessional(Graphics g) {
        // created by Bakir
        drawEasy(g);

        g.setColor(ObstacleColor);
        g.fillPolygon(P1);
        g.fillPolygon(P2);
        g.fillPolygon(P3);
        g.fillPolygon(P4);
        g.fillPolygon(P5);
        g.fillPolygon(P6);
        g.fillPolygon(P7);
        g.fillPolygon(P8);
        g.fillPolygon(P9);
        g.setColor(new Color(143, 186, 134));
        P10 = new Polygon(ObstaclesX10,ObstaclesY10,4);
        g.fillPolygon(P10);





        if(running) {

            drawSnake(g);
        }

        else {

            GameOver(g);

        }


    }

    public void drawSuicide(Graphics g){

        drawEasy(g);


        g.setColor(ObstacleColor);
        g.fillRect(150,100,1000,25);
        g.fillRect(150,550,1000,25);
        g.fillRect(1150,100,25,375);
        g.fillRect(150,350,25,225);
        g.fillRect(250,200,225,25);
        g.fillRect(250,200,25,200);
        g.fillRect(800,200,200,25);
        g.fillRect(1000,200,25,200);
        g.fillRect(700,575,25,200);
        g.fillRect(550,575,25,200);
        g.fillRect(500,450,25,125);
        g.fillRect(150,150,200,25);
        g.fillRect(375,125,25,75);
        g.fillRect(150,175,25,175);
        g.fillRect(200,200,50,25);
        g.fillRect(175,250,50,25);
        g.fillRect(200,300,25,225);
        g.fillRect(500,200,275,25);
        g.fillRect(925,150,200,25);
        g.fillRect(225,450,75,25);
        g.fillRect(325,225,25,150);
        g.fillRect(425,450,100,25);
        g.fillRect(425,275,25,175);
        g.fillRect(500,200,25,175);
        g.fillRect(500,350,100,25);
        g.fillRect(600,300,25,200);
        g.fillRect(700,300,25,250);
        g.fillRect(825,300,25,175);
        g.fillRect(825,300,100,25);
        g.fillRect(825,450,100,25);
        g.fillRect(1000,450,100,25);
        g.fillRect(1100,450,25,100);
        g.fillRect(1075,225,25,175);
        g.fillRect(825,375,200,25);

        if(running) {

            drawSnake(g);
        }

        else {

            GameOver(g);

        }
    }

    public void drawpause(Graphics g){
        g.setColor(new Color(0, 20, 36));
        g.fillRect(0, 0, 1300, 50);
        g.drawImage(BackgroundImage, 0, 50, null);
        g.setColor(new Color(0,0,0,150));
        g.fillRect(0, 50, 1300, 800);
        g.setColor(new Color(255,255,255));
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten , (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        g.setColor(Color.WHITE);
        g.setFont( new Font("Ink Free",Font.BOLD, 48));
        g.drawString("PRESS SPACE OR ENTER TO START...", 185, 350);
    }

    public void newApple(){

        // new apple in Easy Level
        if("Easy".equals(Level)){

            appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            appleY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
        }
        // new apple in Medium Level
        else if( "Medium".equals(Level)) {
            do{
                appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                appleY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((appleX > 75 && appleX < 125 && appleY > 200 && appleY < 575)  || (appleX > 1175 && appleX < 1225 && appleY > 200 && appleY < 575)|| (appleX > 825 && appleX < 1250 && appleY > 75 && appleY < 125)
                    || (appleX > 75 && appleX < 500 && appleY > 75 && appleY < 125)   || (appleX > 75 && appleX < 500 && appleY > 675 && appleY < 725)
                    || (appleX > 450 && appleX < 875 && appleY > 375 && appleY < 425) || (appleX > 775 && appleX < 1200 && appleY > 675 && appleY < 725));

        }
        // new apple in Hard Level
        else if( "Hard".equals(Level)) {
            do{
                appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                appleY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
            }while(P11.contains(appleX,appleY) || P12.contains(appleX,appleY) || P13.contains(appleX,appleY)
                    || P14.contains(appleX,appleY) || P15.contains(appleX,appleY)|| P16.contains(appleX,appleY)
                    ||(appleX > 225 && appleX < 475 && appleY > 50 && appleY < 100)   || (appleX > 325 && appleX < 375 && appleY > 75 && appleY < 300)  || (appleX > 575 && appleX < 675 && appleY > 175 && appleY < 225)
                    || (appleX > 1000 && appleX < 1250 && appleY > 50 && appleY < 100)|| (appleX > 1100 && appleX < 1150 && appleY > 75 && appleY < 300)|| (appleX > 500 && appleX < 650 && appleY > 425 && appleY < 475)
                    || (appleX > 500 && appleX < 550 && appleY > 425 && appleY < 600) || (appleX > 625 && appleX < 675 && appleY > 425 && appleY < 600) || (appleX > 500 && appleX < 650 && appleY > 550 && appleY < 600)
                    || (appleX > 725 && appleX < 775 && appleY > 425 && appleY < 600) || (appleX > 825 && appleX < 875 && appleY > 425 && appleY < 600)
                    || (appleX > 975 && appleX < 1025 && appleY > 425 && appleY < 600)||(appleX > 225 && appleX < 450 && appleY > 450 && appleY < 575));

        }
        // new apple in Professional Level
        else if("Professional".equals(Level)){
            do{
                appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                appleY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((appleX==0 && appleY==50)||P1.contains(appleX,appleY)||P2.contains(appleX,appleY)||P3.contains(appleX,appleY)||P4.contains(appleX,appleY)
                    ||P5.contains(appleX,appleY)||P6.contains(appleX,appleY)||P7.contains(appleX,appleY)||P8.contains(appleX,appleY)||P9.contains(appleX,appleY));

        }
        // new apple in Suicide Level
        else {
            do{
                appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                appleY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((appleX > 125 && appleX < 1150 && appleY > 75 && appleY < 125)    || (appleX > 125 && appleX < 1150 && appleY > 525 && appleY < 575) ||(appleX > 1125 && appleX < 1175 && appleY > 75 && appleY < 475)
                    ||(appleX > 125 && appleX < 175 && appleY > 325 && appleY < 575)  || (appleX > 225 && appleX < 475 && appleY > 175 && appleY < 225)  || (appleX > 225 && appleX < 275 && appleY > 175 && appleY < 400)
                    ||(appleX > 775 && appleX < 1000 && appleY > 175 && appleY < 225) || (appleX > 975 && appleX < 1025 && appleY > 175 && appleY < 400) || (appleX > 675 && appleX < 725 && appleY > 550 && appleY < 775)
                    ||(appleX > 525 && appleX < 575 && appleY > 550 && appleY < 775)  || (appleX > 475 && appleX < 525 && appleY > 425 && appleY < 575)  || (appleX > 125 && appleX < 350 && appleY > 125 && appleY < 175)
                    ||(appleX > 350 && appleX < 400 && appleY > 100 && appleY < 200)  || (appleX > 125 && appleX < 175 && appleY > 150 && appleY < 350)  || (appleX > 175 && appleX < 250 && appleY > 175 && appleY < 225)
                    ||(appleX > 150 && appleX < 225 && appleY > 225 && appleY < 275)  || (appleX > 175 && appleX < 225 && appleY > 275 && appleY < 525)  || (appleX > 475 && appleX < 775 && appleY > 175 && appleY < 225)
                    ||(appleX > 900 && appleX < 1125 && appleY > 125 && appleY < 175) || (appleX > 200 && appleX < 300 && appleY > 425 && appleY < 475)  || (appleX > 300 && appleX < 350 && appleY > 200 && appleY < 375)
                    ||(appleX > 400 && appleX < 525 && appleY > 425 && appleY < 475)  || (appleX > 400 && appleX < 450 && appleY > 250 && appleY < 450)  || (appleX > 475 && appleX < 525 && appleY > 175 && appleY < 375)
                    ||(appleX > 475 && appleX < 600 && appleY > 325 && appleY < 375)  || (appleX > 575 && appleX < 625 && appleY > 275 && appleY < 500)  || (appleX > 675 && appleX < 725 && appleY > 275 && appleY < 550)
                    ||(appleX > 800 && appleX < 850 && appleY > 275 && appleY < 475)  || (appleX > 800 && appleX < 925 && appleY > 275 && appleY < 325)  || (appleX > 800 && appleX < 925 && appleY > 425 && appleY < 475)
                    ||(appleX > 975 && appleX < 1100 && appleY > 425 && appleY < 475) || (appleX > 1075 && appleX < 1125 && appleY > 425 && appleY < 550)
                    ||(appleX > 1050 && appleX < 1100 && appleY > 200 && appleY < 400)|| (appleX > 800 && appleX < 1025 && appleY > 350 && appleY < 400));

        }
    }

    public void newlives(){


        // new apple in Easy Level
        if("Easy".equals(Level)){
            do{
                livesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                livesY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
            }while(appleX==livesX && appleY==livesY);
        }
        // new apple in Medium Level
        else if( "Medium".equals(Level)) {
            do{
                livesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                livesY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((livesX > 75 && livesX < 125 && livesY > 200 && livesY < 575)  || (livesX > 1175 && livesX < 1225 && livesY > 200 && livesY < 575)|| (livesX > 825 && livesX < 1250 && livesY > 75 && livesY < 125)
                    || (livesX > 75 && livesX < 500 && livesY > 75 && livesY < 125)   || (livesX > 75 && livesX < 500 && livesY > 675 && livesY < 725)
                    || (livesX > 450 && livesX < 875 && livesY > 375 && livesY < 425) || (livesX > 775 && livesX < 1200 && livesY > 675 && livesY < 725)||(appleX==livesX && appleY==livesY));

        }
        // new apple in Hard Level
        else if( "Hard".equals(Level)) {
            do{
                livesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                livesY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
            }while(P11.contains(livesX,livesY) || P12.contains(livesX,livesY) || P13.contains(livesX,livesY)
                    || P14.contains(livesX,livesY) || P15.contains(livesX,livesY)|| P16.contains(livesX,livesY)
                    ||(livesX > 225 && livesX < 475 && livesY > 50 && livesY < 100)   || (livesX > 325 && livesX < 375 && livesY > 75 && livesY < 300)  || (livesX > 575 && livesX < 675 && livesY > 175 && livesY < 225)
                    || (livesX > 1000 && livesX < 1250 && livesY > 50 && livesY < 100)|| (livesX > 1100 && livesX < 1150 && livesY > 75 && livesY < 300)|| (livesX > 500 && livesX < 650 && livesY > 425 && livesY < 475)
                    || (livesX > 500 && livesX < 550 && livesY > 425 && livesY < 600) || (livesX > 625 && livesX < 675 && livesY > 425 && livesY < 600) || (livesX > 500 && livesX < 650 && livesY > 550 && livesY < 600)
                    || (livesX > 725 && livesX < 775 && livesY > 425 && livesY < 600) || (livesX > 825 && livesX < 875 && livesY > 425 && livesY < 600)
                    || (livesX > 975 && livesX < 1025 && livesY > 425 && livesY < 600)||(livesX > 225 && livesX < 450 && livesY > 450 && livesY < 575)||(appleX==livesX && appleY==livesY));

        }
        // new apple in Professional Level
        else if("Professional".equals(Level)){
            do{
                livesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                livesY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((livesX==0 && livesY==50)||P1.contains(livesX,livesY)||P2.contains(livesX,livesY)||P3.contains(livesX,livesY)||P4.contains(livesX,livesY)
                    ||P5.contains(livesX,livesY)||P6.contains(livesX,livesY)||P7.contains(livesX,livesY)||P8.contains(livesX,livesY)||P9.contains(livesX,livesY)||(appleX==livesX && appleY==livesY));

        }
        // new apple in Suicide Level
        else {
            do{
                livesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                livesY = ThreadLocalRandom.current().nextInt((int)(50/UNIT_SIZE),(int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

            }while((livesX > 125 && livesX < 1150 && livesY > 75 && livesY < 125)    || (livesX > 125 && livesX < 1150 && livesY > 525 && livesY < 575) ||(livesX > 1125 && livesX < 1175 && livesY > 75 && livesY < 475)
                    ||(livesX > 125 && livesX < 175 && livesY > 325 && livesY < 575)  || (livesX > 225 && livesX < 475 && livesY > 175 && livesY < 225)  || (livesX > 225 && livesX < 275 && livesY > 175 && livesY < 400)
                    ||(livesX > 775 && livesX < 1000 && livesY > 175 && livesY < 225) || (livesX > 975 && livesX < 1025 && livesY > 175 && livesY < 400) || (livesX > 675 && livesX < 725 && livesY > 550 && livesY < 775)
                    ||(livesX > 525 && livesX < 575 && livesY > 550 && livesY < 775)  || (livesX > 475 && livesX < 525 && livesY > 425 && livesY < 575)  || (livesX > 125 && livesX < 350 && livesY > 125 && livesY < 175)
                    ||(livesX > 350 && livesX < 400 && livesY > 100 && livesY < 200)  || (livesX > 125 && livesX < 175 && livesY > 150 && livesY < 350)  || (livesX > 175 && livesX < 250 && livesY > 175 && livesY < 225)
                    ||(livesX > 150 && livesX < 225 && livesY > 225 && livesY < 275)  || (livesX > 175 && livesX < 225 && livesY > 275 && livesY < 525)  || (livesX > 475 && livesX < 775 && livesY > 175 && livesY < 225)
                    ||(livesX > 900 && livesX < 1125 && livesY > 125 && livesY < 175) || (livesX > 200 && livesX < 300 && livesY > 425 && livesY < 475)  || (livesX > 300 && livesX < 350 && livesY > 200 && livesY < 375)
                    ||(livesX > 400 && livesX < 525 && livesY > 425 && livesY < 475)  || (livesX > 400 && livesX < 450 && livesY > 250 && livesY < 450)  || (livesX > 475 && livesX < 525 && livesY > 175 && livesY < 375)
                    ||(livesX > 475 && livesX < 600 && livesY > 325 && livesY < 375)  || (livesX > 575 && livesX < 625 && livesY > 275 && livesY < 500)  || (livesX > 675 && livesX < 725 && livesY > 275 && livesY < 550)
                    ||(livesX > 800 && livesX < 850 && livesY > 275 && livesY < 475)  || (livesX > 800 && livesX < 925 && livesY > 275 && livesY < 325)  || (livesX > 800 && livesX < 925 && livesY > 425 && livesY < 475)
                    ||(livesX > 975 && livesX < 1100 && livesY > 425 && livesY < 475) || (livesX > 1075 && livesX < 1125 && livesY > 425 && livesY < 550)
                    ||(livesX > 1050 && livesX < 1100 && livesY > 200 && livesY < 400)|| (livesX > 800 && livesX < 1025 && livesY > 350 && livesY < 400)||(appleX==livesX && appleY==livesY));

        }
    }


    public void move(){
        direction = ladirection ;
        for(int i = bodyParts;i>0;i--) {

            x[i] = x[i-1];

            y[i] = y[i-1];

        }

        switch(direction) {

            case 'U':

                y[0] = y[0] - UNIT_SIZE;

                break;

            case 'D':

                y[0] = y[0] + UNIT_SIZE;

                break;

            case 'L':

                x[0] = x[0] - UNIT_SIZE;

                break;

            case 'R':

                x[0] = x[0] + UNIT_SIZE;

                break;

        }

    }

    public void checkApple() {

        if((x[0] == appleX ) && (y[0]+50 == appleY )) {

            bodyParts++;

            applesEaten++;

            liveChance();
            newApple();

        }

    }

    public void checkLives() {

        if((x[0] == livesX ) && (y[0]+50 == livesY ) && LivesisDrawed) {
            if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("Play-Music").equalsIgnoreCase("true")){
                try{
                    GameOverFile = new File("src/main/audio/LivesEaten.wav");
                    GameOverStream = AudioSystem.getAudioInputStream(GameOverFile);
                    GameOver = AudioSystem.getClip();
                    GameOver.open(GameOverStream);
                    FloatControl gainControl = (FloatControl) GameOver.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-30.0f);
                    GameOver.start();

                }
                catch(Exception ex){
                    System.out.println("i'm sorry");
                }
            }
            Lives++;
            giveLiveChance = false;

        }

    }

    public void liveChance(){
        int liveChance;

        liveChance = ThreadLocalRandom.current().nextInt(0,ChanceAppear);
        if(liveChance==10){
            giveLiveChance = true;
            ChanceAppear = ChanceAppear + applesEaten;
            seconds=10;
            if(!LivesisDrawed)
                newlives();
            LivesisDrawed = true;
            mytimer.start();
        }
    }

    public void checkCollisions() {

        //checks if head collides with body

        for(int i = bodyParts;i>0;i--) {

            if((x[0] == x[i])&& (y[0] == y[i])) {

                running = false;
            }

        }

        //check if head touches left border

        if(x[0] < 0) {
            if("ON".equals(Border)){
                running = false;
            }else{
                x[0] = SCREEN_WIDTH - UNIT_SIZE;
            }
        }

        //check if head touches right border

        if((x[0]+UNIT_SIZE) > SCREEN_WIDTH) {
            if("ON".equals(Border)){
                running = false;
            }else{
                x[0] = 0;
            }

        }

        //check if head touches top border

        if(y[0] < 0) {
            if("ON".equals(Border)){
                running = false;
            }else{
                y[0] = SCREEN_HEIGHT- 50 - UNIT_SIZE;
            }

        }

        //check if head touches bottom border

        if((y[0]+UNIT_SIZE) > (SCREEN_HEIGHT-50)) {
            if("ON".equals(Border)){
                running = false;
            }else{
                y[0] = 0;
            }
        }


        //check if head touches any  MediumObstacle
        if( "Medium".equals(Level)) {

            if((x[0] > 75 && x[0] < 125 && y[0]+50 > 200 && y[0]+50 < 575)  || (x[0] > 1175 && x[0] < 1225 && y[0]+50 > 200 && y[0]+50 < 575) || (x[0] > 825 && x[0] < 1250 && y[0]+50 > 75 && y[0]+50 < 125)
                    || (x[0] > 75 && x[0] < 500 && y[0]+50 > 75 && y[0]+50 < 125)   || (x[0] > 75 && x[0] < 500 && y[0]+50 > 675 && y[0]+50 < 725)
                    || (x[0] > 450 && x[0] < 875 && y[0]+50 > 375 && y[0]+50 < 425) || (x[0] > 775 && x[0] < 1200 && y[0]+50 > 675 && y[0]+50 < 725))
            {
                running = false;
            }
        }

        //check if head touches any  HardObstacle

        else if( "Hard".equals(Level)) {


            if(P11.contains(x[0],y[0]+50) || P12.contains(x[0],y[0]+50) || P13.contains(x[0],y[0]+50)
                    || P14.contains(x[0],y[0]+50) || P15.contains(x[0],y[0]+50)|| P16.contains(x[0],y[0]+50)) {

                running = false;
            }



            if((x[0] > 225 && x[0] < 475 && y[0]+50 > 50 && y[0]+50 < 100)      || (x[0] > 325 && x[0] < 375 && y[0]+50 > 75 && y[0]+50 < 300)  || (x[0] > 575 && x[0] < 675 && y[0]+50 > 175 && y[0]+50 < 225)
                    || (x[0] > 1000 && x[0] < 1250 && y[0]+50 > 50 && y[0]+50 < 100)|| (x[0] > 1100 && x[0] < 1150 && y[0]+50 > 75 && y[0]+50 < 300)|| (x[0] > 500 && x[0] < 650 && y[0]+50 > 425 && y[0]+50 < 475)
                    || (x[0] > 500 && x[0] < 550 && y[0]+50 > 425 && y[0]+50 < 600) || (x[0] > 625 && x[0] < 675 && y[0]+50 > 425 && y[0]+50 < 600) || (x[0] > 500 && x[0] < 650 && y[0]+50 > 550 && y[0]+50 < 600)
                    || (x[0] > 725 && x[0] < 775 && y[0]+50 > 425 && y[0]+50 < 600) || (x[0] > 825 && x[0] < 875 && y[0]+50 > 425 && y[0]+50 < 600) || (x[0] > 975 && x[0] < 1025 && y[0]+50 > 425 && y[0]+50 < 600) )
            {

                running = false;
            }

            if(direction=='R')
                if (x[0]==275 && y[0]+50==325){
                    x[0]=750;
                    y[0]=325;
                }

            if (x[0] > 225 && x[0] < 450 && y[0]+50 > 450 && y[0]+50 < 575){
                ladirection = 'R';
                direction= 'R' ;
                x[0]=0;
                y[0]=0;
            }
        }

        //check if head touches any  ProfissionalObstacle
        else if("Professional".equals(Level)){
            if(P1.contains(x[0],y[0]+50) || P2.contains(x[0],y[0]+50) || P3.contains(x[0],y[0]+50) || P4.contains(x[0],y[0]+50) || P5.contains(x[0],y[0]+50)
                    || P6.contains(x[0],y[0]+50) || P7.contains(x[0],y[0]+50) || P8.contains(x[0],y[0]+50) || P9.contains(x[0],y[0]+50) ){

                running = false;
            }


            if(P10 != null){
                for(int i=0 ; i < bodyParts ;i++){
                    if( P10.contains(x[i],y[i]+50))
                        running = false;
                }
            }
        }
        //check if head touches any  SuicideObstacle
        else if("Suicide".equals(Level)){


            if((x[0] > 125 && x[0] < 1150 && y[0]+50 > 75 && y[0]+50 < 125)     || (x[0] > 125 && x[0] < 1150 && y[0]+50 > 525 && y[0]+50 < 575) || (x[0] > 1125 && x[0] < 1175 && y[0]+50 > 75 && y[0]+50 < 475)
                    ||(x[0] > 125 && x[0] < 175 && y[0]+50 > 325 && y[0]+50 < 575)  || (x[0] > 225 && x[0] < 475 && y[0]+50 > 175 && y[0]+50 < 225)  || (x[0] > 225 && x[0] < 275 && y[0]+50 > 175 && y[0]+50 < 400)
                    ||(x[0] > 775 && x[0] < 1000 && y[0]+50 > 175 && y[0]+50 < 225) || (x[0] > 975 && x[0] < 1025 && y[0]+50 > 175 && y[0]+50 < 400) || (x[0] > 675 && x[0] < 725 && y[0]+50 > 550 && y[0]+50 < 775)
                    ||(x[0] > 525 && x[0] < 575 && y[0]+50 > 550 && y[0]+50 < 775)  || (x[0] > 475 && x[0] < 525 && y[0]+50 > 425 && y[0]+50 < 575)  || (x[0] > 125 && x[0] < 350 && y[0]+50 > 125 && y[0]+50 < 175)
                    ||(x[0] > 350 && x[0] < 400 && y[0]+50 > 100 && y[0]+50 < 200)  || (x[0] > 125 && x[0] < 175 && y[0]+50 > 150 && y[0]+50 < 350)  || (x[0] > 175 && x[0] < 250 && y[0]+50 > 175 && y[0]+50 < 225)
                    ||(x[0] > 150 && x[0] < 225 && y[0]+50 > 225 && y[0]+50 < 275)  || (x[0] > 175 && x[0] < 225 && y[0]+50 > 275 && y[0]+50 < 525)  || (x[0] > 475 && x[0] < 775 && y[0]+50 > 175 && y[0]+50 < 225)
                    ||(x[0] > 900 && x[0] < 1125 && y[0]+50 > 125 && y[0]+50 < 175) || (x[0] > 200 && x[0] < 300 && y[0]+50 > 425 && y[0]+50 < 475)  || (x[0] > 300 && x[0] < 350 && y[0]+50 > 200 && y[0]+50 < 375)
                    ||(x[0] > 400 && x[0] < 525 && y[0]+50 > 425 && y[0]+50 < 475)  || (x[0] > 400 && x[0] < 450 && y[0]+50 > 250 && y[0]+50 < 450)  || (x[0] > 475 && x[0] < 525 && y[0]+50 > 175 && y[0]+50 < 375)
                    ||(x[0] > 475 && x[0] < 600 && y[0]+50 > 325 && y[0]+50 < 375)  || (x[0] > 575 && x[0] < 625 && y[0]+50 > 275 && y[0]+50 < 500)  || (x[0] > 675 && x[0] < 725 && y[0]+50 > 275 && y[0]+50 < 550)
                    ||(x[0] > 800 && x[0] < 850 && y[0]+50 > 275 && y[0]+50 < 475)  || (x[0] > 800 && x[0] < 925 && y[0]+50 > 275 && y[0]+50 < 325)  || (x[0] > 800 && x[0] < 925 && y[0]+50 > 425 && y[0]+50 < 475)
                    ||(x[0] > 975 && x[0] < 1100 && y[0]+50 > 425 && y[0]+50 < 475) || (x[0] > 1075 && x[0] < 1125 && y[0]+50 > 425 && y[0]+50 < 550)
                    ||(x[0] > 1050 && x[0] < 1100 && y[0]+50 > 200 && y[0]+50 < 400)|| (x[0] > 800 && x[0] < 1025 && y[0]+50 > 350 && y[0]+50 < 400))
            {

                running = false;
            }


        }


        if(!running) {

            MyTimer.stop();

        }

    }

    public void GameOver(Graphics g){

        if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("Play-Music").equalsIgnoreCase("true")){
            try{
                clip.stop();
                GameOverFile = new File("src/main/audio/SnakeGameOver.wav");
                GameOverStream = AudioSystem.getAudioInputStream(GameOverFile);
                GameOver = AudioSystem.getClip();
                GameOver.open(GameOverStream);
                FloatControl gainControl = (FloatControl) GameOver.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-30.0f);
                GameOver.start();

            }
            catch(Exception ex){
                System.out.println("i'm sorry");
            }
        }


        for(int i = 1; i< bodyParts;i++) {

            g.setColor(bodyColor);
            g.fillOval(x[i], y[i]+50, UNIT_SIZE, UNIT_SIZE);
        }
        if(direction == 'R'){
            g.drawImage(RightImage, x[0]-25, y[0]+50, null);
        }else if(direction =='L'){
            g.drawImage(LeftImage, x[0]+25, y[0]+50, null);
        }else if (direction=='U'){
            g.drawImage(UpImage, x[0], y[0]+75, null);
        }else{
            g.drawImage(DownImage, x[0], y[0]+25, null);
        }



        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckScore();

                frame.dispose();
                GameOverFrame gameOver = new GameOverFrame(applesEaten,Lives);
                gameOver.setVisible(true);
                gameOver.requestFocus();
                gameOver.requestFocusInWindow();


            }
        });

        timer.setRepeats(false);
        timer.start();

    }

    String result = null ;
    FileReader readFile ;
    public  String getPropValue(String Key)  {

        try {
            Properties prop = new Properties();
            String propFileName = "src/main/myFile.properties";
            readFile = new FileReader(propFileName);

            if (readFile != null) {

                prop.load(readFile);
            } else {

                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty(Key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                readFile.close();
            } catch (IOException ex) {
                System.out.println("we cant close propertie file....");
            }
        }
        return result;
    }

    public void ReplacePropValue(String key,String value){
        try {
            Properties prop = new Properties();
            String propFileName = "src/main/myFile.properties";
            readFile = new FileReader(propFileName);
            if (readFile != null) {
                prop.load(readFile);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            prop.replace(key,value);

            FileOutputStream outputStrem = new FileOutputStream(propFileName);
            prop.store(outputStrem, "done!");


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                readFile.close();
            } catch (IOException ex) {
                System.out.println("we cant close propertie file....");
            }
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {



        if(running && !paused) {

            move();
            checkCollisions();
            checkApple();
            if(giveLiveChance)
                checkLives();



        }

        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override

        public void keyPressed(KeyEvent e) {

            if(running){
                switch(e.getKeyCode()) {

                    case KeyEvent.VK_LEFT:

                        if(direction != 'R') {


                            ladirection = 'L';


                        }

                        break;

                    case KeyEvent.VK_RIGHT:

                        if(direction != 'L') {


                            ladirection = 'R';


                        }

                        break;

                    case KeyEvent.VK_UP:

                        if(direction != 'D') {


                            ladirection = 'U';

                        }

                        break;

                    case KeyEvent.VK_DOWN:

                        if(direction != 'U') {


                            ladirection = 'D';


                        }

                        break;

                    case KeyEvent.VK_SPACE:

                        paused = false;

                        break;

                    case KeyEvent.VK_ENTER:
                        if(!paused)
                            paused = true;
                        else
                            paused = false;
                        break;

                    case KeyEvent.VK_ESCAPE:

                        paused = true;

                        break;
                }

            }
        }
    }

    public void CheckScore(){

        if(getPropValue("HighScore"+getPropValue("Level")).equalsIgnoreCase("Not Yet") || (applesEaten > Integer.parseInt(getPropValue("HighScore"+getPropValue("Level")))) ){

            ReplacePropValue("HighScore"+getPropValue("Level"),String.valueOf(applesEaten));

        }
    }



}
