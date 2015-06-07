public class PartTimeWerknemer extends Werknemer
{
	public int urenGewerkt;

	public PartTimeWerknemer(	String voornaam, 
														String achternaam, 
														int werknemerNummer, 
														float salaris, 
														int urenGewerkt)
	{
		super(voornaam, achternaam, werknemerNummer, salaris);
		this.urenGewerkt = urenGewerkt;
	}

	public float getWeekloon()
	{
		return (this.salaris * (float)this.urenGewerkt);	/* this.urenGewerkt omzetten naar float */
	}

	public void salarisVerhogen(int percentage)
	{
		if (percentage > 5) {
			percentage = 0;
			System.out.println("Fout: slechts 5% opslag toegestaan");
		}
		else {
			super.salarisVerhogen(percentage);
		}
	}
}