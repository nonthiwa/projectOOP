package menu;

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.IOException;
import javax.imageio.ImageIO;
public class LevelMenu {
    private ImageIcon easyb, easybh, normalb, normalbh, hardb, hardbh, backb, backbh;
    private boolean check=false;
    JFrame window;
    Container con;
    JPanel titleNamePanel, levelButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton easyButton,normalButton,hardButton,backButton;

    public LevelMenu() {
        getImages();
        levelButtonPanel = new JPanel();
        levelButtonPanel.setBounds(300, 300, 200, 300);
//        levelButtonPanel.setBackground(Color.black);
        levelButtonPanel.setOpaque(false);
        
        easyButton = new JButton("");
        easyButton.setBackground(Color.black);
        easyButton.setForeground(Color.white);
        easyButton.setOpaque(false);
        easyButton.setBorderPainted(false);
        easyButton.setIcon(easyb);
        easyButton.setRolloverEnabled(true);
        easyButton.setRolloverIcon(easybh);
        easyButton.setFont(normalFont);
        
        normalButton = new JButton("");
        normalButton.setBackground(Color.black);
        normalButton.setForeground(Color.white);
        normalButton.setOpaque(false);
        normalButton.setBorderPainted(false);
        normalButton.setIcon(normalb);
        normalButton.setRolloverEnabled(true);
        normalButton.setRolloverIcon(normalbh);
        normalButton.setFont(normalFont);
        
        hardButton = new JButton("");
        hardButton.setBackground(Color.black);
        hardButton.setForeground(Color.white);
        hardButton.setOpaque(false);
        hardButton.setBorderPainted(false);
        hardButton.setIcon(hardb);
        hardButton.setRolloverEnabled(true);
        hardButton.setRolloverIcon(hardbh);
        hardButton.setFont(normalFont);
        
        backButton = new JButton("");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setIcon(backb);
        backButton.setRolloverEnabled(true);
        backButton.setRolloverIcon(backbh);
        backButton.setFont(normalFont);
        
        levelButtonPanel.add(easyButton);
        levelButtonPanel.add(normalButton);
        levelButtonPanel.add(hardButton);
        levelButtonPanel.add(backButton);
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
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

    public void setLevelButtonPanel(JPanel levelButtonPanel) {
        this.levelButtonPanel = levelButtonPanel;
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

    public void setEasyButton(JButton easyButton) {
        this.easyButton = easyButton;
    }

    public void setNormalButton(JButton normalButton) {
        this.normalButton = normalButton;
    }

    public void setHardButton(JButton hardButton) {
        this.hardButton = hardButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
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

    public JPanel getLevelButtonPanel() {
        return levelButtonPanel;
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

    public JButton getEasyButton() {
        return easyButton;
    }

    public JButton getNormalButton() {
        return normalButton;
    }

    public JButton getHardButton() {
        return hardButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    public void getImages(){
        try{
            easyb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/easy.png")));
            easybh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/easyhover.png")));
            normalb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/normal.png")));
            normalbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/normalhover.png")));
            hardb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/hard.png")));
            hardbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/hardhover.png")));
            backb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/back.png")));
            backbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/backhover.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
