package SignIn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



import Admin.AdminView;
import Entiteti.Korisnici;

import User.UserView;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import Interfaces.IKorisnici;


public class Prozor {
	private static Controler controlor;
	private JFrame frame;
	
	public JLabel izabrano;
	private JTextField username;
	private JTextField password;
	public JLabel status;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						
					
					
					
				Prozor window = new Prozor();
					SajamManager sm= new SajamManager();
					controlor=new Controler(sm,window);
					window.frame.setVisible(true);
				 
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Prozor() {
		
		
		initialize();
	}

	
	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
	
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\slike\\life picture\\o-music-heart-facebook.jpg"));
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 izabrano = new JLabel("");
		izabrano.setBounds(158, 207, 140, 14);
		frame.getContentPane().add(izabrano);
		
		username = new JTextField();
		username.setBounds(110, 147, 86, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(110, 190, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(36, 150, 72, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 193, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=username.getText();
				String pass=password.getText();
				if(user== null )
					user="";
				if(pass==null)
					pass="";
				
				controlor.UlogujSe(user, pass);
			}
		});
		btnUlogujSe.setBounds(110, 243, 89, 23);
		frame.getContentPane().add(btnUlogujSe);
		
	
	
	}
}
