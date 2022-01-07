package com.guedelho.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImageFundo extends JPanel {
	private Image background;
	public PanelImageFundo(URL path) {
		this.background = new ImageIcon(path).getImage();
        setOpaque(false);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setLayout(null);
	}
	
	 @Override
     protected void paintComponent(Graphics g) {   
         super.paintComponent(g);
         g.drawImage(background, 0, 0, this);
     }
	 @Override
     public int getWidth() {
         return background.getWidth(this);
     }

     @Override
     public int getHeight() {
         return background.getHeight(this);
     }
}
