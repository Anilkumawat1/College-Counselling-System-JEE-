
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import java.awt.Choice;
import java.awt.Checkbox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Menu {

	private JFrame frame;
	private JTextField textField;
	public JPanel panel;
	public JPanel panel2;
	public int count = 0;
	public String selected_Branch[] = new String[116];
	String branch_name[] = null;
	public DBMS d;

	/**
	 * Launch the application.
	 */
	public void main() {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		d = new DBMS();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(450, 150, 597, 528);
		panel2.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		
		
		Border border = BorderFactory.createLineBorder(Color.black);
		panel=new JPanel();  
        panel.setBounds(230,100,1100,500);  
        panel.setVisible(false);
        panel.setLayout(null);
        panel2.setBackground(Color.white);
        panel.setBackground(Color.white);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        JButton btnNewButton_2 = new JButton("All");
        btnNewButton_2.setBounds(500-50, 419, 92, 32);
        
        
        JButton btnNewButton_2_1 = new JButton("Ok");
        btnNewButton_2_1.setBounds(300-50, 419, 100, 32);
        panel.add(btnNewButton_2_1);
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_2_2 = new JButton("Clear");
        btnNewButton_2_2.setBounds(700-50, 419, 100, 32);
        panel.add(btnNewButton_2_2);
        
        
        
		try {
			branch_name = d.branch_Name();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
       
       
        JPanel listOfFiles = new JPanel();
        listOfFiles.setLayout(new BoxLayout(listOfFiles, BoxLayout.Y_AXIS));
        
        JCheckBox chckbxNewCheckBox[] = new JCheckBox[116];
		for(int i=0;i<116;i++) {
			chckbxNewCheckBox[i] = new JCheckBox(branch_name[i]);
			chckbxNewCheckBox[i].setSelected(true);
			listOfFiles.add(chckbxNewCheckBox[i]);
		}
		
       
       
        JScrollPane jScrollPane = new JScrollPane(listOfFiles);
       
        
        jScrollPane.setSize(1020, 358);
        jScrollPane.setLocation(10, 10);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setPreferredSize(new Dimension (200, 100));
        jScrollPane.setBackground(Color.white);
        panel.add(jScrollPane);
       
        panel2.setBorder(new RoundedBorder(60));
        
        
		JLabel lblNewLabel = new JLabel("Merit Rank");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(115, 189, 89, 38);
		panel2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seat Pool");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(115, 253, 89, 38);
		panel2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(115, 124, 89, 38);
		panel2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Exam type");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(115, 56, 89, 38);
		panel2.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jee Advance", "Jee Main"}));
		comboBox.setBounds(279, 56, 213, 38);
		panel2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All","OPEN","OPEN (PwD)", "EWS", "EWS (PwD)","OBC-NCL","OBC-NCL (PwD)", "SC","SC (PwD)", "ST","ST (PwD)"}));
		comboBox_1.setBounds(279, 124, 213, 38);
		panel2.add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Gender-Neutral", "Female-only"}));
		comboBox_3.setBounds(279, 253, 213, 38);
		panel2.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(textField.getText())>0)
					
					
				   try {
					d.Table((String)textField.getText(),(String)comboBox.getSelectedItem(),(String)comboBox_3.getSelectedItem(),(String)comboBox_1.getSelectedItem(),selected_Branch);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(165, 390, 115, 38);
		panel2.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(332, 390, 115, 38);
		panel2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				textField.setText(null);
		}
	});
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(279, 190, 213, 38);
		panel2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Branch");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1.setBackground(Color.BLACK);
		lblNewLabel_4_1.setBounds(115, 316, 89, 38);
		panel2.add(lblNewLabel_4_1);
		
		
		JButton btnNewButton_1 = new JButton("Select branch");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(false);
				panel.setVisible(true);
				
			}
		});
		
		
		btnNewButton_1.setBounds(279, 316, 213, 38);
		panel2.add(btnNewButton_1);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Component[] components = (Component[]) 
        				listOfFiles.getComponents();

                for (Component comp : components) {

                    if (comp instanceof JCheckBox) {
                        JCheckBox box = (JCheckBox) comp;
                        box.setSelected(true);
                    }
                }            
        	}
        });
		
		btnNewButton_2_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Component[] components = (Component[]) 
        				listOfFiles.getComponents();

                for (Component comp : components) {

                    if (comp instanceof JCheckBox) {
                        JCheckBox box = (JCheckBox) comp;
                        box.setSelected(false);
                    }
                }            
        	}
        });

		
	        btnNewButton_2_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		panel2.setVisible(true);
	        		int j = 0;
	        	for(int i=0;i<116;i++) {
	        		if(chckbxNewCheckBox[i].isSelected()) {
	        			selected_Branch[j] = branch_name[i];
	        			count++;
	        			j++;
	        		}
	        		
	        	}
	        	String st = Integer.toString(count);
	        	if(count==0)
	        	{
	        		for(int i=0;i<116;i++) {
	        			selected_Branch[i] = branch_name[i];
	        		}
	        	}
	        	if(count==116||count==0)
	        		btnNewButton_1.setText("All Branch");
	        	else
	        	btnNewButton_1.setText("Branches ("+st+" Selected)");
	        	count=0;
	        	System.out.println(selected_Branch[1]);
	        	}
	        });
		
	}
}
