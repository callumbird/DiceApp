import java.util.*;

public class DiceStats {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please type in number of rolls");
		int rolls = input.nextInt();
		
		System.out.println("Please type in number of sides on dice");
		int diceSides = input.nextInt();
		
		int[] count = new int[diceSides];

		for (int i=0; i<rolls; i++){
		  count[rollDice(diceSides, 0) - 1]++;
		}
		
		for (int number=1; number<=count.length; number++) {
			System.out.println("Number of times you rolled " + number + ": " + count[number-1]);
		}
	}
	
	public static int rollDice(int diceSides, int modifier) {
		
		double randomNumber = Math.random();
		randomNumber = (randomNumber*diceSides)+1;
		int randomInt = (int)randomNumber;
		
		return randomInt;
	}
}
