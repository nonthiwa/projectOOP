package menu;

import Main.StartGame;
import Main.soundcontrol;
import java.awt.event.*;
import javax.swing.JFrame;
public class Menucontrol implements ActionListener, WindowListener {
    private Mainmenu main;
    private LevelMenu level;
    private soundcontrol Sound;
    private int easy=1;
    private int normal=2;
    private int hard=3;
    public Menucontrol(){
        Sound = new soundcontrol();
        main = new Mainmenu();;
        level = new LevelMenu();
        level.getLevelButtonPanel().setVisible(false);
        main.getCon().add(level.getLevelButtonPanel());
        main.getStartButton().addActionListener(this);
        main.getExitButton().addActionListener(this);
        level.getNormalButton().addActionListener(this);
        level.getEasyButton().addActionListener(this);
        level.getHardButton().addActionListener(this);
        level.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(main.getStartButton())){
            main.getStartButtonPanel().setVisible(false);
            if(level.isCheck() == false){
                level.getLevelButtonPanel().setVisible(true);
                level.setCheck(true);
            }
            Sound.playSe(2);
        }
        if (e.getSource().equals(level.getBackButton())){
            level.getLevelButtonPanel().setVisible(false);
            main.getStartButtonPanel().setVisible(true);
            level.setCheck(false);
            Sound.playSe(2);
        }
        if(e.getSource().equals(main.getExitButton())){
            Sound.playSe(2);
            System.exit(0);
        }
        if(e.getSource().equals(level.getEasyButton())){
            Sound.playSe(2);
            main.getSound().stopMusic();
            main.getWindow().setVisible(false);
            new StartGame(easy);
        }
        else if(e.getSource().equals(level.getNormalButton())){
            Sound.playSe(2);
            main.getSound().stopMusic();
            main.getWindow().setVisible(false);
            new StartGame(normal);
        }
        else if(e.getSource().equals(level.getHardButton())){
            Sound.playSe(2);
            main.getSound().stopMusic();
            main.getWindow().setVisible(false);
            new StartGame(hard);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
