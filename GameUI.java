package com.kino.GamePlane1228;

import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class GameUI extends KeyAdapter{
	public GameFrame jf;
	private Graphics g;  
	private GameThread gt;
	private MyPlane mp;
	private int speed=8;
	private Bullet biu;
	private ArrayList<Bullet> bulletList=new ArrayList<Bullet>();
	private ArrayList<Enemy> EnemytList=new	ArrayList<Enemy>();
	public GameUI(){
		jf = new GameFrame();
		jf.setTitle("·É»ú´óÕ½");
		jf.setSize(900, 1100);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.addKeyListener(this);
		
		g = jf.getGraphics();
	}
	public static void main(String[] args){
		new GameUI();
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			mp.setVx(-speed);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			mp.setVy(speed);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			mp.setVx(speed);
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			mp.setVy(-speed);
			break;
		case KeyEvent.VK_SPACE:
			
			if(gt == null){
				mp = new MyPlane(jf.getWidth()/2-50,jf.getHeight()-150);
				mp.drawPlane(g);
				BulletThread BT = new BulletThread(g,mp,bulletList);
				new Thread(BT).start();
				EnemyThread ET = new EnemyThread(mp,EnemytList);
				new Thread(ET).start();
				gt = new GameThread(g, mp,jf,bulletList,EnemytList);
				new Thread(gt).start();
				
			}
		
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			mp.setVx(0);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			mp.setVy(0);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			mp.setVx(0);
			break;
		case KeyEvent.VK_W: 
		case KeyEvent.VK_UP:
			mp.setVy(0);
			break;
		}
	}
}
