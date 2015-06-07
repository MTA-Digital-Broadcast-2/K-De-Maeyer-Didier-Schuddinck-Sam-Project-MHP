public class Main
{
	public static void main(String[] args) 
	{
		Werknemer giele = new Werknemer("Giele", "Cools", 1, 2000);
		Werknemer jim = new Werknemer("Jim", "Peeters", 2, 50);
		Werknemer jeroen = new Werknemer("Jeroen", "Van den Broeck", 3, 2000000);
		Werknemer didier = new Werknemer("Didier", "De Maeyer", 4, 9000000);

		giele.salarisVerhogen(10);
		jim.salarisVerhogen(10);

		System.out.println(giele.voornaam + ": " + giele.getSalaris());
		System.out.println(jim.voornaam + ": " + jim.getSalaris());
		System.out.println(jeroen.voornaam + ": " + jeroen.getSalaris());
		System.out.println(didier.voornaam + ": " + didier.getSalaris());
	}
}