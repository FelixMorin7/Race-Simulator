//Assignment 5, RaceLane1 class
//Written by: Felix Morin (40063253)
//For COMP 248 section E-X - Fall 2017 (12/01/17)

//Program that simulates a collision between two car objects.
//RaceLane1 Class, main method for part 1

//Necessary to user Scanner
import java.util.Scanner;

public class RaceLane1 {

	//Main method for part 1
	public static void main(String[] args) {
		
	//Welcome message
	System.out.println("Welcome to my program, which simulates a car crash between two cars.\nYou will have to enter some information about" +
	" the cars before the simulation can start.\n");
	
	//Create Scanner object
	Scanner key = new Scanner(System.in);
	
	//Initialize temporary variables to take inputs from the user and use them to create objects 
	String tempModel = ""; //model of the car
	int tempLocation = 0; //location of the car
	int tempMaxSpeed = 0; //maximum speed of the car
	
	//Ask and store the model of the first car
	System.out.print("Enter the model of the first car: ");
	tempModel = key.nextLine();
	
	//Ask and store the location of the first car
	System.out.print("Enter the location of the first car: ");
	tempLocation = key.nextInt();
	
	//Make sure that the location is a positive value
	while(tempLocation < 0)
	{
		System.out.print("You have to enter a positive number. Try again: ");
		tempLocation = key.nextInt();
	}
	
	//Ask and store the maximum speed of the first car
	System.out.print("Enter the maximum speed of the first car: ");
	tempMaxSpeed = key.nextInt();
	
	//Make sure that the maximum speed is a positive value
	while(tempMaxSpeed < 0)
	{
		System.out.print("You have to enter a positive number. Try again: ");
		tempMaxSpeed = key.nextInt();
	}
	
	//Create the first car object using the above information  
	Car Car1 = new Car(tempModel, tempLocation, tempMaxSpeed);
	
	//Ask and store the model of the second car
	System.out.print("\nEnter the model of the second car: ");
	tempModel = key.nextLine(); //Extra nextLine in order to absorb the remain of the previous line
	tempModel = key.nextLine();
	
	//Ask and store the location of the second car
	System.out.print("Enter the location of the second car: ");
	tempLocation = key.nextInt();
	
	//Make sure that the location is a positive value
	while(tempLocation < 0)
	{
		System.out.print("You have to enter a positive number. Try again: ");
		tempLocation = key.nextInt();
	}
	
	//Ask and store the maximum speed of the second car
	System.out.print("Enter the maximum speed of the second car: ");
	tempMaxSpeed = key.nextInt();
	
	//Make sure that the maximum speed is a positive value
	while(tempMaxSpeed < 0)
	{
		System.out.print("You have to enter a positive number. Try again: ");
		tempMaxSpeed = key.nextInt();
	}
	
	//Create the second car object using the above information  
	Car Car2 = new Car(tempModel, tempLocation, tempMaxSpeed);
	
	System.out.println("");
	
	//Output the strings containing the model, location, current speed, and direction of each car
	System.out.println(Car1.toString());
	System.out.println(Car2.toString());
	
	//Make the car with the greatest location (the one that is on the right side of the other) change direction
	if(Car1.getLocation() > Car2.getLocation())
		Car1.turnAround();
	if(Car1.getLocation() < Car2.getLocation())
		Car2.turnAround();
	
	System.out.println("");
	
	//Re-output the strings containing the model, location, current speed, and direction of each car
	System.out.println(Car1.toString());
	System.out.println(Car2.toString());
	
	//Make the cars go from rest to their respective maximum speed
	Car1.go();
	Car2.go();
	
	System.out.print("\n3..\n2..\n1..\nGO!\n");
	
	//The purpose of the following loops is to keep updating the position of the cars as they move toward another, until the cars collide.
	//The information about the cars is shown to the user after each update.
	//Only one of the two loops below will run, depending on which car is on which side of the other.
	
	if (Car1.getLocation() > Car2.getLocation()) //The loop below is entered if Car1 is on the right of Car2
		while(Car1.getLocation() > Car2.getLocation()) //Repeated as long as Car1 is still on the right of Car2 
		{
			Car1.move(); //The location of the car is changed depending on its current speed and direction
			Car2.move(); //The location of the car is changed depending on its current speed and direction
			System.out.println(Car1.toString()); //Prints the string containing the model, location, current speed, and direction of Car1
			System.out.println(Car2.toString()); //Prints the string containing the model, location, current speed, and direction of Car2
		}
	
	else if (Car1.getLocation() < Car2.getLocation()) //The loop below is entered if Car2 is on the right of Car1
		while(Car1.getLocation() < Car2.getLocation()) //Repeated as long as Car2 is still on the right of Car1 
		{
			Car1.move(); //The location of the car is changed depending on its current speed and direction
			Car2.move(); //The location of the car is changed depending on its current speed and direction
			System.out.println(Car1.toString()); //Prints the string containing the model, location, current speed, and direction of Car1
			System.out.println(Car2.toString()); //Prints the string containing the model, location, current speed, and direction of Car2
		}
	
	System.out.println("Boom!!"); //Printed once the two cars have reached the same location or passed each other
	
	key.close(); //Close Scanner
	
	//Closing message
	System.out.print("\nThanks for using my crash simulation program!");
	}
}
