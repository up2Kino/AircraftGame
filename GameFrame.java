package com.kino.GamePlane1228;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class GameFrame extends JFrame{
	private ImageIcon image;

	public GameFrame() {
		image = new ImageIcon("E:\\Java\\Resource\\plane\\±³¾°4.jpg");
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
