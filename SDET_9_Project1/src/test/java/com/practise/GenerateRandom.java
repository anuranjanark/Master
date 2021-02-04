package com.practise;

import java.util.Random;

public class GenerateRandom {
	public static void main(String[] args) {
		Random random=new Random();
		int randomInt = random.nextInt(10000);
		System.out.println(randomInt);
	}


}
