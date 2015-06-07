import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
* @author Didier
*/

public class EersteProg 
{
	/**
	* Deze methode is de main methode
	* @param args Dit zijn de command line parameters
	*/

	public static void main(String args[])
	{
		drukaf(100);
	}

	//De commentaar hieronder wordt niet laten zien in de html pagina wanneer je javadoc doet omdat
	//het een private methode is => de documentatie is bedoeld voor mensen die de code niet moeten aanpassen,
	//maar ze enkel gebruiken
	/**
	* Deze methode de drukaf methode
	* @param m Dit is het cijfer tot hoeveel het moet afdrukken
	*/
	
	private static void drukaf(int m)
	{
		int a;
		for (a=0; a<m; a++)
		{
			System.out.println(a);
		}
	}
}