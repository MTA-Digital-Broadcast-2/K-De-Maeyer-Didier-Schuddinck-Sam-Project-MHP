
public class Oefening3 {
	public static void main(String args[])
	{
		double pi = 0;
		double teller = 1.0;
		double noemer = 1.0;
		double som = 0;
		boolean teken = true;
		for(int i = 0;i < 10000;i ++)
		{
			if(teken)
			{
				som += +teller/noemer;
			}
			else
			{
				som += -teller/noemer;
			}
			noemer += 2.0;
			teken = !teken;
		}
		pi = 4.0*som;
		System.out.println(pi);
	}
}
