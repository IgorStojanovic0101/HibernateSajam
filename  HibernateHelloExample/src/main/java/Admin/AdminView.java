package Admin;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.codejava.hibernate.Entiteti.Sajam_automobila;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class AdminView  {
	
	private JFrame frame;
	public JLabel l2;
	public JTextField marka_auto;
	public JTextField naziv_auto;
	public JTextField boja_auto;
	public JTextField poreklo_auto;
	public JTextField ks_auto;
	public JTextField cena_auto;
	public JTextField broj_sedista_auto;
	public JButton btnUnesi;
	
	private JTable table;
	private DefaultTableModel model;
	private JTextField naziv_sajma;
	private JTextField mesto_sajma;
	
	
	
	private AdminStrategy as;
	public AdminView() {
		
		
		frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.WHITE);
	
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		
		l2 = new JLabel("");
		l2.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(l2);
		
		JLabel lblUnesiAuto = new JLabel("Unesi auto");
		lblUnesiAuto.setBounds(24, 102, 111, 14);
		frame.getContentPane().add(lblUnesiAuto);
		
		JLabel naziv = new JLabel("Naziv");
		naziv.setBounds(49, 144, 46, 14);
		frame.getContentPane().add(naziv);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setBounds(49, 172, 46, 14);
		frame.getContentPane().add(lblMarka);
		
		JLabel BOJA = new JLabel("Boja");
		BOJA.setBounds(53, 203, 46, 14);
		frame.getContentPane().add(BOJA);
		
		JLabel lblPoreklo = new JLabel("Poreklo");
		lblPoreklo.setBounds(49, 244, 46, 14);
		frame.getContentPane().add(lblPoreklo);
		
		JLabel lblKonjaskaSnaga = new JLabel("Konjaska snaga");
		lblKonjaskaSnaga.setBounds(24, 294, 86, 14);
		frame.getContentPane().add(lblKonjaskaSnaga);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setBounds(53, 348, 46, 14);
		frame.getContentPane().add(lblCena);
		
		marka_auto = new JTextField();
		marka_auto.setBounds(105, 169, 86, 20);
		frame.getContentPane().add(marka_auto);
		marka_auto.setColumns(10);
		
		naziv_auto = new JTextField();
		naziv_auto.setBounds(105, 141, 86, 20);
		frame.getContentPane().add(naziv_auto);
		naziv_auto.setColumns(10);
		
		boja_auto = new JTextField();
		boja_auto.setBounds(105, 200, 86, 20);
		frame.getContentPane().add(boja_auto);
		boja_auto.setColumns(10);
		
		poreklo_auto = new JTextField();
		poreklo_auto.setBounds(105, 241, 86, 20);
		frame.getContentPane().add(poreklo_auto);
		poreklo_auto.setColumns(10);
		
		ks_auto = new JTextField();
		ks_auto.setBounds(105, 291, 86, 20);
		frame.getContentPane().add(ks_auto);
		ks_auto.setColumns(10);
		
		cena_auto = new JTextField();
		cena_auto.setBounds(105, 345, 86, 20);
		frame.getContentPane().add(cena_auto);
		cena_auto.setColumns(10);
		
		btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv=naziv_auto.getText();
				String marka=marka_auto.getText();
				String boja=boja_auto.getText();
				String poreklo=poreklo_auto.getText();
				int konji=Integer.parseInt(ks_auto.getText());
				int broj_sedista=Integer.parseInt(broj_sedista_auto.getText());
				int cena=Integer.parseInt(cena_auto.getText());
				as.InsertAuto(naziv, marka, boja, poreklo, konji, broj_sedista, cena);
			}
		});
		
		btnUnesi.setBounds(84, 405, 89, 23);
		frame.getContentPane().add(btnUnesi);
		
		JLabel lblBrojsedista = new JLabel("Broj_sedista");
		lblBrojsedista.setBounds(30, 269, 80, 14);
		frame.getContentPane().add(lblBrojsedista);
		
		broj_sedista_auto = new JTextField();
		broj_sedista_auto.setBounds(105, 266, 86, 20);
		frame.getContentPane().add(broj_sedista_auto);
		broj_sedista_auto.setColumns(10);
		
		JButton btnOneToMany = new JButton("One to Many");
		btnOneToMany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				as.OneToManyInsert();
			}
		});
		btnOneToMany.setBounds(58, 21, 133, 23);
		frame.getContentPane().add(btnOneToMany);
		
		JButton btnLista = new JButton("Lista");
		//Table--------------------------------------------------------
		 table = new JTable(); 
			String vrste[]= {"Id","Naziv","Mesto"};
			///////////////
		    model = new DefaultTableModel();
	        model.setColumnIdentifiers(vrste);
	        
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(239, 11, 600, 200);
	        frame.getContentPane().setLayout(null);
	        frame.getContentPane().add(pane);
	       
		
		
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAllrows(model);
				 List<Sajam_automobila> lista=as.getSajams();
			       
			        Object[] row = new Object[3];
			        for(int i=0;i<lista.size();i++)
			        {
			        	 Object o = (Object)lista.get(i);
			             Sajam_automobila p = (Sajam_automobila)o; 
			             row[0] = p.getId();
			             row[1] = p.getNaziv();
			             row[2] = p.getMesto();
			        	
			             model.addRow(row);
			        }
			        
			}
		}); 
		
		btnLista.setBounds(239, 222, 89, 23);
		frame.getContentPane().add(btnLista);
		
		naziv_sajma = new JTextField();
		naziv_sajma.setBounds(239, 291, 86, 20);
		frame.getContentPane().add(naziv_sajma);
		naziv_sajma.setColumns(10);
		
		mesto_sajma = new JTextField();
		mesto_sajma.setBounds(239, 324, 86, 20);
		frame.getContentPane().add(mesto_sajma);
		mesto_sajma.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(201, 294, 46, 14);
		frame.getContentPane().add(lblNaziv);
		
		JLabel lblMesto = new JLabel("Mesto");
		lblMesto.setBounds(201, 327, 46, 14);
		frame.getContentPane().add(lblMesto);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			as.InsertSajam(naziv_sajma.getText(), mesto_sajma.getText());
			
			}
		});
		btnDodaj.setBounds(239, 361, 89, 23);
		frame.getContentPane().add(btnDodaj);
		
		
		table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	        
	            naziv_sajma.setText(model.getValueAt(i, 1).toString());
	            mesto_sajma.setText(model.getValueAt(i, 2).toString());
	           
	        }
	        });
           
           
           
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int i = table.getSelectedRow();
				as.UpdateSajam(Integer.parseInt(model.getValueAt(i, 0).toString()),naziv_sajma.getText(),mesto_sajma.getText());
				 
			}
		});
		btnUpdate.setBounds(239, 395, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnBrisi = new JButton("Brisi");
		btnBrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int i = table.getSelectedRow();
					as.DeleteSajam(Integer.parseInt(model.getValueAt(i, 0).toString()));
			}
		});
		btnBrisi.setBounds(239, 424, 89, 23);
		frame.getContentPane().add(btnBrisi);
		
      
		
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\slike\\life picture\\o-music-heart-facebook.jpg"));
		frame.setBounds(100, 100, 919, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	public void deleteAllrows(DefaultTableModel model)
	{
		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
	}
	public void SetControler(AdminStrategy strategy)
	{
		this.as=strategy;
	}
}
