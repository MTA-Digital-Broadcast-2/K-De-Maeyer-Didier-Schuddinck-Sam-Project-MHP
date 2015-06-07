public class Oefening5 {
	public static void main(String args[])
	{
		String priemGetallen ="";
		
		for(int i = 3;i < 100; i ++)
		{
			boolean isPriemGetal = true;
			for(int k = 2; k < i; k++)
			{
				if(i % k == 0)
				{
					isPriemGetal = false;
				}
			}
			if(isPriemGetal)
			{
				priemGetallen += i + ", ";
			}
			
		}
		System.out.println(priemGetallen);
	}
}
