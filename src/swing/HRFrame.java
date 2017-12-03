package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.*;
import javafx.scene.control.DatePicker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JLayeredPane;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRFrame extends JFrame {

	private HRFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JButton button_10;
	private JButton button_11;
	private JButton btnRemove_1;
	private JList list;
	private JList list_2;
	private JList list_3;
	private JTable table2;
	
	private DefaultTableModel dtm;
	private JScrollPane registerStaff;
	private JScrollPane removeStaff;
	private JScrollPane updateStaff;
	private JScrollPane addAllotments;
	private JPanel addOffice;
	private JPanel manageStaff;
	private JPanel home;
	private JPanel manageAllotments;
	private JPanel removeAllotment;
	private JPanel updateAllotment;
	private DefaultListModel listModel;
	private DefaultListModel listModel2;
	private JList list2;
	private DefaultListModel listModel3;
	private DefaultListModel listModel4;
	private JList list4;
	private DefaultListModel listModel5;
	private JPanel panel_3;
	private ArrayList<Container> containers;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRFrame frame = new HRFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showPanel(String a)
	{
		for (int i = 0; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		if (a.equals("Home"))
		{
			containers.get(0).setVisible(true);
		}
		if (a.equals("Register Staff"))
		{
			containers.get(1).setVisible(true);
		}
		if (a.equals("Remove Staff"))
		{
			containers.get(2).setVisible(true);
		}
		if (a.equals("Update Allotment"))
		{
			containers.get(3).setVisible(true);
		}
		if (a.equals("Update Staff"))
		{
			containers.get(4).setVisible(true);
		}
		if (a.equals("Add Office"))
		{
			containers.get(5).setVisible(true);
		}
		if (a.equals("Manage Staff"))
		{
			containers.get(6).setVisible(true);
		}
		if (a.equals("Add Allotment"))
		{
			containers.get(7).setVisible(true);
		}
		if (a.equals("Remove Allotment"))
		{
			containers.get(8).setVisible(true);
		}
		if (a.equals("Manage Allotments"))
		{
			containers.get(9).setVisible(true);
		}
		
	}
	/**
	 * Create the frame.
	 */
	public HRFrame() {
		frame = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();
		listModel2 = new DefaultListModel();
		listModel3 = new DefaultListModel();
		listModel4 = new DefaultListModel();
		listModel5 = new DefaultListModel();
		
		JPanel topPanel = new JPanel();
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		//addOffice.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(704, 600));
		panel_2.setBackground(Color.BLACK);
		//updateStaff.setBounds(249, 152, 704, 442);
		//contentPane.add(updateStaff);
		
		JLabel label_2 = new JLabel("Update Staff Details");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(33, 11, 227, 35);
		panel_2.add(label_2);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(33, 48, 227, 2);
		panel_2.add(separator_14);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_3.setBounds(33, 102, 54, 27);
		panel_2.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setText("Mustafa");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(36, 47, 65));
		textField_2.setBounds(364, 106, 130, 20);
		panel_2.add(textField_2);
		
		JLabel label_13 = new JLabel("Date of Birth");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_13.setBounds(33, 140, 99, 27);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Phone");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_14.setBounds(33, 178, 54, 27);
		panel_2.add(label_14);
		
		textField_5 = new JTextField();
		textField_5.setText("+923123456789");
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(36, 47, 65));
		textField_5.setBounds(191, 182, 154, 20);
		panel_2.add(textField_5);
		
		JLabel label_15 = new JLabel("Email");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_15.setBounds(33, 214, 54, 27);
		panel_2.add(label_15);
		
		textField_6 = new JTextField();
		textField_6.setText("ahmad.mustafa@myschool.com");
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(36, 47, 65));
		textField_6.setBounds(191, 214, 154, 20);
		panel_2.add(textField_6);
		
		JLabel label_16 = new JLabel("CNIC");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_16.setBounds(33, 252, 54, 27);
		panel_2.add(label_16);
		
		textField_7 = new JTextField();
		textField_7.setText("12345-6789123-4");
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(36, 47, 65));
		textField_7.setBounds(191, 256, 154, 20);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("+923123456788");
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(36, 47, 65));
		textField_8.setBounds(191, 295, 154, 20);
		panel_2.add(textField_8);
		
		JLabel label_17 = new JLabel("Gender");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_17.setBounds(33, 328, 61, 27);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel("Emergency Contact");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_18.setBounds(33, 290, 148, 27);
		panel_2.add(label_18);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(191, 331, 154, 20);
		comboBox_1.addItem('M');
		comboBox_1.addItem('F');
		panel_2.add(comboBox_1);
		
		textField_9 = new JTextField();
		textField_9.setText("Ahmad");
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(new Color(36, 47, 65));
		textField_9.setBounds(191, 105, 154, 22);
		panel_2.add(textField_9);
		
		JLabel label_19 = new JLabel("Address");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_19.setBounds(33, 366, 61, 27);
		panel_2.add(label_19);
		
		textField_10 = new JTextField();
		textField_10.setText("test addr");
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(new Color(36, 47, 65));
		textField_10.setBounds(191, 371, 303, 20);
		panel_2.add(textField_10);
		
		JLabel label_20 = new JLabel("Department");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_20.setBounds(33, 404, 109, 27);
		panel_2.add(label_20);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_3.setBorder(null);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(191, 409, 154, 20);
		comboBox_3.addItem("HR");
		comboBox_3.addItem("Accounts");
		
		comboBox_3.addItem("Academic");
		panel_2.add(comboBox_3);
		
		JLabel label_21 = new JLabel("Picture");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_21.setBounds(33, 447, 61, 27);
		panel_2.add(label_21);
		
		JButton button_4 = new JButton("Upload Photo");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_4.setBackground(new Color(36, 47, 65));
		button_4.setBounds(191, 447, 130, 23);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Update");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String empID = textField_11.getText();
				String name = textField_9.getText() + " " + textField_2.getText();
				//Date date = DatePicker.class..
				String phone = textField_15.getText();
				String email = textField_16.getText();
				String cnic = textField_17.getText();
				String emergency = textField_18.getText();
				char gender = (char) comboBox_1.getSelectedItem();
				String address = textField_20.getText();
				String department = (String) comboBox_3.getSelectedItem();
			}
		});
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_5.setBackground(new Color(36, 47, 65));
		button_5.setBounds(191, 485, 130, 23);
		panel_2.add(button_5);
		
		JLabel label_22 = new JLabel("Search Employee by ID");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_22.setBounds(54, 60, 179, 17);
		panel_2.add(label_22);
		
		textField_11 = new JTextField();
		textField_11.setText("1234");
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(new Color(36, 47, 65));
		textField_11.setBounds(245, 58, 282, 22);
		panel_2.add(textField_11);
		
		JButton button_6 = new JButton("Search");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				//Session.academicInstitution.getStaff(textField_11.getText());
				//Show if exists or not
			}
		});
		removeAllotment = new JPanel();
		removeAllotment.setLayout(null);
		removeAllotment.setOpaque(true);
		removeAllotment.setBackground(Color.BLACK);
		removeAllotment.setBounds(249, 152, 704, 442);
		contentPane.add(removeAllotment);
		
		JLabel lblRemoveAllotments = new JLabel("Remove Allotments");
		lblRemoveAllotments.setForeground(Color.WHITE);
		lblRemoveAllotments.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblRemoveAllotments.setBounds(41, 23, 246, 27);
		removeAllotment.add(lblRemoveAllotments);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(41, 55, 225, 5);
		removeAllotment.add(separator_4);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmployeeId.setBounds(121, 87, 104, 27);
		removeAllotment.add(lblEmployeeId);
		
		textField_3 = new JTextField();
		textField_3.setText("15L-1234");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(36, 47, 65));
		textField_3.setBounds(252, 91, 198, 20);
		removeAllotment.add(textField_3);
		
		JButton button = new JButton("Search");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Staff staffMember = Session.getInst().getStaff(textField_3.getText()); 
				if (staffMember != null)
				{
					ArrayList<Staff> staff = ((HRManager) Session.getUser()).getAllotedStaff();
					if (staff.contains(staffMember) == true)
					{
						String[] columnNames = {"Emp ID",
				                "Name",
				                "DOB"};
						
						table2 = new JTable();
						dtm = new DefaultTableModel(0, 0);
						dtm.setColumnIdentifiers(columnNames);
						table2.setModel(dtm);
						
						JScrollPane scrollPane_5 = new JScrollPane(table2);
						scrollPane_5.setForeground(Color.WHITE);
						scrollPane_5.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						scrollPane_5.setBackground(Color.WHITE);
						scrollPane_5.setAlignmentX(0.0f);
						scrollPane_5.setBounds(197, 135, 279, 40);
						removeAllotment.add(scrollPane_5);
						
						//dtm.addRow(new Object[] {.....}
						dtm.addRow(new Object[] { "LOL", "LOL", "LOL"});
						
						btnRemove_1 = new JButton("Remove");
						btnRemove_1.setBounds(270, 215, 97, 25);
						btnRemove_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								//Session.getUser().removeAllotment((String) dtm.getValueAt(0, 0));
			
							}
						});
						removeAllotment.add(btnRemove_1);
						removeAllotment.repaint();
					}
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button.setBackground(SystemColor.menu);
		button.setBounds(476, 89, 130, 23);
		removeAllotment.add(button);
		
		
		updateAllotment = new JPanel();
		updateAllotment.setBounds(249, 152, 704, 442);
		contentPane.add(updateAllotment);
		updateAllotment.setLayout(null);
		updateAllotment.setOpaque(true);
		updateAllotment.setBackground(Color.BLACK);
		
		JLabel lblUpdateAllotment_1 = new JLabel("Update Allotment");
		lblUpdateAllotment_1.setForeground(Color.WHITE);
		lblUpdateAllotment_1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblUpdateAllotment_1.setBounds(41, 23, 246, 27);
		updateAllotment.add(lblUpdateAllotment_1);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(41, 55, 225, 5);
		updateAllotment.add(separator_9);
		
		JLabel label_8 = new JLabel("Staff:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_8.setBounds(387, 88, 42, 27);
		updateAllotment.add(label_8);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(387, 110, 42, 5);
		updateAllotment.add(separator_5);
		
		JLabel label_9 = new JLabel("Office ID:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(177, 88, 78, 27);
		updateAllotment.add(label_9);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(177, 110, 71, 5);
		updateAllotment.add(separator_7);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(160, 126, 100, 288);
		updateAllotment.add(scrollPane_1);
		
		JList list_1 = new JList(listModel2);
		scrollPane_1.setViewportView(list_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//remove previous items
				String empID = (String) list_2.getSelectedValue();
				String officeID = (String) list_1.getSelectedValue();
				//Session.getUser().UpdateAllotment(empID,officeID);
			}
		});
		btnUpdate.setBounds(532, 256, 89, 23);
		updateAllotment.add(btnUpdate);
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		scrollPane_2.setBounds(359, 126, 100, 288);
		updateAllotment.add(scrollPane_2);
		
		list_2 = new JList(listModel3);
		scrollPane_2.setViewportView(list_2);
		
		addAllotments = new JScrollPane();
		addAllotments.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		addAllotments.setBounds(249, 152, 704, 442);
		contentPane.add(addAllotments);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(true);
		panel_3.setBackground(Color.BLACK);
		addAllotments.setViewportView(panel_3);
		
		JLabel label_7 = new JLabel("Add Allotments\r\n\r\n");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_7.setBounds(38, 11, 211, 27);
		panel_3.add(label_7);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 43, 211, 5);
		panel_3.add(separator_1);
		
		JLabel lblStaffType = new JLabel("Staff:");
		lblStaffType.setForeground(Color.WHITE);
		lblStaffType.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStaffType.setBounds(360, 71, 42, 27);
		panel_3.add(lblStaffType);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(360, 93, 42, 5);
		panel_3.add(separator_2);
		
		JLabel label_38 = new JLabel("Office ID:");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_38.setBounds(150, 71, 78, 27);
		panel_3.add(label_38);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(150, 93, 71, 5);
		panel_3.add(separator_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String empID = (String) list.getSelectedValue();
				String officeID = (String) list_3.getSelectedValue();
				//Session.getUser().addAllotment(officeID, empID);
			}
		});
		btnAdd.setBounds(505, 239, 89, 23);
		panel_3.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(332, 109, 100, 288);
		panel_3.add(scrollPane);
		list = new JList(listModel5);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_4 = new JScrollPane((Component) null);
		scrollPane_4.setBounds(135, 109, 100, 288);
		panel_3.add(scrollPane_4);
		
		list_3 = new JList(listModel4);
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(list_3);
				
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_6.setBackground(new Color(36, 47, 65));
		button_6.setBounds(539, 59, 130, 23);
		panel_2.add(button_6);
		
		updateStaff = new JScrollPane();
		updateStaff.setBounds(249, 152, 704, 442);
		contentPane.add(updateStaff);
		updateStaff.setViewportView(panel_2);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(36, 47, 65));
		textField.setBounds(191, 145, 154, 22);
		panel_2.add(textField);
		updateStaff.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);;
		//Create the list and put it in a scroll pane.
		
		//manageAllotment.setVisible(false);
		
		addOffice = new JPanel();
		addOffice.setBounds(249, 152, 704, 442);
		contentPane.add(addOffice);
		addOffice.setLayout(null);
		addOffice.setBackground(Color.BLACK);
		
		JLabel label_11 = new JLabel("Add Office\r\n\r\n");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_11.setBounds(41, 23, 246, 27);
		addOffice.add(label_11);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(41, 55, 135, 2);
		addOffice.add(separator_12);
		
		JLabel label_12 = new JLabel("Office ID:");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_12.setBounds(259, 91, 105, 27);
		addOffice.add(label_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(259, 116, 77, 2);
		addOffice.add(separator_13);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(346, 96, 77, 22);
		addOffice.add(textField_1);
		
		JButton button_3 = new JButton("Add");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = textField_1.getText();
				//boolean result = Session.getUser().addOffce(id);
				//if (result == false)
				//{
				//	//error prompt
				//}
				//else
				//{
				//	//success prompt
				//}
			}
		});
		button_3.setFont(new Font("Century Gothic", Font.BOLD, 11));
		button_3.setBounds(304, 160, 89, 23);
		addOffice.add(button_3);
		
		removeStaff = new JScrollPane();
		removeStaff.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		removeStaff.setBackground(Color.BLACK);
		removeStaff.setBounds(249, 152, 704, 442);
		contentPane.add(removeStaff);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(704, 430));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		removeStaff.setViewportView(panel_1);
		
		JLabel label_34 = new JLabel("Remove Staff");
		label_34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
				label_34.setForeground(Color.WHITE);
				label_34.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				label_34.setBounds(33, 11, 227, 35);
				panel_1.add(label_34);
				
				JSeparator separator_16 = new JSeparator();
				separator_16.setBounds(33, 48, 139, 2);
				panel_1.add(separator_16);
				
				JLabel label_35 = new JLabel("Search Employee by ID");
				label_35.setForeground(Color.WHITE);
				label_35.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				label_35.setBounds(54, 60, 179, 17);
				panel_1.add(label_35);
				
				textField_21 = new JTextField();
				textField_21.setText("4321");
				textField_21.setForeground(Color.WHITE);
				textField_21.setFont(new Font("Century Gothic", Font.ITALIC, 13));
				textField_21.setColumns(10);
				textField_21.setBorder(null);
				textField_21.setBackground(new Color(36, 47, 65));
				textField_21.setBounds(245, 58, 282, 22);
				panel_1.add(textField_21);
				
				JButton button_9 = new JButton("Search");
				button_9.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						//if Staff staff = Session.academicInstitution.getStaff(textField_21.getText()) returns not null;
						
						String[] columnNames = {"Emp ID",
				                "Name",
				                "DOB"};
						
						JTable table2 = new JTable();
						DefaultTableModel dtm = new DefaultTableModel(0, 0);
						dtm.setColumnIdentifiers(columnNames);
						table2.setModel(dtm);

						JScrollPane scrollPane_3 = new JScrollPane(table2);
						scrollPane_3.setForeground(Color.WHITE);
						scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						scrollPane_3.setBackground(Color.WHITE);
						scrollPane_3.setAlignmentX(0.0f);
						scrollPane_3.setBounds(197, 100, 279, 40);
						panel_1.add(scrollPane_3);
						
						//dtm.addRow(new Object[] { staff.getEmpID(),staff.getName(),staff.getDOB() });
					    dtm.addRow(new Object[] { "23","Blah","2017" }); //
					    String name = (String) dtm.getValueAt(0, 1);
						
						button_10 = new JButton("Remove");
						button_10.setBounds(265, 199, 117, 29);
						panel_1.add(button_10);
						
						button_10.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								//if (Session.user.removeStaff((String) dtm.getValueAt(0, 0) == false))
								//{
									//error prompt
								//}
							}
						});
						
						panel_1.repaint();
						
						//else prompt of no student found
					}
				});
				button_9.setForeground(Color.BLACK);
				button_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
				button_9.setBackground(new Color(36, 47, 65));
				button_9.setBounds(539, 59, 130, 23);
				panel_1.add(button_9);
		
		manageAllotments = new JPanel();
		manageAllotments.setLayout(null);
		manageAllotments.setPreferredSize(new Dimension(704, 430));
		manageAllotments.setForeground(Color.WHITE);
		manageAllotments.setBackground(Color.BLACK);
		manageAllotments.setBounds(249, 152, 704, 442);
		contentPane.add(manageAllotments);
		
		JLabel lblAddAllotment = new JLabel("Add Allotment");
		lblAddAllotment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				fillUnallotedOfficeIDs(listModel4);
				fillUnallotedStaffMembers(listModel5);
				panel_3.repaint();
			}
		});
		lblAddAllotment.setForeground(Color.WHITE);
		lblAddAllotment.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddAllotment.setBounds(133, 90, 158, 35);
		manageAllotments.add(lblAddAllotment);
		
		JLabel lblRemoveAllotment = new JLabel("Remove Allotment");
		lblRemoveAllotment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
			
		});
		lblRemoveAllotment.setForeground(Color.WHITE);
		lblRemoveAllotment.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveAllotment.setBounds(133, 179, 199, 35);
		manageAllotments.add(lblRemoveAllotment);
		
		JLabel lblUpdateAllotment = new JLabel("Update Allotment");
		lblUpdateAllotment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				
				fillUnallotedOfficeIDs(listModel2);
				fillAllotedStaffMembers(listModel3);
				updateAllotment.repaint();
			}
		});
		lblUpdateAllotment.setForeground(Color.WHITE);
		lblUpdateAllotment.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateAllotment.setBounds(133, 266, 199, 35);
		manageAllotments.add(lblUpdateAllotment);
		
		manageStaff = new JPanel();
		manageStaff.setBounds(249, 152, 704, 442);
		contentPane.add(manageStaff);
		manageStaff.setLayout(null);
		manageStaff.setPreferredSize(new Dimension(704, 430));
		manageStaff.setForeground(Color.WHITE);
		manageStaff.setBackground(Color.BLACK);
		
		JLabel lblRegisterstaff = new JLabel("Register Staff");
		lblRegisterstaff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
				lblRegisterstaff.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JLabel evlbl = (JLabel) e.getComponent();
						showPanel(evlbl.getText());
					}
				});
				lblRegisterstaff.setForeground(Color.WHITE);
				lblRegisterstaff.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				lblRegisterstaff.setBounds(133, 90, 158, 35);
				manageStaff.add(lblRegisterstaff);
				
				JLabel lblRemoveStaff = new JLabel("Remove Staff");
				lblRemoveStaff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblRemoveStaff.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JLabel evlbl = (JLabel) e.getComponent();
						showPanel(evlbl.getText());
					}
				});
				lblRemoveStaff.setForeground(Color.WHITE);
				lblRemoveStaff.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				lblRemoveStaff.setBounds(133, 179, 172, 35);
				manageStaff.add(lblRemoveStaff);
				
				JLabel lblUpdateStaff = new JLabel("Update Staff");
				lblUpdateStaff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
						lblUpdateStaff.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								JLabel evlbl = (JLabel) e.getComponent();
								showPanel(evlbl.getText());
							}
						});
						lblUpdateStaff.setForeground(Color.WHITE);
						lblUpdateStaff.setFont(new Font("Century Gothic", Font.PLAIN, 20));
						lblUpdateStaff.setBounds(133, 266, 172, 35);
						manageStaff.add(lblUpdateStaff);
		
		registerStaff = new JScrollPane();
		registerStaff.setBounds(249, 152, 704, 442);
		contentPane.add(registerStaff);
		registerStaff.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		registerStaff.setBackground(Color.BLACK);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 600));
		panel.setBackground(Color.BLACK);
		registerStaff.setViewportView(panel);
		
		JLabel label_23 = new JLabel("Staff Registration");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_23.setBounds(33, 11, 212, 35);
		panel.add(label_23);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(33, 48, 197, 2);
		panel.add(separator_15);
		
		JLabel label_24 = new JLabel("Name");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_24.setBounds(33, 102, 54, 27);
		panel.add(label_24);
		
		textField_12 = new JTextField();
		textField_12.setText("Last");
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_12.setColumns(10);
		textField_12.setBorder(null);
		textField_12.setBackground(new Color(36, 47, 65));
		textField_12.setBounds(364, 106, 130, 20);
		panel.add(textField_12);
		
		JLabel label_25 = new JLabel("Date of Birth");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_25.setBounds(33, 140, 99, 27);
		panel.add(label_25);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.WHITE);
		textField_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_13.setColumns(10);
		textField_13.setBorder(null);
		textField_13.setBackground(new Color(36, 47, 65));
		textField_13.setBounds(364, 144, 40, 20);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_14.setColumns(10);
		textField_14.setBorder(null);
		textField_14.setBackground(new Color(36, 47, 65));
		textField_14.setBounds(414, 144, 80, 20);
		panel.add(textField_14);
		
		JLabel label_26 = new JLabel("Phone");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_26.setBounds(33, 178, 54, 27);
		panel.add(label_26);
		
		textField_15 = new JTextField();
		textField_15.setForeground(Color.WHITE);
		textField_15.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_15.setColumns(10);
		textField_15.setBorder(null);
		textField_15.setBackground(new Color(36, 47, 65));
		textField_15.setBounds(191, 182, 154, 20);
		panel.add(textField_15);
		
		JLabel label_27 = new JLabel("Email");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_27.setBounds(33, 214, 54, 27);
		panel.add(label_27);
		
		textField_16 = new JTextField();
		textField_16.setForeground(Color.WHITE);
		textField_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_16.setColumns(10);
		textField_16.setBorder(null);
		textField_16.setBackground(new Color(36, 47, 65));
		textField_16.setBounds(191, 218, 154, 20);
		panel.add(textField_16);
		
		JLabel label_28 = new JLabel("CNIC");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_28.setBounds(33, 252, 54, 27);
		panel.add(label_28);
		
		textField_17 = new JTextField();
		textField_17.setForeground(Color.WHITE);
		textField_17.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_17.setColumns(10);
		textField_17.setBorder(null);
		textField_17.setBackground(new Color(36, 47, 65));
		textField_17.setBounds(191, 256, 154, 20);
		panel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setForeground(Color.WHITE);
		textField_18.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(null);
		textField_18.setBackground(new Color(36, 47, 65));
		textField_18.setBounds(191, 295, 154, 20);
		panel.add(textField_18);
		
		JLabel label_29 = new JLabel("Gender");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_29.setBounds(33, 328, 61, 27);
		panel.add(label_29);
		
		JLabel label_30 = new JLabel("Emergency Contact");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_30.setBounds(33, 290, 148, 27);
		panel.add(label_30);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_4.setBorder(null);
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(191, 331, 154, 20);
		comboBox_4.addItem('M');
		comboBox_4.addItem('F');
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(191, 145, 154, 20);
		panel.add(comboBox_5);
		
		textField_19 = new JTextField();
		textField_19.setText("First");
		textField_19.setForeground(Color.WHITE);
		textField_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_19.setColumns(10);
		textField_19.setBorder(null);
		textField_19.setBackground(new Color(36, 47, 65));
		textField_19.setBounds(191, 105, 154, 22);
		panel.add(textField_19);
		
		JLabel label_31 = new JLabel("Address");
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_31.setBounds(33, 366, 61, 27);
		panel.add(label_31);
		
		textField_20 = new JTextField();
		textField_20.setForeground(Color.WHITE);
		textField_20.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_20.setColumns(10);
		textField_20.setBorder(null);
		textField_20.setBackground(new Color(36, 47, 65));
		textField_20.setBounds(191, 371, 303, 20);
		panel.add(textField_20);
		
		JLabel label_32 = new JLabel("Department");
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_32.setBounds(33, 404, 116, 27);
		panel.add(label_32);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setForeground(Color.BLACK);
		comboBox_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_6.setBorder(null);
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(191, 409, 154, 20);
		comboBox_6.addItem("HR");
		comboBox_6.addItem("Accounts");
		comboBox_6.addItem("Academic");
		panel.add(comboBox_6);
		
		JLabel label_33 = new JLabel("Picture");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_33.setBounds(33, 447, 61, 27);
		panel.add(label_33);
		
		JButton button_7 = new JButton("Upload Photo");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_7.setBackground(new Color(36, 47, 65));
		button_7.setBounds(191, 447, 130, 23);
		panel.add(button_7);
		
		JButton button_8 = new JButton("Register");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = textField_19.getText() + " " + textField_12.getText();
				//Date date = DatePicker.class..
				String phone = textField_15.getText();
				String email = textField_16.getText();
				String cnic = textField_17.getText();
				String emergency = textField_18.getText();
				char gender = (char) comboBox_4.getSelectedItem();
				String address = textField_20.getText();
				String department = (String) comboBox_6.getSelectedItem();
				
				//Session.user.registerStaff(name,date,phone,email,cnic,emergency,gender,address,department);
				//show prompt depending on return
				
				
				
			}
		});
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_8.setBackground(new Color(36, 47, 65));
		button_8.setBounds(191, 485, 130, 23);
		panel.add(button_8);
		
		
		home = new JPanel();
		home.setBackground(Color.BLACK);
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		home.setLayout(null);
		
		JLabel lblUserimage = new JLabel("UserImage");
		lblUserimage.setBounds(70, 69, 99, 152);
		home.add(lblUserimage);
		lblUserimage.setIcon(new ImageIcon(HRFrame.class.getResource("/images/user2.png")));
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(85, 23, 93, 16);
		home.add(lblProfile);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(86, 48, 61, 2);
		home.add(separator);
		
		
		viewDetails(new User("A", "B", new Date(1,2,3), "C", "D", "E", 'M', "F", "G"));
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageFaculty = new JLabel("Add Office");
		lblManageFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
			
		});
		lblManageFaculty.setForeground(Color.WHITE);
		lblManageFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageFaculty.setBounds(57, 137, 182, 27);
		
		sidePanel.add(lblManageFaculty);
		
		JLabel lblManageStudents = new JLabel("Manage Allotments");
		lblManageStudents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(57, 189, 182, 27);
		sidePanel.add(lblManageStudents);
		
		JLabel lblManageRegistrations = new JLabel("Manage Staff");
		lblManageRegistrations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel evlbl = (JLabel) arg0.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageRegistrations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageRegistrations.setForeground(Color.WHITE);
		lblManageRegistrations.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageRegistrations.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageRegistrations);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HRFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 189, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(13, 137, 33, 32);
		sidePanel.add(label);
		label.setIcon(new ImageIcon(HRFrame.class.getResource("/images/faculty.png")));
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HRFrame.class.getResource("/images/registration.png")));
		label_4.setBounds(12, 87, 40, 30);
		sidePanel.add(label_4);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Session.getInst().logout();
				frame.setVisible(false);
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
			}
		});
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(HRFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("HR Manager");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		sidePanel.setVisible(true);
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel evlbl = (JLabel) arg0.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblHome.setIcon(new ImageIcon(HRFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(HRFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HRFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 258, 152);
		topPanel.add(label_6);
		
		addContainers();
		
		for (int i = 1; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		
	}
	
	void addContainers()
	{
		containers.add(home);
		containers.add(registerStaff);
		containers.add(removeStaff);
		containers.add(updateAllotment);
		containers.add(updateStaff);
		containers.add(addOffice);
		containers.add(manageStaff);
		containers.add(addAllotments);
		containers.add(removeAllotment);
		containers.add(manageAllotments);
	}
	
	public void viewDetails(User user)
	{
		JLabel lblEhtishamulhaq = new JLabel(user.getName());
		lblEhtishamulhaq.setForeground(Color.WHITE);
		lblEhtishamulhaq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEhtishamulhaq.setBounds(70, 252, 175, 27);
		home.add(lblEhtishamulhaq);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(71, 283, 61, 2);
		home.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(71, 323, 61, 2);
		home.add(separator_2);
		
		JLabel label_7 = new JLabel(user.getPhoneNo());
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7.setBounds(70, 292, 175, 27);
		home.add(label_7);
		
		JLabel lblPrincessshamsgmailcom = new JLabel(user.getEmail());
		lblPrincessshamsgmailcom.setForeground(Color.WHITE);
		lblPrincessshamsgmailcom.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrincessshamsgmailcom.setBounds(70, 334, 205, 27);
		home.add(lblPrincessshamsgmailcom);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(71, 365, 61, 2);
		home.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(71, 405, 61, 2);
		home.add(separator_4);
		
		JLabel lblHStreet = new JLabel(user.getAddress());
		lblHStreet.setForeground(Color.WHITE);
		lblHStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHStreet.setBounds(70, 374, 239, 27);
		home.add(lblHStreet);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(418, 405, 61, 2);
		home.add(separator_5);
		
		JLabel lblGenderM = new JLabel("Gender: "+ user.getGender());
		lblGenderM.setForeground(Color.WHITE);
		lblGenderM.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGenderM.setBounds(417, 374, 175, 27);
		home.add(lblGenderM);
		
		JLabel lblDob = new JLabel("DOB: " + user.getDOB());
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDob.setBounds(417, 334, 250, 27);
		home.add(lblDob);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(418, 365, 61, 2);
		home.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(418, 323, 61, 2);
		home.add(separator_7);
		
		JLabel lblCnic = new JLabel("CNIC: " + user.getCNIC());
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic.setBounds(417, 292, 175, 27);
		home.add(lblCnic);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(418, 283, 61, 2);
		home.add(separator_8);
		
		JLabel lblEmergency = new JLabel("Emergency: " + user.getEmergencyContact());
		lblEmergency.setForeground(Color.WHITE);
		lblEmergency.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmergency.setBounds(417, 252, 192, 27);
		home.add(lblEmergency);
		//home.setVisible(false);
		home.setVisible(true);
	}
	
	public void fillUnallotedOfficeIDs(DefaultListModel listModel)
	{
		listModel.removeAllElements();
		listModel.addElement("HAHA");
//		ArrayList<Office> offices = Session.getUser().getUnallotedOffice();
//		for (int i = 0; i < offices.size(); i++)
//		{
//			listModel.addElement(offices.get(i).getID());
//		}
	}
	
	public void fillUnallotedStaffMembers(DefaultListModel listModel)
	{
		listModel.removeAllElements();
		listModel.addElement("HAHA");
//		ArrayList<StaffMember> staff = Session.getUser().getUnallotedStaff();
//		for (int i = 0; i < staff.size(); i++)
//		{
//			listModel.addElement(staff.get(i).getID());
//		}
        
        
		
	}
	
	public void fillAllotedStaffMembers(DefaultListModel listModel)
	{
		listModel.removeAllElements();

		listModel.addElement("HAHA");
//		ArrayList<StaffMember> staff = Session.getUser().getAllotedStaff();
//		for (int i = 0; i < staff.size(); i++)
//		{
//			listModel.addElement(staff.get(i).getID());
//		}
        
        
		
	}
}
