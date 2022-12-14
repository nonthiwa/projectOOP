package entity;


import java.awt.image.BufferedImage;

public abstract  class Entity {
    
    public int x , y;
    private int hp;
    private String hpS;
    private int atk;
    
    
    public BufferedImage idle1,idle2,idle3,idle4,idle5,idle6,idle7,idle8,idle9,idle10,idle11,idle12,idle13,idle14,idle15,aATK1,aATK2,aATK3,aATK4,aATK5,aATK6,aATK7,aATK8,aATK9,aATK10,aATK11,aATK12,aATK13,aATK14; 
    public String direction;
    
    public int checkrev = 0;
    public int spriteCounter = 0;
    public int spriteNum = 0;
    
    public abstract void attack(Hero h);
    public abstract void attack(Enemy e);
    public abstract void attacked(double n);
    public abstract void heal(Hero h);
    public abstract void powerup(Hero h);
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

    public void setAtk(int atk) {
        this.atk = atk;
    }
    
}
