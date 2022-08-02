
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class Table extends JFrame {
   private JTextField jtf;
   private JLabel searchLbl;
   private TableModel model;
   private JTable table;
   private TableRowSorter sorter;
   private JScrollPane jsp;
   private JPanel panel;
   public Table(String data[][]) {
	   
	   panel = new JPanel();
      setTitle("Table");
      jtf = new JTextField(50);
 
      jtf.setBounds(520+150, 5, 200, 30);
      searchLbl = new JLabel("Search");
      searchLbl.setBounds(470+150, 5, 200, 30);
      String[] columnNames = {"Sr.","College Name", "Branch","Seat type","Gender","Opening Rank","Closing Rank",};
      
      model = new DefaultTableModel(data, columnNames);
      sorter = new TableRowSorter<>(model);
      table = new JTable(model);
      table.setRowSorter(sorter);
      
      
      jsp = new JScrollPane(table);
      jsp.setBounds(2,50, 1535, 750);
      panel.setBounds(0, 0, 1800, 1000);
      panel.setLayout(null);
      panel.add(searchLbl);
      panel.add(jtf);
      panel.add(jsp);
      add(panel);
      jtf.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
            search(jtf.getText());
         }
         @Override
         public void removeUpdate(DocumentEvent e) {
            search(jtf.getText());
         }
         @Override
         public void changedUpdate(DocumentEvent e) {
            search(jtf.getText());
         }
         public void search(String str) {
            if (str.length() == 0) {
               sorter.setRowFilter(null);
            } else {
               sorter.setRowFilter(RowFilter.regexFilter(str));
            }
         }
      });
      
      table.getColumnModel().getColumn(2).setPreferredWidth(480);
      table.getColumnModel().getColumn(0).setPreferredWidth(10);
      table.getColumnModel().getColumn(1).setPreferredWidth(360);
      table.getColumnModel().getColumn(3).setPreferredWidth(30);
      table.getColumnModel().getColumn(4).setPreferredWidth(50);
      table.getColumnModel().getColumn(5).setPreferredWidth(30);
      table.getColumnModel().getColumn(6).setPreferredWidth(25);
      table.setRowHeight(table.getRowHeight() + 25);
      table.setLocation(0,100);
      setSize(1300, 650);
      getContentPane().setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLocationRelativeTo(null);
      setResizable(true);
      setVisible(true);
     setLayout(null);
   }
   
}