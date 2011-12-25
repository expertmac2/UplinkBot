package tc.net.expertmac2.UplinkBot;

import org.jibble.pircbot.PircBot;
import tc.net.expertmac2.UplinkBot.Logger;

public class Bot extends PircBot {

	private Logger l = new Logger();
	
	public Bot(String n) {
		this.setName(n);
	}
	
	public void onPrivateMessage(String s, String login, String hs, String m) {
		l.log("INFO", s + " has sent you a PM. Contents: " + m);
		String margs[] = m.split("\\s");
		if (!margs[0].startsWith("!")) {
			this.sendMessage(s, "[ERROR] That's not a command. Do you have a ! at the start?");
		} else {
			this.sendMessage(s, "[YAY] Now, that's a command!");
		}
	}
}
