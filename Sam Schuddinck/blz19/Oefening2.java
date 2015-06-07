
public class Oefening2 {
	/*
	* Dit is de main methode
	* @param args Dit zijn de command line parameters
	*/
	public static void main(String args[])
	{
		int weekdag = 1;
		for(int i = 1; i < 29;i++)
		{
			switch(weekdag)
			{
			case 1:
				System.out.println("Zondag " + i + " februari");
				break;
			case 2:
				System.out.println("Maandag " + i + " februari");
				break;
			case 3:
				System.out.println("Dinsdag " + i + " februari");
				break;
			case 4:
				System.out.println("Woensdag " + i + " februari");
				break;
			case 5:
				System.out.println("Donderdag " + i + " februari");
				break;
			case 6:
				System.out.println("Vrijdag " + i + " februari");
				break;
			case 7:
				System.out.println("Zaterdag " + i + " februari");
				break;
			}
			weekdag ++;
			if(weekdag == 8)
			{
				weekdag = 1;
			}
		}
	}
}
