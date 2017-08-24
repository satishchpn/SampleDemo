package com.zycus.mobileappserver.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeUtility {

	public static void main(String[] args) {
		Date date = saveDateTime();
		getDateTime(date);
	}

	private static void getDateTime(Date date) {
		System.out.println("=========================================");
		Calendar indiaTime = new GregorianCalendar(TimeZone.getTimeZone("IST"));
		indiaTime.setTime(date);
		indiaTime.setTimeInMillis(indiaTime.getInstance().getTimeInMillis());
		System.out.println("Property Date: " + indiaTime.getTime());
	}

	private static Date saveDateTime() {
		Calendar c = Calendar.getInstance();
		System.out.println("Property Date: " + c.getTime());

		TimeZone z = c.getTimeZone();
		int offset = z.getRawOffset();
		if (z.inDaylightTime(new Date())) {
			offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;

		// System.out.println("offset: " + offsetHrs);
		// System.out.println("offset: " + offsetMins);

		c.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
		c.add(Calendar.MINUTE, (-offsetMins));
		System.out.println("=========================================");
		System.out.println("Server Date: " + c.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		// System.out.println("Date " + sdf.format(c.getTime()));
		return c.getTime();
	}

}
