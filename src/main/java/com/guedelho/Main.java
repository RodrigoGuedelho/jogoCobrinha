package com.guedelho;

import java.util.Timer;

import com.guedelho.telas.TelaPrincipal;

public class Main {
	public static void main(String[] args) {
		TelaPrincipal tela = new TelaPrincipal();
		tela.setVisible(true);
		Timer timer = new Timer();
		AnimaTask animaTask = new AnimaTask(tela.getCanvas());
		timer.scheduleAtFixedRate(animaTask, 0, 200);
	}
}
