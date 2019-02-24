package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SajamManager {
	
	
	    protected SessionFactory sessionFactory;
	 
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
	 
	    protected void create() {
	    	Sajam_automobila book = new Sajam_automobila();
	    	    book.setNaziv("Hibrid");
	    	    book.setMesto("Nis");
	    	   
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.save(book);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	 
	    protected void read() {
	    	Session session = sessionFactory.openSession();
	    	 
	        long id = 2;
	        Sajam_automobila book = session.get(Sajam_automobila.class, id);
	     
	        System.out.println("Naziv: " + book.getNaziv());
	        System.out.println("Mesto: " + book.getMesto());
	     
	        session.close();
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
	public static void main(String[] args) {
		SajamManager manager = new SajamManager();
	    manager.setup();
	    manager.update();
	 
	    manager.read(); 
	    manager.delete();
	    manager.exit();

	}

}
