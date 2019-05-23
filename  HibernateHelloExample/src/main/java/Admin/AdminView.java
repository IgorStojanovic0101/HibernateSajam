package Admin;


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

import Entiteti.Auto;
import Entiteti.Sajam_automobila;
import SignIn.SajamManager;

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

	
	private JTable table,table2;
	public DefaultTableModel model;
	public DefaultTableModel model2;
	private JTextField naziv_sajma;
	private JTextField mesto_sajma;
	public JLabel l2;
	
	
	
	private AdminStrategy as;
	public AdminView() {
		
		
		frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.WHITE);
	
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		
		l2 = new JLabel("");
		l2.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(l2);
		
		
			
	
		
		
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
	       
		//Table2 --------------------------------------------------------
	     Table2();
		
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
		btnLista.setBounds(239, 222, 178, 50);
		frame.getContentPane().add(btnLista);
		
		
		
		
		
		
		
		JButton btnLista2 = new JButton("Lista2");
		btnLista2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAllrows(model2);
				  int index = table.getSelectedRow();
				  System.out.println("OVO JE INDEX"+index);
				  if(index<0)
				  {
				 List<Auto> lista=as.getAutos();
			       
			        Object[] row = new Object[8];
			        for(int i=0;i<lista.size();i++)
			        {
			        	 Object o = (Object)lista.get(i);
			             Auto p = (Auto)o; 
			             row[0] = p.getId();
			             row[1] = p.getNaziv();
			             row[2] = p.getMarka();
			             row[3] = p.getBoja();
			             row[4] = p.getPoreklo();
			             row[5] = p.getKs();
			             row[6] = p.getBroj_sedista();
			             row[7] = p.getCena();
			        	
			             model2.addRow(row);
			        }
				  }
				  else {
					  int id_sajma =Integer.parseInt(model.getValueAt(index, 0).toString());
						 List<Auto> lista=as.getOdredjeniAutomobili(id_sajma);
					       
					        Object[] row = new Object[8];
					        for(int i=0;i<lista.size();i++)
					        {
					        	 Object o = (Object)lista.get(i);
					             Auto p = (Auto)o; 
					             row[0] = p.getId();
					             row[1] = p.getNaziv();
					             row[2] = p.getMarka();
					             row[3] = p.getBoja();
					             row[4] = p.getPoreklo();
					             row[5] = p.getKs();
					             row[6] = p.getBroj_sedista();
					             row[7] = p.getCena();
					        	
					             model2.addRow(row);
					        }
					  
				  }
			        
			}
		}); 
		btnLista2.setBounds(586, 222, 134, 50);
		frame.getContentPane().add(btnLista2);
		
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
		
		JButton btnAutomobliNaSajmu = new JButton("Automobli na sajmu");
		btnAutomobliNaSajmu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AutomobiliView frame = new AutomobiliView();
					AutomobiliControler ac=new AutomobiliControler(as.getSajam(),frame);
					frame.setControler(ac);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAutomobliNaSajmu.setBounds(49, 55, 142, 23);
		frame.getContentPane().add(btnAutomobliNaSajmu);
		
      
		
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\slike\\life picture\\o-music-heart-facebook.jpg"));
		frame.setBounds(100, 100, 994, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	public void Table2() {
		   table2 = new JTable(); 
					String vrste2[]= {"Id","Naziv","Marka","Boja","Poreklo","Snaga","Broj sedista","Cena"};
					///////////////
				    model2 = new DefaultTableModel();
			        model2.setColumnIdentifiers(vrste2);
			        
			        // set the model to the table
			        table2.setModel(model2);
			        
			        // Change A JTable Background Color, Font Size, Font Color, Row Height
			        table2.setBackground(Color.LIGHT_GRAY);
			        table2.setForeground(Color.black);
			        Font font2 = new Font("",1,22);
			        table2.setFont(font2);
			        table2.setRowHeight(30);
			        // create JScrollPane
			        JScrollPane pane2 = new JScrollPane(table2);
			        pane2.setBounds(368, 281, 600, 200);
			        frame.getContentPane().setLayout(null);
			        frame.getContentPane().add(pane2);
			        
			    	
	}
	public void deleteAllrows(DefaultTableModel modeld)
	{
		int rowCount = modeld.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    modeld.removeRow(i);
		}
	}
	public void SetControler(AdminStrategy strategy)
	{
		this.as=strategy;
	}
	
}
