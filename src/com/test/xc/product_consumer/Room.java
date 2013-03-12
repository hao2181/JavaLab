package com.test.xc.product_consumer;

import java.util.Random;

public class Room {
	private boolean finished= false;//
	private int foodNumber = 0;
	public void enter(){
		synchronized (this) {
			String personName = Thread.currentThread().getName(); 
			if(personName.startsWith("厨师")){
				while(!finished){
					if(foodNumber == 0){
						while(foodNumber ==0){
							foodNumber = new Random().nextInt(5);
						}
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						System.out.println(personName+"说：我做好了"+foodNumber+"份饭，大家快来吃饭了！~~~");
						notify();
					}else{
						System.out.println(personName+"说：还有菜，老子去休息会");
						try {
							wait(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println(personName+"说大家都吃完了 ，我下班了！！！！！！");
			}else{//顾客
				while(foodNumber == 0){
					System.out.println(personName+"说：没饭了 ，先睡会儿！来饭叫我！");
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				foodNumber = foodNumber - 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(personName+"说：终于吃上饭了，饿了好久了！下来个人吃饭吧！");
				notify();
			}
		}
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
}
