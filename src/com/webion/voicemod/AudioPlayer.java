package com.webion.voicemod;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AudioPlayer {
    final int BUFFER_SIZE = 1024;
    public AudioPlayer() throws IOException {
        Mixer.Info[] allMixers = AudioSystem.getMixerInfo();
        Mixer headphone = AudioSystem.getMixer(allMixers[6]);
        SourceDataLine line = null;
        File audioFile = null;
        AudioInputStream audioStream = null;
        try {
            line = (SourceDataLine) headphone.getLine(headphone.getSourceLineInfo()[0]);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        audioFile = new File("C:\\Users\\rakti\\OneDrive\\Code\\Voice Modifier\\src\\CantinaBand3.wav");
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        byte[]buffer = new byte[BUFFER_SIZE];
        int read = -1;
        assert line != null;
        assert audioStream != null;
        try {
            line.open(audioStream.getFormat());
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        line.start();
        while ((read = audioStream.read(buffer)) != -1) {
            line.write(buffer, 0, read);
        }
    }
}