public class Oef5
{
	public static void main(String[] args) {
		
		boolean isPriemgetal;

		for (int getal = 3; getal < 100; getal++) {

			isPriemgetal = true;

			for (int deler = 2; deler < getal; deler++) {
				if ( (getal % deler) == 0) {
					isPriemgetal = false;
				}
			}

			if (isPriemgetal) {
				System.out.println(getal + " is een priemgetal");
			}
		}	

	}
}