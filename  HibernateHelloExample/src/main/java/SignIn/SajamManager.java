package SignIn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import Entiteti.Auto;
import Entiteti.Korisnici;
import Entiteti.Sajam_automobila;

import javax.persistence.criteria.CriteriaQuery;
import javassist.bytecode.Descriptor.Iterator;

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
	 
	 
	    protected String read(long id) {
	    	Session session = sessionFactory.openSession();
	    	 
	       
	        Sajam_automobila book = session.get(Sajam_automobila.class, id);
	        session.close();
	   
	     return "Naziv: " + book.getNaziv() +"Mesto: " + book.getMesto();
	      }  
	    public void readAll() {
	    	Session session = sessionFactory.openSession();
	    	 
	    	try
	        {
	            List<Sajam_automobila>books = session.createCriteria(Sajam_automobila.class).list();
	          
	            for(int i=0;i<books.size();i++)
	            {
	                Object o = (Object)books.get(i);
	               Sajam_automobila p = (Sajam_automobila)o;
	                System.out.println("Product id : "+p.getId());
	                System.out.println("Product Name : "+p.getNaziv());
	                System.out.println("Product Price : "+p.getMesto());
	                System.out.println("----------------------");
	            }       
	            
	        } catch (Exception e) {
	        	System.out.print(e);
	        }
	        
	        session.close();
	   
	    
	      }  
	    public List<Sajam_automobila> ListSajma() {
	    	Session session = sessionFactory.openSession();
	    	 
	    	List<Sajam_automobila>books;
	           try {
	        	   
	        	   books = session.createCriteria(Sajam_automobila.class).list();
	        	   session.close();
	        	   return books;
	        	   
	           }
	           catch(Exception e) {
	        	   return null;
	         
	           }
	    
	    }
	    public List<Auto> ListAuto() {
	    	Session session = sessionFactory.openSession();
	    	 
	    	List<Auto>books;
	           try {
	        	   
	        	   books = session.createCriteria(Auto.class).list();
	        	   session.close();
	        	   return books;
	        	   
	           }
	           catch(Exception e) {
	        	   return null;
	         
	           }
	    
	    }
	    
	    public int VelicinaSajma() {
	    	Session session = sessionFactory.openSession();
	    	 
	    	
	            List<Sajam_automobila>books = session.createCriteria(Sajam_automobila.class).list();
	         
	            session.close();
	    return books.size();
	            
	     
	       
	    
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
	 
	    public void DeleteSajam(int id) {
	    	Sajam_automobila sajam= new Sajam_automobila();
	    	    sajam.setId(id);
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.delete(sajam);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	
	    public void InsertAuto (String naziv,String marka,String boja,

	    		String poreklo,int konji,int broj_sedista,int cena,byte[] bFile)
	    {
	    	Auto auto = new Auto();
	    	auto.setNaziv(naziv);
	    	auto.setBoja(marka);
	    	auto.setCena(cena);
	    	auto.setKs(konji);
	    	auto.setMarka(marka);
	    	auto.setBroj_sedista(broj_sedista);
	    	auto.setPoreklo(poreklo);
	    	auto.setSlika(bFile);
	    	
    	   
    	 
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.save(auto);
    	 
    	    session.getTransaction().commit();
    	    session.close();
	    }
	    public void OneToMany()
	    {
	    	 Sajam_automobila sajam = new  Sajam_automobila();
	    	 sajam.setNaziv("Prlita");
	    	 sajam.setMesto("Zjaece");
	    	 Auto auto= new Auto();
	    	 auto.setBoja("dawd");
	    	 auto.setNaziv("dawdwd");
	    	 auto.setBroj_sedista(4);
	    	 auto.setCena(1000);
	    	 auto.setKs(100);
	    	 auto.setMarka("dwad");
	    	 auto.setPoreklo("dwad");
	    	 
	    	 sajam.getAutomobili().add(auto);
	    	 auto.setSajam_automobila(sajam);
	    	 
	    	 Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.save(sajam);
	    	    session.save(auto);
	    	    Sajam_automobila book = session.get(Sajam_automobila.class, sajam.getId());
	    	    System.out.print(book.getNaziv()+"  "+book.getId());
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    }
	    
		public void InsertSajam(String naziv,String mesto) {
			
			Sajam_automobila sajam = new Sajam_automobila();
    	    sajam.setNaziv(naziv);
    	    sajam.setMesto(mesto);
    	   
    	 
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.save(sajam);
    	 
    	    session.getTransaction().commit();
    	    session.close();
			
		}
		public void UpdateSajam(int id, String naziv, String mesto) {
			  Sajam_automobila sajam = new  Sajam_automobila();
	    	    sajam.setId(id);
	    	    sajam.setNaziv(naziv);
	    	    sajam.setMesto(mesto);
	    	    
	    	 
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.update(sajam);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
			
			
		}
		public void DodajAutoUsajam(int id_sajma, Auto auto) {
			Long id=Long.valueOf(id_sajma);
			 Session session = sessionFactory.openSession();
			Sajam_automobila sajam= session.get(Sajam_automobila.class, id);

    	    sajam.getAutomobili().add(auto);
	    	 auto.setSajam_automobila(sajam);
	    	 
	    	
	    	    session.beginTransaction();
	    	    session.save(auto);
	    	    session.getTransaction().commit();
	    	    session.close();
		}
	    
		public Korisnici ReadKorisnika(String user,String pass)
		{
			Session session = sessionFactory.openSession();
			 Korisnici korisik=null;
			 
			
			 Query query = session.createQuery("from Korisnici where username = :username and password = :password");
		        query.setParameter("username", user);
		        query.setParameter("password", pass);
		        if(query!=null)
		        {
		        	    List<Korisnici> lista= query.list(); 
		        	    korisik = (Korisnici)lista.get(0); 
		        }
		      
		     
		        session.close();
		        return korisik;
			
		}
		public List<Auto> ListaAutomobilaNaSajmu(int id_sajma)
		{
			Long id=Long.valueOf(id_sajma);
			Session session = sessionFactory.openSession();
					
			Sajam_automobila sajam = session.get(Sajam_automobila.class, id);

			List<Auto> automobili=sajam.getAutomobili();
			
		     
		        session.close();
		       return automobili;
			
		}
}

