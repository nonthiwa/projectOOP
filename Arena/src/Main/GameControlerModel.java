package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GameControlerModel extends JFrame{
    private ImageIcon attackb, attackbh, powerb, powerbh, healb, healbh;
    private JFrame controlwindow;
    private JButton attack,heal,power;
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public GameControlerModel() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = ((centerPoint.x - windowSize.width)/2)+850;
        int dy = ((centerPoint.y - windowSize.height)/2)+70;
        getImages();
        controlwindow = new JFrame("Option");
        attack = new JButton("");
        attack.setBackground(Color.red);
        attack.setForeground(Color.white);
        attack.setBorderPainted(false);
        attack.setIcon(attackb);
        attack.setRolloverEnabled(true);
        attack.setRolloverIcon(attackbh);
        attack.setFont(normalFont);
        heal = new JButton("");
        heal.setBackground(Color.cyan);
        heal.setForeground(Color.white);
        heal.setBorderPainted(false);
        heal.setIcon(healb);
        heal.setRolloverEnabled(true);
        heal.setRolloverIcon(healbh);
        heal.setFont(normalFont);
        power = new JButton("");
        power.setBackground(Color.orange);
        power.setForeground(Color.white);
        power.setBorderPainted(false);
        power.setIcon(powerb);
        power.setRolloverEnabled(true);
        power.setRolloverIcon(powerbh);
        power.setFont(normalFont);
        controlwindow.setSize(300,500);
        controlwindow.setLayout(new GridLayout(3,1));
        controlwindow.add(attack);
        controlwindow.add(heal);
        controlwindow.add(power);
        
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

    public JButton getHeal() {
        return heal;
    }

    public JButton getPower() {
        return power;
    }

    public Font getNormalFont() {
        return normalFont;
    }
    
    public void getImages(){
        try{
            attackb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/attack.png")));
            attackbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/attackhover.png")));
            healb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/heal.png")));
            healbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/healhover.png")));
            powerb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/power.png")));
            powerbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/powerhover.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
}
