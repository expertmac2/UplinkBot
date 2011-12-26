package tc.net.expertmac2.util;

public class findOS {
	
	public findOS() {}

	public String getOS() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win")>=0) {
			return "Windows";
		} else if(os.indexOf("uni")>=0){
			return "Unix";
		} else if(os.indexOf("lin")>=0) {
			return "Linux";
		}
		return "Unknown";
	}
}
