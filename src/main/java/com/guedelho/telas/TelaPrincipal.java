package com.guedelho.telas;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.guedelho.components.Canvas;
import com.guedelho.components.MenuTelaPrincipal;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public TelaPrincipal() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Jogo Da Cobrinha");
		this.add(new MenuTelaPrincipal());
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
