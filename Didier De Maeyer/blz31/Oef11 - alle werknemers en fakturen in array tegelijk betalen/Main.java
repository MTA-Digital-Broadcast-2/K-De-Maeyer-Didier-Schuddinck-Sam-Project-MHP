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
		Faktuur faktuur2 = new Faktuur(2, 33000);
		Faktuur faktuur3 = new Faktuur(3, 120000);

		Betaalbaar[] objecten = {giele, jim, jeroen, didier, sam, joske, jef, faktuur1, faktuur2, faktuur3};

		for (int i = 0; i < objecten.length; i++) 
		{
			objecten[i].betaal();
		}
	}
}