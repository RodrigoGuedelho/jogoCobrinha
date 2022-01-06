package com.guedelho;

import java.util.TimerTask;

import com.guedelho.components.Canvas;

public class GameTask extends TimerTask{
	private Canvas canvas;
	public GameTask(Canvas canvas) {
		this.canvas = canvas;
	}
	@Override
	public void run() {
		canvas.atualizar();
		canvas.repaint();
	}
}
