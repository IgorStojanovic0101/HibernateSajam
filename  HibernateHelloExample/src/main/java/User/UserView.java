package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class UserView extends JFrame {

	private JFrame frame;
	public JLabel l1;
	
	
	public UserView() {
		
		l1 = new JLabel("");
		getContentPane().add(l1, BorderLayout.NORTH);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
	
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.getContentPane().add(l1, BorderLayout.NORTH);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\slike\\life picture\\o-music-heart-facebook.jpg"));
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}

}
