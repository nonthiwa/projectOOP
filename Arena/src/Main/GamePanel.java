package Main;

import entity.Enemy;
import entity.Enemy2;
import entity.Enemy3;
import entity.Hero;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTING
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;//48x48 titleK
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;//768 pixelsI
    public final int screenHeight = tileSize * maxScreenRow;//576 pixelsB

    private BufferedImage image1,    image2, image3;
    private Image bg1, bg2, bg3;

    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private String gm = "Gamer Over", c = "Congratulations!!";

    private int stage = 1;
    public int type;
    
    private JFrame startgame;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Hero hero;
    private GameControlerModel gameControlmodel;
    private LogControlerModel logControlmodel;
    private GameControler gameControl;
    private int action = 0;
    private soundcontrol Sound;
    public Thread gameThread;
    public int FPS = 60;

    public GamePanel(int i, JFrame window){
        getImages();
        setStartgame(window);
        Sound = new soundcontrol();
        Sound.playMusic(1);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        type = i;
        enemy = new Enemy(this,type);
        enemy2 = new Enemy2(this,type);
        enemy3 = new Enemy3(this,type);
        hero = new Hero(this);
        gameControlmodel = new GameControlerModel();
        logControlmodel = new LogControlerModel(hero, enemy, enemy2, enemy3, type, stage);
        gameControl = new GameControler(gameControlmodel,hero, logControlmodel, enemy, enemy2, enemy3, stage);
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
            if (getStage() == 5){
                GameOver gameover = new GameOver();
                getStartgame().dispose();
                gameThread.stop();
            }
            if (getStage() == 4){
                GameWinner gamewinner = new GameWinner();
                getStartgame().dispose();
                gameThread.stop();
            }
            if (hero.getHp() <= 0){
                setStage(5);
                Sound.stopMusic();
                getLogControlmodel().closeWindow();
                getGameControlmodel().closeWindow();
            }
            if(enemy.getHp() > 0 && hero.getHp() >0){
                getLogControlmodel().getLogh().setText("\n Hero Status\n HP : "+getHero().getHp()+"/100\n ATK : "+getHero().getAtk());
                getLogControlmodel().getLogm().setText("\n Enemy Status\n HP : "+getEnemy().getHp()+"\n ATK : "+getEnemy().getAtk());
            }
            if (enemy.getHp() <= 0 && enemy2.getHp() > 0 && hero.getHp() >0){
                setStage(2);
                getLogControlmodel().getLogh().setText("\n Hero Status\n HP : "+getHero().getHp()+"/100\n ATK : "+getHero().getAtk());
                getLogControlmodel().getLogm().setText("\n Enemy Status\n HP : "+getEnemy2().getHp()+"\n ATK : "+getEnemy2().getAtk());

            }
            if (enemy3.getHp() > 0 && enemy2.getHp() <= 0 && hero.getHp() > 0){
                setStage(3);
                getLogControlmodel().getLogh().setText("\n Hero Status\n HP : "+getHero().getHp()+"/100\n ATK : "+getHero().getAtk());
                getLogControlmodel().getLogm().setText("\n Enemy Status\n HP : "+getEnemy3().getHp()+"\n ATK : "+getEnemy3().getAtk());
            }
            if (enemy3.getHp() <= 0 && enemy2.getHp() <= 0 && hero.getHp() > 0){
                setStage(4);
                Sound.stopMusic();
                getLogControlmodel().closeWindow();
                getGameControlmodel().closeWindow();
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
        if(getStage() == 1){
            hero.update();
            enemy.update();
        }
        if (getStage() == 2){
            hero.update();
            enemy2.update();
        }
        if(getStage() == 3){
            hero.update();
            enemy3.update();
        }

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        switch (getStage()) {
            case 1:
                g.drawImage(bg1, 0, 0, null);
                hero.draw(g2);
                enemy.draw(g2);
                break;
            case 2:
                g.drawImage(bg2, 0, 0, null);
                hero.draw(g2);
                enemy2.draw(g2);
                break;
            case 3:
                g.drawImage(bg3, 0, 0, null);
                hero.draw(g2);
                enemy3.draw(g2);
                break;
            default:
                break;
        }
        g2.dispose();

    }

    public Hero getHero() {
        return hero;
    }

    public void getImages(){
        try{
            image1 = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/wallpaperflare.com_wallpaper_2.jpg"));
            bg1 = image1.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            image2 = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/wallpaperflare.com_wallpaper_4.jpg"));
            bg2 = image2.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            image3 = ImageIO.read(getClass().getResourceAsStream("/BackgroundPic/wallpaperflare.com_wallpaper_1.jpg"));
            bg3 = image3.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setEnemy2(Enemy2 enemy2) {
        this.enemy2 = enemy2;
    }

    public void setEnemy3(Enemy3 enemy3) {
        this.enemy3 = enemy3;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setGameControlmodel(GameControlerModel gameControlmodel) {
        this.gameControlmodel = gameControlmodel;
    }

    public void setLogControlmodel(LogControlerModel logControlmodel) {
        this.logControlmodel = logControlmodel;
    }

    public void setGameControl(GameControler gameControl) {
        this.gameControl = gameControl;
    }

    public GameControlerModel getGameControlmodel() {
        return gameControlmodel;
    }

    public LogControlerModel getLogControlmodel() {
        return logControlmodel;
    }

    public GameControler getGameControl() {
        return gameControl;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getType() {
        return type;
    }

    private void setType(int type) {
        this.type = type;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Enemy2 getEnemy2() {
        return enemy2;
    }

    public Enemy3 getEnemy3() {
        return enemy3;
    }

    public soundcontrol getSound() {
        return Sound;
    }

    public void setSound(soundcontrol Sound) {
        this.Sound = Sound;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setStartgame(JFrame startgame) {
        this.startgame = startgame;
    }

    public JFrame getStartgame() {
        return startgame;
    }
    
}