package com.szxy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String format(Date date,String pattern){
		String str = null;
		
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			
			str = sdf.format(date);
		}
		return str;
	}
	
	public static Date parse(String sdate,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		Date date = null;
		
		if(null==sdate || pattern==null){
			return date;
		}
		
		try {
			date = sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
