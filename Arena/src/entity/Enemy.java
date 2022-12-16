package entity;


import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Entity{
    private GamePanel gp;

    public Enemy(GamePanel gp) {
        this.setGp(gp);
        
        setDefaultValues();
        getEnemyImage();
    }
    
    public void setDefaultValues(){
        x=450;
        y=180;
        setHp(200);
        atk=40;
        direction = "idle1";
    }
    public void update(){
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 0 && checkrev == 0){
                spriteNum = 1;
            }
            else if(spriteNum == 1 && checkrev == 0){
                spriteNum = 2;
            }
            else if(spriteNum == 2 && checkrev == 0){
                spriteNum = 3;
            }
            else if(spriteNum == 3 && checkrev == 0){
                spriteNum = 4;
            }
            else if(spriteNum == 4&& checkrev == 0){
                spriteNum = 5;
            }
            else if(spriteNum == 5 && checkrev == 0){
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
          
        BufferedImage image = null;
        switch(spriteNum){
            case 0:
                image = idle1;
                break;
            case 1:
                image = idle2;
                break;
            case 2:
                image = idle3;
                break;
            case 3:
                image = idle4;
                break;
            case 4:
                image = idle5;
                break;
            case 5:
                image = idle6;
                break;
        }
        g2.drawImage(image,x,y,gp.tileSize*4,gp.tileSize*4,null);
    }
    
    public void getEnemyImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/demon-idle6.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void attack(Hero h) {
        h.attacked(this.getAtk());
    }

    @Override
    public void attack(Enemy e1) {
        e1.attacked(this.getAtk());
    }

    @Override
    public void attacked(double n) {
        this.setHp((int) (this.getHp()-n));
    }
}
 