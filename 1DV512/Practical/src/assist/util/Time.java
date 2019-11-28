package assist.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private static boolean showTime = false;
	private static String prefix = "[Time]";
	
	public static void Show() { showTime = true; }
	
	static String getTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date(time);
		return "[" + simpleDateFormat.format(date) + "]\n";
	}
	
	public static String Display() {
		if(showTime) { return prefix + getTime(); }
		else { return ""; }
	}
	
	void setShowTime(boolean showTime) {
		Time.showTime = showTime;
	}
	
	static boolean getShowTime() {
		return showTime;
	}
}
