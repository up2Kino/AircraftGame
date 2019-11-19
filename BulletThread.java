package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.util.ArrayList;

public class BulletThread implements Runnable {
	private ArrayList<Bullet> BulletList=new ArrayList<Bullet>();
	private Graphics g;
	private GameFrame GF;
	private Bullet biu;
	private MyPlane mp;

	public BulletThread(Graphics g,MyPlane mp,ArrayList<Bullet> BulletList) {
		this.g = g;
		this.mp = mp;
		this.BulletList = BulletList;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			biu = new Bullet(g,mp);
			BulletList.add(biu);
		}
	}
}
