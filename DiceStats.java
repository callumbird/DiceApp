import java.util.*;

public class DiceStats {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to roll one dice at a time or multiple dice at once?");
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
			

		}
		
		else {
		
		int[] count = oneDiceOutput(diceSides, rolls);
		
		for (int number=1; number<=count.length; number++) {
			System.out.println("Number of times you rolled " + (number + modifier) + ": " + count[number-1]);
			}
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
		
		int[] count = new int[array1.length];
		
		for (int i=0; i < array1.length; i++) {
			count[i] += array1[i];
			count[i] += array2[i];
		}
		
		return count;
	}
}