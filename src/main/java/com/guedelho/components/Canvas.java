package com.guedelho.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.guedelho.enums.Direcao;
import com.guedelho.models.NodeCobrinha;

public class Canvas extends JPanel{
	private static final long serialVersionUID = 1L;
	private List<NodeCobrinha> cobrinha;
	private int tamanhoBlocoCobrinha = 25;
	private boolean movimentandoDireita;
	private boolean movimentandoEsquerda;
	private boolean movimentandobaixo;
	private boolean movimentandoCima;
	private boolean desenharComidaCobra;
	private int posicaoComidaX = 0;
	private int posicaoComidaY = 0;
	private int tamanhoMatrizPanelCobrinha = 30;
	private boolean mostraMensagemGameOver = true;
	
	public Canvas() {
		init();
	}
	
	public void init() {
		mostraMensagemGameOver = true;
		cobrinha = new ArrayList<>();
		cobrinha.add(new NodeCobrinha(0, 0));
		cobrinha.add(new NodeCobrinha(tamanhoBlocoCobrinha + 1, 0));
		cobrinha.add(new NodeCobrinha((tamanhoBlocoCobrinha + 1) * 2, 0));
		
		setPreferredSize(new Dimension(tamanhoMatrizPanelCobrinha *(tamanhoBlocoCobrinha + 1) , 
				tamanhoMatrizPanelCobrinha * (tamanhoBlocoCobrinha+ 1)));	
		movimentandoDireita = movimentandoEsquerda = movimentandobaixo = movimentandoCima = false;
		desenharComidaCobra = true;
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
		NodeCobrinha nodeAuxiliar = cobrinha.get(cobrinha.size()-1);
		cobrinha.remove(0);
		if (direcao.equals(Direcao.ESQUERDA))
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX() - (tamanhoBlocoCobrinha + 1), nodeAuxiliar.getPosicaoY()));
		else if (direcao.equals(Direcao.DIREITA))
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX() + (tamanhoBlocoCobrinha + 1), nodeAuxiliar.getPosicaoY()));
		else if (direcao.equals(Direcao.CIMA))
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX(), nodeAuxiliar.getPosicaoY() - (tamanhoBlocoCobrinha + 1)));
		else if (direcao.equals(Direcao.BAIXO)) 
			cobrinha.add(new NodeCobrinha(nodeAuxiliar.getPosicaoX(), nodeAuxiliar.getPosicaoY() + (tamanhoBlocoCobrinha + 1)));
	}
	@Override
	public void paint(Graphics g) {
		if (!verificarGameOver()) {
			g.clearRect(0, 0, getWidth(), getHeight());
			for (NodeCobrinha nodeCobrinha : cobrinha) {
				g.fillRect(nodeCobrinha.getPosicaoX(), nodeCobrinha.getPosicaoY(), tamanhoBlocoCobrinha, tamanhoBlocoCobrinha);
				if (nodeCobrinha.getPosicaoX() == getPosicaoComidaX() && nodeCobrinha.getPosicaoY() == getPosicaoComidaY()) 
					desenharComidaCobra = true;			
			}
			
			if (desenharComidaCobra) {
				desenharComidaCobra = false;
				atualizarPosicaoComidaCobrinha();
				cobrinha.add(0, new NodeCobrinha(cobrinha.get(0).getPosicaoX()- (tamanhoBlocoCobrinha +1), 
						cobrinha.get(0).getPosicaoY()));
			}
			g.fillRect(getPosicaoComidaX(), getPosicaoComidaY(), tamanhoBlocoCobrinha, tamanhoBlocoCobrinha);
		} else{
			if (mostraMensagemGameOver) {
				init();
			}
		}
		
		this.getToolkit().sync();
	}
	
	public boolean verificarGameOver() {
		NodeCobrinha nodeCabecaCobrinha= cobrinha.get(cobrinha.size()-1);
		for (int i = 0; i < cobrinha.size()-1; i++) {
			NodeCobrinha nodeCobrinha = cobrinha.get(i);	
			if (nodeCabecaCobrinha.getPosicaoX() == nodeCobrinha.getPosicaoX() 
					&& nodeCabecaCobrinha.getPosicaoY() == nodeCobrinha.getPosicaoY())
				return true;
		}
		int posicaoMaximaXY = tamanhoMatrizPanelCobrinha * (tamanhoBlocoCobrinha + 1);
		if (nodeCabecaCobrinha.getPosicaoX() >  posicaoMaximaXY
				|| nodeCabecaCobrinha.getPosicaoY() > posicaoMaximaXY
				|| nodeCabecaCobrinha.getPosicaoX() < 0
				|| nodeCabecaCobrinha.getPosicaoY() < 0)
			return true;
		
		return false;
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
	
	public int gerarPosicaoAleatoria() {
		Random gerador = new Random();
		return gerador.nextInt(tamanhoMatrizPanelCobrinha -1) * (tamanhoBlocoCobrinha + 1);
	}
	
	public void atualizarPosicaoComidaCobrinha() {
		setPosicaoComidaX(gerarPosicaoAleatoria());
		setPosicaoComidaY(gerarPosicaoAleatoria());
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

	public int getPosicaoComidaX() {
		return posicaoComidaX;
	}

	public void setPosicaoComidaX(int posicaoComidaX) {
		this.posicaoComidaX = posicaoComidaX;
	}

	public int getPosicaoComidaY() {
		return posicaoComidaY;
	}

	public void setPosicaoComidaY(int posicaoComidaY) {
		this.posicaoComidaY = posicaoComidaY;
	}
}
