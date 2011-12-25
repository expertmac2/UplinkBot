package tc.net.expertmac2.UplinkBot;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import tc.net.expertmac2.UplinkBot.Logger;

public class UplinkRPG {

	private Logger l = new Logger();
	private static ExceptionHandler eh = new ExceptionHandler();
	private static String botnick = "UplinkRPG";
	
	public static void main(String[] args) {
		Bot bot = new Bot(botnick);
		bot.setVerbose(true);
		try {
			bot.connect("irc.esper.net");
		} catch (NickAlreadyInUseException e) {
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
		
		bot.joinChannel("#expertmac2");
		
	}
}
