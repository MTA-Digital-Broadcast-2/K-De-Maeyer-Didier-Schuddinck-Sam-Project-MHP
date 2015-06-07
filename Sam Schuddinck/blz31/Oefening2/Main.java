public class Main {
	public static void main(String args[])
	{
		Werknemer Sam = new Werknemer("Sam","Schuddinck",1,10000);
		Werknemer Bram = new Werknemer("Bram","De Baerdemaker",2,8000);
		Werknemer Felix = new Werknemer("Felix","Rijkers",2,1);
		Werknemer  Didier = new Werknemer("Didier","De Maeyer",3,50);
		
		System.out.println("Het loon van:"+ Sam.voornaam +" is " +Sam.getSalaris() +" euries");
		
	}
}
