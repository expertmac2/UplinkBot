package tc.net.expertmac2.UplinkBot;

import java.io.PrintStream;

public class Logger {

	private String logPriority;
	private PrintStream out = System.out;
	
	public Logger() {
	}
	
	public void log(String s1, String s2) {
		logPriority = s1;
		// Unfinished, let's just print it out for now
		out.println("[" + logPriority + "] " + s2);
	}
}
