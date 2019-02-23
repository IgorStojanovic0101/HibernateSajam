package net.codejava.hibernate;

import javax.persistence.*;



@Entity
@Table(name = "sajam_automobila")
public class Sajam_automobila {
		
	    private long id;
	    private String naziv;
	    private String mesto;
	    
	 
	    public Sajam_automobila() {
	    }
	    public Sajam_automobila(long id,String naziv,String mesto)
	    {
	    	super();
	    	this.id=id;
	    	this.naziv=naziv;
	    	this.mesto=mesto;
	    }
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public long getId() {
	        return id;
	    }
	 
	    public void setId(long id) {
	        this.id = id;
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
	 
	  
	
}
