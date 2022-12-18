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
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LogControlerModel extends JFrame{
    private JFrame controlwindow;
    private JTextArea log;
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private Hero hero;
    private Enemy e1;
    private Enemy2 e2;
    private Enemy3 e3;
    public LogControlerModel(Hero hero, Enemy enemy, Enemy2 enemy2, Enemy3 enemy3, int type, int stage) {
        setHero(hero);
        setE1(enemy);
        setE2(enemy2);
        setE3(enemy3);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = ((centerPoint.x - windowSize.width)/2)+850;
        int dy = ((centerPoint.y - windowSize.height)/2)-130;
        controlwindow = new JFrame("Log");
        log = new JTextArea("Hero Status\nHP : "+hero.getHp()+"/100\nATK : "+hero.getAtk()+"\nEnemy Status\nHP : "+e1.getHp()+"\nATK : "+e1.getAtk());
        log.setBackground(Color.black);
        log.setForeground(Color.white);
        log.setFont(normalFont);
        log.setEditable(true);
        controlwindow.setSize(300,250);
        controlwindow.setLayout(new GridLayout(1,1));
        controlwindow.add(log);
        
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

    public JTextArea getLog() {
        return log;
    }

    public Font getNormalFont() {
        return normalFont;
    }
}