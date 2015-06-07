public class Main
{
	public static void main(String[] args) 
	{
		Werknemer giele = new Werknemer("Giele", "Cools", 1, 2000);
		Werknemer jim = new Werknemer("Jim", "Peeters", 2, 50);
		Werknemer jeroen = new Werknemer("Jeroen", "Van den Broeck", 3, 2000000);
		Werknemer didier = new Werknemer("Didier", "De Maeyer", 4, 9000000);

		PartTimeWerknemer sam = new PartTimeWerknemer("Sam", "Schuddinck", 5, 1, 15);
		PartTimeWerknemer joske = new PartTimeWerknemer("Joske", "Vermeulen", 6, 20, 18);

		StudentWerknemer jef = new StudentWerknemer("Jef", "Patat", 7, 15, 40);

		Faktuur faktuur1 = new Faktuur(1, 25000);


		giele.salarisVerhogen(10);
		jim.salarisVerhogen(10);

		System.out.println(giele.voornaam + ": " + giele.getSalaris());
		System.out.println(jim.voornaam + ": " + jim.getSalaris());
		System.out.println(jeroen.voornaam + ": " + jeroen.getSalaris());
		System.out.println(didier.voornaam + ": " + didier.getSalaris());

		sam.salarisVerhogen(10);

		System.out.println(sam.voornaam + ": " + sam.getWeekloon());
		System.out.println(joske.voornaam + ": " + joske.getWeekloon());

		System.out.println(jim.voornaam + "'s RSZ percentage: " + jim.getRSZ());
		jim.setRSZ(25);
		System.out.println(jim.voornaam + "'s RSZ percentage: " + jim.getRSZ());

		System.out.println(joske.voornaam + "'s RSZ percentage: " + joske.getRSZ());
		joske.setRSZ(10);
		System.out.println(joske.voornaam + "'s RSZ percentage: " + joske.getRSZ());

		
		System.out.println(jef.voornaam + "'s RSZ percentage: " + jef.getRSZ());

		didier.betaal();
		joske.betaal();
		jef.betaal();


		faktuur1.betaal();
	}
}