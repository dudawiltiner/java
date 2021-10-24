package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static void main(String[] args) { // ponto de entrada
		final int median = median(new int[]{ 1,2,3,5});
		System.out.println(median);
	}

	public static int average(int[] elements) {
		int sum = 0;
		for(int element: elements) {
			sum += element;
		}

		return sum/elements.length;
	}

	public static int mode(int[] elements) {

		int count = 0;
		int count1 = 0;
		int element = 0;

		for (int element1: elements) {
			count1 = 0;
			for(int element2: elements) {
				if(element1 == element2) {
					count1 ++;
				}
			}
			if (count1 > count){
				element = element1;
				count = count1;
			}
		}

		return element;
	}

	public static int median(int[] elements) {
		int [] sortedElements = Arrays.stream(elements).sorted().toArray();
		System.out.println(sortedElements);

		//System.out.println(elements.length);
		if((sortedElements.length)%2 == 0){
			int position = sortedElements.length/2;
			int sum = sortedElements[position] + sortedElements[position - 1];

			return sum/2;
		}

		float position = sortedElements.length/2;
		return sortedElements[Math.round(position)];
	}
}