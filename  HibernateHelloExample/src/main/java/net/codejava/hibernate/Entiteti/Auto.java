package net.codejava.hibernate.Entiteti;

import javax.persistence.*;
@Entity
public class Auto {
	
	private int auto_id;
	private String naziv;
	private String marka;
	private String boja;
	private String poreklo;
	private int ks;
	private int broj_sedista;
	private int cena;
	
	
	
	private Sajam_automobila sajam_automobila;
	
	public Auto() {
	}
	
	@ManyToOne
	@JoinColumn(name="sajam_id")
	public Sajam_automobila getSajam_automobila() {
		return sajam_automobila;
	}
	public void setSajam_automobila(Sajam_automobila sajam_automobila) {
		this.sajam_automobila = sajam_automobila;
	}
	@Id
	@Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAuto_Id() {
		return auto_id;
	}
	public void setAuto_Id(int auto_id) {
		this.auto_id = auto_id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getPoreklo() {
		return poreklo;
	}
	public void setPoreklo(String poreklo) {
		this.poreklo = poreklo;
	}
	public int getKs() {
		return ks;
	}
	public void setKs(int ks) {
		this.ks = ks;
	}
	public int getBroj_sedista() {
		return broj_sedista;
	}
	public void setBroj_sedista(int broj_sedista) {
		this.broj_sedista = broj_sedista;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}

	
	
}
