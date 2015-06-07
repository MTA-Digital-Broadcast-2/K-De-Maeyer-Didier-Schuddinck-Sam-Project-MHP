import java.lang.*;
/**
 * Deze klasse is een afdruk programma
 * @author Sam Schuddinck
 * @ Version 1,0
 */
public class Oefening1{
	/*
	* Dit is de main methode
	* @param args Dit zijn de command line parameters
	*/
	public static void main(String args[])
	{
		int i;
		int k;
		for(i = 1; i < 10; i++)
		{
			for(k = 1; k < 10; k++)
			{
				int product = i*k;
				System.out.println(i +"x"+ k +" ="+ product); 
			}
		}
	}
}