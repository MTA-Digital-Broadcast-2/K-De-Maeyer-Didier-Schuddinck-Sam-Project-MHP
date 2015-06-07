public class Oef7
{
	public static void main(String[] args) {

		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int[8];
		int grootsteGetal;
		int getalPlaats;

		for (int i=0; i < b.length; i++) {
			grootsteGetal = 0;
			getalPlaats = 0;

			for (int j = 0; j < a.length; j++) {
				if (a[j] > grootsteGetal) {
					grootsteGetal = a[j];
					getalPlaats = j;
				}
			}

			b[i] = grootsteGetal;
			a[getalPlaats] = 0;	
		}
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}