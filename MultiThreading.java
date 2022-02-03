package java_project;

class Message implements Runnable {
	private String message;

	public Message(String message) {
		this.message = message;
	}

	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(message);
			try {Thread.sleep(1000);} catch(Exception e){}
		}
	}
}

class Guess extends Thread {
	private int number;
	public Guess(int number) {
		this.number = number;
	}

	public void run() {
		int counter = 0;
		int guess = 0;
		do {
			guess = (int) (Math.random() * 9 + 1);
			System.out.println(" guesses " + guess);
			counter++;
			try {Thread.sleep(1000);} catch(Exception e){}
		} while(guess != number);
		System.out.println("** Correct guesses.** "+number+" Attempts="+counter);
	}
}

public class MultiThreading {
	public static void main(String [] args) {
		Runnable hello = new Message("Hello");
		Thread thread1 = new Thread(hello);
		thread1.setDaemon(true);
		thread1.setName("hello");
		System.out.println("Starting hello thread..."); 
		thread1.start();
		System.out.println("Starting thread2...");
		Thread thread2 = new Guess(2);
		thread2.start();
	}
}
