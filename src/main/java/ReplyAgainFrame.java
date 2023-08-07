
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReplyAgainFrame extends JFrame {

    TheGamePanel GamePanel;
    JPanel MainPanel;
    JPanel MenuPanel;
    JLabel HighScoreLabel;
    JLabel MenuLabel;
    JLabel PauseLabel;
    JLabel UserNameLabel;
    JTextField UserNameTextField;
    JButton EditUserName;

    public ReplyAgainFrame(int Score,int Lives) {
        GamePanel = new TheGamePanel(Score,Lives);
        MainPanel = new JPanel();
        MenuPanel = new JPanel();
        MenuLabel = new JLabel();
        PauseLabel = new JLabel();
        HighScoreLabel = new JLabel();
        UserNameLabel = new JLabel();
        UserNameTextField = new JTextField();
        EditUserName = new JButton();



        MainPanel.setBackground(new java.awt.Color(0, 20, 36));
        MainPanel.setMaximumSize(new java.awt.Dimension(1300, 750));
        MainPanel.setMinimumSize(new java.awt.Dimension(1300, 750));
        MainPanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        MenuPanel.setBackground(new java.awt.Color(0, 20, 36));
        MenuPanel.setPreferredSize(new java.awt.Dimension(1300, 50));
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


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
        PauseLabel.setIcon(new javax.swing.ImageIcon("/Users/mac/NetBeansProjects/SnakeGame/src/snakegame/images/pause.png")); // NOI18N
        PauseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(TheGamePanel.paused)
                    TheGamePanel.paused = false;
                else
                    TheGamePanel.paused = true;
            }
        });


        GamePanel.setPreferredSize(new java.awt.Dimension(1300, 750));
        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 50));
        MenuPanel.add(PauseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 0, 55, 50));
        MenuPanel.add(HighScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 300, 60));
        MenuPanel.add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 50));
        MenuPanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, 390, 40));
        MenuPanel.add(EditUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 110, 40));
        MenuLabel.setVisible(true);
        PauseLabel.setVisible(true);
        HighScoreLabel.setVisible(true);


        getContentPane().add(MenuPanel, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(GamePanel, java.awt.BorderLayout.CENTER);



        setTitle("Snake");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1300, 800));
        setMaximumSize(new java.awt.Dimension(1300, 800));
        setMinimumSize(new java.awt.Dimension(1300, 800));
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        GamePanel.setFocusable(true);
        GamePanel.requestFocusInWindow();

    }


    private void MenuLabelMousePressed(java.awt.event.MouseEvent evt) {
        if(getPropValue("Play-Music").equalsIgnoreCase("true") && getPropValue("Sound").equalsIgnoreCase("General") )
            GamePanel.clip.stop();
        dispose();
        SnakeGameFrame frame = new SnakeGameFrame();
        frame.setVisible(true);

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



}
