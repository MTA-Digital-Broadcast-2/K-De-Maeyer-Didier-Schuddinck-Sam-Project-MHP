public class Main {
	public static void main(String args[])
	{
		Werknemer Sam = new Werknemer("Sam","Schuddinck",1,10000);
		PartTimeWerknemer Bram = new PartTimeWerknemer("Bram","De Baerdemaker",2,8000,6);
		
	
		System.out.println("Het RSZ-Percentage van:"+ Sam.voornaam +" is " +Sam.getRSZPercentage()+" %");
		System.out.println("Het RSZ-Percentage van:"+ Bram.voornaam +" is " +Bram.getRSZPercentage() +" %");
		
		Sam.setRSZPercentage(25);
		Bram.setRSZPercentage(40);
		
		System.out.println("Het RSZ-Percentage van:"+ Sam.voornaam +" is " +Sam.getRSZPercentage() +" %");
		System.out.println("Het RSZ-Percentage van:"+ Bram.voornaam +" is " +Bram.getRSZPercentage() +" %");
		
	}
}
