package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;

public class JTextAreaPlus extends JTextArea{
    
    BufferedImage image;
    
    public JTextAreaPlus(){
        super();
    }
    
    public JTextAreaPlus(String string){
        super(string);
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
        setOpaque(false);
        repaint();
    }
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, this);
        super.paint(g);
    }
}