package entity;


import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Entity{
    private GamePanel gp;
    private int ty;
    public Enemy(GamePanel gp,int type) {
        this.setGp(gp);
        setTy(type);
        setDefaultValues();
        getEnemyImage();
    }
    
    public void setDefaultValues(){
        x=450;
        y=250;
        switch (getTy()) {
            case 1 -> {
                setHp(60);
                setAtk(10);
            }
            case 2 -> {
                setHp(140);
                setAtk(10);
            }
            case 3 -> {
                setHp(140);
                setAtk(15);
            }
        }
        direction = "idle1";
    }
    public void update(){
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 0 && getGp().getAction() == 0){
                spriteNum = 1;
            }
            else if(spriteNum == 1 && getGp().getAction() == 0){
                spriteNum = 2;
            }
            else if(spriteNum == 2 && getGp().getAction() == 0){
                spriteNum = 3;
            }
            else if(spriteNum == 3 && getGp().getAction() == 0){
                spriteNum = 4;
            }
            else if(spriteNum == 4&& getGp().getAction() == 0){
                spriteNum = 5;  
            }
            else if(spriteNum == 5 && getGp().getAction() == 0){
                spriteNum = 6;
            }
            else if(spriteNum == 6 && getGp().getAction() == 0){
                spriteNum = 0;
            }
            if(spriteNum == 0 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 1;
            }
            else if(spriteNum == 1 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 2;
            }
            else if(spriteNum == 2 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 3;
            }
            else if(spriteNum == 3 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
          
        BufferedImage image = null;
        if(getGp().getAction() == 0){
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
            case 6:
                image = idle7;
                break;
        }
        }
        else if (getGp().getAction() == 1){
            switch(spriteNum){
            case 0:
                image = aATK1;
                break;
            case 1:
                image = aATK2;
                break;
            case 2:
                image = aATK3;
                break;
            case 3:
                image = aATK4;
                break;
        }
        }
        else if (getGp().getAction() == 2){
            switch(spriteNum){
            case 0:
                image = aATK1;
                break;
            case 1:
                image = aATK2;
                break;
            case 2:
                image = aATK3;
                break;
            case 3:
                image = aATK4;
                break;
        }
        }
        else if (getGp().getAction() == 3){
            switch(spriteNum){
            case 0:
                image = aATK1;
                break;
            case 1:
                image = aATK2;
                break;
            case 2:
                image = aATK3;
                break;
            case 3:
                image = aATK4;
                break;
        }
        }

        g2.drawImage(image,x,y,gp.tileSize*5,gp.tileSize*5,null);
    }
    public void getEnemyImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/Monidle7.png"));
            
            aATK1 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/MonATK1.png"));
            aATK2 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/MonATK2.png"));
            aATK3 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/MonATK3.png"));
            aATK4 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/MonATK4.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
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

    @Override
    public void heal(Hero h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void powerup(Hero h) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
 