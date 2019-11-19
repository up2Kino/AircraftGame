package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MyPlane {
	private int x, y, vx, vy, w = 100, h = 100;
	private ImageIcon mp;

	public MyPlane(int x, int y) {
		this.x = x;
		this.y = y;

		mp = new ImageIcon("E:\\Java\\Resource\\plane\\BluePlane.png");
	}

	public void drawPlane(Graphics g) {
		g.drawImage(mp.getImage(), x, y, w, h, null);
		x+=vx;
		y+=vy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}


}
