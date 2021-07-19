package com.webion.voicemod;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    final int BUFFER_SIZE = 1024;

    public AudioPlayer(int SourceDataLineIndex, int TargetDataLineIndex) {
        try {
            Mixer.Info[] allMixers = AudioSystem.getMixerInfo();
            Mixer headphone = AudioSystem.getMixer(allMixers[SourceDataLineIndex]);
            Mixer mic = AudioSystem.getMixer(allMixers[TargetDataLineIndex]);
            SourceDataLine line = (SourceDataLine) headphone.getLine(headphone.getSourceLineInfo()[0]);
            TargetDataLine tLine = (TargetDataLine) mic.getLine(mic.getTargetLineInfo()[0]);
            tLine.open();
            tLine.start();
            AudioInputStream audioStream = new AudioInputStream(tLine);
            byte[] buffer = new byte[BUFFER_SIZE];

            line.open(audioStream.getFormat());
            line.start();
            int read;
            while ((read = audioStream.read(buffer)) != -1) {
                line.write(buffer, 0, read);
            }
        } catch (LineUnavailableException e) {
            System.out.println("unsupported line");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}