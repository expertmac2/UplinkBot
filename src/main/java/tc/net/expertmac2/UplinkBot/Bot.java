package tc.net.expertmac2.UplinkBot;

import org.jibble.pircbot.PircBot;
import tc.net.expertmac2.UplinkBot.Logger;
import tc.net.expertmac2.UplinkBot.CommandHandler;
import java.sql.*;

// @SuppressWarnings("unused")
public class Bot extends PircBot {

	private Logger l = new Logger();
	private CommandHandler c = new CommandHandler();
	Connection db;

	public Bot(String n) {
		this.setName(n);
		try { 
			Class.forName("org.h2.Driver");
			// db = DriverManager.getConnection()
		}
		catch (ClassNotFoundException e) {
			l.log("SEVERE", "Could not find the database drivers! Is your jar corrupt?");
		} //catch (SQLException e) {}
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

	public void dbquery(String a) {


	}
}

/* void db(String a)
if (a.equalsIgnoreCase("connect")) dh.action = "connect";
if (a.equalsIgnoreCase("disconnect")) dh.action = "disconnect";
if (a.equalsIgnoreCase("setrunning")) dh.running = true;
if (a.equalsIgnoreCase("setnotrunning")) dh.running = false; */