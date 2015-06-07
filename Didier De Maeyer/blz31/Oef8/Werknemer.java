public class Werknemer
{
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage = 33;

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
		float verhogingsfactor = (float)percentage/100;		/* percentage omzetten naar float */
		salaris += salaris * verhogingsfactor;
	}

	public float getSalaris()
	{
		return salaris;
	}

	public void setRSZ(float RSZ)
	{
		this.RSZpercentage = RSZ;
	}

	public float getRSZ()
	{
		return this.RSZpercentage;
	}
}