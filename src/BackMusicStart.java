import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class BackMusicStart extends Thread {
    private String musicFilePath;
    Clip clip = AudioSystem.getClip();

    public BackMusicStart(String musicPath) throws LineUnavailableException {
        this.musicFilePath = musicPath;
    }
    // 배경음악을 멈추는 메서드 추가

    @Override
    public void run() {
        try {
            File audioFile = new File(musicFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            clip.open(audioInputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopMusic() { //배경음악 멈춤
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}
