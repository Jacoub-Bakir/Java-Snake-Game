
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;



public class GameOverFrame extends JFrame  {

    int seconds=15;
    int Score;
    int Lives;
    JPanel GameOverPanel = new JPanel();
    JLabel BackgroundLabel = new JLabel();
    JPanel MenuBarPanel = new JPanel();
    JLabel UserNameLabel = new JLabel();
    JTextField UserNameTextField = new JTextField();
    JButton EditUserName = new JButton();
    JLabel MenuLabel= new JLabel();
    JLabel ContinueIconLabel = new JLabel();
    JLabel ContinueLabel = new JLabel();
    JLabel GameOverLabel = new JLabel();
    JLabel HighScoreLabel = new JLabel();
    JLabel RetryIconLabel = new JLabel();
    JLabel RetryLabel = new JLabel();
    JLabel ScoreLabel = new JLabel();
    JLabel TimerLabel = new JLabel();
    JPanel TheChancePanel = new JPanel();
    JLabel QuestionLabel = new JLabel();
    JLabel ANoteLabel = new JLabel();
    JLabel FirstChoice = new JLabel();
    JLabel SecondChoice = new JLabel();
    JLabel ThirdChoice = new JLabel();
    JButton A_Button = new JButton();
    JButton B_Button = new JButton();
    JButton C_Button = new JButton();
    final Container glassPane;
    String[] Questions = {
            "Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?" };
    String[][] Options = {
            {"Sun Microsystems","Starbucks","Microsoft"},
            {"1989","1996","1972"},
            {"Apple","Latte","Oak"},
            {"Steve Jobs","Bill Gates","James Gosling"}};
    char[] Answers = {  'A',
            'B',
            'C',
            'C'};

    Random randomizer = new Random();
    final int Guess = randomizer.nextInt(Questions.length);
    char Answer ;
    boolean iscorrect = false;


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;

            TimerLabel.setText(String.valueOf(seconds));
            if(seconds<=0) {
                ContinueIconLabel.setEnabled(false);
                if(Lives!=0){
                    ContinueIconLabel.removeMouseListener(ContinueIconLabel.getMouseListeners()[0]);
                    ContinueLabel.setEnabled(false);
                }
                StopTheTimer(timer);


            }
        }});
    Timer timer_2 = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;

            TimerLabel.setText(String.valueOf(seconds));
            if(seconds<=0) {
                clip2.stop();
                A_Button.setEnabled(true);
                B_Button.setEnabled(true);
                C_Button.setEnabled(true);
                GameOverPanel.remove(TimerLabel);
                GameOverPanel.remove(TheChancePanel);
                GameOverPanel.repaint();
                GameOverPanel.revalidate();
                GameOverLabel.setForeground(new Color(220,4,31));
                GameOverPanel.add(GameOverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 150, 450, 150));
                StopTheTimer(timer_2);
                Timer pause = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        SnakeGameFrame frame = new SnakeGameFrame();
                        frame.setVisible(true);
                    }});
                pause.setRepeats(false);
                pause.start();
            }
        }});

    File audioStream ;
    AudioInputStream audios;
    Clip clip;
    File audioStream2 ;
    AudioInputStream audios2;
    Clip clip2;

    GameOverFrame( int Score ,int Lives){

        this.Score = Score;
        this.Lives = Lives;

        if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true")){
            try{

                audioStream = new File("src/main/audio/audio4.wav");
                audios = AudioSystem.getAudioInputStream(audioStream);
                clip = AudioSystem.getClip();
                clip.open(audios);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-35.0f);


                audioStream2 = new File("src/main/audio/audio2.wav");
                audios2 = AudioSystem.getAudioInputStream(audioStream2);
                clip2 = AudioSystem.getClip();
                clip2.open(audios2);
                FloatControl gainControl2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl2.setValue(-40.0f);


                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            catch(Exception ex){
                System.out.println("i'm sorry");
            }
        }


        BackgroundLabel.setPreferredSize(new Dimension(1300,750));
        if(getPropValue("Mode").equalsIgnoreCase("Forest")){
            BackgroundLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Forest-background-2.jpg"));
        }else if (getPropValue("Mode").equalsIgnoreCase("Desert")){
            BackgroundLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Desert-Background.jpg"));
        }else if(getPropValue("Mode").equalsIgnoreCase("Ocean")){
            BackgroundLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Ocan-background.jpg"));
        }else{
            BackgroundLabel.setIcon(new javax.swing.ImageIcon("src/main/images/space_background.jpeg"));
        }


        MenuBarPanel.setBackground(new java.awt.Color(0, 20, 36));
        MenuBarPanel.setPreferredSize(new Dimension(1300,50));
        MenuBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        UserNameLabel.setFont(new java.awt.Font("Kannada MN", 0, 36)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(204, 255, 204));
        UserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameLabel.setText("UserName :");


        UserNameTextField.setEditable(false);
        UserNameTextField.setBackground(new java.awt.Color(0, 20, 36));
        UserNameTextField.setFont(new java.awt.Font("Kannada MN", 0, 30)); // NOI18N
        UserNameTextField.setForeground(new java.awt.Color(255, 204, 204));
        if(new File("src/main/myFile.properties").exists()){
            UserNameTextField.setText(getPropValue("UserName"));
        }


        EditUserName.setBackground(new java.awt.Color(0, 20, 36));
        EditUserName.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        EditUserName.setForeground(new java.awt.Color(0, 255, 204));
        EditUserName.setText("Edit");
        EditUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 204)));
        EditUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserNameActionPerformed(evt);
            }
        });

        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setIcon(new javax.swing.ImageIcon("src/main/images/MenuIcon.png")); // NOI18N
        MenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuLabelMousePressed(evt);
            }
        });
        MenuBarPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));

        MenuBarPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 50));
        MenuBarPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, 390, 40));
        MenuBarPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 110, 40));
        MenuLabel.setVisible(true);
        MenuBarPanel.setFocusable(true);
        MenuBarPanel.requestFocusInWindow();

        GameOverPanel.setPreferredSize(new Dimension(900,500));
        GameOverPanel.setBackground(new java.awt.Color(0, 0, 0,150));
        GameOverPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        RetryLabel.setBackground(new java.awt.Color(255, 255, 255));
        RetryLabel.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        RetryLabel.setForeground(new java.awt.Color(255, 255, 255));
        RetryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RetryLabel.setText("Retry");
        GameOverPanel.add(RetryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 80, 40));

        ContinueLabel.setBackground(new java.awt.Color(255, 255, 255));
        ContinueLabel.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        ContinueLabel.setForeground(new java.awt.Color(255, 255, 255));
        ContinueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContinueLabel.setText("Continue");

        GameOverPanel.add(ContinueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 420, 120, 40));

        GameOverLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        GameOverLabel.setForeground(new Color(255,255,255));
        GameOverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameOverLabel.setText("Game Over");
        GameOverPanel.add(GameOverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 150, 450, 150));

        ScoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(0, 153, 51));
        ScoreLabel.setText("Score:  "+ Score);
        GameOverPanel.add(ScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 60));

        ContinueIconLabel.setBackground(new java.awt.Color(255, 255, 255));
        ContinueIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContinueIconLabel.setIcon(new javax.swing.ImageIcon("src/main/images/ContinueIcon.png")); // NOI18N
        ContinueIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ContinueIconLabelMouseClicked(evt);
                if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true"))
                    clip.stop();
            }
        });
        GameOverPanel.add(ContinueIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 340, 120, 80));

        if(Lives==0){
            ContinueIconLabel.setEnabled(false);
            ContinueIconLabel.removeMouseListener(ContinueIconLabel.getMouseListeners()[0]);
            ContinueLabel.setEnabled(false);

        }

        RetryIconLabel.setBackground(new java.awt.Color(255, 255, 255));
        RetryIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RetryIconLabel.setIcon(new javax.swing.ImageIcon("src/main/images/ReplayIcon.png")); // NOI18N
        RetryIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clip.stop();
                RetryIconLabelMouseClicked(evt);
            }
        });
        GameOverPanel.add(RetryIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 90, 80));

        HighScoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        HighScoreLabel.setForeground(new java.awt.Color(204, 0, 51));
        HighScoreLabel.setText("High Score: " + getPropValue("HighScore"+getPropValue("Level")));
        GameOverPanel.add(HighScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 300, 60));


        TimerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 50)); // NOI18N
        TimerLabel.setForeground(new java.awt.Color(225, 13, 46));
        TimerLabel.setBackground(new Color(0, 0, 0,150));
        TimerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLabel.setText(String.valueOf(seconds));
        GameOverPanel.add(TimerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 10, 90, 75));

        TheChancePanel.setBackground(new Color(0, 0, 0,90));
        TheChancePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        QuestionLabel.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        QuestionLabel.setForeground(new java.awt.Color(4, 246, 242));
        QuestionLabel.setText(Questions[Guess]);


        ANoteLabel.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        ANoteLabel.setForeground(new java.awt.Color(255, 255, 255));
        ANoteLabel.setText("Answer This And You'll Continue..");


        FirstChoice.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        FirstChoice.setForeground(new java.awt.Color(255, 255, 255));
        FirstChoice.setText(Options[Guess][0]);


        SecondChoice.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        SecondChoice.setForeground(new java.awt.Color(255, 255, 255));
        SecondChoice.setText(Options[Guess][1]);


        ThirdChoice.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ThirdChoice.setForeground(new java.awt.Color(255, 255, 255));
        ThirdChoice.setText(Options[Guess][2]);



        A_Button.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        A_Button.setText("A");

        A_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true"))
                    clip2.stop();
                MyactionPerformed(evt);
            }
        });

        B_Button.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        B_Button.setText("B");
        B_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true"))
                    clip2.stop();
                MyactionPerformed(evt);
            }
        });

        C_Button.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        C_Button.setText("C");
        C_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true"))
                    clip2.stop();
                MyactionPerformed(evt);
            }
        });






        GameOverPanel.setOpaque(true);
        MenuBarPanel.setOpaque(true);


        this.setGlassPane(new JComponent(){
            protected void paintComponent(Graphics g){
                g.setColor(new Color(0,0,0,150));
                g.fillRect(0, 50, 1300, 750);
            }
        });
        glassPane = (Container)this.getGlassPane();
        glassPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        glassPane.add(MenuBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 50));
        glassPane.add(GameOverPanel,new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 900, 500));



        glassPane.setVisible(true);
        glassPane.addMouseListener(new MouseAdapter(){});



        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(255,255,255));
        this.setPreferredSize(new Dimension(1300,825));
        this.setResizable(false);
        //this.getContentPane().add(MenuBarPanel, java.awt.BorderLayout.PAGE_START);
        this.getContentPane().add(BackgroundLabel, java.awt.BorderLayout.PAGE_END);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setFocusable(true);
        requestFocusInWindow();

        timer.start();
    }

    private void ContinueIconLabelMouseClicked(java.awt.event.MouseEvent evt) {

        timer.stop();
        seconds = 15;
        if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true")){
            try{


                clip2.start();
                clip2.loop(Clip.LOOP_CONTINUOUSLY);
            }
            catch(Exception ex){
                System.out.println("i'm sorry");
            }
        }
        TimerLabel.setText(String.valueOf(seconds));

        GameOverPanel.remove(GameOverLabel);
        GameOverPanel.remove(RetryLabel);
        GameOverPanel.remove(ContinueLabel);
        GameOverPanel.remove(ContinueIconLabel);
        GameOverPanel.remove(RetryIconLabel);
        GameOverPanel.repaint();
        GameOverPanel.revalidate();

        TheChancePanel.add(QuestionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 590, 60));
        TheChancePanel.add(ANoteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 0, 250, 50));
        TheChancePanel.add(FirstChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 410, 50));
        TheChancePanel.add(SecondChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 410, 50));
        TheChancePanel.add(ThirdChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 410, 50));
        TheChancePanel.add(A_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 100, 50));
        TheChancePanel.add(B_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 100, 50));
        TheChancePanel.add(C_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 100, 50));

        GameOverPanel.add(TheChancePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 600, 300));
        timer_2.start();
    }

    private void RetryIconLabelMouseClicked(java.awt.event.MouseEvent evt) {
        GameOverPanel.remove(TimerLabel);
        GameOverPanel.remove(RetryIconLabel);
        GameOverPanel.remove(RetryLabel);
        GameOverPanel.remove(ContinueIconLabel);
        GameOverPanel.remove(ContinueLabel);
        GameOverPanel.repaint();
        GameOverPanel.revalidate();
        GameOverLabel.setForeground(new Color(220,4,31));
        Timer pause = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ReplyAgainFrame frame = new ReplyAgainFrame(0,0);
                frame.setVisible(true);
                dispose();

            }});
        pause.setRepeats(false);
        pause.start();


    }

    private void EditUserNameActionPerformed(java.awt.event.ActionEvent evt) {
        if(!UserNameTextField.isEditable()){
            UserNameTextField.setEditable(true);
            UserNameTextField.requestFocus();
            UserNameTextField.selectAll();
            EditUserName.setText("Save");
        }else{
            if(!"".equals(UserNameTextField.getText())){
                ReplacePropValue("UserName",UserNameTextField.getText());
            }else{
                UserNameTextField.setText("Utilisateur");
                ReplacePropValue("UserName","Utilisateur");
            }
            EditUserName.setText("Edit");
            UserNameTextField.setEditable(false);
        }
    }

    private void MenuLabelMousePressed(java.awt.event.MouseEvent evt) {
        if(getPropValue("GameOver-Music").equalsIgnoreCase("true") && getPropValue("Sound").equalsIgnoreCase("General") ){

            if(clip.isRunning())
                clip.stop();
            System.out.println(clip.isRunning()+":://::"+clip2.isRunning());
            //if(clip2.isRunning())
            //     clip2.stop();
        }
        dispose();
        SnakeGameFrame frame = new SnakeGameFrame();
        frame.setVisible(true);

    }

    public void MyactionPerformed(ActionEvent e) {
        A_Button.setEnabled(false);
        B_Button.setEnabled(false);
        C_Button.setEnabled(false);
        if(e.getSource()==A_Button){
            Answer = 'A';
            if(Answer == Answers[Guess])
                iscorrect = true;
        }
        if(e.getSource()==B_Button) {
            Answer = 'B';
            if(Answer == Answers[Guess])
                iscorrect = true;
        }
        if(e.getSource()==C_Button){
            Answer = 'C';
            if(Answer == Answers[Guess])
                iscorrect = true;
        }

        timer_2.stop();
        FirstChoice.setForeground(new Color(25,255,0));
        SecondChoice.setForeground(new Color(25,255,0));
        ThirdChoice.setForeground(new Color(25,255,0));
        if(Answers[Guess] != 'A')
            FirstChoice.setForeground(new Color(255,0,0));
        if(Answers[Guess] != 'B')
            SecondChoice.setForeground(new Color(255,0,0));
        if(Answers[Guess] != 'C')
            ThirdChoice.setForeground(new Color(255,0,0));



        try{
            if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("GameOver-Music").equalsIgnoreCase("true")){

                if(!iscorrect){
                    clip2.stop();
                    File GameOverFile = new File("src/main/audio/QuizWrongAnswer.wav");
                    AudioInputStream GameOverStream = AudioSystem.getAudioInputStream(GameOverFile);
                    Clip GameOver = AudioSystem.getClip();
                    GameOver.open(GameOverStream);
                    FloatControl gainControl = (FloatControl) GameOver.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-20.0f);
                    GameOver.start();

                }else {
                    clip2.stop();
                    File GameOverFile = new File("src/main/audio/QuizCorrectAnswer.wav");
                    AudioInputStream GameOverStream = AudioSystem.getAudioInputStream(GameOverFile);
                    Clip GameOver = AudioSystem.getClip();
                    GameOver.open(GameOverStream);
                    FloatControl gainControl = (FloatControl) GameOver.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-20.0f);
                    GameOver.start();


                }

            }
        }
        catch(Exception ex){
            System.out.println("i'm sorry");
        }


        Timer pause = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!iscorrect){

                    GameOverPanel.remove(TimerLabel);
                    GameOverPanel.remove(TheChancePanel);
                    GameOverPanel.repaint();
                    GameOverPanel.revalidate();
                    GameOverLabel.setForeground(new Color(220,4,31));
                    GameOverPanel.add(GameOverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 150, 450, 150));
                    Timer pause = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            SnakeGameFrame frame = new SnakeGameFrame();
                            frame.setVisible(true);
                            dispose();
                        }});
                    pause.setRepeats(false);
                    pause.start();
                }
                else {
                    Lives--;
                    ReplyAgainFrame frame = new ReplyAgainFrame(Score,Lives);
                    frame.setVisible(true);
                    dispose();

                }


            }
        });
        pause.setRepeats(false);
        pause.start();

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
                Logger.getLogger(GameOverFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SnakeGameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }


    public void StopTheTimer(Timer timer){
        timer.stop();
        GameOverPanel.remove(TimerLabel);
        GameOverPanel.revalidate();
        GameOverPanel.repaint();
    }




}
