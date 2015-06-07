public class StudentWerknemer extends PartTimeWerknemer
{
	public StudentWerknemer(	String voornaam, 
														String achternaam, 
														int werknemerNummer, 
														float salaris, 
														int urenGewerkt)
	{
		super(voornaam, achternaam, werknemerNummer, salaris, urenGewerkt);
		setRSZ(5);
	}
}