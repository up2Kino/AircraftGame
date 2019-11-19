package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyThread implements Runnable {
	private ArrayList<Enemy> EnemytList;
	private MyPlane mp;
	public EnemyThread(MyPlane mp,ArrayList<Enemy> EnemytList){
		this.EnemytList = EnemytList;
		this.mp = mp;
		
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Enemy en = new Enemy(mp);
			EnemytList.add(en);
		}
	}
}
