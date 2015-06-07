public class Main {
	public static void main(String args[])
	{
		Werknemer Sam = new Werknemer("Sam","Schuddinck",1,10000);
		Werknemer Bram = new Werknemer("Bram","De Baerdemaker",2,8000);
		Werknemer Felix = new Werknemer("Felix","Rijkers",3,1);
		Werknemer  Didier = new Werknemer("Didier","De Maeyer",4,50);
		
		Sam.salarisVerhogen(10);
		Bram.salarisVerhogen(10);
		
		System.out.println("Werknemer:" + Sam.voornaam + ", Salaris: " + Sam.getSalaris());
		System.out.println("Werknemer:" + Bram.voornaam + ", Salaris: " + Bram.getSalaris());
		System.out.println("Werknemer:" + Felix.voornaam + ", Salaris: " + Felix.getSalaris());
		System.out.println("Werknemer:" + Didier.voornaam + ", Salaris: " + Sam.getSalaris());
		
	}
}
