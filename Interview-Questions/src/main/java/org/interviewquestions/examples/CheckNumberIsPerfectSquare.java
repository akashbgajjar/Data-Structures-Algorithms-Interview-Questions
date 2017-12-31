package org.interviewquestions.examples;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class CheckNumberIsPerfectSquare {

	public static void main(String[] args){
		
		/*
		 * O/P: TRUE
		 */
		System.out.println(isPerfectSquare(4));
		
		/*
		 * O/P: FALSE
		 */
		System.out.println(isPerfectSquare(3));
	}
	
	private static boolean isPerfectSquare(double number){
		if(number == 0 || number == 1)
			return true;
		
		/*
		 * Iterate to the half of the number and if the double
		 * of the number is same its perfect square
		 * 
		 */
		for(double i = 1; i <= number/2; i++){
			
			double sqrt = i * i;
			
			if(sqrt == number){
				return true;
			}else if(sqrt > number){
				return false;
			}
		}
		return false;
	}
}
