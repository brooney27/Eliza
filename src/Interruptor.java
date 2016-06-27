import java.util.Random;



public class Interruptor implements Runnable {
	public void run(){
		Random r = new Random();
		while(true){
			try{
				Thread.sleep(r.nextInt(5)*1000+5000);
			}catch (InterruptedException e){
				break;
			}
			String[] q = {"Did you get a haircut?","It's cold in here!",
					"Take all the time you need","No pressure, you can think about it.",
					"You're thinking too much, what does your instinct tell you?",
					"Domo arigato Mr. Roboto"};
			System.err.println(q[r.nextInt(6)]);
		}
		System.out.println("Mom stopped");
	}
}
