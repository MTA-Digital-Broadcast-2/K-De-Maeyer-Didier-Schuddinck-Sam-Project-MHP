public class Main {
	public static void main(String args[])
	{
		PartTimeWerknemer Sam = new PartTimeWerknemer("Sam","Schuddinck",1,10000,7);
		PartTimeWerknemer Bram = new PartTimeWerknemer("Bram","De Baerdemaker",2,8000,6);
		
		Sam.salarisVerhogen(10);
		Bram.salarisVerhogen(10);
	
		System.out.println("Het loon van:"+ Sam.voornaam +" is " +Sam.getSalaris() +" euries");
		System.out.println("Het loon van:"+ Bram.voornaam +" is " +Bram.getSalaris() +" euries");
		
	}
}
