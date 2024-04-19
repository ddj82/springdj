package com.springbook.biz.board;
import java.util.*;
public class aaa {

	public static void main(String[] args) {
//		int[] numbers = {1, 2, 3, 4, 5, 6};
		int[] numbers = {1, 2, 3};
		int c = 0;
		int k = 3;
		int answer = 0;
		
		for (int i = 0; i <= numbers.length; i++) {
			if (i == numbers.length) { // 3
				i = -1;
			} else {
				if (i % 2 == 0) {
					c++; //1 2
					if (c == k) {
						answer = numbers[i];
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
		
		
//		List<Integer> a = new ArrayList<>();
//		for (int i = 0; i < numbers.length; i++) {
//			a.add(numbers[i]);
//			if (i == numbers.length - 1) {
//				i = -1;
//				c++;
//				if (c == 3) {
//					break;
//				}
//			}
//		}
//		System.out.println(a);
//		
//		int k = 5;
//		int r = 0;
//		c = 0;
//		for (int i = 0; i < a.size(); i++) {
//			if (i % 2 == 0) {
//				c++;
//				if (c == k) {
//					r = a.get(i);
//				}
//			}
//		}
//		System.out.println(r);
	}

}
