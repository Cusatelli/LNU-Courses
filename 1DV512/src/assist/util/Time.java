package assist.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	protected static boolean showTime = false;
	
	public static void Show() { showTime = true; }
	
	static String getTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date(time);
		return "[" + simpleDateFormat.format(date) + "]";
	}
}
