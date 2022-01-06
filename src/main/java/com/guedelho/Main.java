package com.guedelho;

import java.util.Timer;

import com.guedelho.telas.TelaPrincipal;

public class Main {
	public static void main(String[] args) {
		TelaPrincipal tela = new TelaPrincipal();
		tela.setVisible(true);
		Timer timer = new Timer();
		GameTask gameTask = new GameTask(tela.getCanvas());
		timer.scheduleAtFixedRate(gameTask, 0, 200);
	}
}
