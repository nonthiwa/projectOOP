package entity;


import java.awt.image.BufferedImage;

public abstract  class Entity {
    
    public int x , y;
    public int speed;
    private int hp;
    public String hpS;
    public int atk;
    
    
    public BufferedImage idle1,idle2,idle3,idle4,idle5,idle6; 
    public String direction;
    
    public int checkrev = 0;
    public int spriteCounter = 0;
    public int spriteNum = 0;
    
    public abstract void attack(Hero h);
    public abstract void attack(Enemy e1);
    public abstract void attacked(double n);
    public int getHp() {
        return hp;
    }
    
    public String getHp(int hp) {
        hpS = hp+"";
        return hpS;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHpS(String hpS) {
        this.hpS = hpS;
    }

    public int getAtk() {
        return atk;
    }
    
}
