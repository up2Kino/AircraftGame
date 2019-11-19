package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameThread implements Runnable {
	private Graphics g;
	private MyPlane mp;
	private ImageIcon image;
	private GameFrame gameFrame;
	private ArrayList<Bullet> bulletList;
	private ArrayList<Enemy> EnemytList;
	private int EnemySlay = 0;

	public GameThread(Graphics g, MyPlane mp, GameFrame gameFrame, ArrayList<Bullet> bulletList,
			ArrayList<Enemy> EnemytList) {
		this.g = g;
		this.mp = mp;
		this.gameFrame = gameFrame;
		this.bulletList = bulletList;
		this.EnemytList = EnemytList;

		image = new ImageIcon("E:\\Java\\Resource\\plane\\背景4.jpg");
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//创建缓冲区
			BufferedImage Buff = new BufferedImage(gameFrame.getWidth(), gameFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics BG = Buff.getGraphics();
			BG.drawImage(image.getImage(), 0, 0, gameFrame.getWidth(), gameFrame.getHeight(), null);
			
			for (int i = 0; i < bulletList.size(); i++) {
				Bullet bu = bulletList.get(i);
				if (bu.gety() < 0) {
					bulletList.remove(i);
				}
				else
					bu.DrawBullet(BG);
			}
			for (int i = 0; i < EnemytList.size(); i++) {
				Enemy en = EnemytList.get(i);
				if(en.getx()>gameFrame.getWidth()||en.gety()>gameFrame.getHeight()){
					EnemytList.remove(i);
				}
				for(int j = 0;j<bulletList.size();j++){
					Bullet bu = bulletList.get(j);
					if(en.Ecrash(bu.getx(),bu.gety())==1){
						EnemytList.remove(i);
						EnemySlay++;
						bulletList.remove(j);
					}
				}
				en.drawEnemy(BG, mp);
			}
			mp.drawPlane(BG);
			BG.drawString("玩家分数："+EnemySlay*10, 50, 50);
			g.drawImage(Buff, 0, 0, null);

		}
	}
}
