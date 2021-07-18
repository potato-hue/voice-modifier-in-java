package com.webion.voicemod;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    final int BUFFER_SIZE = 1024;

    public AudioPlayer() {
        try {
            Mixer.Info[] allMixers = AudioSystem.getMixerInfo();
            Mixer headphone = AudioSystem.getMixer(allMixers[6]);
            SourceDataLine line = (SourceDataLine) headphone.getLine(headphone.getSourceLineInfo()[0]);
            File audioFile = new File("C:\\Users\\rakti\\OneDrive\\Code\\Voice Modifier\\src\\CantinaBand3.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            line.open(audioStream.getFormat());
            line.start();
            int read;
            while ((read = audioStream.read(buffer)) != -1) {
                line.write(buffer, 0, read);
            }
        } catch (LineUnavailableException e) {
            System.out.println("unsupported line");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("file type not supported");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}