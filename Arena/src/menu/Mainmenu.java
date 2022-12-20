package menu;

import Main.soundcontrol;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Mainmenu extends JFrame{
    private ImageIcon playb, playbh, tutorialb, tutorialbh, exitb, exitbh;
    private Image bg,tutorbg,tutorbgS;
    private soundcontrol Sound;
    private JFrame window;
    private Container con;
    private JPanel titleNamePanel, startButtonPanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private JButton startButton;
    private JButton exitButton;
    private JButton howtoButton;

    public Mainmenu() {   
        Sound = new soundcontrol();
        window = new JFrame();
//        window.setSize(800,700)DAN;
        window.setPreferredSize(new Dimension(800, 700));
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getImages();
        Imagebg("/BackgroundPic/wallpaperflare.com_wallpaper.jpg");
        window.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, null);
            }
        });
        window.setLayout(null);
        window.setVisible(true);
        
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setOpaque(false);
//        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("THE ARENA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(275, 300, 250, 200);
        startButtonPanel.setOpaque(false);
//        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("");
        startButton.setBackground(Color.black);
        startButton.setOpaque(false);
        startButton.setBorderPainted(false);
        startButton.setIcon(playb);
        startButton.setRolloverEnabled(true);
        startButton.setRolloverIcon(playbh);
        startButton.setFont(normalFont);
        
        howtoButton = new JButton("");
        howtoButton.setBackground(Color.black);
        howtoButton.setOpaque(false);
        howtoButton.setBorderPainted(false);
        howtoButton.setIcon(tutorialb);
        howtoButton.setRolloverEnabled(true);
        howtoButton.setRolloverIcon(tutorialbh);
        howtoButton.setFont(normalFont);
        
        exitButton = new JButton("");
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorderPainted(false);
        exitButton.setIcon(exitb);
        exitButton.setRolloverEnabled(true);
        exitButton.setRolloverIcon(exitbh);
        exitButton.setFont(normalFont);
        
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.add(howtoButton);
        startButtonPanel.add(exitButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        titleNamePanel.revalidate();
        startButtonPanel.revalidate();
        Sound.playMusic(0);
    }

    public void setSound(soundcontrol Sound) {
        this.Sound = Sound;
    }

    public void setHowtoButton(JButton howtoButton) {
        this.howtoButton = howtoButton;
    }

    public soundcontrol getSound() {
        return Sound;
    }

    public JButton getHowtoButton() {
        return howtoButton;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void setCon(Container con) {
        this.con = con;
    }

    public void setTitleNamePanel(JPanel titleNamePanel) {
        this.titleNamePanel = titleNamePanel;
    }

    public void setStartButtonPanel(JPanel startButtonPanel) {
        this.startButtonPanel = startButtonPanel;
    }

    public void setTitleNameLabel(JLabel titleNameLabel) {
        this.titleNameLabel = titleNameLabel;
    }

    public void setTitleFont(Font titleFont) {
        this.titleFont = titleFont;
    }

    public void setNormalFont(Font normalFont) {
        this.normalFont = normalFont;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JFrame getWindow() {
        return window;
    }

    public Container getCon() {
        return con;
    }

    public JPanel getTitleNamePanel() {
        return titleNamePanel;
    }

    public JPanel getStartButtonPanel() {
        return startButtonPanel;
    }

    public JLabel getTitleNameLabel() {
        return titleNameLabel;
    }

    public Font getTitleFont() {
        return titleFont;
    }

    public Font getNormalFont() {
        return normalFont;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
    
    public void Imagebg(String imagePath){
      try{
           this.bg = ImageIO.read(getClass().getResourceAsStream(imagePath));
      }
      catch(IOException e){
            e.printStackTrace();
        }
   
  }
    public void getImages(){
        try{
            tutorbg =ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/wallpaperflare.com_wallpaper.jpg"));
            tutorbgS = tutorbg.getScaledInstance(800, 700, Image.SCALE_DEFAULT);
            playb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/play.png")));
            playbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/playhover.png")));
            tutorialb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/tutorial.png")));
            tutorialbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/tutorialhover.png")));
            exitb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/exit.png")));
            exitbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/exithover.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
