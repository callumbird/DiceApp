 import java.util.*;
  
  public class DiceCalculator {

  public static void main(String[] args) {
	  	Scanner input = new Scanner(System.in);
		
		//array of all dice being rolled at once
		int[] dice = getUserArray("enter a list of dice sides to roll", input);
		
		//array of all modifiers being applied to dice
		int[] diceModifiers = getUserArray("enter a list of dice modifiers to add", input);
		
		int totalDiceModifiers = sumOfArrayValues(diceModifiers);
		
		int repeats = getUserInput("enter number of times to perform these rolls", input);
		
		int[] resultOfAllRepeats = arrayCalculation(dice, repeats);
		
		output(resultOfAllRepeats, dice.length, totalDiceModifiers);
  	}
  	
  	private static int[] arrayCalculation(int[] dice, int repeats) {
  		
  		int maxRoll = sumOfArrayValues(dice);
  		
  		int[] resultOfAllRepeats = new int[maxRoll - dice.length + 1];
  		
  		for(int repeat = 0; repeat < repeats; repeat++) {
  		
  			int sumOfOneRoll = rollDice(dice);
  		
  			resultOfAllRepeats[sumOfOneRoll]++;
  		
  		}
  		
  		return resultOfAllRepeats;
  	}
  	
  	private static int getUserInput(String message, Scanner input) {
  		System.out.println(message);
  		return input.nextInt();
  	}
  	
  	private static int[] getUserArray(String message, Scanner input) {
  		System.out.println(message);
  		
  		String line = input.nextLine();
    	String[] nums = line.split(",");
    	int[] result = new int[nums.length];
    
    	for (int i = 0; i < result.length; i++) {
    		result[i]=Integer.parseInt(nums[i]);
  		}
  		return result;
  	}
  	
  	private static int getMaxRoll(int[] array) {
  		int maxValue = array[0];
  		int maxValuePosition = 0;
  		
  		for(int i = 0; i < array.length; i++) {
  			if(maxValue < array[i]) {
  				maxValue = array[i];
  				maxValuePosition = i;
  			}
  		}
  		
  		return maxValuePosition;
  	}
  	
  	private static int sumOfArrayValues(int[] array) {
  		int count = 0;
  		
  		for(int i=0; i < array.length; i++) {
  			count += array[i];
  		}
  		
  		return count;
  	}
  	
  	private static int getMinimumRoll(int[] array) {
  		int minValue = array[0];
  		
  		for (int i=0; i < array.length; i++) {
  			if (minValue > array[i]) {
  				minValue = array[i];
  			}
  		}
  		
  		return minValue;
  	}
  	
  	private static int rollDice(int[]array) {
  		int total = 0;
  		for(int i = 0; i < array.length; i++) {
  			total += (int)(Math.random()*array[i] + 1);	
  			}
  		return total-array.length;
  	}
  	
  	private static void output(int[] array, int diceLength, int totalDiceModifiers) {
  		int maxValuePosition = getMaxRoll(array);
  		
  		for(int i=0; i < array.length; i++) {
				System.out.println("Number of times you rolled " + (i + totalDiceModifiers + diceLength) + ": " + array[i]);
  		}
	System.out.println("The most common number rolled was " + (maxValuePosition + totalDiceModifiers + diceLength));
  	}
}