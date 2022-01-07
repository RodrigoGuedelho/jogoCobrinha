package com.guedelho.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class MusicaGame {
	
		public MusicaGame() {
			try {
		        Clip clip = AudioSystem.getClip();
		        URL res = MusicaGame.class.getResource("/music/musicaGameOver.wav");
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(res);
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		}
		
}
