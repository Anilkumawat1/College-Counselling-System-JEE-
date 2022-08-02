

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class college extends JFrame {
    DBMS d ;
    DBMS d1;
   
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void main(String college_Name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					college frame = new college(college_Name);
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
	public college(String college_Name) {
		
		d1 = new DBMS();
		String st[] = new String[7];
		try {
			st = d1.college_Details(college_Name);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1148, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new RoundedBorder(40));
		panel.setBackground(Color.white);
		panel.setBounds(350, 150, 868, 434);
		
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel(college_Name);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(22, 0, 782, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(22, 73, 72, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fees / Sem");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(238, 73, 118, 35);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NIRF Rank");
		lblNewLabel_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(453, 73, 100, 35);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(st[0]);
		lblNewLabel_1_3.setForeground(SystemColor.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(22, 110, 72, 35);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(st[6]);
		lblNewLabel_1_1_1.setForeground(SystemColor.black);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(238, 110, 118, 35);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(st[1]);
		lblNewLabel_1_2_1.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(453, 110, 100, 35);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Seat Matrix");
		lblNewLabel_1_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(592, 73, 87, 35);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel(st[5]);
		lblNewLabel_1_5.setForeground(SystemColor.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(592, 110, 87, 35);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Website");
		lblNewLabel_1_2_2_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2.setBounds(22, 268, 782, 35);
		panel.add(lblNewLabel_1_2_2_2);
		
		JLabel lblNewLabel_1_2_2_3 = new JLabel(st[4]);
		lblNewLabel_1_2_2_3.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_3.setBounds(22, 304, 782, 35);
		panel.add(lblNewLabel_1_2_2_3);
		
		JLabel lblNewLabel_1_2_2_4 = new JLabel("Location");
		lblNewLabel_1_2_2_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_4.setBounds(22, 342, 782, 35);
		panel.add(lblNewLabel_1_2_2_4);
		
		JLabel lblNewLabel_1_2_2_5 = new JLabel(st[3]);
		lblNewLabel_1_2_2_5.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_5.setBounds(22, 375, 782, 35);
		panel.add(lblNewLabel_1_2_2_5);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Placement");
		lblNewLabel_1_2_2_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2_1.setBounds(22, 183, 782, 35);
		panel.add(lblNewLabel_1_2_2_2_1);
		
		JLabel lblNewLabel_1_2_2_2_2 = new JLabel(st[2]);
		lblNewLabel_1_2_2_2_2.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2_2.setBounds(22, 215, 50, 35);
		panel.add(lblNewLabel_1_2_2_2_2);
		
		JLabel lblNewLabel_1_2_2_2_21 = new JLabel("LPA");
		lblNewLabel_1_2_2_2_21.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2_2_2_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2_21.setBounds(50, 215, 50, 35);
		panel.add(lblNewLabel_1_2_2_2_21);
		
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Total Course");
		lblNewLabel_1_5_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(711, 73, 109, 35);
		panel.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel(st[7]);
		lblNewLabel_1_5_2.setForeground(SystemColor.black);
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_2.setBounds(711, 110, 109, 35);
		panel.add(lblNewLabel_1_5_2);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(330, 111, 900, 580);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.white);
		panel_1.setBorder(new RoundedBorder(40));
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel(college_Name);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(30, 10, 782, 45);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 26+50, 89, 45);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gender-Neutral", "Female-only"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(190, 26+50, 238, 40);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Category\r\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(30, 96+50, 89, 40);
		panel_1.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"OPEN","OPEN (PwD)", "EWS", "EWS (PwD)","OBC-NCL","OBC-NCL (PwD)", "SC","SC (PwD)", "ST","ST (PwD)"}));
		comboBox_1.setBounds(190, 108+50, 238, 40);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Show");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(72, 195+50, 85, 21);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                d = new DBMS();
                String s[] = {"Branch Name","Opening Rank","Closing Rank"};
				JTable table = null;
				try {
					table = new JTable(d.Table_branch(college_Name, (String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem()),s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setEnabled(false);
				
				JScrollPane scroll = new JScrollPane(table);
				scroll.setBounds(5, 300, 890, 250);
				table.getColumnModel().getColumn(2).setPreferredWidth(10);
			      table.getColumnModel().getColumn(1).setPreferredWidth(10);
			      table.getColumnModel().getColumn(0).setPreferredWidth(400);
			      table.setRowHeight(table.getRowHeight() + 20);
				panel_1.add(scroll);
			}
		});
		
		
		JButton btnNewButton = new JButton("DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(600, 31, 150, 43);
		btnNewButton.setBorder(new RoundedBorder(40));
		btnNewButton.setBackground(Color.white);
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CUTOFF");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(820, 31, 140, 43);
		btnNewButton_1.setBorder(new RoundedBorder(40));
		btnNewButton_1.setBackground(Color.white);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
	}
}
