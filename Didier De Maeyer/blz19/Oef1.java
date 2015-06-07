public class Oef1
{
	public static void main(String args[])
	{
		tafels();
	}

	private static void tafels()
	{
		for (int i=1; i<10; i++)
		{
			for (int j=1; j<10; j++)
			{
				System.out.println( i + "x" + j + "=" + (i * j) );
			}
		}
	}
}