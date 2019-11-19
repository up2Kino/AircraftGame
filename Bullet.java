package com.kino.GamePlane1228;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private Graphics g;
	private MyPlane mp;
	private int x;
	private int y;
	private int vx=0;
	private int vy=6;
	public Bullet(Graphics g,MyPlane mp){
		this.g = g;
		this.mp = mp;
		x = mp.getX()+40;
		y = mp.getY();
	}
	public void DrawBullet(Graphics g){
		g.setColor(Color.white);
		g.fillOval(x, y, 10, 10);
		x-=vx;
		y-=vy;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
}
