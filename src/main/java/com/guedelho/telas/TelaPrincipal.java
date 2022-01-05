package com.guedelho.telas;

import javax.swing.JFrame;

import com.guedelho.components.Canvas;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public TelaPrincipal() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Jogo Da Cobrinha");
		canvas = new Canvas();
		this.add(canvas);
		// Tela vai se ajustar no tamanho dos componentes que tiverem nela
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
