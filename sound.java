import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.net.URL;

public class sound{
        Clip clip;
        URL soundURL[]= new URL[30];
        
        public sound(){
            soundURL[0] = getClass().getResource("/sound/IntotheRuins.wav");
            soundURL[1] = getClass().getResource("/sound/BossBattle.wav");
            soundURL[2] = getClass().getResource("/sound/interface3_1.wav");
        }
        public void setfile(int i){
            try{
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
                clip = AudioSystem.getClip();
                clip.open(ais);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public void play(){
            clip.start();
        }
        public void loop(){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        public void stop(){
            clip.stop();
        }
}