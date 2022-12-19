package entity;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Hero extends Entity{
    private GamePanel gp;
    private boolean dying;
    public Hero(GamePanel gp) {
        this.setGp(gp);
        
        setDefaultValues();
        getHeroImage();
    }
    public void setDefaultValues(){
        x=70;
        y=390;
        setHp(100);
        setAtk(15);
        dying=false;
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
                spriteNum = 6;
            }
            else if(spriteNum == 6 && getGp().getAction() == 0){
                spriteNum = 7;
            }
            else if(spriteNum == 7 && getGp().getAction() == 0){
                spriteNum = 8;
            }
            else if(spriteNum == 8 && getGp().getAction() == 0){
                spriteNum = 9;
            }
            else if(spriteNum == 9 && getGp().getAction() == 0){
                spriteNum = 10;  
            }
            else if(spriteNum == 10 && getGp().getAction() == 0){
                spriteNum = 11;
            }
            else if(spriteNum == 11 && getGp().getAction() == 0){
                spriteNum = 12;
            }
            else if(spriteNum == 12 && getGp().getAction() == 0){
                spriteNum = 13;
            }
            else if(spriteNum == 13 && getGp().getAction() == 0){
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
                spriteNum = 6;
            }
            else if(spriteNum == 6 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 7;
            }
            else if(spriteNum == 7 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 8;
            }
            else if(spriteNum == 8 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 9;
            }
            else if(spriteNum == 9 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 10;
            }
            else if(spriteNum == 10 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 11;
            }
            else if(spriteNum == 11 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 12;
            }
            else if(spriteNum == 12 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                spriteNum = 13;
            }
            else if(spriteNum == 13 && (getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3)){
                if(getGp().getStage() == 1 && getGp().getAction() == 1){
                   getGp().getHero().attack(getGp().getEnemy());
                   if(getGp().getEnemy().getHp() >0){
                       getGp().getEnemy().attack(getGp().getHero());
                   }
                    getGp().setAction(0);
                    getGp().getEnemy().update();
                }
                else if (getGp().getStage() == 2 && getGp().getAction() == 1){
                    getGp().getHero().attack(getGp().getEnemy2());
                    if(getGp().getEnemy2().getHp() >0){
                        getGp().getEnemy2().attack(getGp().getHero());
                        getGp().getEnemy2().spriteNum=0;
                        getGp().getEnemy2().update();
                   }
                    getGp().setAction(0);            
                }
                else if (getGp().getStage() == 3 && getGp().getAction() == 1){
                    getGp().getHero().attack(getGp().getEnemy3());
                    if(getGp().getEnemy3().getHp() >0){
                        getGp().getEnemy3().attack(getGp().getHero());
                        getGp().getEnemy2().spriteNum=0;
                        getGp().getEnemy3().update();
                    }
                    getGp().setAction(0);
                }
                if(getGp().getStage() == 1 && getGp().getAction() == 2){
                   getGp().getHero().heal(getGp().getHero());
                   if(getGp().getEnemy().getHp() >0){
                       getGp().getEnemy().attack(getGp().getHero());
                   }
                    getGp().setAction(0);
                    getGp().getEnemy().update();
                }
                else if (getGp().getStage() == 2 && getGp().getAction() == 2){
                    getGp().getHero().heal(getGp().getHero());
                    if(getGp().getEnemy2().getHp() >0){
                        getGp().getEnemy2().attack(getGp().getHero());
                        getGp().getEnemy2().spriteNum=0;
                        getGp().getEnemy2().update();
                   }
                    getGp().setAction(0);            
                }
                else if (getGp().getStage() == 3 && getGp().getAction() == 2){
                    getGp().getHero().heal(getGp().getHero());
                    if(getGp().getEnemy3().getHp() >0){
                        getGp().getEnemy3().attack(getGp().getHero());
                        getGp().getEnemy3().spriteNum=0;
                        getGp().getEnemy3().update();
                   }
                    getGp().setAction(0);
                }
                if(getGp().getStage() == 1 && getGp().getAction() == 3){
                   getGp().getHero().powerup(getGp().getHero());
                   if(getGp().getEnemy().getHp() >0){
                       getGp().getEnemy().attack(getGp().getHero());
                   }
                    getGp().setAction(0);
                    getGp().getEnemy().update();
                }
                else if (getGp().getStage() == 2 && getGp().getAction() == 3){
                    getGp().getHero().powerup(getGp().getHero());
                    if(getGp().getEnemy2().getHp() >0){
                        getGp().getEnemy2().attack(getGp().getHero());
                        getGp().getEnemy2().spriteNum=0;
                        getGp().getEnemy2().update();
                   }
                    getGp().setAction(0);            
                }
                else if (getGp().getStage() == 3 && getGp().getAction() == 3){
                    getGp().getHero().powerup(getGp().getHero());
                    if(getGp().getEnemy3().getHp() >0){
                        getGp().getEnemy3().attack(getGp().getHero());
                        getGp().getEnemy3().spriteNum=0;
                        getGp().getEnemy3().update();
                   }
                    getGp().setAction(0);
                }
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
          
        BufferedImage image = null;
        if(this.getHp() <=0){
            image = null;
        }
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
            case 7:
                image = idle8;
                break;
            case 8:
                image = idle9;
                break;
            case 9:
                image = idle10;
                break;
            case 10:
                image = idle11;
                break;
            case 11:
                image = idle12;
                break;
            case 12:
                image = idle13;
                break;
            case 13:
                image = idle14;
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
            case 6:
                image = aATK7;
                break;
            case 7:
                image = aATK8;
                break;
            case 8:
                image = aATK9;
                break;
            case 9:
                image = aATK10;
                break;
            case 10:
                image = aATK11;
                break;
            case 11:
                image = aATK12;
                break;
            case 12:
                image = aATK13;
                break;
            case 13:
                image = aATK14;
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
            case 6:
                image = aATK7;
                break;
            case 7:
                image = aATK8;
                break;
            case 8:
                image = aATK9;
                break;
            case 9:
                image = aATK10;
                break;
            case 10:
                image = aATK11;
                break;
            case 11:
                image = aATK12;
                break;
            case 12:
                image = aATK13;
                break;
            case 13:
                image = aATK14;
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
            case 6:
                image = aATK7;
                break;
            case 7:
                image = aATK8;
                break;
            case 8:
                image = aATK9;
                break;
            case 9:
                image = aATK10;
                break;
            case 10:
                image = aATK11;
                break;
            case 11:
                image = aATK12;
                break;
            case 12:
                image = aATK13;
                break;
            case 13:
                image = aATK14;
                break;
        }
        }
            
        g2.drawImage(image,x,y,gp.tileSize*5,gp.tileSize*5,null);
    }
    
    public void getHeroImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle8.png"));
            idle9 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle9.png"));
            idle10 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle10.png"));
            idle11 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle11.png"));
            idle12 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle12.png"));
            idle13 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle13.png"));
            idle14 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle14.png"));
            idle15 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/Heroidle15.png"));
            
            aATK1 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK1.png"));
            aATK2 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK2.png"));
            aATK3 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK3.png"));
            aATK4 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK4.png"));
            aATK5 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK5.png"));
            aATK6 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK6.png"));
            aATK7 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK7.png"));
            aATK8 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK8.png"));
            aATK9 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK9.png"));
            aATK10 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK10.png"));
            aATK11 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK11.png"));
            aATK12 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK12.png"));
            aATK13 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK13.png"));
            aATK14 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/HeroATK14.png"));
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
    public void attack(Enemy2 e2) {
        e2.attacked(this.getAtk());
    }public void attack(Enemy3 e3) {
        e3.attacked(this.getAtk());
    }
    @Override
    public void attacked(double n) {
        this.setHp((int) (this.getHp()-n));
    }

    @Override
    public void heal(Hero h) {
        h.healed(20);
    }
    public void healed(double n){
        if(this.getHp()+n >100){
            this.setHp(100);
        }
        else{
            this.setHp((int) (this.getHp()+n));
        }
    }

    @Override
    public void powerup(Hero h) {
        h.powerupto(5);
    }
    public void powerupto(double n){
        this.setAtk((int) (this.getAtk()+n));
    }
    
}
