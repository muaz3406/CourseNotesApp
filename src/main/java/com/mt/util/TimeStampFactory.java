package com.mt.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeStampFactory {

	public static Timestamp getCurrentTimeStamp() {
		long nanos = 0;
		LocalDateTime dateTime = LocalDateTime.now().minusNanos(nanos);
		return Timestamp.valueOf(dateTime);
	}

}
