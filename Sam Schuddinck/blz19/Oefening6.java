
public class Oefening6 {
	public static void main(String args[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
		
		int grootsteGetal = 0;
		for(int i= 0; i < a.length;i++)
		{
			if(a[i] > grootsteGetal)
			{
				grootsteGetal = a[i];
			}
		}
		
		System.out.println(grootsteGetal);
	}
}
