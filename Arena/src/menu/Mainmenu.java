package menu;

import Main.soundcontrol;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
public class Mainmenu extends JFrame{
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
        window.setSize(800,700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("THE ARENA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(275, 400, 250, 150);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        
        howtoButton = new JButton("HOW TO PLAY");
        howtoButton.setBackground(Color.black);
        howtoButton.setForeground(Color.white);
        howtoButton.setFont(normalFont);
        
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.setFont(normalFont);
        
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.add(howtoButton);
        startButtonPanel.add(exitButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
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
    
    
}
