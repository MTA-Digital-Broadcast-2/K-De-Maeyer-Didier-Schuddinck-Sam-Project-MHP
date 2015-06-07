public class Werknemer
{
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;

	public Werknemer(	String voornaam, 
										String achternaam, 
										int werknemerNummer, 
										float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.werknemerNummer = werknemerNummer;
		this.salaris = salaris;
	}

	public void salarisVerhogen(int percentage)
	{
		float verhogingsfactor = (float)percentage/100;
		salaris += salaris * verhogingsfactor;
	}

	public float getSalaris()
	{
		return salaris;
	}
}