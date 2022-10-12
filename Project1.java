import java.util.Arrays;
import java.util.Scanner;
/*
 * Author: E.F.
 * Course: COP3503
 * Project #: 1
 * Title: Number Statistics
 * Due Date: 9/30/22
 */
public class Project1 {

	public static void main(String[] args) {
		
		
		System.out.println("Enter List of Integers Separated by Spaces: ");
		
		//Get user input
		Scanner scnr = new Scanner(System.in);
		
		String userInput = scnr.nextLine();
		
		
		//Convert Input to an integer Array
		String[] splitString = userInput.split(" ");
		int size = splitString.length;
		int [] userArray = new int [size];
		for (int i = 0; i < size; i++)
		{
			userArray[i] = Integer.parseInt(splitString[i]);
		}
			
		//boolean variable
		boolean flag = true;
		
		//Do-While loop
		do {
			
			
			//Display Menu
			System.out.println("Please make a selection: ");
			System.out.println("1) Display List Statistics");
			System.out.println("2) Display List Ordered");
			System.out.println("3) Number of Odd/Even");
			System.out.println("4) Check for Prime Numbers");
			System.out.println("5) Enter New List");
			System.out.println("exit) Quit Program");
			
			//Let the user select the option
			String userSelection = scnr.next();
			
		//Switch cases
		switch (userSelection) {
			
			case "1":
				//call method
				caseOne(userArray);
				System.out.println();
				
				break;
			case "2":
				//call method
				Arrays.sort(userArray);
				System.out.println(Arrays.toString(userArray));
				System.out.println();
				
				break;
			case "3":
				//call method
				int[] evenOddvalue = findEvenodd(userArray);
				System.out.println("Number Even: " + evenOddvalue[0]);
				System.out.println("Number Odd: " + evenOddvalue[1]);
				System.out.println();
				
				break;
			case "4":
				//call method
				int primeValue = findPrime(userArray);
				System.out.println("Number of Prime in list: " + primeValue);
				System.out.println();
				
				break;
			case "5":
				//call method
				userArray = findList();
				
				
				continue;
			case "exit":
				//call method
				flag = false;
				break;
				
			default: 
				System.out.println("Error: Invalid Input");
				//possibly allow user to enter input again
				
				continue;
		}
	} while (flag == true);
		
}	
	
	/**
	 * This method is used to find the maximum number in an array.
	 * @param userArray First parameter. Holds the user's array in it.
	 * @return integer This returns the highest number value in userArray.
	 */
	public static int findMax(int[] userArray)
	{
		int max = userArray[0];
		for (int i = 1; i < userArray.length; i++)
		{
			if (userArray[i] > max)
			{
				max = userArray[i];
			}
		}
		
		return max;
	}
	
	/**
	 * This method is used to find the minimum number in an array.
	 * @param userArray First parameter. Holds the user's array in it.
	 * @return integer This returns the lowest number value in userArray.
	 */
	public static int findMin(int[] userArray)
	{
		int min = userArray[0];
		for (int i = 1; i < userArray.length; i++)
		{
			if (userArray[i] < min)
			{
				min = userArray[i];
			}
		}
		return min;
	}
	
	/**
	 * This method is used to find the amount of numbers in an array.
	 * @param userArray First parameter. Holds the user's array in it.
	 * @return integer This returns the amount of numbers in userArray.
	 */
	public static int findCount(int[] userArray)
	{
		int counter = 0;
		for (int i = 0; i < userArray.length; i++)
		{
			counter++;
		}
		return counter;
	}
	
	/**
	 * This method is used to find the range in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return integer This returns the range by calling the findMax and findMin methods and subtracting the outputs.
	 */
	public static int findRange(int[] userArray)
	{
		int max = findMax(userArray);
		int min = findMin(userArray);
		int range = max - min;
		return range;
	}
	
	/**
	 * This method is used to find the median number in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return double This returns median number which is calculated by using the findCount method
	 * and using specific calculations.
	 */
	public static double findMedian(int[] userArray)
	{
		Arrays.sort(userArray);
		double median;
		int count = findCount(userArray);
		if (count % 2 == 1)
		{
			median = userArray[(count + 1) / 2 - 1];
		}
		else {
			median = (double) (userArray[count / 2 - 1] + userArray[count / 2]) / 2;
		}
		return median;
	}
	
	/**
	 * This method is used to find the mean or average in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return double This returns the addition of every value in userArray divided by the
	 * value of the findCount method.
	 */
	public static double findMean(int[] userArray)
	{
		int temp = 0;
		double mean;
		int count = findCount(userArray);
		for (int i = 0; i < userArray.length; i++)
		{
			temp = temp + userArray[i];
		}
		mean = (double) temp / count;
		return mean;
	}
	
	/**
	 * This method is used to find the median number in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return integer This returns the number that shows up the most in the array.
	 */
	public static int findMode(int[] userArray)
	{
		int mode = -1;
		int count = findCount(userArray);
		int finalCounter = -1;
		
		for (int i = 0; i < count; i++)
		{
			int counter = 0;
			
			for (int j = 0; j < count; j++)
			{
				if (userArray[i] == userArray[j])
				{
					counter++;
				}
			}
			
			if (counter > finalCounter)
			{
				mode = userArray[i];
				finalCounter = counter;

			}
		}
		
		return mode;
	}

	/**
	 * This method is used to find the population variance in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return double This returns the population variance using a mathematical formula.
	 */
	public static double findVariance(int[] userArray)
	{
		double mean = findMean(userArray);
		int count = findCount(userArray);
		double temp = 0;
		double variance = 0;
		double populationVariance = 0;
		
		for (int i = 0; i < count; i++)
		{
			temp = (userArray[i] - mean);
			variance = (Math.pow(temp, 2)) + variance;
		}
		populationVariance = variance / count;
		return populationVariance;
	}
	
	/**
	 * This method is used to find the population standard deviation in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return double This returns the population standard deviation value which is obtained by first getting the variance.
	 */
	public static double findStandarddeviation(int[] userArray)
	{
		double variance = findVariance(userArray);
		double standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}
	
	/**
	 * This method is used to call other methods, which then print specific values for the user
	 * @param userArray First parameter. Holds the user's array in it
	 */
	public static void caseOne(int[] userArray)
	{
		int maximumValue = findMax(userArray);
		int minimumValue = findMin(userArray);
		int countValue = findCount(userArray);
		int rangeValue = findRange(userArray);
		double medianValue = findMedian(userArray);
		double meanValue = findMean(userArray);
		int modeValue = findMode(userArray);
		double varianceValue = findVariance(userArray);
		double standardDeviationvalue = findStandarddeviation(userArray);
		
		System.out.println("Min: " + minimumValue);
		System.out.println("Max: " + maximumValue);
		System.out.println("Count: " + countValue);
		System.out.println("Range: " + rangeValue);
		System.out.println("Median: " + medianValue);
		System.out.println("Mean: " + meanValue);
		if (modeValue == -1)
		{
		System.out.println("Mode: No Mode");
		}
		else {
			System.out.println("Mode: " + modeValue);
		}
		System.out.println("Variance: " + String.format("%.2f", varianceValue));
		System.out.println("Standard Deviation: " + String.format("%.2f", standardDeviationvalue));
		
	}
	
	//Count even/odd numbers
	/**
	 * This method is used to find the number of odds and evens in an array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return integer[] This returns an array which hold two different values one for the number of odd numbers 
	 * and one for the number of even numbers and is found by using the modulus operator.
	 */
	public static int[] findEvenodd(int[] userArray)
	{
		int[] counter = new int[2];
		for (int i = 0; i < userArray.length; i++)
		{
			if (userArray[i] % 2 == 0)
			{
				counter[0]++;
			}
			else
			{
				counter[1]++;
			}
		}
		return counter;
	}
	
	//Count Prime Numbers
	/**
	 * This method is used to find the amount of prime numbers in the array
	 * @param userArray First parameter. Holds the user's array in it
	 * @return integer This returns the amount of prime numbers in the array.
	 */
	public static int findPrime(int[] userArray)
	{
		int counter = 0;
		int count = findCount(userArray);
		
		for (int i = 0; i < count; i++)
		{
			boolean isPrime = true;
			if (userArray[i] <= 1)
			{
				isPrime = false;
			}
			else if (userArray[i] == 2)
			{
				isPrime = true;
			}
			else if (userArray[i] % 2 == 0)
			{
				isPrime = false;
			}
			
			for (int j = 3; j <= Math.sqrt(userArray[i]); j += 2)
			{
				if (userArray[i] % j == 0)
				{
					isPrime = false;
				}
			}
			if (isPrime == true)
			{
				counter++;
			}
			
		}
			return counter;
	}
	
	//Enter a new list method

	/**
	 * This method is used to allow the user to enter a new array of values.
	 */
	public static int[] findList()
	{
		System.out.println("Enter List of Integers Separated by Spaces: ");
		
		//Get user input
		Scanner scnr = new Scanner(System.in);
		
		String userInput = scnr.nextLine();
		
		
		//Convert Input to an integer Array
		String[] splitString = userInput.split(" ");
		int size = splitString.length;
		int[] userArray = new int [size];
		for (int i = 0; i < size; i++)
		{
			userArray[i] = Integer.parseInt(splitString[i]);
		}
		
		return userArray;
	}
}
