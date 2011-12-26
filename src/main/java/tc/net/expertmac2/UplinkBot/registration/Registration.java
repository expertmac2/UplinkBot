package tc.net.expertmac2.UplinkBot.registration;

import tc.net.expertmac2.UplinkBot.Bot;
import java.sql.*;

@SuppressWarnings("unused")
public class Registration {
	
	public void Reg(String[] args, String sender, Bot b) {
		if (!args[0].equals("!register")) return;
		try { if (args[1].isEmpty() && args[2].isEmpty()) {} }
		catch (ArrayIndexOutOfBoundsException e) { 
			b.sendMessage(sender, "[ERROR] Syntax: !register [desired username] [desired password]"); 
			return;
		}
	}
}
