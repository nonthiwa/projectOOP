package entity;


import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Entity{
    private GamePanel gp;
    private boolean dying;
    private int ty;
    public Enemy(GamePanel gp,int type) {
        this.setGp(gp);
        setTy(type);
        System.out.println(getTy());
        setDefaultValues();
        getEnemyImage();
    }
    
    public void setDefaultValues(){
        x=450;
        y=180;
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
                setAtk(20);
            }
        }
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
        else{
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

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }


    public boolean isDying() {
        return dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
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

}
 