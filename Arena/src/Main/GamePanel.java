package Main;

import entity.Enemy;
import entity.Enemy2;
import entity.Enemy3;
import entity.Hero;
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
    
    int stage = 1;
    
    Thread gameThread;
    Enemy enemy = new Enemy(this);
    Enemy2 enemy2 = new Enemy2(this);
    Enemy3 enemy3 = new Enemy3(this);
    Hero hero = new Hero(this);
    GameControlerModel gameControlmodel = new GameControlerModel();
    LogControlerModel logControlmodel = new LogControlerModel();
    GameControler gameControl = new GameControler(gameControlmodel,hero, logControlmodel, enemy, enemy2, enemy3, stage);
    int FPS = 60;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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
        if (hero.getHp() <= 0){
            stage = 2;
            System.out.println(stage);
        }
        while(gameThread != null){
            if (enemy.getHp() <= 0){
            stage = 2;
            }
            else{
            }
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
        if(stage == 1){
            enemy.update();
        }
        if (stage == 2){
            enemy2.update();
        }
        if(stage == 3){
            enemy3.update();
        }
        hero.update();
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        if(stage == 1){
            enemy.draw(g2);
        }
        if(stage == 2){
            enemy2.draw(g2);
        }
        if(stage == 3){
            enemy3.draw(g2);
        }
        hero.draw(g2);
        
        g2.dispose();
        
    }

    public Hero getHero() {
        return hero;
    }


}