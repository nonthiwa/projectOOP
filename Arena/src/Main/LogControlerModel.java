package Main;

import entity.Enemy;
import entity.Enemy2;
import entity.Enemy3;
import entity.Hero;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LogControlerModel extends JFrame{
    private BufferedImage loghbg, logmbg;
    private JFrame controlwindow;
    private JTextAreaPlus logh, logm;
    private Font normalFont = new Font("Courier New", Font.PLAIN, 20);
    private Hero hero;
    private Enemy e1;
    private Enemy2 e2;
    private Enemy3 e3;
    public LogControlerModel(Hero hero, Enemy enemy, Enemy2 enemy2, Enemy3 enemy3, int type, int stage) {
        getImages();
        setHero(hero);
        setE1(enemy);
        setE2(enemy2);
        setE3(enemy3);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = ((centerPoint.x - windowSize.width)/2)+850;
        int dy = ((centerPoint.y - windowSize.height)/2)-180;
        controlwindow = new JFrame("Log");
        logh = new JTextAreaPlus("\n Hero Status\n HP : "+hero.getHp()+"/100\n ATK : "+hero.getAtk());
        logm = new JTextAreaPlus("\n Enemy Status\n HP : "+e1.getHp()+"\n ATK : "+e1.getAtk());
        logh.setImage(loghbg);
        logh.setImage(logmbg);
        logh.setBackground(Color.black);
        logh.setForeground(Color.black);
        logh.setFont(normalFont);
        logh.setEditable(false);
        logm.setImage(loghbg);
        logm.setBackground(Color.black);
        logm.setForeground(Color.black);
        logm.setFont(normalFont);
        logm.setEditable(false);
        controlwindow.setSize(300,250);
        controlwindow.setLayout(new GridLayout(2,1));
        controlwindow.add(logh);
        controlwindow.add(logm);
        
        controlwindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controlwindow.setLocation(dx,dy);
        controlwindow.setVisible(true);
        
    }

    public Enemy getE1() {
        return e1;
    }

    public Enemy2 getE2() {
        return e2;
    }

    public Enemy3 getE3() {
        return e3;
    }

    public void setE1(Enemy e1) {
        this.e1 = e1;
    }

    public void setE2(Enemy2 e2) {
        this.e2 = e2;
    }

    public void setE3(Enemy3 e3) {
        this.e3 = e3;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public JFrame getControlwindow() {
        return controlwindow;
    }

    public JTextArea getLogh() {
        return logh;
    }
    public JTextArea getLogm() {
        return logm;
    }

    public Font getNormalFont() {
        return normalFont;
    }
    
    public void getImages(){
        try{
            loghbg = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/loghbg.png"));
            logmbg = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/logmbg.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void closeWindow(){
        controlwindow.dispose();
    }
}