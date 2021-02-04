package com.crm.autodesk.generics;

import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * generate random number from 1 to 20
	 * @return
	 */
	public int GenerateRandomInt() {
		Random random=new Random();
		int randomInt = random.nextInt(20);
		return randomInt;
	}
	
	Date d=new Date();
	String currentDate = d.toString();
	String[] arr = currentDate.split(" ");
	/**
	 * to read current date
	 * @return
	 */
	public String getCuurentDate() {
		String date=arr[2];
		return date;
	}
	/**
	 * to read current month
	 * @return
	 */
	public int getCurrentMonth() {
		int month = d.getMonth();
		return month;

	}
	/**
	 * to read current year
	 * @return
	 */
	public  String getCurrentYear() {
		String year = arr[5];
		return year;

	}

}

