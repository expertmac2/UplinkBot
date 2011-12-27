package tc.net.expertmac2.UplinkBot;

import org.jibble.pircbot.PircBot;
import tc.net.expertmac2.UplinkBot.Logger;
import tc.net.expertmac2.UplinkBot.CommandHandler;
import tc.net.expertmac2.UplinkBot.db.DbHandler;

@SuppressWarnings("unused")
public class Bot extends PircBot {

	private Logger l = new Logger();
	private CommandHandler c = new CommandHandler();
	private DbHandler dh =  new DbHandler();
	
	public Bot(String n) {
		this.setName(n);
	}
	
	public void onQuit(String sourceNick, String sourceLogin, 
			String sourceHostname, String reason) {
	}
	
	public void onDisconnect() {
		System.exit(0);
	}
	
	public void onMessage(String chan, String s, String login, String hs, String m) {
		String margs[] = m.split("\\s");
		if (!margs[0].startsWith("!")) {} else c.ChanHandler(margs, s, chan, this);
	}
	
	public void onPrivateMessage(String s, String login, String hs, String m) {
		String margs[] = m.split("\\s");
		if (!margs[0].startsWith("!")) this.sendMessage(s, "[ERROR] That's not a command. Do you have a ! at the start?"); 
		else c.Handler(margs, s, this); 	
	}
	
	public void db(String a) {
		if (a.equalsIgnoreCase("connect")) dh.action = "connect";
		if (a.equalsIgnoreCase("disconnect")) dh.action = "disconnect";
		if (a.equalsIgnoreCase("setrunning")) dh.running = true;
		if (a.equalsIgnoreCase("setnotrunning")) dh.running = false;
	}
}
