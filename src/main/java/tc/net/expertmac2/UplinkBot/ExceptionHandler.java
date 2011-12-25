package tc.net.expertmac2.UplinkBot;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler {
	public String getStackTrace(Throwable throwable) {
		StringWriter w = new StringWriter();
		PrintWriter pw = new PrintWriter(w);
		throwable.printStackTrace(pw);
		return w.toString();
	}
}
