import java.lang.*;

public class EersteProg {
	public static void main(String args[]) 
	{
		System.out.println("Dir is mijn eerste java programma.");

		for (int i=0; i < args.length; i++)
		{
			System.out.println(args[i]);	//print alle parameters die worden meegegeven
		}
	}
}