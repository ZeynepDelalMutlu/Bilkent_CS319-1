package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InterruptedIOException;

/**
 * Created by Baris Poyraz on 17.12.2016.
 */
public class MusicPlay {

    private Clip clip;

    public MusicPlay(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("D:/Games/A Sky Full Of Stars - Coldplay.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception ex){
            System.out.println("Error");
            ex.printStackTrace();
        }
    }

    public void setDisable(){
        clip.stop();
    }

    public void setEnable(){
        clip.start();
    }

}
