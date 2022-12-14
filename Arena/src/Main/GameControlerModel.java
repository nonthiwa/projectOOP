package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GameControlerModel extends JFrame{
    private JFrame controlwindow;
    private JButton attack,item,defend;
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public GameControlerModel() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = ((centerPoint.x - windowSize.width)/2)+850;
        int dy = ((centerPoint.y - windowSize.height)/2)+70;
        controlwindow = new JFrame();
        attack = new JButton("ATTACK");
        attack.setBackground(Color.black);
        attack.setForeground(Color.white);
        attack.setFont(normalFont);
        item = new JButton("ITEM");
        item.setBackground(Color.black);
        item.setForeground(Color.white);
        item.setFont(normalFont);
        defend = new JButton("DEFEND");
        defend.setBackground(Color.black);
        defend.setForeground(Color.white);
        defend.setFont(normalFont);
        controlwindow.setSize(300,500);
        controlwindow.setLayout(new GridLayout(3,1));
        controlwindow.add(attack);
        controlwindow.add(item);
        controlwindow.add(defend);
        
        controlwindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controlwindow.setLocation(dx,dy);
        controlwindow.setVisible(true);
        
    }

    public JFrame getControlwindow() {
        return controlwindow;
    }

    public JButton getAttack() {
        return attack;
    }

    public JButton getItem() {
        return item;
    }

    public JButton getDefend() {
        return defend;
    }

    public Font getNormalFont() {
        return normalFont;
    }
 
}
