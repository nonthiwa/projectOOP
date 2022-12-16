package entity;


import java.awt.image.BufferedImage;

public class Entity {
    
    public int x , y;
    public int speed;
    public int hp;
    public String hpS;
    public int atk;
    
    
    public BufferedImage idle1,idle2,idle3,idle4,idle5,idle6; 
    public String direction;
    
    public int checkrev = 0;
    public int spriteCounter = 0;
    public int spriteNum = 0;

    public int getHp() {
        return hp;
    }
    
    public String getHp(int hp) {
        hpS = hp+"";
        return hpS;
    }
    
}
