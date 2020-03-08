package com.thread;

public class TwoThread {
	public static void main(String[] a) {
		new Thread(new Thread1()).start();
		new Thread(new Thread2()).start();
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Thread1:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Thread2:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}