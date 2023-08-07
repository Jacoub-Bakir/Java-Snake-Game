
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class SnakeGameFrame extends JFrame {

    //components of main game frame
    JLabel AboutLabel;
    JLabel HigHScorELabel;
    JLabel HighScoreLabel;
    JLabel ExitLabel;
    JPanel MainButtonPanel;
    JLabel BackgroundLabel;
    JPanel MainPanel;
    JPanel MenuPanel;
    JLabel OptionLabel;
    JLabel PlayLabel;
    JLabel WelcomeLabel;
    JLabel MenuLabel;
    JLabel PauseLabel;
    JLabel UserNameLabel;
    JTextField UserNameTextField;
    JButton EditUserName;

    File audioStream ;
    AudioInputStream audios ;
    Clip clip;
    //components of option panel
    JPanel OptionPanel;
    JLabel LevelLabel;
    JLabel SpeedLabel;
    JLabel SoundLabel;
    JLabel BorderLabel;
    JLabel ModeLabel;
    JRadioButton EasyLevel;
    JRadioButton MediumLevel;
    JRadioButton HardLevel;
    JRadioButton ProfessionalLevel;
    JRadioButton SuicideLevel;
    JRadioButton ManuallySpeed;
    JSlider SpeedSlider;
    JRadioButton DefaultSpeed;
    JRadioButton SlowSpeed;
    JRadioButton NormalSpeed;
    JRadioButton FastSpeed;
    JRadioButton SilentSound;
    JRadioButton GeneralSound;
    JCheckBox HomeSound;
    JCheckBox PlaySound;
    JCheckBox GameOverSound;
    JLabel CheckBorderLabel;
    JRadioButton BorderOFF;
    JRadioButton BorderON;
    JRadioButton FirstMode;
    JRadioButton SecondMode;
    JRadioButton ThirdMode;
    JRadioButton ForthMode;
    JLabel FirstModeLabel;
    JLabel SecondModeLabel;
    JLabel ThirdModeLabel;
    JLabel ForthModeLabel;
    ButtonGroup LevelButtonGroup;
    ButtonGroup SpeedButtonGroup;
    ButtonGroup DefaultSpeedButtonGroup;
    ButtonGroup SoundButtonGroup;
    ButtonGroup BorderButtonGroup;
    ButtonGroup ModeButtonGroup;

    //components of about panel

    JPanel aboutPanel;
    JLabel jLabel1;
    JLabel jLabel2;
    JScrollPane jScrollPane1;
    JEditorPane AboutTextArea;
    JButton BakirContactButton;
    JButton HacenContactButton;
    JButton NadjibContactButton;
    JButton SlimaneContactButton;
    JButton ToufikContactButton;
    JLabel ClubLabel;

    //components of High Score panel

    JPanel HighScorePanel;
    JLabel EasyLevelHighScore;
    JLabel EasyRecord;
    JLabel HardLevelHighScore;
    JLabel HardRecord;
    JLabel HighScoreTitle;
    JLabel MediumLevelHighScore;
    JLabel MediumRecord;
    JLabel ProfessionalLevelHighScore;
    JLabel SuicideLevelHighScore;
    JLabel ProfessionalRecord;
    JLabel SuicideRecord;

    public SnakeGameFrame() {


        //init components of main game frame
        MainPanel = new JPanel();
        WelcomeLabel = new JLabel();
        MainButtonPanel = new JPanel();
        BackgroundLabel = new JLabel();
        PlayLabel = new JLabel();
        ExitLabel = new JLabel();
        OptionLabel = new JLabel();
        HigHScorELabel = new JLabel();
        AboutLabel = new JLabel();
        MenuPanel = new JPanel();
        MenuLabel = new JLabel();
        PauseLabel = new JLabel();
        HighScoreLabel = new JLabel();
        UserNameLabel = new JLabel();
        UserNameTextField = new JTextField();
        EditUserName = new JButton();


        //init components of option panel
        OptionPanel = new JPanel();
        LevelLabel = new JLabel();
        SpeedLabel = new JLabel();
        SoundLabel = new JLabel();
        BorderLabel = new JLabel();
        ModeLabel = new JLabel();
        LevelButtonGroup = new ButtonGroup();
        EasyLevel = new JRadioButton();
        MediumLevel = new JRadioButton();
        HardLevel = new JRadioButton();
        ProfessionalLevel = new JRadioButton();
        SuicideLevel = new JRadioButton();
        SpeedButtonGroup = new ButtonGroup();
        ManuallySpeed = new JRadioButton();
        SpeedSlider = new JSlider();
        DefaultSpeed = new JRadioButton();
        DefaultSpeedButtonGroup = new ButtonGroup();
        SlowSpeed = new JRadioButton();
        NormalSpeed = new JRadioButton();
        FastSpeed = new JRadioButton();
        SoundButtonGroup = new ButtonGroup();
        SilentSound = new JRadioButton();
        GeneralSound = new JRadioButton();
        HomeSound = new JCheckBox();
        PlaySound = new JCheckBox();
        GameOverSound = new JCheckBox();
        CheckBorderLabel = new JLabel();
        BorderButtonGroup = new ButtonGroup();
        BorderOFF = new JRadioButton();
        BorderON = new JRadioButton();
        ModeButtonGroup = new ButtonGroup();
        FirstMode = new JRadioButton();
        SecondMode = new JRadioButton();
        ThirdMode = new JRadioButton();
        ForthMode = new JRadioButton();
        FirstModeLabel = new JLabel();
        SecondModeLabel = new JLabel();
        ThirdModeLabel = new JLabel();
        ForthModeLabel = new JLabel();


        // init components of about panel
        aboutPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        AboutTextArea = new JEditorPane();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        ToufikContactButton = new JButton();
        BakirContactButton = new JButton();
        HacenContactButton = new JButton();
        SlimaneContactButton = new JButton();
        NadjibContactButton = new JButton();
        ClubLabel = new JLabel();

        //init components of High Score panel
        HighScorePanel = new JPanel();
        HighScoreTitle = new JLabel();
        EasyLevelHighScore = new JLabel();
        MediumLevelHighScore = new JLabel();
        HardLevelHighScore = new JLabel();
        ProfessionalLevelHighScore = new JLabel();
        SuicideLevelHighScore = new JLabel();
        EasyRecord = new JLabel();
        MediumRecord = new JLabel();
        HardRecord = new JLabel();
        ProfessionalRecord = new JLabel();
        SuicideRecord = new JLabel();

        setTitle("Snake");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1300, 800));
        setMaximumSize(new java.awt.Dimension(1300, 800));
        setMinimumSize(new java.awt.Dimension(1300, 800));
        setResizable(false);
        setLocationRelativeTo(null);





        MainPanel.setBackground(new java.awt.Color(0, 20, 36));
        MainPanel.setMaximumSize(new java.awt.Dimension(1300, 750));
        MainPanel.setMinimumSize(new java.awt.Dimension(1300, 750));
        MainPanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WelcomeLabel.setFont(new java.awt.Font("Kannada MN", 1, 48)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("WELCOME");
        WelcomeLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(15, 84, 145)));
        MainPanel.add(WelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 350, 70));






        MainButtonPanel.setBackground(new java.awt.Color(0, 20, 36));
        MainButtonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());



        PlayLabel.setBackground(new java.awt.Color(0, 0, 0));
        PlayLabel.setFont( new Font("Ink Free",Font.BOLD, 35));
        PlayLabel.setForeground(new java.awt.Color(255, 255, 255));
        PlayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayLabel.setText("Play");
        PlayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 84, 145)));
        PlayLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayLabel.setOpaque(true);
        PlayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlayLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PlayLabel.setForeground(new java.awt.Color(255,255,255));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PlayLabel.setForeground(new java.awt.Color(0, 153, 204));
            }
        });
        MainButtonPanel.add(PlayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 50));

        ExitLabel.setBackground(new java.awt.Color(0, 0, 0));
        ExitLabel.setFont(new Font("Ink Free",Font.BOLD, 35));
        ExitLabel.setForeground(new java.awt.Color(255, 255, 255));
        ExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitLabel.setText("Exit");
        ExitLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 84, 145)));
        ExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitLabel.setOpaque(true);
        ExitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitLabel.setForeground(new java.awt.Color(255,255,255));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitLabel.setForeground(new java.awt.Color(0, 153, 204));
            }
        });
        MainButtonPanel.add(ExitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 350, 50));

        OptionLabel.setBackground(new java.awt.Color(0, 0, 0));
        OptionLabel.setFont(new Font("Ink Free",Font.BOLD, 35));
        OptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        OptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel.setText("Option");
        OptionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 84, 145)));
        OptionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OptionLabel.setOpaque(true);
        OptionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OptionLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptionLabel.setForeground(new java.awt.Color(255,255,255));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptionLabel.setForeground(new java.awt.Color(0, 153, 204));
            }
        });
        MainButtonPanel.add(OptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 50));//0, 60, 350, 50

        HigHScorELabel.setBackground(new java.awt.Color(0, 0, 0));
        HigHScorELabel.setFont(new Font("Ink Free",Font.BOLD, 35));
        HigHScorELabel.setForeground(new java.awt.Color(255, 255, 255));
        HigHScorELabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HigHScorELabel.setText("High Score");
        HigHScorELabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 84, 145)));
        HigHScorELabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HigHScorELabel.setOpaque(true);
        HigHScorELabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HigHScorELabel.setForeground(new java.awt.Color(255,255,255));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HigHScorELabel.setForeground(new java.awt.Color(0, 153, 204));
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HigHScorELabelMousePressed(evt);
            }
        });
        MainButtonPanel.add(HigHScorELabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 350, 50));

        AboutLabel.setBackground(new java.awt.Color(0, 0, 0));
        AboutLabel.setFont(new Font("Ink Free",Font.BOLD, 35));
        AboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        AboutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AboutLabel.setText("About");
        AboutLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 84, 145)));
        AboutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutLabel.setOpaque(true);
        AboutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AboutLabelMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AboutLabel.setForeground(new java.awt.Color(255,255,255));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AboutLabel.setForeground(new java.awt.Color(0, 153, 204));
            }
        });
        MainButtonPanel.add(AboutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 350, 50));

        MainPanel.add(MainButtonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 350, 300));

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        MenuPanel.setBackground(new java.awt.Color(0, 20, 36));
        MenuPanel.setPreferredSize(new java.awt.Dimension(1300, 50));
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        UserNameLabel.setFont(new java.awt.Font("Kannada MN", 0, 36)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(204, 255, 204));
        UserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameLabel.setText("UserName :");
        MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 230, 50));

        UserNameTextField.setEditable(false);
        UserNameTextField.setBackground(new java.awt.Color(0, 20, 36));
        UserNameTextField.setFont(new java.awt.Font("Kannada MN", 0, 30)); // NOI18N
        UserNameTextField.setForeground(new java.awt.Color(255, 204, 204));
        if(new File("src/main/myFile.properties").exists()){
            UserNameTextField.setText(getPropValue("UserName"));
        }
        MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 290, 40));

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
        MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 110, 40));

        HighScoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 30)); // NOI18N
        HighScoreLabel.setForeground(new java.awt.Color(255, 122, 13));

        if(new File("src/main/myFile.properties").exists()){
            HighScoreLabel.setText("High Score : " + getPropValue("HighScore"+getPropValue("Level")));
        }else{HighScoreLabel.setText("High Score:Not Yet") ;}

        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setIcon(new javax.swing.ImageIcon("src/main/images/MenuIcon.png")); // NOI18N
        MenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuLabelMousePressed(evt);
            }
        });

        PauseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PauseLabel.setIcon(new javax.swing.ImageIcon("src/main/images/pause.png")); // NOI18N
        PauseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(TheGamePanel.paused)
                    TheGamePanel.paused = false;
                else
                    TheGamePanel.paused = true;
            }
        });

        BackgroundLabel.setIcon(new javax.swing.ImageIcon("src/main/images/SakeGameBackground.jpg"));
        MainPanel.add(BackgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 750));


        getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);

        //adding audio to the main game frame
        try{

            audioStream = new File("src/main/audio/audio1.wav");
            audios = AudioSystem.getAudioInputStream(audioStream);
            clip = AudioSystem.getClip();
            clip.open(audios);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-35.0f);



            if(new File("src/main/myFile.properties").exists()){
                if(getPropValue("Sound").equalsIgnoreCase("General") && getPropValue("Home-Music").equalsIgnoreCase("true")){
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }

        }
        catch(Exception ex){
            System.out.println("i'm sorry");

        }

        // seting Settings to default
        if(!new File("src/main/myFile.properties").exists()){
            setDefaultPropValues();
        }



        OptionPanel.setBackground(new java.awt.Color(0, 20, 36));
        OptionPanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        OptionPanel.setSize(new java.awt.Dimension(1300, 750));
        OptionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LevelLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        LevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        LevelLabel.setText("Level :");
        OptionPanel.add(LevelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 70));

        SpeedLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        SpeedLabel.setForeground(new java.awt.Color(255, 255, 255));
        SpeedLabel.setText("Speed :");
        OptionPanel.add(SpeedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 70));

        SoundLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        SoundLabel.setForeground(new java.awt.Color(255, 255, 255));
        SoundLabel.setText("Sound :");
        OptionPanel.add(SoundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, 70));

        BorderLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        BorderLabel.setForeground(new java.awt.Color(255, 255, 255));
        BorderLabel.setText("Border  :");
        OptionPanel.add(BorderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 220, 70));

        ModeLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        ModeLabel.setForeground(new java.awt.Color(255, 255, 255));
        ModeLabel.setText("Mode  :");
        OptionPanel.add(ModeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 220, 60));

        EasyLevel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        EasyLevel.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Level").equalsIgnoreCase("Easy")){
                EasyLevel.setSelected(true);
            }
        }
        EasyLevel.setText("Easy");
        EasyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Level","Easy");
            }
        });
        LevelButtonGroup.add(EasyLevel);
        OptionPanel.add(EasyLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 45, 170, 50));

        MediumLevel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        MediumLevel.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Level").equalsIgnoreCase("Medium")){
                MediumLevel.setSelected(true);
            }
        }
        MediumLevel.setText("Medium");
        MediumLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Level","Medium");
            }
        });

        LevelButtonGroup.add(MediumLevel);
        OptionPanel.add(MediumLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 45, 200, 50));

        HardLevel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        HardLevel.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Level").equalsIgnoreCase("Hard")){
                HardLevel.setSelected(true);
            }
        }
        HardLevel.setText("Hard");
        HardLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Level","Hard");
            }
        });

        LevelButtonGroup.add(HardLevel);
        OptionPanel.add(HardLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 45, 170, 50));


        ProfessionalLevel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        ProfessionalLevel.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Level").equalsIgnoreCase("Professional")){
                ProfessionalLevel.setSelected(true);
            }
        }
        ProfessionalLevel.setText("Professional");
        ProfessionalLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Level","Professional");
            }
        });
        LevelButtonGroup.add(ProfessionalLevel);
        OptionPanel.add(ProfessionalLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 45, 180, 50));

        SuicideLevel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SuicideLevel.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Level").equalsIgnoreCase("Suicide")){
                SuicideLevel.setSelected(true);
            }
        }
        SuicideLevel.setText("Suicide");
        SuicideLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Level","Suicide");
            }
        });

        LevelButtonGroup.add(SuicideLevel);
        OptionPanel.add(SuicideLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 45, 180, 50));

        ManuallySpeed.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        ManuallySpeed.setForeground(new java.awt.Color(255, 255, 255));
        ManuallySpeed.setText("Manually :");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("SpeedMode").equalsIgnoreCase("Manually")){
                ManuallySpeed.setSelected(true);
                SpeedSlider.setValue((int) (Double.parseDouble(getPropValue("Speed"))/1.5));
                SlowSpeed.setEnabled(false);
                NormalSpeed.setSelected(true);
                NormalSpeed.setEnabled(false);
                FastSpeed.setEnabled(false);
            }
        }
        SpeedButtonGroup.add(ManuallySpeed);
        ManuallySpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManuallySpeedActionPerformed(evt);
            }
        });
        OptionPanel.add(ManuallySpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, 160, 40));

        SpeedSlider.setBackground(new java.awt.Color(230, 230, 230));
        SpeedSlider.setForeground(new java.awt.Color(0, 0, 0));
        SpeedSlider.setMajorTickSpacing(20);
        SpeedSlider.setMinorTickSpacing(10);
        SpeedSlider.setPaintLabels(true);
        SpeedSlider.setPaintTicks(true);
        SpeedSlider.setSnapToTicks(true);
        SpeedSlider.setOpaque(true);
        //SpeedSlider.setEnabled(false);
        SpeedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event){
                ReplacePropValue("Speed", String.valueOf(SpeedSlider.getValue()*1.5));
            }
        });
        OptionPanel.add(SpeedSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 560, -1));

        DefaultSpeed.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        DefaultSpeed.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("SpeedMode").equalsIgnoreCase("Default")){
                DefaultSpeed.setSelected(true);
                SpeedSlider.setEnabled(false);
            }
        }
        DefaultSpeed.setText("Default :");
        SpeedButtonGroup.add(DefaultSpeed);
        DefaultSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultSpeedActionPerformed(evt);
            }
        });
        OptionPanel.add(DefaultSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 160, 40));

        SlowSpeed.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SlowSpeed.setForeground(new java.awt.Color(255, 255, 255));
        SlowSpeed.setText("Slow");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Speed").equalsIgnoreCase("0")){
                SlowSpeed.setSelected(true);
            }
        }
        SlowSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Speed","0");
            }
        });
        DefaultSpeedButtonGroup.add(SlowSpeed);
        OptionPanel.add(SlowSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 140, 40));

        NormalSpeed.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        NormalSpeed.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Speed").equalsIgnoreCase("50")){
                NormalSpeed.setSelected(true);
            }
        }
        NormalSpeed.setText("Normal");
        NormalSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Speed","50");
            }
        });
        DefaultSpeedButtonGroup.add(NormalSpeed);
        OptionPanel.add(NormalSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 140, 40));

        FastSpeed.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        FastSpeed.setForeground(new java.awt.Color(255, 255, 255));
        FastSpeed.setText("Fast");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Speed").equalsIgnoreCase("100")){
                FastSpeed.setSelected(true);
            }
        }
        FastSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Speed","100");
            }
        });
        DefaultSpeedButtonGroup.add(FastSpeed);
        OptionPanel.add(FastSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 140, 40));

        SilentSound.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SilentSound.setForeground(new java.awt.Color(255, 255, 255));
        SilentSound.setText("Silent ");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Sound").equalsIgnoreCase("Silent")){
                SilentSound.setSelected(true);
                HomeSound.setEnabled(false);
                PlaySound.setEnabled(false);
                GameOverSound.setEnabled(false);
            }}
        SoundButtonGroup.add(SilentSound);
        SilentSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SilentSoundActionPerformed(evt);
            }
        });
        OptionPanel.add(SilentSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 160, 40));

        GeneralSound.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        GeneralSound.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Sound").equalsIgnoreCase("General")){
                GeneralSound.setSelected(true);
            }
        }
        GeneralSound.setText("General");
        SoundButtonGroup.add(GeneralSound);
        GeneralSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneralSoundActionPerformed(evt);
            }
        });
        OptionPanel.add(GeneralSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 160, 40));

        HomeSound.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        HomeSound.setForeground(new java.awt.Color(255, 255, 255));
        HomeSound.setText("Home-Music");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Home-Music").equalsIgnoreCase("true")){
                HomeSound.setSelected(true);
            }
        }
        HomeSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HomeSoundMousePressed(evt);
            }});

        OptionPanel.add(HomeSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 190, 35));

        PlaySound.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        PlaySound.setForeground(new java.awt.Color(255, 255, 255));
        PlaySound.setText("Play-Music");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Play-Music").equalsIgnoreCase("true")){
                PlaySound.setSelected(true);
            }}
        PlaySound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlaySoundMousePressed(evt);
            }});
        OptionPanel.add(PlaySound, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 180, 35));

        GameOverSound.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        GameOverSound.setForeground(new java.awt.Color(255, 255, 255));
        GameOverSound.setText("GameOver-Music");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("GameOver-Music").equalsIgnoreCase("true")){
                GameOverSound.setSelected(true);
            }}
        GameOverSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GameOverSoundMousePressed(evt);
            }});
        OptionPanel.add(GameOverSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 190, 35));

        CheckBorderLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CheckBorderLabel.setForeground(new java.awt.Color(255, 255, 255));
        CheckBorderLabel.setText("Check Collision in Borders :");
        OptionPanel.add(CheckBorderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 270, 40));

        BorderOFF.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        BorderOFF.setForeground(new java.awt.Color(255, 255, 255));
        BorderOFF.setText("OFF");
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Border").equalsIgnoreCase("OFF")){
                BorderOFF.setSelected(true);
            }}
        BorderOFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Border","OFF");
            }
        });
        BorderButtonGroup.add(BorderOFF);
        OptionPanel.add(BorderOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 75, 30));

        BorderON.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        BorderON.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Border").equalsIgnoreCase("ON")){
                BorderON.setSelected(true);
            }}
        BorderON.setText("ON");
        BorderON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Border","ON");
            }
        });
        BorderButtonGroup.add(BorderON);
        OptionPanel.add(BorderON, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 75, 30));

        FirstMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        FirstMode.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Mode").equalsIgnoreCase("Forest")){
                FirstMode.setSelected(true);
            }}
        FirstMode.setText("Forest");
        FirstMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Mode","Forest");
            }
        });
        ModeButtonGroup.add(FirstMode);
        OptionPanel.add(FirstMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        SecondMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        SecondMode.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Mode").equalsIgnoreCase("Desert")){
                SecondMode.setSelected(true);
            }}
        SecondMode.setText("Desert");
        SecondMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Mode","Desert");
            }
        });
        ModeButtonGroup.add(SecondMode);
        OptionPanel.add(SecondMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, -1, -1));

        ThirdMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ThirdMode.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Mode").equalsIgnoreCase("Ocean")){
                ThirdMode.setSelected(true);
            }}
        ThirdMode.setText("Ocean");
        ThirdMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Mode","Ocean");
            }
        });
        ModeButtonGroup.add(ThirdMode);
        OptionPanel.add(ThirdMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 520, -1, -1));

        ForthMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ForthMode.setForeground(new java.awt.Color(255, 255, 255));
        if(new File("src/main/myFile.properties").exists()){
            if(getPropValue("Mode").equalsIgnoreCase("Space")){
                ForthMode.setSelected(true);
            }}
        ForthMode.setText("Space");
        ForthMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacePropValue("Mode","Space");
            }
        });
        ModeButtonGroup.add(ForthMode);
        OptionPanel.add(ForthMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 520, -1, -1));

        FirstModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirstModeLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Forest-Mode.jpg"));
        FirstModeLabel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReplacePropValue("Mode","Forest");
            }
        });

        FirstModeLabel.setOpaque(true);
        OptionPanel.add(FirstModeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 240, 180));

        SecondModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecondModeLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Desert_Mode.jpg"));
        SecondModeLabel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReplacePropValue("Mode","Desert");
            }
        });
        SecondModeLabel.setOpaque(true);
        OptionPanel.add(SecondModeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 240, 180));

        ThirdModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThirdModeLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Ocean_Mode.jpg"));
        ThirdModeLabel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReplacePropValue("Mode","Ocean");
            }
        });
        ThirdModeLabel.setOpaque(true);
        OptionPanel.add(ThirdModeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 240, 180));

        ForthModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ForthModeLabel.setIcon(new javax.swing.ImageIcon("src/main/images/Space_Mode.jpg"));
        ForthModeLabel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReplacePropValue("Mode","Space");
            }
        });
        ForthModeLabel.setOpaque(true);
        OptionPanel.add(ForthModeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 560, 240, 180));




        aboutPanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        aboutPanel.setBackground(new java.awt.Color(0, 20, 36));
        aboutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        ToufikContactButton.setBackground(new java.awt.Color(0, 20, 36));
        ToufikContactButton.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        ToufikContactButton.setForeground(new java.awt.Color(204, 255, 204));
        ToufikContactButton.setText("- Menaa Toufik");
        ToufikContactButton.setBorder(null);
        ToufikContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ToufikContactButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        ToufikContactButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ToufikContactButton.setOpaque(true);
        ToufikContactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    URI uri = null;
                    try {
                        uri = new URI("https://instagram.com/tou_officiel?igshid=yfcmqt4e8z7p");
                    }catch(URISyntaxException exx){System.out.println("0 problem");}
                    try {

                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) { System.out.println("1 problem");
                        /* TODO: error handling */ }
                } else {System.out.println("2 problem");
                    /* TODO: error handling */ }
            }


        });
        ToufikContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ToufikContactButton.setForeground(new java.awt.Color(204, 255, 204));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ToufikContactButton.setForeground(new java.awt.Color(165,205,255));
            }
        });
        aboutPanel.add(ToufikContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 125, 190, 30));

        BakirContactButton.setBackground(new java.awt.Color(0, 20, 36));
        BakirContactButton.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        BakirContactButton.setForeground(new java.awt.Color(204, 255, 204));
        BakirContactButton.setText("- Yagoub Bakir");
        BakirContactButton.setBorder(null);
        BakirContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BakirContactButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        BakirContactButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BakirContactButton.setOpaque(true);
        BakirContactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    URI uri = null;
                    try {
                        uri = new URI("https://www.instagram.com/bakir_artist/");
                    }catch(URISyntaxException exx){}
                    try {
                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) { /* TODO: error handling */ }
                } else {/* TODO: error handling */ }
            }


        });
        BakirContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BakirContactButton.setForeground(new java.awt.Color(204, 255, 204));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BakirContactButton.setForeground(new java.awt.Color(165,205,255));
            }



        });
        aboutPanel.add(BakirContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 155, 180, 35));

        HacenContactButton.setBackground(new java.awt.Color(0, 20, 36));
        HacenContactButton.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        HacenContactButton.setForeground(new java.awt.Color(204, 255, 204));
        HacenContactButton.setText("- Allout Hacen");
        HacenContactButton.setBorder(null);
        HacenContactButton.setBorderPainted(false);
        HacenContactButton.setContentAreaFilled(false);
        HacenContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HacenContactButton.setFocusPainted(false);
        HacenContactButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        HacenContactButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HacenContactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    URI uri = null;
                    try {
                        uri = new URI("https://www.instagram.com/hacen_allout/");
                    }catch(URISyntaxException exx){System.out.println("0 problem");}
                    try {

                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) { System.out.println("1 problem");
                        /* TODO: error handling */ }
                } else {System.out.println("2 problem");
                    /* TODO: error handling */ }
            }


        });
        HacenContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HacenContactButton.setForeground(new java.awt.Color(204, 255, 204));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HacenContactButton.setForeground(new java.awt.Color(165,205,255));
            }


        });
        aboutPanel.add(HacenContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 180, 30));

        SlimaneContactButton.setBackground(new java.awt.Color(0, 20, 36));
        SlimaneContactButton.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        SlimaneContactButton.setForeground(new java.awt.Color(204, 255, 204));
        SlimaneContactButton.setText("- Moussaoubrahim Slimane");
        SlimaneContactButton.setBorder(null);
        SlimaneContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SlimaneContactButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        SlimaneContactButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SlimaneContactButton.setOpaque(true);
        SlimaneContactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    URI uri = null;
                    try {
                        uri = new URI("https://www.instagram.com/sslimanebbm/");
                    }catch(URISyntaxException exx){System.out.println("0 problem");}
                    try {

                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) { System.out.println("1 problem");
                        /* TODO: error handling */ }
                } else {System.out.println("2 problem");
                    /* TODO: error handling */ }
            }



        });
        SlimaneContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SlimaneContactButton.setForeground(new java.awt.Color(204, 255, 204));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SlimaneContactButton.setForeground(new java.awt.Color(165,205,255));
            }

        });
        aboutPanel.add(SlimaneContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 330, 30));

        NadjibContactButton.setBackground(new java.awt.Color(0, 20, 36));
        NadjibContactButton.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        NadjibContactButton.setForeground(new java.awt.Color(204, 255, 204));
        NadjibContactButton.setText("- Bouaziz Nadjib");
        NadjibContactButton.setBorder(null);
        NadjibContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NadjibContactButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        NadjibContactButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NadjibContactButton.setOpaque(true);
        NadjibContactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    URI uri = null;
                    try {
                        uri = new URI("https://instagram.com/nadjib_bouaziz?igshid=lkse0za2urb4");
                    }catch(URISyntaxException exx){System.out.println("0 problem");}
                    try {

                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) { System.out.println("1 problem");
                        /* TODO: error handling */ }
                } else {System.out.println("2 problem");
                    /* TODO: error handling */ }
            }



        });
        NadjibContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NadjibContactButton.setForeground(new java.awt.Color(204, 255, 204));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NadjibContactButton.setForeground(new java.awt.Color(165,205,255));
            }


        });
        aboutPanel.add(NadjibContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 200, 30));



        AboutTextArea.setEditable(false);
        AboutTextArea.setBackground(new java.awt.Color(0, 20, 36));
        AboutTextArea.setFont(new java.awt.Font("Kannada MN", 0, 24)); // NOI18N
        AboutTextArea.setForeground(new java.awt.Color(204, 255, 204));
        AboutTextArea.setText(  "\n   The Snake game was created by our team,\n consisting of:"
                + " \n\t   \n\t   \n\t   \n\t   \n\t   \n\n   This team belongs to the start coding club, "
                + "and it is considered the first project \n of this team, and in this way snake game is the portal"
                + " that opened the vast world \n of programming in front of us.\n\n   The snake game relied on "
                + "the Java language in its creation by 100% through the \n eclipse application and NetBeans as "
                + "it is characterized by ease and simplicity of \n use which makes it a fun game that everyone can use."
                + " \n\n   We hope you like the game and thank you.");
        AboutTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(AboutTextArea);
        aboutPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 25, 1060, 576));


        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scan this QR code to join us in the club....");
        aboutPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 810, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/mac/Downloads/frame.png")); // NOI18N
        aboutPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 600, 150, 150));
        ClubLabel.setFont(new java.awt.Font("Kannada MN", 0, 48)); // NOI18N
        ClubLabel.setForeground(new java.awt.Color(51,255,255));
        ClubLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        ClubLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClubLabel.setText("Start Coding Club");




        HighScorePanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        HighScorePanel.setBackground(new java.awt.Color(0, 20, 36));
        HighScorePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HighScoreTitle.setFont(new java.awt.Font("Lao Sangam MN", 0, 48)); // NOI18N
        HighScoreTitle.setForeground(new java.awt.Color(255, 255, 255));
        HighScoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HighScoreTitle.setText("High Score by Level :");
        HighScorePanel.add(HighScoreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 900, 110));

        EasyLevelHighScore.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        EasyLevelHighScore.setForeground(new java.awt.Color(255, 255, 255));
        EasyLevelHighScore.setText("Easy Level :");
        HighScorePanel.add(EasyLevelHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 210, 50));

        MediumLevelHighScore.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        MediumLevelHighScore.setForeground(new java.awt.Color(255, 255, 255));
        MediumLevelHighScore.setText("Medium Level :");
        HighScorePanel.add(MediumLevelHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 270, 50));

        HardLevelHighScore.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        HardLevelHighScore.setForeground(new java.awt.Color(255, 255, 255));
        HardLevelHighScore.setText("Hard Level :");
        HighScorePanel.add(HardLevelHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 210, 50));

        ProfessionalLevelHighScore.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        ProfessionalLevelHighScore.setForeground(new java.awt.Color(255, 255, 255));
        ProfessionalLevelHighScore.setText("Professional Level :");
        HighScorePanel.add(ProfessionalLevelHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 370, 50));

        SuicideLevelHighScore.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        SuicideLevelHighScore.setForeground(new java.awt.Color(255, 255, 255));
        SuicideLevelHighScore.setText("Suicide Level :");
        HighScorePanel.add(SuicideLevelHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 270, 50));

        EasyRecord.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        EasyRecord.setForeground(new java.awt.Color(255, 255, 255));
        EasyRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(new File("src/main/myFile.properties").exists()){
            EasyRecord.setText(getPropValue("HighScoreEasy"));
        }
        HighScorePanel.add(EasyRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 210, 50));

        MediumRecord.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        MediumRecord.setForeground(new java.awt.Color(255, 255, 255));
        MediumRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(new File("src/main/myFile.properties").exists()){
            MediumRecord.setText(getPropValue("HighScoreMedium"));
        }
        HighScorePanel.add(MediumRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 210, 50));

        HardRecord.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        HardRecord.setForeground(new java.awt.Color(255, 255, 255));
        HardRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(new File("src/main/myFile.properties").exists()){
            HardRecord.setText(getPropValue("HighScoreHard"));
        }
        HighScorePanel.add(HardRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 210, 50));

        ProfessionalRecord.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        ProfessionalRecord.setForeground(new java.awt.Color(255, 255, 255));
        ProfessionalRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(new File("src/main/myFile.properties").exists()){
            ProfessionalRecord.setText(getPropValue("HighScoreProfessional"));
        }
        HighScorePanel.add(ProfessionalRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 210, 50));

        SuicideRecord.setFont(new java.awt.Font("Heiti TC", 0, 36)); // NOI18N
        SuicideRecord.setForeground(new java.awt.Color(255, 255, 255));
        SuicideRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(new File("src/main/myFile.properties").exists()){
            SuicideRecord.setText(getPropValue("HighScoreSuicide"));
        }
        HighScorePanel.add(SuicideRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 620, 210, 50));


        pack();



    }



    private void EditUserNameActionPerformed(java.awt.event.ActionEvent evt) {
        if(!UserNameTextField.isEditable()){
            UserNameTextField.setEditable(true);
            UserNameTextField.requestFocus();
            UserNameTextField.selectAll();
            EditUserName.setText("Save");
        }else{
            if(!"".equals(UserNameTextField.getText().trim())){
                ReplacePropValue("UserName",UserNameTextField.getText());
            }else{
                UserNameTextField.setText("Utilisateur");
                ReplacePropValue("UserName","Utilisateur");
            }
            EditUserName.setText("Edit");
            UserNameTextField.setEditable(false);
            if(this.getContentPane().isAncestorOf(GamePanel))  {
                GamePanel.setFocusable(true);
                GamePanel.requestFocusInWindow();
            }
        }
    }


    TheGamePanel GamePanel;
    private void PlayLabelMousePressed(java.awt.event.MouseEvent evt) {
        //this.removeAll();
        clip.stop();
        this.remove(MenuPanel);
        this.remove(MainPanel);
        GamePanel= new TheGamePanel(0,0);
        GamePanel.setPreferredSize(new java.awt.Dimension(1300, 750));




        //this.setContentPane(GamePanel);
        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));
        MenuPanel.add(PauseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 0, 55, 50));
        MenuPanel.add(HighScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 300, 60));
        MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 50));
        MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, 300, 40));
        MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 110, 40));
        MenuLabel.setVisible(true);
        PauseLabel.setVisible(true);
        HighScoreLabel.setVisible(true);

        this.getContentPane().add(GamePanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);

        GamePanel.setFocusable(true);
        GamePanel.requestFocusInWindow();


        this.revalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void MenuLabelMousePressed(java.awt.event.MouseEvent evt) {


        if(this.getContentPane().isAncestorOf(GamePanel))  {
            this.remove(GamePanel);
            HighScoreLabel.setVisible(false);
            PauseLabel.setVisible(false);
            if(getPropValue("Play-Music").equalsIgnoreCase("true") && getPropValue("Sound").equalsIgnoreCase("General") )
                GamePanel.clip.stop();
        }else if(this.getContentPane().isAncestorOf(OptionPanel)){
            HighScoreLabel.setText("High Score : " + getPropValue("HighScore"+getPropValue("Level")));
            this.remove(OptionPanel);
        }else if(this.getContentPane().isAncestorOf(aboutPanel)){
            ClubLabel.setVisible(false);
            this.remove(aboutPanel);
        }else if(this.getContentPane().isAncestorOf(HighScorePanel)){
            this.remove(HighScorePanel);
        }
        if(getPropValue("Home-Music").equalsIgnoreCase("true") && getPropValue("Sound").equalsIgnoreCase("General")){

            clip.start();

        }


        this.remove(MenuPanel);
        MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 230, 50));
        MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 390, 40));
        MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 110, 40));

        this.getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);
        MenuLabel.setVisible(false);

        PlayLabel.setForeground(new java.awt.Color(255,255,255));
        OptionLabel.setForeground(new java.awt.Color(255,255,255));
        AboutLabel.setForeground(new java.awt.Color(255,255,255));
        HigHScorELabel.setForeground(new java.awt.Color(255,255,255));
        this.revalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void ExitLabelMousePressed(java.awt.event.MouseEvent evt) {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void HigHScorELabelMousePressed(java.awt.event.MouseEvent evt){
        this.remove(MenuPanel);
        this.remove(MainPanel);


        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));
        MenuPanel.remove(UserNameLabel);
        MenuPanel.remove(UserNameTextField);
        MenuPanel.remove(EditUserName);
        // MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 50));
        // MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, 290, 40));
        // MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 110, 40));
        MenuLabel.setVisible(true);
        MenuLabel.setFocusable(true);
        this.getContentPane().add(HighScorePanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);




        this.revalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    private void OptionLabelMousePressed(java.awt.event.MouseEvent evt) {
        this.remove(MenuPanel);
        this.remove(MainPanel);


        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));
        MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 50));
        MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, 390, 40));
        MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 110, 40));
        MenuLabel.setVisible(true);
        MenuLabel.setFocusable(true);
        this.getContentPane().add(OptionPanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);




        this.revalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void AboutLabelMousePressed(java.awt.event.MouseEvent evt){
        this.remove(MenuPanel);
        this.remove(MainPanel);


        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));
        MenuPanel.add(ClubLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 0, 450, 50));
        MenuPanel.remove(UserNameLabel);
        MenuPanel.remove(UserNameTextField);
        MenuPanel.remove(EditUserName);
        ClubLabel.setVisible(true);
        MenuLabel.setVisible(true);
        MenuLabel.setFocusable(true);
        this.getContentPane().add(aboutPanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);




        this.revalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void setDefaultPropValues(){

        //Instantiating the properties file
        Properties Settings = new Properties();

        //Populating the properties file
        Settings.put("UserName","Utilisateur");
        Settings.put("Level", "Medium");
        Settings.put("SpeedMode", "Default");
        Settings.put("Speed", "50");
        Settings.put("Sound", "General");
        Settings.put("Home-Music","true");
        Settings.put("Play-Music","true");
        Settings.put("GameOver-Music","true");
        Settings.put("Border", "On");
        Settings.put("Mode", "Forest");
        Settings.put("HighScoreEasy", "Not Yet");
        Settings.put("HighScoreMedium", "Not Yet");
        Settings.put("HighScoreHard", "Not Yet");
        Settings.put("HighScoreProfessional", "Not Yet");
        Settings.put("HighScoreSuicide", "Not Yet");

        try {
            //Instantiating the FileInputStream for output file
            String path = "src/main/myFile.properties";
            FileOutputStream outputStrem = new FileOutputStream(path);
            //Storing the properties file
            Settings.store(outputStrem, "This is the Setting file");
            HomeSound.setSelected(true);
            PlaySound.setSelected(true);
            GameOverSound.setSelected(true);
            BorderON.setSelected(true);
            NormalSpeed.setSelected(true);
            GeneralSound.setSelected(true);
            DefaultSpeed.setSelected(true);
            FirstMode.setSelected(true);
            MediumLevel.setSelected(true);
            UserNameTextField.setText("Utilisateur");
            clip.start();

        } catch (IOException ex) {
            Logger.getLogger(SnakeGameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                Logger.getLogger(SnakeGameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    private void ManuallySpeedActionPerformed(java.awt.event.ActionEvent evt) {
        SpeedSlider.setEnabled(true);
        SlowSpeed.setEnabled(false);
        NormalSpeed.setEnabled(false);
        FastSpeed.setEnabled(false);
        ReplacePropValue("SpeedMode","Manually");
        ReplacePropValue("Speed",String.valueOf(SpeedSlider.getValue()*1.5));
    }

    private void DefaultSpeedActionPerformed(java.awt.event.ActionEvent evt) {
        SpeedSlider.setEnabled(false);
        SlowSpeed.setEnabled(true);
        NormalSpeed.setEnabled(true);
        FastSpeed.setEnabled(true);
        ReplacePropValue("SpeedMode","Default");
        if(SlowSpeed.isSelected()){
            ReplacePropValue("Speed","0");
        }else  if(NormalSpeed.isSelected()){
            ReplacePropValue("Speed","50");
        }else {
            ReplacePropValue("Speed","100");
        }
    }

    private void GeneralSoundActionPerformed(java.awt.event.ActionEvent evt) {
        HomeSound.setEnabled(true);
        PlaySound.setEnabled(true);
        GameOverSound.setEnabled(true);
        ReplacePropValue("Sound","General");
        if(getPropValue("Home-Music").equalsIgnoreCase("true")){
            clip.start();
        }
    }

    private void SilentSoundActionPerformed(java.awt.event.ActionEvent evt) {
        HomeSound.setEnabled(false);
        PlaySound.setEnabled(false);
        GameOverSound.setEnabled(false);
        clip.stop();
        ReplacePropValue("Sound","Silent");
    }

    private void HomeSoundMousePressed(java.awt.event.MouseEvent evt) {

        if(HomeSound.isSelected()){
            clip.stop();
            ReplacePropValue("Home-Music","false");

        }else{
            clip.start();
            ReplacePropValue("Home-Music","true");
        }
    }

    private void PlaySoundMousePressed(java.awt.event.MouseEvent evt) {
        if(PlaySound.isSelected()){
            ReplacePropValue("Play-Music","false");
        }else{
            ReplacePropValue("Play-Music","true");
        }
    }

    private void GameOverSoundMousePressed(java.awt.event.MouseEvent evt) {
        if(GameOverSound.isSelected()){
            ReplacePropValue("GameOver-Music","false");
        }else{
            ReplacePropValue("GameOver-Music","true");
        }
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



    public static void main(String[] args) {
        new SnakeGameFrame().setVisible(true);
    }

}
