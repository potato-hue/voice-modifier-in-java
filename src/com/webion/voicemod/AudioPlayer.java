package com.webion.voicemod;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
public class AudioPlayer {
    JFrame frame;
    public AudioPlayer(){
        frame = new JFrame("Audio Player !!!");
        JButton audioPlayButton = new JButton("play audio");
        frame.getContentPane().add(audioPlayButton, BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        audioPlayButton.addActionListener((al)->playAudio());   
    }
    public void playAudio(){

    }
}
