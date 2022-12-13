import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
public class LevelMenu {
    private boolean check=false;
    JFrame window;
    Container con;
    JPanel titleNamePanel, levelButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton easyButton,normalButton,hardButton,backButton;

    public LevelMenu() {
        levelButtonPanel = new JPanel();
        levelButtonPanel.setBounds(300, 400, 200, 200);
        levelButtonPanel.setBackground(Color.black);
        
        easyButton = new JButton("EASY");
        easyButton.setBackground(Color.black);
        easyButton.setForeground(Color.white);
        easyButton.setFont(normalFont);
        
        normalButton = new JButton("NORMAL");
        normalButton.setBackground(Color.black);
        normalButton.setForeground(Color.white);
        normalButton.setFont(normalFont);
        
        hardButton = new JButton("HARD");
        hardButton.setBackground(Color.black);
        hardButton.setForeground(Color.white);
        hardButton.setFont(normalFont);
        
        backButton = new JButton("BACK");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
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
    
    
}
