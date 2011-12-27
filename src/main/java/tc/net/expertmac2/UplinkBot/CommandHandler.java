package tc.net.expertmac2.UplinkBot;

import org.jibble.pircbot.Colors;
import tc.net.expertmac2.UplinkBot.registration.Registration;

@SuppressWarnings("unused")
public class CommandHandler {
	
	private Registration r = new Registration();
	public String c = "\u0003";

	public void Handler(String[] args, String sender, Bot b) {
		if (args[0].equals("!register")) {
			r.Reg(args, sender, b);
			// b.sendMessage(sender, c() + "03,01 Connecting to: " + Colors.BOLD + c() + "04,01Uplink Public Access Server... " + Colors.BOLD + c() + "00,01<- / -> ");
		} else if (args[0].equals("!help")) {
			b.sendMessage(sender, "~-~ UplinkRPG v0.1a by expertmac2 ~-~");
			b.sendMessage(sender, "!argstest [arg] [arg]: Testing of args");
			b.sendMessage(sender, "!register: Establishes a connection to the Uplink Public Access Server.");
		} else if (args[0].equals("!argstest")) {
			try { b.sendMessage(sender, "1: " + args[1] + " and 2: " + args[2]); }
			catch (ArrayIndexOutOfBoundsException e) { 
				b.sendMessage(sender, "[ERROR] Syntax: !argstest [arg1] [arg2]"); 
			}
		} else {
			b.sendMessage(sender, "[ERROR] Invalid command. Try !help.");
		}
	}
	
	public void ChanHandler(String[] args, String sender, String c, Bot b) {
		if (args[0].equals("!info")) {
			b.sendMessage(c, "Hi " + sender + ".");
		} else {
			b.sendMessage(c, "[ERROR] Invalid command. Try !help.");
		}
	}
}
