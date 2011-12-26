package tc.net.expertmac2.UplinkBot.setup;

import java.io.*;

import org.yaml.snakeyaml.*;
import tc.net.expertmac2.UplinkBot.UplinkRPG;
import tc.net.expertmac2.util.findOS;

@SuppressWarnings("unused")
public class Setup {
	
	private findOS a = new findOS();

	public void SetupBot() {
		System.out.println("-- UplinkRPG " + UplinkRPG.version + " Setup --");
		System.out.println("UplinkRPG (C) 2011 expertmac2");
		System.out.println("");
		System.out.println("Initializing setup, please wait.");
		System.out.print("Detecting OS..");
		String os = a.getOS();
		if (os.equalsIgnoreCase("windows")) { System.out.print("OS: Windows"); }
		if (os.equalsIgnoreCase("unix")) { System.out.print("OS: Unix-based"); }
		if (os.equalsIgnoreCase("linux")) { System.out.print("OS: Linux-based"); }
		if (os.equalsIgnoreCase("unknown")) { 
			System.out.print("OS: Unknown");
			System.out.println("[ERROR] Your OS is unsupported by the UplinkRPG bot installation.");
			System.out.println("[ERROR] If you are running Windows, Linux, or Unix, restart the setup.");
			System.exit(1);
		}
		// TODO: configuration file setup
		Yaml y = new Yaml();
		// TODO: database configuration
	}
}
