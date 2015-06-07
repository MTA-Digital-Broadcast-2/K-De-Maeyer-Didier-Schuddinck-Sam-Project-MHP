
public class StudentWerknemer extends PartTimeWerknemer {
	
	public StudentWerknemer(String newVoornaam, String newAchternaam, int newWerknemerNummer,
			double newSalaris, int newUrenGewerkt)
			
	{
		super(newVoornaam,newAchternaam,newWerknemerNummer,newSalaris,newUrenGewerkt);
		this.setRSZPercentage(5);
	}
}
