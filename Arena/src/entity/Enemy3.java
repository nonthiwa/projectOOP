package entity;


import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy3 extends Entity{
    private GamePanel gp;
    private int ty;
    public Enemy3(GamePanel gp,int type) {
        this.setGp(gp);
        
        setDefaultValues();
        getEnemyImage();
    }
    
    public void setDefaultValues(){
        x=350;
        y=200;
        switch (getGp().getType()) {
            case 1:
                setHp(120);
                setAtk(12);
                break;
            case 2:
                setHp(220);
                setAtk(12);
                break;
            case 3:
                setHp(180);
                setAtk(20);
                break;
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
            else if(spriteNum == 4 && getGp().getAction() == 0){
                spriteNum = 5;
            }
            else if(spriteNum == 5 && getGp().getAction() == 0){
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
                spriteNum = 4;
            }
            else if(spriteNum == 4 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 5;
            }
            else if(spriteNum == 5 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
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
            case 4:
                image = aATK5;
                break;
            case 5:
                image = aATK6;
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
            case 4:
                image = aATK5;
                break;
            case 5:
                image = aATK6;
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
            case 4:
                image = aATK5;
                break;
            case 5:
                image = aATK6;
                break;
        }
        }
        g2.drawImage(image,x,y,gp.tileSize*7,gp.tileSize*7,null);
    }
    
    public void getEnemyImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/Monidle6.png"));
            
            aATK1 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK1.png"));
            aATK2 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK2.png"));
            aATK3 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK3.png"));
            aATK4 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK4.png"));
            aATK5 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK5.png"));
            aATK6 = ImageIO.read(getClass().getResourceAsStream("/Enemy3Pic/MonATK6.png"));
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
 