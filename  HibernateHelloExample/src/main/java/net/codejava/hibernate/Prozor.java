package net.codejava.hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Admin.AdminView;
import User.UserView;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Prozor {
	private static Controler controlor;
	private JFrame frame;
	public JLabel l1;
	private JButton btnNewButton;
	public JTextField tb1;
	public JTextField tb2;
	private JLabel lblMesto;
	public JLabel izabrano;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SajamManager ss= new SajamManager();
					Prozor window = new Prozor();
					controlor=new Controler(ss,window);
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
		
	
	
		
		JButton btnPretisni = new JButton("Pretisni");
		btnPretisni.setBounds(0, 333, 434, 23);
		btnPretisni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlor.PrikaziNaslov();
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnPretisni);
		
		l1 = new JLabel("");
		l1.setBounds(10, 135, 434, 23);
		frame.getContentPane().add(l1);
		
		btnNewButton = new JButton("Unesi");
		btnNewButton.setBounds(0, 310, 434, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlor.Unesi();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		tb1 = new JTextField();
		tb1.setBounds(69, 275, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(268, 275, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(10, 278, 46, 14);
		frame.getContentPane().add(lblNaziv);
		
		lblMesto = new JLabel("Mesto:");
		lblMesto.setBounds(196, 278, 46, 14);
		frame.getContentPane().add(lblMesto);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(62, 48, 46, 14);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(62, 90, 46, 14);
		frame.getContentPane().add(lblUser);
		
		JButton btnDugme = new JButton("dugme1");
		btnDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlor.ActionAdmin();
			}
		});
		btnDugme.setBounds(130, 44, 89, 23);
		frame.getContentPane().add(btnDugme);
		
		JButton btnDugme_1 = new JButton("dugme2");
		btnDugme_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlor.ActionUser();
			}
		});
		btnDugme_1.setBounds(130, 90, 89, 23);
		frame.getContentPane().add(btnDugme_1);
		
		 izabrano = new JLabel("");
		izabrano.setBounds(158, 207, 140, 14);
		frame.getContentPane().add(izabrano);
	}
}
