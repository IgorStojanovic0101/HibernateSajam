package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Entiteti.Auto;
import Entiteti.Sajam_automobila;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;

public class AutomobiliView  implements ActionListener{
	
	private JFrame frame;
	private JPanel contentPane;
	public JLabel automobili_naslov;
	
	public JLabel l2;
	public JButton btnUnesi;
	public AutomobiliControler ac;
	private JTextField naziv_a;
	private JTextField marka_a;
	private JTextField boja_a;
	private JTextField poreklo_a;
	private JTextField ks_a;
	private JTextField cena_a;
	private JTextField broj_a;
	private JButton btnUnesi_1;
	private JTextField id_sajma;
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane pane;
	private JLabel lblSajmovi;

	private JMenuItem item1= new JMenuItem("Open");
	private JMenuItem item2= new JMenuItem("Close");
	private JMenuItem item3= new JMenuItem("Save");
	private File selectedFile;
	private JLabel pic;
	
	/**
	 * Create the frame.
	 */
	public AutomobiliView() {
		frame = new JFrame();
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Filters");
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		
		menu1.add(item1);
		menu1.add(item3);
		menu1.add(item2);
	
		
		menubar.add(menu1);
		menubar.add(menu2);
		frame.setJMenuBar(menubar);
		
		
		frame.setBounds(100, 100, 896, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		automobili_naslov = new JLabel("");
		automobili_naslov.setBounds(117, 17, 0, 0);
		contentPane.add(automobili_naslov);
		
		JLabel label = new JLabel("Unesi auto");
		label.setBounds(66, 85, 106, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Naziv");
		label_1.setBounds(76, 110, 75, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Marka");
		label_2.setBounds(76, 147, 75, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Boja");
		label_3.setBounds(76, 172, 75, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Poreklo");
		label_4.setBounds(76, 211, 75, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Konjaska snaga");
		label_5.setBounds(76, 254, 111, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Cena");
		label_6.setBounds(76, 288, 75, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Broj_sedista");
		label_7.setBounds(76, 323, 96, 14);
		contentPane.add(label_7);
		
		naziv_a = new JTextField();
		naziv_a.setBounds(172, 107, 86, 20);
		contentPane.add(naziv_a);
		naziv_a.setColumns(10);
		
		marka_a = new JTextField();
		marka_a.setBounds(172, 144, 86, 20);
		contentPane.add(marka_a);
		marka_a.setColumns(10);
		
		boja_a = new JTextField();
		boja_a.setBounds(172, 169, 86, 20);
		contentPane.add(boja_a);
		boja_a.setColumns(10);
		
		poreklo_a = new JTextField();
		poreklo_a.setBounds(172, 208, 86, 20);
		contentPane.add(poreklo_a);
		poreklo_a.setColumns(10);
		
		ks_a = new JTextField();
		ks_a.setBounds(172, 251, 86, 20);
		contentPane.add(ks_a);
		ks_a.setColumns(10);
		
		cena_a = new JTextField();
		cena_a.setBounds(172, 285, 86, 20);
		contentPane.add(cena_a);
		cena_a.setColumns(10);
		
		broj_a = new JTextField();
		broj_a.setBounds(172, 320, 86, 20);
		contentPane.add(broj_a);
		broj_a.setColumns(10);
		pic = new JLabel("");
        pic.setBounds(475, 288, 147, 110);
        contentPane.add(pic);
        frame.setLocationRelativeTo(null);
		frame.setSize(1200,700);
		frame.setVisible(true);
		
		
		btnUnesi_1 = new JButton("Unesi");
		btnUnesi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int konji,broj_sedista,cena;
					String naziv=naziv_a.getText();
					String marka=marka_a.getText();
					String boja=boja_a.getText();
					String poreklo=poreklo_a.getText();
					konji=Integer.parseInt(ks_a.getText());
					
					broj_sedista=Integer.parseInt(broj_a.getText());
					cena=Integer.parseInt(cena_a.getText());
					byte[] bFile = new byte[(int) selectedFile.length()];
					  try {
						     FileInputStream fileInputStream = new FileInputStream(selectedFile);
						     //convert file into array of bytes
						     fileInputStream.read(bFile);
						     fileInputStream.close();
					        } catch (Exception e) {
						     e.printStackTrace();
					        }
					  
					ac.InsertAuto(naziv, marka, boja, poreklo, konji, broj_sedista, cena, bFile);
				}
			
		});
		btnUnesi_1.setBounds(131, 375, 89, 23);
		contentPane.add(btnUnesi_1);
		
		id_sajma = new JTextField();
		id_sajma.setBounds(102, 31, 138, 20);
		contentPane.add(id_sajma);
		id_sajma.setColumns(10);
		JButton btnLista = new JButton("Lista");
		
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAllrows(model);
				 List<Sajam_automobila> lista=ac.getSajams();
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
		btnLista.setBounds(276, 284, 89, 23);
		contentPane.add(btnLista);
		JButton btnUnesiUSajam = new JButton("Unesi u Sajam");
		btnUnesiUSajam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    int i = table.getSelectedRow();
				Auto auto= new Auto();
				int id=Integer.parseInt(model.getValueAt(i, 0).toString());
				String naziv=naziv_a.getText();
				String marka=marka_a.getText();
				String boja=boja_a.getText();
				String poreklo=poreklo_a.getText();
				int konji=Integer.parseInt(ks_a.getText());
				int broj_sedista=Integer.parseInt(broj_a.getText());
				int cena=Integer.parseInt(cena_a.getText());
				byte[] bFile = new byte[(int) selectedFile.length()];
				  try {
					     FileInputStream fileInputStream = new FileInputStream(selectedFile);
					     //convert file into array of bytes
					     fileInputStream.read(bFile);
					     fileInputStream.close();
				        } catch (Exception e) {
					     e.printStackTrace();
				        }
				auto.setNaziv(naziv);
				auto.setBoja(boja);
				auto.setPoreklo(poreklo);
				auto.setMarka(marka);
				auto.setCena(cena);
				auto.setKs(konji);
				auto.setBroj_sedista(broj_sedista);
				auto.setSlika(bFile);
				ac.DodajUSajam(id, auto);
				
			}
		});
		btnUnesiUSajam.setBounds(238, 375, 147, 23);
		contentPane.add(btnUnesiUSajam);
		
		
		
		
		
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
	         pane = new JScrollPane(table);
	        pane.setBounds(280, 60, 600, 200);
	        contentPane.setLayout(null);
	        contentPane.add(pane);
	        
	        JLabel lblNazivSajma = new JLabel("Naziv sajma");
	        lblNazivSajma.setBounds(10, 34, 86, 14);
	        contentPane.add(lblNazivSajma);
	        
	        lblSajmovi = new JLabel("Sajmovi");
	        lblSajmovi.setFont(new Font("Trajan Pro 3", Font.PLAIN, 25));
	        lblSajmovi.setBounds(338, 12, 281, 50);
	        contentPane.add(lblSajmovi);
	        
	        
	       
		
		
	    	table.addMouseListener(new MouseAdapter(){
		        
		        @Override
		        public void mouseClicked(MouseEvent e){
		            
		            // i = the index of the selected row
		            int i = table.getSelectedRow();
		            
		        
		           id_sajma.setText(model.getValueAt(i, 1).toString());
		          
		           
		        }
		        });
	    	
	    	
	    	
	           
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item1)
		{
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File("F:\\slike\\Cars"));
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png","bmp");
			 file.addChoosableFileFilter(filter);
	          int result = file.showSaveDialog(null);
	          if(result == JFileChooser.APPROVE_OPTION){
	              selectedFile = file.getSelectedFile();
	             
	              pic.setIcon(ResizeImage(selectedFile));
	              
	              
	          }
	          
		}
		if(e.getSource() == item2)
		{
			System.exit(0);
		}
		
		
	}
	 public ImageIcon ResizeImage(File input)
	    { 
		 BufferedImage image;
		 ImageIcon image1=null;
		 ImageInputStream iis;
		try {
			iis = ImageIO.createImageInputStream(input);
			image = ImageIO.read(iis);
			Image newImg = image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
	        image1 = new ImageIcon(newImg);
	       
			
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return image1;
		
	        
	    }
	
	
	public void deleteAllrows(DefaultTableModel model)
	{
		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
	}

	public void setControler(AutomobiliControler ac2) {
		this.ac=ac2;
		
	}

	
}
