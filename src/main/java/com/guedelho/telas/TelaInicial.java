package com.guedelho.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.guedelho.GameTask;

public class TelaInicial extends JFrame{
	private JLabel jlabelImg;
	private JButton btnIniciar;
	
	public TelaInicial() {
		this.setSize(750, 750);	
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		adicionarImagemFundo();
		adicionarButtonIniciar();
	}
	
	public void adicionarButtonIniciar() {
		btnIniciar = new JButton("START");
		btnIniciar.setBounds(300, 600, 150, 50);
		btnIniciar.setBackground(new Color(46, 124, 13));
		btnIniciar.setForeground(Color.white);	
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 25));
		btnIniciar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				Timer timer = new Timer();
				GameTask gameTask = new GameTask(tela.getCanvas());
				timer.scheduleAtFixedRate(gameTask, 0, 200);
				dispose();
				
			}
		});
		this.add(btnIniciar);
	}
	
	public void adicionarImagemFundo() {
		Icon imagem = new ImageIcon(getClass().getResource("/img/fundo.jpeg"));
		jlabelImg = new JLabel();
		jlabelImg.setIcon(imagem);
		jlabelImg.setSize(750, 750);
		this.add(jlabelImg);
	}
}
