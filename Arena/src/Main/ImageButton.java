package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;


public class ImageButton extends JButton{
    
    private Image img;
    
     public void setImage(BufferedImage image){
        this.img = image;
        repaint();
     }
    @Override
    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, this);
    }

}
