package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest{
	public static void main(String[] a) {
		MyCallableThread callable = new MyCallableThread();
		MyRunnableThread runnable = new MyRunnableThread();
		//执行runnable的线程
		new Thread(runnable).start();
		//执行callable的线程
		FutureTask<String> task = new FutureTask<String>(callable);
		new Thread(task).start();
		System.out.println("I'm in main function");
		try {
			//这里会阻塞主线程，知道子线程有返回值
			String result = task.get();
			System.out.println("result:  "+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}


class MyCallableThread implements Callable<String> {
	@Override
	public String call() throws Exception {
		int i = 0;
		while(i<10) {
			System.out.println("I'm in MyCallableThread:" + i);
			Thread.sleep(1000);
			i++;
		}
		return Thread.currentThread().getName();
	}
}

class MyRunnableThread implements Runnable {

	@Override
	public void run() {

	}

}