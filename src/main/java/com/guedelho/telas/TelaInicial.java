package com.guedelho.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.guedelho.GameTask;
import com.guedelho.components.PanelImageFundo;

public class TelaInicial extends JFrame{
	private JButton btnIniciar;
	private JComboBox<String> jComboBoxDificuldade;
	private PanelImageFundo panelImageFundo;
	
	private int DIFICULDADE_FACIL = 200, DIFICULDADE_MEDIO = 100, DIFICULDADE_DIFICIL = 50; 
	
	public TelaInicial() {
		panelImageFundo = new PanelImageFundo(getClass().getResource("/img/fundo.jpeg"));
		this.setContentPane(panelImageFundo);
		this.setSize(750, 750);	
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		adicionarComboboxDificuldade();
		adicionarButtonIniciar();
		
	}

	public void adicionarButtonIniciar() {
		btnIniciar = new JButton("START");
		btnIniciar.setBounds(300, 640, 150, 50);
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
				if (jComboBoxDificuldade.getSelectedItem().toString().equals("Fácil"))
					timer.scheduleAtFixedRate(gameTask, 0, DIFICULDADE_DIFICIL);
				else if (jComboBoxDificuldade.getSelectedItem().toString().equals("Médio"))
					timer.scheduleAtFixedRate(gameTask, 0, DIFICULDADE_MEDIO);
				else if (jComboBoxDificuldade.getSelectedItem().toString().equals("Difícil"))
					timer.scheduleAtFixedRate(gameTask, 0, DIFICULDADE_DIFICIL);
				dispose();	
			}
		});
		panelImageFundo.add(btnIniciar);
	}
	
	public void adicionarComboboxDificuldade() {
		String dificuldades[] = {"Fácil", "Médio", "Difícil"};
		jComboBoxDificuldade = new JComboBox<String>(dificuldades);
		jComboBoxDificuldade.setBounds(300, 590, 150, 40);
		jComboBoxDificuldade.setFont(new Font("Arial", Font.PLAIN, 18));			
		panelImageFundo.add(jComboBoxDificuldade);
		UIManager.put("jComboBoxDificuldade.selectionBackground", new Color(204, 229, 193));
	}
}
