package newMarimo;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
	MusicPlay(){
		new Thread(()-> {
			try {
				 	   File file = new File("C:\\Users\\�ڽ�ä\\Downloads\\MP_������ ������ (online-audio-converter.com).wav");
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
