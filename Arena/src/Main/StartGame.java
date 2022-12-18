package Main;



import javax.swing.JFrame;

public class StartGame {
    private JFrame window; 
    private soundcontrol Sound;
    public StartGame(int level) {
        window = new JFrame();
        Sound = new soundcontrol();
        Sound.playMusic(1);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("THE ARENA");
        
        GamePanel gamePanel = new GamePanel(level);
        window.add(gamePanel);
        window.pack();
         
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
    }
    
            
}
