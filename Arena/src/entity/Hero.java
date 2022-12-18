package entity;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Hero extends Entity{
    private GamePanel gp;
    private boolean dying;
    private boolean actionA=false;
    private boolean actionD=false;
    public Hero(GamePanel gp) {
        this.setGp(gp);
        
        setDefaultValues();
        getHeroImage();
    }
    public void setDefaultValues(){
        x=130;
        y=210;
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
            else if(spriteNum == 4&& getGp().getAction() == 0){
                spriteNum = 5;  
            }
            else if(spriteNum == 5 && getGp().getAction() == 0){
                spriteNum = 0;
            }
            if(spriteNum == 0 && getGp().getAction() == 1){
                spriteNum = 1;
            }
            else if(spriteNum == 1 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 2;
            }
            else if(spriteNum == 2 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 3;
            }
            else if(spriteNum == 3 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 4;
            }
            else if(spriteNum == 4 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 5;  
            }
            else if(spriteNum == 5 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 6;
            }
            else if(spriteNum == 6 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 7;
            }
            else if(spriteNum == 7 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 8;
            }
            else if(spriteNum == 8 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 9;
            }
            else if(spriteNum == 9 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 10;
            }
            else if(spriteNum == 10 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                spriteNum = 11;
            }
            else if(spriteNum == 11 && getGp().getAction() == 1 || getGp().getAction() == 2 || getGp().getAction() == 3){
                if(getGp().stage == 1){
                    getGp().getHero().attack(getGp().getEnemy());
                    getGp().getLogControlmodel().getLog().setText("Hero Status\nHP : "+getGp().getHero().getHp()+"/100\nATK : "+getGp().getHero().getAtk()+"\nEnemy Status\nHP : "+getGp().getEnemy().getHp()+"\nATK : "+getGp().getEnemy().getAtk());
                    setActionA(false);
                }
                else if (getGp().stage == 2){
                    getGp().getHero().attack(getGp().getEnemy2());
                    getGp().getLogControlmodel().getLog().setText("Hero Status\nHP : "+getGp().getHero().getHp()+"/100\nATK : "+getGp().getHero().getAtk()+"\nEnemy Status\nHP : "+getGp().getEnemy2().getHp()+"\nATK : "+getGp().getEnemy2().getAtk());
                    setActionA(false);
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
        if(actionA == false){
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
        else if (actionA == true){
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
        }
        }
            
        g2.drawImage(image,x,y,gp.tileSize*4,gp.tileSize*4,null);
    }
    
    public void getHeroImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip6.png"));
            
            aATK1 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk1.png"));
            aATK2 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk2.png"));
            aATK3 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk3.png"));
            aATK4 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk4.png"));
            aATK5 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk5.png"));
            aATK6 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk6.png"));
            aATK7 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk7.png"));
            aATK8 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk8.png"));
            aATK9 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk9.png"));
            aATK10 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk10.png"));
            aATK11 = ImageIO.read(getClass().getResourceAsStream("/EnemyPic/monAtk11.png"));
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

    public boolean isActionA() {
        return actionA;
    }

    public void setActionA(boolean actionA) {
        this.actionA = actionA;
    }
    public void setActionD(boolean actionD) {
        this.actionD = actionD;
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
        
    }
    
}
