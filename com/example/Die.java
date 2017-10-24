package com.example;

import java.util.Random;

public class Die {
	public int numberOfSides = 6;
	
	public int roll() {
		Random random = new Random();
		
		return random.nextInt(6) + 1;
	}
}
