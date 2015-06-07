/**
* Deze klasse is een Java programma
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
		System.out.println( ~(10) + 1 );	//door +1 te doen nadat er bitsgewijs NOT wordt gedaan, 
							//krijg je de correcte negatieve waarde (-10)
		
		//om in 2's complement van 10 naar -10 te gaan kan je alle bits inverteren
 		//en dan +1 maar de +1 doe je hier niet, dus je komt op -11 uit
	}
}