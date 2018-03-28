package com.thunisoft.hyyd.arithmetic;

import java.util.Random;

public class Demo01 {


	/**
	 * 0-99 随机排列 随便加上一个数  已找出重复的数
	 * @param args
	 */
	
	public static void main(String[] args) {
		Integer [] array = generalArray();
		for(int i = 0 ;i<array.length;i++) {
			for(int m = 0;m<array.length;m++) {
				if(array[i]<array[m]) {
					array[i]=array[m]+array[i];
					array[m]= array[i]-array[m];
					array[i]= array[i]-array[m];				}
			}
		}
		for (Integer integer : array) {
			System.out.println(integer);
		}
		
		
		
		Integer [] sort = new Integer[100];
		for (Integer integer : array) {
			sort[integer]= sort[integer]==null?1:++sort[integer];
		}
		
		for (int i =0 ;i<100;i++) {
			System.out.println(i+"="+sort[i]);
		}
		
		
		
	}

	private static Integer[] generalArray() {
		Integer [] array  = new Integer[101];
		Random random = new Random();
		int index =0 ;
		while (index<100) {
			int  i  = random.nextInt(100);
			boolean boo  = true;
			for (Integer integer : array) {
				if(integer!=null&&integer==i) {
					boo = false;
					break;
				}
			}
			
			if(boo) {
				array[index++] = i;
			}
			
		}
		array[100] = random.nextInt(100);
		
		return array;
	}

}
