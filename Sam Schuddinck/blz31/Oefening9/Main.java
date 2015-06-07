public class Main {
	public static void main(String args[])
	{
		StudentWerknemer Sam = new StudentWerknemer("Sam","Schuddinck",1,10000,7);
		PartTimeWerknemer Bram = new PartTimeWerknemer("Bram","De Baerdemaker",2,800,6);
		Werknemer Felix = new Werknemer("Felix","Rijkers",3,0);
			
		Sam.betaal();
		Bram.betaal();
		Felix.betaal();
				
	}
}
