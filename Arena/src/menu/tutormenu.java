package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tutormenu extends JFrame{
    private JFrame frame;
    private ImageIcon backb,backbh;
    private Image bg, bgS;
    private Container con;
    private JButton backButton;
    private JPanel backButtonPanel;
    private boolean check=false;
    public tutormenu(){
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
        
        
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(550, 570, 250, 200);
        backButtonPanel.setOpaque(false);
        
        backButton = new JButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCheck(false);
                getFrame().dispose(); 
            }
        });
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setIcon(backb);
        backButton.setRolloverEnabled(true);
        backButton.setRolloverIcon(backbh);
        backButtonPanel.add(backButton);
        
        con.add(backButtonPanel);
        backButtonPanel.revalidate();
    }
    
    public void getImages(){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/tutor.png"));
            bgS = bg.getScaledInstance(790, 670, Image.SCALE_DEFAULT);
            backb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/back.png")));
            backbh = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/buttonPic/backhover.png")));
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

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }
    
}
