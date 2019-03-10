package net.codejava.hibernate.Entiteti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "sajam_automobila")
public class Sajam_automobila {
		
	    private long sajam_id;
	    private String naziv;
	    private String mesto;
	    
	 
	    private List<Auto> automobili = new ArrayList<Auto>();
	    
	 
	    public Sajam_automobila() {
	    }
	    public Sajam_automobila(long id,String naziv,String mesto)
	    {
	    	super();
	    	this.sajam_id=id;
	    	this.naziv=naziv;
	    	this.mesto=mesto;
	    }
	    @Id
	    @Column(name = "sajam_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public long getId() {
	        return sajam_id;
	    }
	 
	    public void setId(long id) {
	        this.sajam_id = id;
	    }
	 
	    public String getNaziv() {
	        return naziv;
	    }
	 
	    public void setNaziv(String title) {
	        this.naziv = title;
	    }
	    public String getMesto() {
	        return mesto;
	    }
	 
	    public void setMesto(String mesto) {
	        this.mesto = mesto;
	    }
	    @OneToMany(targetEntity=Auto.class,mappedBy="sajam_automobila",cascade=CascadeType.ALL)
	    public List<Auto>  getAutomobili()
	    {
	    	return this.automobili;
	    }
	    public void setAutomobili(List<Auto> automobili)
	    {
	    	this.automobili=automobili;
	    }
	 
	  
	
}
