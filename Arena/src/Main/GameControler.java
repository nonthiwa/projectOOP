package Main;

import entity.Hero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameControler implements ActionListener{
    private GameControlerModel controlModel;
    private Hero hero;
    public GameControler(GameControlerModel gm,Hero hero) {
        setHero(hero);
        setControlModel(gm);
        controlModel.getAttack().addActionListener(this);
        controlModel.getDefend().addActionListener(this);
        controlModel.getItem().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(controlModel.getAttack())){
           hero.setActionA(true);
       }
       if (e.getSource().equals(controlModel.getDefend())){
           hero.setActionD(true);
       }
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
    

