package th.ac.rmutsb.pro.test.config.helper;

import java.sql.Timestamp;

public class StampHelper {
	public static Timestamp convertTimeStamp(String date_string, String time_string) {
		String[] date_split = date_string.split("-");
		Timestamp timestamp = Timestamp.valueOf(date_split[2] + "-" + date_split[1] + "-" + date_split[0] + " " + time_string);
		return timestamp;
	}
	/*public static boolean isOverlapping_old(Timestamp start1, Timestamp end1, Timestamp start2, Timestamp end2) {
		return ((null == end2) || start1.before(end2)) &&
				((null == end1) || start2.before(end2));
	}*/
	public static boolean isOverlapping(Timestamp start1, Timestamp end1, Timestamp start2, Timestamp end2) {
		return start1.compareTo(end2) <= 0 && end1.compareTo(start2) >= 0;
	}
}
