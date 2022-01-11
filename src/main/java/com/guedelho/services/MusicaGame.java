package com.guedelho.services;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicaGame {
	
	private static void startMusic(String musicaPath) {
		try {
			Clip clip = AudioSystem.getClip();
	        URL res = MusicaGame.class.getResource(musicaPath);
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(res);
	        clip.open(inputStream);
	        clip.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro " + e);
		} 
	}
	
	public static void startMusicaGameOver() {
		MusicaGame.startMusic("/music/musicaGameOver.wav");
	}
	
	public static void startMusicaComendo() {
		MusicaGame.startMusic("/music/comendo.wav");
	}
}
