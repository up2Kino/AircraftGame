package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy{
	private ImageIcon ep;
	private Random ran;
	private int x;
	private int y;
	private int vx;
	private int vy;
	private int w = 50;
	private int h = 50;
	public Enemy(MyPlane mp){
		ep = new ImageIcon("E:\\Java\\Resource\\plane\\LXPlane.png");
		ran = new Random();
		y = 0;
		vx = (x-Math.abs(ran.nextInt(20))-10)/5;
		vy = (y-Math.abs(ran.nextInt(20))-10)/4;
	}
	public void drawEnemy(Graphics g,MyPlane mp){
		g.drawImage(ep.getImage(), x, y, w, h, null);
		x-=vx;
		y-=vy;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public int Ecrash(int x1,int y1){
		if(Math.abs(x1-(x+w/2))<w/2&&Math.abs(y1-(y+h/2))<h/2){
			return 1;
		}else return 0;
	}
}
