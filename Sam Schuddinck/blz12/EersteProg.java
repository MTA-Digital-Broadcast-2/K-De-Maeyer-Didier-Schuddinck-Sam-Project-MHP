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
	*/
	public static void main(String args[])
	{
		drukAf(100);
	}
	
	/* 
	* Dit is de drukAf methode
	* @param m Dit is het getal tot waar er moet worden afgedrukt
	*/
	public static void drukAf(int m)
	{
		int a;
		for(a = 0; a<m; a++)
		{
			System.out.println(a);
		}
	}
}