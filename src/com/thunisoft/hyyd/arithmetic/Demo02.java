package com.thunisoft.hyyd.arithmetic;

public class Demo02 {
	// 1 1 2 3 5 8 13 21
	
	public static void main(String[] args) {
		int count = 0 ;
		int value = 0;
		int pre = 1;
		int post = 1;
		int temp;
		while(count<29) {
			value = pre +post;
			temp = post;
			post = value;
			pre =temp;
			count++;
			System.out.println(value);
		}
		
		
		
		
	}
	
	

}
