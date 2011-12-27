package tc.net.expertmac2.UplinkBot.db;

import java.sql.*;
import org.h2.*;
import tc.net.expertmac2.UplinkBot.ExceptionHandler;

@SuppressWarnings("unused")
public class DbHandler {
	
	public ExceptionHandler eh =  new ExceptionHandler();
	public String action; public boolean running; public String query;
	Connection c;
	
	public DbHandler() {
		while (running) { // Remember to set it running when the bot starts.
			if (action.equals("connect")) {
				try {
					Class.forName("org.h2.Driver");
					c = DriverManager.getConnection("jdbc:h2:", "sa", "");
				} catch (ClassNotFoundException e) {
					System.out.println("[ERROR] Is your jar corrupt? I can't seem to find the H2 dependency files!");
					System.exit(1);
				} catch (SQLException e) {
					System.out.println("[ERROR] Some kind of SQL error occured. Stacktrace:");
					System.out.println(eh.getStackTrace(e));
				}
				action = "none";
			} else if (action.equals("disconnect")) {
				try { c.close(); } // I trust that you have the connection all set up.
				catch (Exception e) {
					System.out.println("[ERROR] An error occured while closing the H2 Database connection. Stacktrace:");
					System.out.println(eh.getStackTrace(e));
				}
				action = "none";
			} else if (!query.equals(null)) {
				
			}
		}
	}

	/* Outdated.
	 * public void Handler() {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:", "sa", "");
		} catch (ClassNotFoundException e) {
			System.out.println("[ERROR] Is your jar corrupt? I can't seem to find the H2 dependency files!");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("[ERROR] Some kind of SQL error occured. Stacktrace:");
			System.out.println(eh.getStackTrace(e));
		}
	}

	public void disconnDb() {
		
	} */

}
