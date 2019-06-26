package com.main.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class testMethod {

	public static void main(String[] args) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ();
		
		String curtDt = mSimpleDateFormat.format ( currentTime );
		
//		System.out.println( curtDt );
	}

}
