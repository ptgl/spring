package csc.training.login.util;

import java.util.Calendar;

public class DateUtil {
	
	public static java.sql.Date getSQLDate(){
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
	}
}
