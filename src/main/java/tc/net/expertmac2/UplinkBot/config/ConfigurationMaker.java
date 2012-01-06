package tc.net.expertmac2.UplinkBot.config;

import org.yaml.snakeyaml.*;

import tc.net.expertmac2.UplinkBot.ExceptionHandler;
import tc.net.expertmac2.UplinkBot.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("unused")
public class ConfigurationMaker {
	
	@Deprecated
	private final Yaml y = new Yaml();
	private final Properties p = new Properties();
	private final Logger l = new Logger();
	private final ExceptionHandler eh = new ExceptionHandler();
	
	@Deprecated
	public void loadYaml(String file) {
		y.load(file);	
	}
	
	public void makeConfig(String ntwk, String nick) throws NullPointerException {
		try {
			File f = new File("UplinkBot.properties"); // Make a new file
			BufferedWriter out = new BufferedWriter(new FileWriter(f)); // Open the writer to the file
			out.write("# UplinkRPG Bot Configuration File");
			out.write("# UplinkRPG (C) 2011-2012 expertmac2");
			// Checking if things are null
			if (ntwk.equals(null) || nick.equals(null)) { 
				throw new NullPointerException(); // Something is null! Throw an exception that will be caught by the calling class
			}
			out.write("network=" + ntwk);
		} catch (IOException ioe) {
			// l.log("SEVERE","Could not find the configuration file! Run the jar with --setup to set the bot up!");
			l.log("SEVERE", "An unhandled Exception was thrown!");
			l.log("SEVERE", eh.getStackTrace(ioe));
		}
	}
}
