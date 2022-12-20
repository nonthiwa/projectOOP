package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import menu.Menucontrol;

public class GameOver extends JFrame{
    private JFrame frame;
    private ImageIcon retryb,retrybh;
    private Image bg, bgS;
    private Container con;
    private JButton retryButton;
    private JPanel titleNamePanel,retryButtonPanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public GameOver(){
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getImages();
        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgS, 0, 0, null);
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
        
        con = frame.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setOpaque(false);
        titleNameLabel = new JLabel("GAME OVER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        retryButtonPanel = new JPanel();
        retryButtonPanel.setBounds(275, 300, 250, 200);
        retryButtonPanel.setOpaque(false);
        
        retryButton = new JButton();
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
                new Menucontrol();
                
            }
        });
        retryButton.setBackground(Color.black);
        retryButton.setOpaque(false);
        retryButton.setBorderPainted(false);
        retryButton.setIcon(retryb);
        retryButton.setRolloverEnabled(true);
        retryButton.setRolloverIcon(retrybh);
        retryButtonPanel.add(retryButton);
        
        con.add(titleNamePanel);
        con.add(retryButtonPanel);
        titleNamePanel.revalidate();
        retryButtonPanel.revalidate();
    }
    
    public void getImages(){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/wallpaperflare.com_wallpaper_3.jpg"));
            bgS = bg.getScaledInstance(800, 700, Image.SCALE_DEFAULT);
            retryb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/menu.png")));
            retrybh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/menuhover.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
}
