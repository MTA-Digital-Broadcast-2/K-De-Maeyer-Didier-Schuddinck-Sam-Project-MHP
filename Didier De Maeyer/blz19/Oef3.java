// noemer = 1
// for (tel -> 1...5000)
// 	som+= (1.0/noemer)
// 	noemer+=4;
// noemer=3
// for (tel -> 1...5000)
// 	som-= (1.0/noemer)
// 	noemer+= 4;

// som=som*4;

public class Oef3
{
	public static void main(String args[]) {
		double noemer = 1;
		double som = 0;

		for (int tel = 0; tel < 5000; tel++) {
			som+= (1.0/noemer);
			noemer+=4.0;
		}

		noemer = 3;

		for (int tel = 0; tel < 5000; tel++) {
			som-= (1.0/noemer);
			noemer+=4.0;
		}

		som = som * 4;

		System.out.println(som);
	}
}