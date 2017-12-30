package org.interviewquestions.example3;

public class FindSqrtOfNumber {

	public static void main(String[] args){
		
		int number = 3;
		
		double sqrt = computeSquareRoot(number);
		
		System.out.println(sqrt);
		System.out.println(sqrt * sqrt);
	}
	
	/**
	 * Divide number by sqrt of nearest square of a number
	 * Average sqrt with divisor
	 * Repeate till couple of decimal places
	 */
	private static double computeSquareRoot(double number){
		double sqrt = nearestSquare(number);
		
		double p;
		
		for(int i=0; i < 4; i++){
			p = number/sqrt;
			sqrt = (sqrt + p)/2;
		}
		
		return sqrt;
	}
	
	/**
	 * Get most nearest square of the number
	 */
	private static double nearestSquare(double number){
		double nearer = 0;
		double nearest = 0;
		int index = 0;
		boolean flag = true;
		
		for(int i=0; i <= number/2; i++){
			int sq = i * i;
			if(flag){
				nearest = sq;
				flag = false;
			}
			nearer = sq;
			double nearer_diff  = number - nearer;
			double nearest_diff = number - nearest;
			
			nearer_diff = nearer_diff < 0 ? nearer_diff * (-1) : nearer_diff;
			nearest_diff = nearest_diff < 0 ? nearest_diff * (-1) : nearest_diff;
			
			if(nearer_diff < nearest_diff){
				nearest = sq;
				index = i;
			}
		}
		
		return index;
	}
}
