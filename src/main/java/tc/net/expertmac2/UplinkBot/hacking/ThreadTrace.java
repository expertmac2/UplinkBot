package tc.net.expertmac2.UplinkBot.hacking;

import tc.net.expertmac2.UplinkBot.CommandHandler;

@SuppressWarnings("all")
public class ThreadTrace extends Thread {
	
	public CommandHandler cmd;
	public String agent;
	public int bounces;
	public int timer;
	public boolean agentiscaught;
	
	public ThreadTrace(String s1, int i1) {
		agent = s1;
		bounces = i1;
	}
	
	public void run() {
		while (!agentiscaught) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}

}
