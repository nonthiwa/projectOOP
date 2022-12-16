package Main;

import entity.Hero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameControler implements ActionListener{
    private GameControlerModel controlModel;
    private LogControlerModel logModel;
    private Hero hero;
    public GameControler(GameControlerModel gm,Hero hero, LogControlerModel lm) {
        setHero(hero);
        setControlModel(gm);
        setLogModel(lm);
        controlModel.getAttack().addActionListener(this);
        controlModel.getDefend().addActionListener(this);
        controlModel.getItem().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(controlModel.getAttack())){
           hero.setActionA(true);
           logModel.getLog().setText("HP : "+hero.getHp(hero.hp)+"/100");
           
       }
       if (e.getSource().equals(controlModel.getDefend())){
           hero.setActionD(true);
           logModel.getLog().setText("Defend!!\n");
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

        
}