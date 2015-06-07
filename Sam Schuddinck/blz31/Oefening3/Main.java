public class Main {
	public static void main(String args[])
	{
		PartTimeWerknemer Sam = new PartTimeWerknemer("Sam","Schuddinck",1,10000,7);
		PartTimeWerknemer Bram = new PartTimeWerknemer("Bram","De Baerdemaker",2,8000,6);
		
		System.out.println( Sam.voornaam +" werkte " +Sam.urenGewerkt +" uren");
		
	}
}
