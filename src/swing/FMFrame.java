package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;


public class FMFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtl;
	private JTextField txtSpring;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtFall;
	private JTextField textField_4;
	private JTextField txtNotPaid;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMFrame frame = new FMFrame();
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
	public FMFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane manageFee = new JScrollPane();
		manageFee.setBounds(249, 152, 704, 442);
		contentPane.add(manageFee);
		manageFee.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		manageFee.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 550));
		panel.setBackground(Color.BLACK);
		manageFee.setViewportView(panel);
		
		JLabel label_14 = new JLabel("Fee Management");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_14.setBounds(33, 11, 212, 35);
		panel.add(label_14);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(23, 44, 197, 2);
		panel.add(separator_10);
		
		textField = new JTextField();
		textField.setText("15L-1234");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(36, 47, 65));
		textField.setBounds(230, 106, 198, 20);
		panel.add(textField);
		
		JLabel label_15 = new JLabel("Roll Number");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_15.setBounds(133, 102, 87, 27);
		panel.add(label_15);
		
		JButton button_1 = new JButton("Upload Photo");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_1.setBackground(new Color(36, 47, 65));
		button_1.setBounds(191, 447, 130, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Register");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_2.setBackground(new Color(36, 47, 65));
		button_2.setBounds(191, 485, 130, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Search");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_3.setBackground(SystemColor.menu);
		button_3.setBounds(438, 104, 130, 23);
		panel.add(button_3);
		
		JLabel label_16 = new JLabel("Amount");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_16.setBounds(207, 194, 57, 27);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("DatePaid");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_17.setBounds(316, 194, 68, 27);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("DueDate");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_18.setBounds(427, 194, 68, 27);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("Semester");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_19.setBounds(87, 194, 68, 27);
		panel.add(label_19);
		
		textField_3 = new JTextField();
		textField_3.setText("Spring-2017");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(36, 47, 65));
		textField_3.setBounds(67, 244, 115, 20);
		panel.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setText("100000");
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(36, 47, 65));
		textField_5.setBounds(191, 244, 100, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("25/01/2017");
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(36, 47, 65));
		textField_6.setBounds(301, 245, 100, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("30/01/2017");
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(36, 47, 65));
		textField_7.setBounds(411, 245, 100, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("Fall-2017");
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(36, 47, 65));
		textField_8.setBounds(67, 275, 115, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("110000");
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(new Color(36, 47, 65));
		textField_9.setBounds(191, 275, 100, 20);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("Not Paid");
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(new Color(36, 47, 65));
		textField_10.setBounds(301, 276, 100, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("30/07/2017");
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(new Color(36, 47, 65));
		textField_11.setBounds(411, 276, 100, 20);
		panel.add(textField_11);
		
		JButton button_4 = new JButton("Update");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_4.setBackground(SystemColor.menu);
		button_4.setBounds(521, 244, 130, 20);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Update");
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_5.setBackground(SystemColor.menu);
		button_5.setBounds(521, 275, 130, 20);
		panel.add(button_5);
		
		JPanel home = new JPanel();
		home.setLayout(null);
		home.setBackground(Color.BLACK);
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		
		JLabel label_2 = new JLabel("UserImage");
		label_2.setIcon(new ImageIcon(FMFrame.class.getResource("/images/user2.png")));
		label_2.setBounds(54, 71, 99, 152);
		home.add(label_2);
		
		JLabel label_3 = new JLabel("Profile");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(69, 25, 93, 16);
		home.add(label_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 50, 61, 2);
		home.add(separator_1);
		
		JLabel label_4 = new JLabel("Ehtisham-Ul-Haq");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_4.setBounds(54, 254, 175, 27);
		home.add(label_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(55, 285, 61, 2);
		home.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(55, 325, 61, 2);
		home.add(separator_3);
		
		JLabel label_7 = new JLabel("0900-78601");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7.setBounds(54, 294, 175, 27);
		home.add(label_7);
		
		JLabel label_8 = new JLabel("princess_sid@gmail.com");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_8.setBounds(54, 336, 205, 27);
		home.add(label_8);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(55, 367, 61, 2);
		home.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(55, 407, 61, 2);
		home.add(separator_5);
		
		JLabel label_9 = new JLabel("H#666, Street 1, Road 5, Lahore");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(54, 376, 239, 27);
		home.add(label_9);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(402, 407, 61, 2);
		home.add(separator_6);
		
		JLabel label_10 = new JLabel("Gender: M");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_10.setBounds(401, 376, 175, 27);
		home.add(label_10);
		
		JLabel label_11 = new JLabel("DOB: 15/11/1996");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_11.setBounds(401, 336, 175, 27);
		home.add(label_11);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(402, 367, 61, 2);
		home.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(402, 325, 61, 2);
		home.add(separator_8);
		
		JLabel label_12 = new JLabel("CNIC: 35201-8327761-9");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_12.setBounds(401, 294, 175, 27);
		home.add(label_12);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(402, 285, 61, 2);
		home.add(separator_9);
		
		JLabel label_13 = new JLabel("Emergency: 03224077810");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_13.setBounds(401, 254, 192, 27);
		home.add(label_13);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(FMFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(FMFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FMFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 258, 152);
		topPanel.add(label_6);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageFaculty = new JLabel("Manage Pays");
		lblManageFaculty.setForeground(Color.WHITE);
		lblManageFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageFaculty.setBounds(57, 103, 182, 27);
		
		sidePanel.add(lblManageFaculty);
		
		JLabel lblManageStudents = new JLabel("Manage Fees");
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(57, 158, 182, 27);
		sidePanel.add(lblManageStudents);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FMFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 153, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 103, 33, 32);
		sidePanel.add(label);
		label.setIcon(new ImageIcon(FMFrame.class.getResource("/images/faculty.png")));
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(FMFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("Finance Manager");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		
		JScrollPane managePay = new JScrollPane();
		managePay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(managePay);
		managePay.setBackground(Color.BLACK);
		managePay.setBounds(249, 152, 704, 442);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(249, 152, 704, 442);
		managePay.setViewportView(panel_2);
		panel_2.setPreferredSize(new Dimension(704, 550));
		panel_2.setLayout(null);
		
		JLabel lblProfile = new JLabel("Pay Management");
		lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(33, 11, 212, 35);
		panel_2.add(lblProfile);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 44, 197, 2);
		panel_2.add(separator);
		
		txtl = new JTextField();
		txtl.setText("1234");
		txtl.setForeground(Color.WHITE);
		txtl.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtl.setColumns(10);
		txtl.setBorder(null);
		txtl.setBackground(new Color(36, 47, 65));
		txtl.setBounds(230, 106, 198, 20);
		panel_2.add(txtl);
		
		JLabel lblSchool = new JLabel("Employee ID");
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool.setBounds(125, 102, 95, 27);
		panel_2.add(lblSchool);
		
		JButton btnUploadPhoto = new JButton("Upload Photo");
		btnUploadPhoto.setForeground(Color.WHITE);
		btnUploadPhoto.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUploadPhoto.setBackground(new Color(36, 47, 65));
		btnUploadPhoto.setBounds(191, 447, 130, 23);
		panel_2.add(btnUploadPhoto);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnRegister.setBackground(new Color(36, 47, 65));
		btnRegister.setBounds(191, 485, 130, 23);
		panel_2.add(btnRegister);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSearch.setBackground(UIManager.getColor("Button.background"));
		btnSearch.setBounds(438, 104, 130, 23);
		panel_2.add(btnSearch);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAmount.setBounds(252, 206, 57, 27);
		panel_2.add(lblAmount);
		
		JLabel lblDatepaid = new JLabel("DatePaid");
		lblDatepaid.setForeground(Color.WHITE);
		lblDatepaid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDatepaid.setBounds(360, 206, 68, 27);
		panel_2.add(lblDatepaid);
		
		JLabel lblSemester = new JLabel("Month");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSemester.setBounds(133, 206, 68, 27);
		panel_2.add(lblSemester);
		
		txtSpring = new JTextField();
		txtSpring.setText("August");
		txtSpring.setForeground(Color.WHITE);
		txtSpring.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtSpring.setColumns(10);
		txtSpring.setBorder(null);
		txtSpring.setBackground(new Color(36, 47, 65));
		txtSpring.setBounds(109, 244, 115, 20);
		panel_2.add(txtSpring);
		
		textField_1 = new JTextField();
		textField_1.setText("500000");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(36, 47, 65));
		textField_1.setBounds(234, 244, 100, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("25/01/2017");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(36, 47, 65));
		textField_2.setBounds(344, 244, 100, 20);
		panel_2.add(textField_2);
		
		txtFall = new JTextField();
		txtFall.setText("September");
		txtFall.setForeground(Color.WHITE);
		txtFall.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtFall.setColumns(10);
		txtFall.setBorder(null);
		txtFall.setBackground(new Color(36, 47, 65));
		txtFall.setBounds(109, 275, 115, 20);
		panel_2.add(txtFall);
		
		textField_4 = new JTextField();
		textField_4.setText("50000");
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(36, 47, 65));
		textField_4.setBounds(234, 275, 100, 20);
		panel_2.add(textField_4);
		
		txtNotPaid = new JTextField();
		txtNotPaid.setText("Not Paid");
		txtNotPaid.setForeground(Color.WHITE);
		txtNotPaid.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtNotPaid.setColumns(10);
		txtNotPaid.setBorder(null);
		txtNotPaid.setBackground(new Color(36, 47, 65));
		txtNotPaid.setBounds(344, 275, 100, 20);
		panel_2.add(txtNotPaid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.setBackground(SystemColor.menu);
		btnUpdate.setBounds(454, 243, 130, 20);
		panel_2.add(btnUpdate);
		
		JButton button = new JButton("Update");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button.setBackground(SystemColor.menu);
		button.setBounds(454, 274, 130, 20);
		panel_2.add(button);
		
		
		
		
		
		
		
		
	}
}
