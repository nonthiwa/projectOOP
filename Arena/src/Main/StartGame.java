package Main;



import javax.swing.JFrame;

public class StartGame {
    private JFrame window; 
    public StartGame(int level) {
        window = new JFrame();
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
