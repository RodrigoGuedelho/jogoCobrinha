package com.guedelho.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.guedelho.enums.Direcao;
import com.guedelho.models.NodeCobrinha;

public class Canvas extends java.awt.Canvas{
	private static final long serialVersionUID = 1L;
	private List<NodeCobrinha> cobrinha;
	private int tamanhoBlocoCobrinha = 15;
	private boolean movimentandoDireita;
	private boolean movimentandoEsquerda;
	private boolean movimentandobaixo;
	private boolean movimentandoCima;
	private boolean desenharComidaCobra;
	
	public Canvas() {
		cobrinha = new ArrayList<>();
		cobrinha.add(new NodeCobrinha(0, 0));
		cobrinha.add(new NodeCobrinha(tamanhoBlocoCobrinha + 1, 0));
		cobrinha.add(new NodeCobrinha((tamanhoBlocoCobrinha + 1) * 2, 0));
		
		setPreferredSize(new Dimension(50 *tamanhoBlocoCobrinha, 50 * tamanhoBlocoCobrinha));	
		movimentandoDireita = movimentandoEsquerda = movimentandobaixo = movimentandoCima = false;
		desenharComidaCobra = false;
		setFocusable(true);
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			
			public void keyPressed(KeyEvent arg0) {
				setMovimentandoEsquerda(false);
				setMovimentandoDireita(false);
				setMovimentandoCima(false);
				setMovimentandoBaixo(false);
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
					setMovimentandoEsquerda(true);
				else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
					setMovimentandoDireita(true);
				else if (arg0.getKeyCode() == KeyEvent.VK_UP)
					setMovimentandoCima(true);
				else if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
					setMovimentandoBaixo(true);
			}
		});
	}
	
	public void caminharCobrinha(Direcao direcao) {
		if (direcao.equals(Direcao.ESQUERDA)) {
			NodeCobrinha nodeAuxiliar = cobrinha.get(cobrinha.size()-1);
			List<NodeCobrinha> cobrinhaAuxiliar = new ArrayList<>();
			
			for (int i = cobrinha.size() -1; i >= 0; i--) {
				cobrinhaAuxiliar.add(cobrinha.get(i));
			}
			cobrinha.remove(0);
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX() - 16, nodeAuxiliar.getPosicaoY()));
		}
		else if (direcao.equals(Direcao.DIREITA)) {
			NodeCobrinha nodeAuxiliar = cobrinha.get(cobrinha.size()-1);
			cobrinha.remove(0);
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX() + 16, nodeAuxiliar.getPosicaoY()));
		}
		else if (direcao.equals(Direcao.CIMA)) {
			NodeCobrinha nodeAuxiliar = cobrinha.get(cobrinha.size()-1);
			cobrinha.remove(0);
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX(), nodeAuxiliar.getPosicaoY() - 16));
		}
		else if (direcao.equals(Direcao.BAIXO)) {
			NodeCobrinha nodeAuxiliar = cobrinha.get(cobrinha.size()-1);
			cobrinha.remove(0);
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX(), nodeAuxiliar.getPosicaoY() + 16));
		}
	}
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		for (NodeCobrinha nodeCobrinha : cobrinha) {
			g.fillRect(nodeCobrinha.getPosicaoX(), nodeCobrinha.getPosicaoY(), tamanhoBlocoCobrinha, tamanhoBlocoCobrinha);
		}
		
		this.getToolkit().sync();
	}
	
	public void atualizar() {
		if (movimentandoDireita)
			caminharCobrinha(Direcao.DIREITA);
		if (movimentandoEsquerda)
			caminharCobrinha(Direcao.ESQUERDA);
		if (movimentandoCima)
			caminharCobrinha(Direcao.CIMA);
		if (movimentandobaixo == true)
			caminharCobrinha(Direcao.BAIXO);
	}

	public boolean isMovimentandoDireita() {
		return movimentandoDireita;
	}

	public void setMovimentandoDireita(boolean movimentandoDireita) {
		this.movimentandoDireita = movimentandoDireita;
	}

	public boolean isMovimentandoEsquerda() {
		return movimentandoEsquerda;
	}

	public void setMovimentandoEsquerda(boolean movimentandoEsquerda) {
		this.movimentandoEsquerda = movimentandoEsquerda;
	}

	public boolean isMovimentandobaixo() {
		return movimentandobaixo;
	}

	public void setMovimentandoBaixo(boolean movimentandobaixo) {
		this.movimentandobaixo = movimentandobaixo;
	}

	public boolean isMovimentandoCima() {
		return movimentandoCima;
	}

	public void setMovimentandoCima(boolean movimentandoCima) {
		this.movimentandoCima = movimentandoCima;
	}

	public boolean isDesenharComidaCobra() {
		return desenharComidaCobra;
	}

	public void setDesenharComidaCobra(boolean desenharComidaCobra) {
		this.desenharComidaCobra = desenharComidaCobra;
	}
}
