//Assignment 5, Car class
//Written by: Felix Morin (40063253)
//For COMP 248 section E-X - Fall 2017 (12/01/17)

//Program that simulates races and crashes from car objects.
//Car class

public class Car {

	//Declare instance variables and constants of the class
	private final String model; //model of the car
	private int location; //location of the car on a number line
	private int currentSpeed; //speed of the car
	private boolean movingForward; //direction of the car (true: forward, false: backwards)
	private final int maxSpeed; //maximum speed of the car
	
	Car() //Default constructor 
	{ 
		this.model = "Unnamed model";
		this.location = 0;
		this.currentSpeed = 0;
		this.movingForward = true;
		this.maxSpeed = 0;
	}
	
	//Constructor with 3 parameters: model of car, location, and maximum speed, to be input by the user
	Car(String model, int location, int maxSpeed)
	{ 
		this.model = model;
		this.location = location;
		this.currentSpeed = 0;
		this.movingForward = true;
		this.maxSpeed = maxSpeed;
	}
	
	//Accessor method for the car model
	public String getModel()
	{
		return model;
	}
	
	//Accessor method for direction
	public boolean getDirection()
	{
		return movingForward;
	}
	
	//Accessor method for the location
	public int getLocation()
	{
		return location;
	}
	
	//Method that sets the current speed to the maximum speed
	public void go()
	{
		this.currentSpeed = this.maxSpeed;
	}
	
	//Method that makes the car stop, sets the current speed to 0
	public void stop()
	{
		this.currentSpeed = 0;
	}
	
	//Method that makes the car change direction
	public void turnAround()
	{
		this.movingForward = !this.movingForward;
	}
	
	//Method that changes the location of the car depending on the speed
	public void move()
	{
		if(movingForward)
			this.location += this.currentSpeed; //Adds the current speed to the location if going towards the right
		else
			this.location -= this.currentSpeed; //Subtracts the current speed from the location if going towards the left
	}
	
	//Method that returns the model, location, current speed, and direction of the car in a single string
	public String toString() 
	{
		if(currentSpeed !=0)
			return (model + ": Located at " + this.location + ", facing " + (this.movingForward ? "forward, " : "backwards, ") + "moving at " + currentSpeed + " speed.");
		else
			return (model + ": Located at " + this.location + ", facing " + (this.movingForward ? "forward, " : "backwards, ") + "not moving.");	
	}
	
	//Expansion for Part 2
	
	//Constructor with 2 parameters: model of the car and its maximum speed, to be input from the user
	Car(String model, int maxSpeed)
	{
		this.model = model;
		this.location = 0;
		this.currentSpeed = 0;
		this.movingForward = true;
		this.maxSpeed = maxSpeed;
	}
	
	//Method to increase the speed of the car, adds 1 unit of speed to the current speed 
	public void accelerate()
	{
		if(this.currentSpeed < maxSpeed)
			this.currentSpeed++;
	}
	
	//Method to decrease the speed of the car, subtracts 1 unit of speed from the current speed
	public void brake()
	{
		if(this.currentSpeed > 0)
			this.currentSpeed--;
	}
	
	//Variables specific to part 2
	private boolean crashed = false; //true if the car has crashed
	private int position; //Positions (1 to 3) of the first 3 cars to finish the race, set to 0 as default if the car is not in the top 3
	
	//Method to identify a car as crashed (mutator)
	public void crashed()
	{
		this.crashed = true;
	}
	
	//Accessor method to know if the car is crashed 
	public boolean isCrashed()
	{
		return crashed;
	}
	
	//mutator method that assigns a finishing position to a car
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	//Accessor method to know the position of the car
	public int getPosition()
	{
		return this.position;
	}
	
}
