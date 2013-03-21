/**
 * 
 */

/**
 * @author ZhangHao 
 * @date  2013-3-20
 */

	public class RandomCard extends Thread{
		
		private int start = 0;
		private int end = 10;
		
		public RandomCard(int start,int end){
			this.start =start;
			this.end = end;
		}
		public void run(){
			while (end>=start) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(end);//这里改成处理方法，现在只是打印表示一下
				end--;
			}
		}
		public static void main(String[] args) {
			Thread thread = new RandomCard(0,9);
			Thread thread1 = new RandomCard(10,19);
			Thread thread2 = new RandomCard(20,29);
			Thread thread3 = new RandomCard(30,39);
			Thread thread4 = new RandomCard(40,53);
			
			thread.start();
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
		}
	}

