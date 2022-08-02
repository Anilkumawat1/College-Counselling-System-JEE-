

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Main extends JFrame {
	Menu menu;
	college college;
	DBMS d;
	private JPanel contentPane;
	JLabel photo = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 1200, 800);
		panel.setLayout(null);
		panel.setVisible(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("580 (1).jpg");
		setIconImage(icon.getImage());
		setLayout(null);
		photo.setIcon(icon);
  	    photo.setBounds(0, 0, 2000, 900);
	
		contentPane = new JPanel();
		
		contentPane.setBounds(0, 0,2000, 900);
		contentPane.setLayout(null);
		
		add(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Select College");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(90, 86, 156, 44);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(300, 87, 800, 43);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		d = new DBMS();
		try {
			comboBox.setModel(new DefaultComboBoxModel(d.college_Name()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(300, 199, 151, 37);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(true);
				panel.setVisible(false);
				college = new college((String)comboBox.getSelectedItem());
				college.main((String)comboBox.getSelectedItem());
			}
		});
		
		add(panel);
		setLayout(null);
		int x = -200;
		JLabel lblNewLabel = new JLabel("Counselling Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(60, 500+x, 600, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("College");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(270, 600+x, 140, 74);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton.setBorder(new RoundedBorder(40));
		btnNewButton.setBackground(Color.white);
		
		JButton btnCutoff = new JButton("CutOff");
		btnCutoff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCutoff.setBounds(120, 600+x, 140, 74);
		contentPane.add(btnCutoff);
		btnCutoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu =  new Menu();
				menu.main();
				contentPane.setVisible(true);
			}
		});
		btnCutoff.setBorder(new RoundedBorder(40));
		contentPane.add(photo);
		btnCutoff.setBackground(Color.white);
	}

}
