public class Main {
	public static void main(String args[])
	{
		StudentWerknemer Sam = new StudentWerknemer("Sam","Schuddinck",1,10000,7);
		
		System.out.println("Het RSZ-Percentage van:"+ Sam.voornaam +" is " +Sam.getRSZPercentage()+" %");
				
	}
}
