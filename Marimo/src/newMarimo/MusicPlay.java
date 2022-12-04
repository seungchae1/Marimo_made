package newMarimo;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
	MusicPlay(){
		new Thread(()-> {
			try {
				 	   File file = new File("C:\\Users\\박승채\\Downloads\\MP_놀고싶은 강아지 (online-audio-converter.com).wav");
				        Clip clip = AudioSystem.getClip();
				        clip.open(AudioSystem.getAudioInputStream(file));
				        clip.loop(10);
				        clip.start();
			    } catch (Exception e) {
			        System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
			    }
		}).start();
	}
}
