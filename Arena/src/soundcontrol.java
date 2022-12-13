public class soundcontrol {
    private sound Sound;

    public soundcontrol() {
        Sound = new sound();
    }
    public void playMusic(int i ){
        Sound.setfile(i);
        Sound.play();
        Sound.loop();
    }
    public void stopMusic(){
        Sound.stop();
    }
    public void playSe(int i ){
        Sound.setfile(i);
        Sound.play();
    }
}
