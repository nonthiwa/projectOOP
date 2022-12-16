package Main;

import entity.Enemy;
import entity.Hero;


public class Attack extends Action{
    public void action(Enemy e){
        e.setHp(e.getHp()-10);
    }

    @Override
    public void action(Hero h) {
        h.setHp(h.getHp()-15);
    }
}
