package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import net.codejava.hibernate.Entiteti.Sajam_automobila;

public class SajamManager {
	
	
	    protected SessionFactory sessionFactory;
	   public SajamManager()
	   {
		   setup();
	   }
	   @Override
	    public void finalize() throws Throwable {
	       exit();
	    }
	   
	   
	    protected void setup() {
	    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	    	        .configure() // configures settings from hibernate.cfg.xml
	    	        .build();
	    	try {
	    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    	    StandardServiceRegistryBuilder.destroy(registry);
	    	}
	    }
	 
	    protected void exit() {
	    	sessionFactory.close();
	    }
	 
	    protected void create(String naziv, String mesto) {
	    	Sajam_automobila sajam = new Sajam_automobila();
	    	    sajam.setNaziv(naziv);
	    	    sajam.setMesto(mesto);
	    	   
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.save(sajam);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	 
	    protected String read() {
	    	Session session = sessionFactory.openSession();
	    	 
	        long id = 1;
	        Sajam_automobila book = session.get(Sajam_automobila.class, id);
	        session.close();
	   
	     return "Naziv: " + book.getNaziv() +"Mesto: " + book.getMesto();
	      }  
	   
	    protected void update() {
	    	  Sajam_automobila book = new  Sajam_automobila();
	    	    book.setId(2);
	    	    book.setNaziv("Ultimate Java Programming");
	    	    book.setMesto("Nam Ha Minh");
	    	    
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.update(book);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	 
	    protected void delete() {
	    	Sajam_automobila book = new Sajam_automobila();
	    	    book.setId(2);
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.delete(book);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	

}
