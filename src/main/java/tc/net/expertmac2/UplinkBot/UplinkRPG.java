package tc.net.expertmac2.UplinkBot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.yaml.snakeyaml.Yaml;

import tc.net.expertmac2.UplinkBot.Logger;
import tc.net.expertmac2.UplinkBot.db.DbHandler;
import tc.net.expertmac2.UplinkBot.setup.Setup;

public class UplinkRPG {

	private static ExceptionHandler eh = new ExceptionHandler();
	private static String botnick = "UplinkRPG";
	public static String version = "v0.0.1b";
	private static Setup su = new Setup();
	
	public static void main(String[] args) {
		try { 
			if (args[0].equals("--setup") || args[0].equals("-s")) firstRun(); return;
		} catch (Exception e) {}
		Bot bot = new Bot(botnick);
		bot.db("connect");
		bot.setVerbose(true);
		// dh.establishDbConn();
		try {
			// Connect to BitsJoint-IRC, using IPv6
			bot.connect("irc6.bitsjointirc.net");
		} catch (NickAlreadyInUseException e) { // Self explanatory, as with the below ones
			Logger a = new Logger();
			a.log("SEVERE", "The nick provided is already in use!");
			System.exit(1);
		} catch (IrcException e) {
			Logger a = new Logger();
			a.log("SEVERE", "IrcException! Stack trace is printing. The bot will halt after this!");
			a.log("SEVERE", eh.getStackTrace(e));
			System.exit(1);
		} catch (IOException e) {
			Logger a = new Logger();
			a.log("SEVERE", "IOException! Stack trace is printing. The bot will halt after this!");
			a.log("SEVERE", eh.getStackTrace(e));
			System.exit(1);
		}
		bot.joinChannel("#expertmac2"); // Self explanatory
	}
	
	public void loadConfig() {
		Yaml y = new Yaml();
		y.load("C:\\UplinkRPG\\config.yml");
	}
	
	public static void firstRun() {
		su.SetupBot();
	}
}
