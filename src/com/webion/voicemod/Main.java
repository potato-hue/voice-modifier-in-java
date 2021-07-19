package com.webion.voicemod;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        new AudioPlayer(getMixerIndex(sc), getMixerIndex(sc));
        sc.close();
    }
    public static int getMixerIndex(Scanner sc){
        Mixer.Info[]mixerInfo = AudioSystem.getMixerInfo();
        for(int i  = 0; i < mixerInfo.length; i ++){
            System.out.print("[" + i + "]");
            System.out.println(mixerInfo[i].toString());
        }
        System.out.print("What is the index of your desired Mixer ? : ");
        return sc.nextInt();
    }
}
