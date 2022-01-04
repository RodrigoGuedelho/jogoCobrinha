package com.guedelho;

import java.util.TimerTask;

import javax.swing.JFrame;

import com.guedelho.components.Canvas;
import com.guedelho.telas.TelaPrincipal;

public class AnimaTask extends TimerTask{
	private Canvas canvas;
	public AnimaTask(Canvas canvas) {
		this.canvas = canvas;
	}
	@Override
	public void run() {
		canvas.atualizar();
		canvas.repaint();
	}

}
