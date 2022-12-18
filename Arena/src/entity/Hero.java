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
        getEnemyImage();
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
                image = idle1;
                break;
            case 1:
                image = idle1;
                break;
            case 2:
                image = idle1;
                break;
            case 3:
                image = idle1;
                break;
            case 4:
                image = idle1;
                break;
            case 5:
                image = idle1;
                setActionA(false);
                break;
            }
        }
            
        g2.drawImage(image,x,y,gp.tileSize*4,gp.tileSize*4,null);
    }
    
    public void getEnemyImage(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/HeroPic/noBKG_Knightidle_strip6.png"));
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

    @Override
    public void attacked(double n) {
        this.setHp((int) (this.getHp()-n));
    }

    @Override
    public void heal(Hero h) {
        
    }
    
}
