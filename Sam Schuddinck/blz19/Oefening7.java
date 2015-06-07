public class Oefening7 {
	public static void main(String args[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int[8];
		
		for(int i = 0; i < a.length;i++)
		{
			int grootsteGetal = 0;
			int plaatsGrootsteGetal = 0;
			
			for(int k = 0; k < a.length ; k++)
			{
				if( a[k] > grootsteGetal)
				{
					grootsteGetal = a[k];
					plaatsGrootsteGetal = k;
				}
			}
			
			b[i] = a[plaatsGrootsteGetal];
			a[plaatsGrootsteGetal] = 0;
			System.out.println(b[i]);
		}
		
	}
}
