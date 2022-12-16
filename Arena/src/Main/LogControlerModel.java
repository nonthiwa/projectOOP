package Main;

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
    public LogControlerModel() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = ((centerPoint.x - windowSize.width)/2)+850;
        int dy = ((centerPoint.y - windowSize.height)/2)-130;
        controlwindow = new JFrame("Log");
        log = new JTextArea("HP : 100/100");
        log.setBackground(Color.black);
        log.setForeground(Color.white);
        log.setFont(normalFont);
        log.setEditable(true);
        controlwindow.setSize(300,200);
        controlwindow.setLayout(new GridLayout(1,1));
        controlwindow.add(log);
        
        controlwindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controlwindow.setLocation(dx,dy);
        controlwindow.setVisible(true);
        
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