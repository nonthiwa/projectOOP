package Main;

import entity.Enemy;
import entity.Enemy2;
import entity.Enemy3;
import entity.Hero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameControler implements ActionListener{
    private GameControlerModel controlModel;
    private LogControlerModel logModel;
    private Hero hero;
    private Enemy e1;
    private Enemy2 e2;
    private Enemy3 e3;
    private soundcontrol Sound;
    private int stage;
    public GameControler(GameControlerModel gm,Hero hero, LogControlerModel lm, Enemy e, Enemy2 e2, Enemy3 e3, int s) {
        setHero(hero);
        setE1(e);
        setE2(e2);
        setE3(e3);
        setStage(s);
        setControlModel(gm);
        setLogModel(lm);
        Sound = new soundcontrol();
        controlModel.getAttack().addActionListener(this);
        controlModel.getHeal().addActionListener(this);
        controlModel.getPower().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(controlModel.getAttack())){
           Sound.playSe(3);
           if(getStage() == 1){
               getHero().spriteNum = 0;
               getE1().spriteNum = 0;
               getHero().getGp().setAction(1);
           }
           if(getStage() == 2){
               getHero().spriteNum = 0;
               getE2().spriteNum = 0;
               getHero().getGp().setAction(1);
           }
           if(getStage() == 3){
               getHero().spriteNum = 0;
               getE3().spriteNum = 0;
               getHero().getGp().setAction(1);
           }
           
       }
       if (e.getSource().equals(controlModel.getHeal())){
           if(getStage() == 1){
               getHero().getGp().setAction(2);
               getHero().spriteNum = 0;
               getE1().spriteNum = 0;
           }
           if(getStage() == 2){
               getHero().getGp().setAction(2);
               getHero().spriteNum = 0;
               getE2().spriteNum = 0;
           }
           if(getStage() == 3){
               getHero().getGp().setAction(2);
               getHero().spriteNum = 0;
               getE3().spriteNum = 0;
           }
       }
       if (e.getSource().equals(controlModel.getPower())){
           if(getStage() == 1){
               getHero().spriteNum = 0;
               getE1().spriteNum = 0;
               getHero().getGp().setAction(3);
           }
           if(getStage() == 2){
               getHero().spriteNum = 0;
               getE2().spriteNum = 0;
               getHero().getGp().setAction(3);
           }
           if(getStage() == 3){
               getHero().spriteNum = 0;
               getE3().spriteNum = 0;
               getHero().getGp().setAction(3);
           }
       }
    }
    public void setLogModel(LogControlerModel logModel) {
        this.logModel = logModel;
    }

    public void setControlModel(GameControlerModel controlModel) {
        this.controlModel = controlModel;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Enemy getE1() {
        return e1;
    }

    public Enemy2 getE2() {
        return e2;
    }

    public Enemy3 getE3() {
        return e3;
    }

    public void setE1(Enemy e1) {
        this.e1 = e1;
    }

    public void setE2(Enemy2 e2) {
        this.e2 = e2;
    }

    public void setE3(Enemy3 e3) {
        this.e3 = e3;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }


        
}