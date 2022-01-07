package com.guedelho.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.guedelho.components.Canvas;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public TelaPrincipal() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Jogo Da Cobrinha");
		canvas = new Canvas();
		this.add(canvas);
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
