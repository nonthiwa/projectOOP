package Main;

import entity.Enemy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable {
    
    //SCREEN SETTING
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;//48x48 title
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;//768 pixels
    final int screenHeight = tileSize * maxScreenRow;//576 pixels
    
    //test for animation
    KeyHandler keyH = new KeyHandler();
    int playerX = 100;
    int playerY = 100;
    int speed = 4;
    //test for animation
    
    Thread gameThread;
    Enemy enemy = new Enemy(this);
    
    int FPS = 60;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        //test for animation
        this.addKeyListener(keyH);
        this.setFocusable(true);
        //test for animation
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            delta +=(currentTime - lastTime)/ drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

        }
    }
    public void update(){
        enemy.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        enemy.draw(g2);
        
        g2.dispose();
        
    }
}
