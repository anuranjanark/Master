package com.practise;

import java.time.LocalDateTime;
import java.util.Date;

public class SampleData {
public static void main(String[] args) {
	/*LocalDateTime ldt=LocalDateTime.now();
	System.out.println(ldt);
	int day = ldt.getDayOfMonth();
	System.out.println(day);*/
	Date d=new Date();
	String currentDate = d.toString();
	System.out.println(currentDate);
    String[] arr = currentDate.split(" ");
    
    String datee=arr[2];
    System.out.println(datee);
  
    String month = arr[1];
    System.out.println(month);
    
    String year = arr[5];
    System.out.println(year);
   
    // to get month in int format
    int monthInt = d.getMonth();
    System.out.println(monthInt);
}
}
