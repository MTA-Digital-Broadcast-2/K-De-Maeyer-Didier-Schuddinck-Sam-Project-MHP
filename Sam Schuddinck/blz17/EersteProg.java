import java.lang.*;
/**
 * Deze klasse is een afdruk programma
 * @author Sam Schuddinck
 * @ Version 1,0
 */
public class EersteProg{
	/*
	* Dit is de main methode
	* @param args Dit zijn de command line parameters
	* 10 = 0000 1010
	* ~ 10 = 1111 0101 = -11
	*/
	public static void main(String args[])
	{
		System.out.println(~10);
		// om in 2's complement van 10 naar - 10 te gaan
		// kan je alle bits inverteren en dan +1
		// maar de +1 doe je hier niet, dus kom je op -11 uit
	}
}