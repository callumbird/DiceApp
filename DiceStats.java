import java.util.*;

public class DiceStats {

	public static void main(String[] args) {
		int[] count = method1();
		method2(count);
	}
	
	public static int[] method1() {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to roll multiple dice at once?");
		String question = input.nextLine();
		
		System.out.println("Please type in number of rolls");
		int rolls = input.nextInt();
		
		System.out.println("Please type in number of sides on dice");
		int diceSides = input.nextInt();
		
		System.out.println("Please type in modifier number");
		int modifier = input.nextInt();
		
		if(question.equals("Yes")) {
			System.out.println("Please type in number of dice being rolled at once");
			int diceRolls = input.nextInt();
			
			int[] count = multipleDice(diceSides, diceRolls, rolls);
			
			for (int number=1; number<=count.length; number++) {
				System.out.println("Number of times you rolled " + (number + modifier) + ": " + count[number-1]);
			}
			
			return count; 
		}
		
		else {
		
		int[] count = oneDiceOutput(diceSides, rolls);
		
		for (int number=1; number<=count.length; number++) {
			System.out.println("Number of times you rolled " + (number + modifier) + ": " + count[number-1]);
			}
		
		return count;
		
		}	
	}
	
	public static void method2(int[] count) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to add another set of dice rolls to this result?");
		String question = input.nextLine();
		
		if(question.equals("Yes")) {
			int[] count2 = method1();
			int[] count3 = mixedDice(count, count2);
			
			for (int number=1; number<=count3.length; number++) {
				System.out.println("Number of times you rolled " + number + ": " + count3[number-1]);
			}
		}
		
		else {
			;
		}
	}
	
	public static int[] oneDiceOutput(int diceSides, int rolls) {
		
		int[] count = new int[diceSides];

		for (int i=0; i<rolls; i++){
		  count[(int)(Math.random()*diceSides)]++;
		}
		
		return count;
	}
	
	
	public static int[] multipleDice(int diceSides, int diceNumber, int rolls) {
		
		int[] count = new int[diceNumber*diceSides];
		
		for (int i=0; i<rolls; i++) {
			count[multipleDiceRolls(diceSides)]++;
		}
		
		return count;
	}
	
	public static int multipleDiceRolls(int diceSides) {
		
		int roll1 = (int)(Math.random()*diceSides);
		int roll2 = (int)(Math.random()*diceSides);
		
		return roll1 + roll2;
	}
	
	public static int[] mixedDice(int[] array1, int[] array2) {
		if(array1.length >= array2.length) {
		
			int[] count = new int[array1.length];
		
			for (int i=0; i < array1.length; i++) {
				count[i] += array1[i];
				count[i] += array2[i];
			}
		return count;
		}
		else {
			int[] count = new int[array2.length];
			
			for (int i=0; i < array2.length; i++) {
				count[i] += array2[i];
				count[i] += array1[i];
			}
		return count;
		}
	}
}