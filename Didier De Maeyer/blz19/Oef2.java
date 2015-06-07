public class Oef2
{
	public static void main(String args[])
	{
		int weekdag = 1;
		String dagString;

		for (int dag=1; dag<=28; dag++)
		{
			switch (weekdag)
			{
				case 1:
					dagString = "zondag ";
					break;
				case 2:
					dagString = "maandag ";
					break;
				case 3:
					dagString = "dinsdag ";
					break;
				case 4:
					dagString = "woensdag ";
					break;
				case 5:
					dagString = "donderdag ";
					break;
				case 6:
					dagString = "vrijdag ";
					break;
				case 7:
					dagString = "zaterdag ";
					break;
				default:
					dagString = "Fout bij weekdag ";
					break;
			}
			
			System.out.println(dagString + dag + " februari 2009");
			
			
			weekdag++;
			if (weekdag > 7)
			{
				weekdag = 1;
			}
		}	
	}
}