//Assignment 5, RaceLane2 class
//Written by: Felix Morin (40063253)
//For COMP 248 section E-X - Fall 2017 (12/01/17)

//Program that simulates a race between a certain number of car objects.
//RaceLane2 Class, main method for part 2

//Necessary to user Scanner
import java.util.Scanner;

public class RaceLane2 {

	//Main method for part 2
	public static void main(String[] args) {
		
		//Create a Scanner object
		Scanner key = new Scanner(System.in);
		
		//Initialize variables (all inputs from user)
		final int carNum; //number of cars to race
		int tempMaxSpeed = 0; //maximum speed of a given car 
		String tempModel = ""; //model of a given car
		final int raceLength; //length of the race
		
		final int lapLength = 100; //Length of 1 lap (given in the problem)
		
		//Welcome message
		System.out.println("Welcome to my program, which simulates a race between a given number of cars. You will have to enter some\ninformation about" +
		" the cars and the race before the simulation can start.\n");
		
		//Ask and store the number of cars that will race
		System.out.print("Enter the number of cars that will race: ");
		carNum = key.nextInt();
		
		//Create an array of car objects with the desired number of objects
		Car[] Cars = new Car[carNum];
		
		//Loop in order to create the car objects using some information input by the user
		for(int i=0; i<carNum; i++) //Goes through all the objects of the array
		{
			//Ask and store the maximum speed of the given car
			System.out.print("\nEnter the maximum speed of car #" + (i+1) + ": "); 
			tempMaxSpeed = key.nextInt();
			
			//Make sure that the maximum speed is between 2 and 7
			while(tempMaxSpeed > 7 || tempMaxSpeed < 2)
			{
				System.out.print("You have to enter a number from 2 to 7. Try again: ");
				tempMaxSpeed = key.nextInt();
			}
			
			//Ask and store the model of the given car
			System.out.print("Enter the model of the car #" + (i+1) + ": ");
			tempModel = key.nextLine();
			tempModel = key.nextLine();
			
			//Create a car object based on the information gathered above 
			Cars[i] = new Car(tempModel, tempMaxSpeed);
		}
		
		
		//Ask for the number of laps and multiply the input by the length of 1 lap in order to get the length of the race
		System.out.print("\nEnter the number of laps that the race will consist of: ");
		raceLength = lapLength*key.nextInt();
		
		
		//The following part is dedicated to the race simulation itself
		
		//Variables necessary for the race loops
		int done = 0; //number of cars that finished the race
		int crashes = 0; //number of cars that crashed
		int sameLocation = 1; //number of cars that are in the same location
		int crashLocation = 0; //location of a crash if 3 cars are at a same location
		int position = 1; //position in which the cars finish the race (for the 3 first cars) 
		
		System.out.println("\n3..\n2..\n1..\nRACE!"); //Announce the beginning of the race
		
		while(done < 3 && carNum > done+crashes) //Stops when 3 cars have finished the race, or if no more cars are left racing
		{
			System.out.println("");
			System.out.println(carNum-crashes-done + " cars are still racing.");
			
			//Loop that updates and outputs the race information about each cars
			for(int i = 0; i<carNum; i++) 
			{
				if(Cars[i].getLocation() >= raceLength || Cars[i].isCrashed()) 
					continue; //Skip to the next car if the present car has finished the race or crashed
				
				System.out.println(Cars[i].toString()); //Output information about the car
				Cars[i].accelerate(); //Update speed
				Cars[i].move(); //Update location
				
				if(Cars[i].getLocation() >= raceLength) //if car has finished the race
				{
					System.out.println(Cars[i].getModel() + " finished the race."); 
					done++; 
					Cars[i].setPosition(position++); //Assign position to the car
				}
			}
			
			//Loop that deals with possible crashes
			for(int i = 0; i<carNum; i++) 
			{
				if(Cars[i].getLocation() > lapLength) //Is entered if at least one car has finished the first lap
				{
					//Compares each car with all the other cars
					for(int j = 0; j<carNum; j++)
					{
						for(int k = 0; k<carNum; k++)
						{
							//Entered if the car has the same location as a car other than itself, and if both cars are not already crashed
							if(Cars[j].getLocation()==Cars[k].getLocation() && !Cars[j].getModel().equals(Cars[k].getModel()) && !Cars[j].isCrashed() && !Cars[k].isCrashed() && Cars[j].getLocation() < raceLength && Cars[k].getLocation() < raceLength)
							{
								sameLocation++; //add 1 to the number of cars in a same location
								crashLocation = Cars[j].getLocation(); //get the location of the potential crash
							}
						}
						if(sameLocation >= 3) //if 3 cars are at the same location
						{
							crashes += sameLocation; //add the number of cars at the same location to the number of crashes
							
							System.out.println("The following " + sameLocation + " cars crashed:");
							
							//List the cars that have crashed
							for(int l = 0; l<carNum; l++)
							{
								if(Cars[l].getLocation()==crashLocation && !Cars[l].isCrashed()) //If the car is crashed / is at the collision location, but was not already crashed
									{
									Cars[l].crashed(); //identify the car as crashed
									System.out.println(Cars[l].getModel()); //Print the model of the car
									}
							
								Cars[l].stop(); //All the cars, even if it is not crashed, has to stop before continuing the race
							}
						}
						
						sameLocation = 1; //Reset to 1 to check for other potential crashes at other locations
					}
					
					break; //break from the first loop because it is only meant to make sure that at least 1 car has finished the first lap
				}
			}
		}
			
		System.out.println("");
		
		if(carNum == crashes) //if all cars have crashed
			System.out.println("All cars have crashed. No winners.");
		else
		{
			System.out.println("---WINNERS---"); 	
		
			//Determine the winners and assign their position
			for(int j=1; j<=3 && j<=done;) 
			{
				for(int i = 0; i<carNum; i++)
				{
				if(Cars[i].getPosition()==j)
					System.out.println("Position #" + j++ + ": " + Cars[i].getModel());
				}
			}
		}
		
		key.close(); //Close Scanner
		
		//Closing message
		System.out.print("\nThanks for using my racing simulator program!");
	}
}


