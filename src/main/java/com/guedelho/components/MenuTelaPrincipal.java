package com.guedelho.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTelaPrincipal extends JMenuBar{
	private JMenu menuConfig, menuSobre;
	private JMenuItem menuItemSom, menuNovaPartida;
	
	public MenuTelaPrincipal() {
		menuConfig = new JMenu("Configurações");
		menuItemSom = new JMenuItem("Ativar/Desativar som");
		menuNovaPartida = new JMenuItem("Nova Partida");
		menuConfig.add(menuItemSom);
		menuConfig.add(menuNovaPartida);
		this.add(menuConfig);
		
		menuSobre = new JMenu();
		this.add(menuSobre);
	}
}
