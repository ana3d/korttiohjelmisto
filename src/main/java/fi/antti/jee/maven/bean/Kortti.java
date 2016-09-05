package fi.antti.jee.maven.bean;

public class Kortti {
	
	String etunimi, sukunimi, osoite, zip, postitoimipaikka;
	int id;
	public Kortti() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kortti(String etunimi, String sukunimi, String osoite, String zip,
			String postitoimipaikka, int id) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.osoite = osoite;
		this.zip = zip;
		this.postitoimipaikka = postitoimipaikka;
		this.id = id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}
	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Kortti [etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", osoite=" + osoite + ", zip=" + zip + ", postitoimipaikka="
				+ postitoimipaikka + ", id=" + id + "]";
	}

	
	

}
