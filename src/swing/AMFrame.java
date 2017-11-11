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
import javax.swing.JTextArea;
import java.awt.SystemColor;


public class AMFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtFirst;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AMFrame frame = new AMFrame();
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
	public AMFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel home = new JPanel();
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		home.setLayout(null);
		home.setBackground(Color.BLACK);
		
		JLabel label_7 = new JLabel("UserImage");
		label_7.setIcon(new ImageIcon(AMFrame.class.getResource("/images/user2.png")));
		label_7.setBounds(54, 71, 99, 152);
		home.add(label_7);
		
		JLabel label_8 = new JLabel("Profile");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_8.setBounds(69, 25, 93, 16);
		home.add(label_8);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 50, 61, 2);
		home.add(separator_1);
		
		JLabel label_9 = new JLabel("Ehtisham-Ul-Haq");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(54, 254, 175, 27);
		home.add(label_9);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(55, 285, 61, 2);
		home.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(55, 325, 61, 2);
		home.add(separator_3);
		
		JLabel label_10 = new JLabel("0900-78601");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_10.setBounds(54, 294, 175, 27);
		home.add(label_10);
		
		JLabel label_11 = new JLabel("princess_sid@gmail.com");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_11.setBounds(54, 336, 205, 27);
		home.add(label_11);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(55, 367, 61, 2);
		home.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(55, 407, 61, 2);
		home.add(separator_5);
		
		JLabel label_12 = new JLabel("H#666, Street 1, Road 5, Lahore");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_12.setBounds(54, 376, 239, 27);
		home.add(label_12);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(402, 407, 61, 2);
		home.add(separator_6);
		
		JLabel label_13 = new JLabel("Gender: M");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_13.setBounds(401, 376, 175, 27);
		home.add(label_13);
		
		JLabel label_14 = new JLabel("DOB: 15/11/1996");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_14.setBounds(401, 336, 175, 27);
		home.add(label_14);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(402, 367, 61, 2);
		home.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(402, 325, 61, 2);
		home.add(separator_8);
		
		JLabel label_15 = new JLabel("CNIC: 35201-8327761-9");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_15.setBounds(401, 294, 175, 27);
		home.add(label_15);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(402, 285, 61, 2);
		home.add(separator_9);
		
		JLabel label_16 = new JLabel("Emergency: 03224077810");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_16.setBounds(401, 254, 192, 27);
		home.add(label_16);
		
		home.setVisible(false);
		
		JScrollPane updateStudent = new JScrollPane();
		updateStudent.setBounds(249, 152, 704, 442);
		contentPane.add(updateStudent);
		updateStudent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		updateStudent.setBackground(Color.BLACK);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setPreferredSize(new Dimension(704, 550));
		panel_5.setBackground(Color.BLACK);
		updateStudent.setViewportView(panel_5);
		
		JLabel label_78 = new JLabel("Update Student Details");
		label_78.setForeground(Color.WHITE);
		label_78.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_78.setBounds(33, 11, 227, 35);
		panel_5.add(label_78);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setBounds(33, 48, 227, 2);
		panel_5.add(separator_19);
		
		JLabel label_79 = new JLabel("Name");
		label_79.setForeground(Color.WHITE);
		label_79.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_79.setBounds(33, 102, 54, 27);
		panel_5.add(label_79);
		
		textField_42 = new JTextField();
		textField_42.setText("Last");
		textField_42.setForeground(Color.WHITE);
		textField_42.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_42.setColumns(10);
		textField_42.setBorder(null);
		textField_42.setBackground(new Color(36, 47, 65));
		textField_42.setBounds(364, 106, 130, 20);
		panel_5.add(textField_42);
		
		JLabel label_80 = new JLabel("Date of Birth");
		label_80.setForeground(Color.WHITE);
		label_80.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_80.setBounds(33, 140, 99, 27);
		panel_5.add(label_80);
		
		textField_43 = new JTextField();
		textField_43.setForeground(Color.WHITE);
		textField_43.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_43.setColumns(10);
		textField_43.setBorder(null);
		textField_43.setBackground(new Color(36, 47, 65));
		textField_43.setBounds(364, 144, 40, 20);
		panel_5.add(textField_43);
		
		textField_44 = new JTextField();
		textField_44.setForeground(Color.WHITE);
		textField_44.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_44.setColumns(10);
		textField_44.setBorder(null);
		textField_44.setBackground(new Color(36, 47, 65));
		textField_44.setBounds(414, 144, 80, 20);
		panel_5.add(textField_44);
		
		JLabel label_81 = new JLabel("Phone");
		label_81.setForeground(Color.WHITE);
		label_81.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_81.setBounds(33, 178, 54, 27);
		panel_5.add(label_81);
		
		textField_45 = new JTextField();
		textField_45.setForeground(Color.WHITE);
		textField_45.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_45.setColumns(10);
		textField_45.setBorder(null);
		textField_45.setBackground(new Color(36, 47, 65));
		textField_45.setBounds(191, 182, 154, 20);
		panel_5.add(textField_45);
		
		JLabel label_82 = new JLabel("Email");
		label_82.setForeground(Color.WHITE);
		label_82.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_82.setBounds(33, 214, 54, 27);
		panel_5.add(label_82);
		
		textField_46 = new JTextField();
		textField_46.setForeground(Color.WHITE);
		textField_46.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_46.setColumns(10);
		textField_46.setBorder(null);
		textField_46.setBackground(new Color(36, 47, 65));
		textField_46.setBounds(191, 218, 154, 20);
		panel_5.add(textField_46);
		
		JLabel label_83 = new JLabel("CNIC");
		label_83.setForeground(Color.WHITE);
		label_83.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_83.setBounds(33, 252, 54, 27);
		panel_5.add(label_83);
		
		textField_47 = new JTextField();
		textField_47.setForeground(Color.WHITE);
		textField_47.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_47.setColumns(10);
		textField_47.setBorder(null);
		textField_47.setBackground(new Color(36, 47, 65));
		textField_47.setBounds(191, 256, 154, 20);
		panel_5.add(textField_47);
		
		textField_48 = new JTextField();
		textField_48.setForeground(Color.WHITE);
		textField_48.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_48.setColumns(10);
		textField_48.setBorder(null);
		textField_48.setBackground(new Color(36, 47, 65));
		textField_48.setBounds(191, 295, 154, 20);
		panel_5.add(textField_48);
		
		JLabel label_84 = new JLabel("Gender");
		label_84.setForeground(Color.WHITE);
		label_84.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_84.setBounds(33, 328, 61, 27);
		panel_5.add(label_84);
		
		JLabel label_85 = new JLabel("Emergency Contact");
		label_85.setForeground(Color.WHITE);
		label_85.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_85.setBounds(33, 290, 148, 27);
		panel_5.add(label_85);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setForeground(Color.BLACK);
		comboBox_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_19.setBorder(null);
		comboBox_19.setBackground(Color.WHITE);
		comboBox_19.setBounds(191, 331, 154, 20);
		panel_5.add(comboBox_19);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBounds(191, 145, 154, 20);
		panel_5.add(comboBox_20);
		
		textField_49 = new JTextField();
		textField_49.setText("First");
		textField_49.setForeground(Color.WHITE);
		textField_49.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_49.setColumns(10);
		textField_49.setBorder(null);
		textField_49.setBackground(new Color(36, 47, 65));
		textField_49.setBounds(191, 105, 154, 22);
		panel_5.add(textField_49);
		
		JLabel label_86 = new JLabel("Address");
		label_86.setForeground(Color.WHITE);
		label_86.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_86.setBounds(33, 366, 61, 27);
		panel_5.add(label_86);
		
		textField_50 = new JTextField();
		textField_50.setForeground(Color.WHITE);
		textField_50.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_50.setColumns(10);
		textField_50.setBorder(null);
		textField_50.setBackground(new Color(36, 47, 65));
		textField_50.setBounds(191, 371, 303, 20);
		panel_5.add(textField_50);
		
		JLabel label_87 = new JLabel("School");
		label_87.setForeground(Color.WHITE);
		label_87.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_87.setBounds(33, 404, 61, 27);
		panel_5.add(label_87);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setForeground(Color.BLACK);
		comboBox_21.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_21.setBorder(null);
		comboBox_21.setBackground(Color.WHITE);
		comboBox_21.setBounds(191, 409, 154, 20);
		panel_5.add(comboBox_21);
		
		JButton button_15 = new JButton("Upload Photo");
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_15.setBackground(new Color(36, 47, 65));
		button_15.setBounds(191, 447, 130, 23);
		panel_5.add(button_15);
		
		JButton button_16 = new JButton("Update");
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_16.setBackground(new Color(36, 47, 65));
		button_16.setBounds(191, 485, 130, 23);
		panel_5.add(button_16);
		
		JLabel label_88 = new JLabel("Roll Number");
		label_88.setForeground(Color.WHITE);
		label_88.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_88.setBounds(33, 69, 87, 27);
		panel_5.add(label_88);
		
		textField_51 = new JTextField();
		textField_51.setForeground(Color.WHITE);
		textField_51.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_51.setColumns(10);
		textField_51.setBorder(null);
		textField_51.setBackground(new Color(36, 47, 65));
		textField_51.setBounds(191, 72, 154, 22);
		panel_5.add(textField_51);
		
		JButton button_17 = new JButton("Search");
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_17.setBackground(new Color(36, 47, 65));
		button_17.setBounds(364, 73, 130, 23);
		panel_5.add(button_17);
		
		JPanel updateSection = new JPanel();
		updateSection.setBounds(249, 152, 704, 442);
		contentPane.add(updateSection);
		updateSection.setLayout(null);
		updateSection.setPreferredSize(new Dimension(704, 550));
		updateSection.setBackground(Color.BLACK);
		
		JLabel label_22 = new JLabel("Update Section");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_22.setBounds(33, 11, 154, 35);
		updateSection.add(label_22);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(33, 48, 154, 2);
		updateSection.add(separator_11);
		
		JLabel label_23 = new JLabel("Code");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_23.setBounds(33, 102, 54, 27);
		updateSection.add(label_23);
		
		JLabel label_24 = new JLabel("Section");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_24.setBounds(33, 140, 54, 27);
		updateSection.add(label_24);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(36, 47, 65));
		textField_1.setBounds(191, 106, 154, 20);
		updateSection.add(textField_1);
		
		JLabel label_25 = new JLabel("Faculty Member");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_25.setBounds(33, 180, 154, 25);
		updateSection.add(label_25);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(36, 47, 65));
		textField_2.setBounds(191, 220, 154, 20);
		updateSection.add(textField_2);
		
		JLabel label_26 = new JLabel("Max Seats");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_26.setBounds(33, 216, 104, 27);
		updateSection.add(label_26);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_4.setBorder(null);
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(191, 182, 154, 20);
		updateSection.add(comboBox_4);
		
		JButton button_1 = new JButton("Update Course Section");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_1.setBackground(new Color(36, 47, 65));
		button_1.setBounds(164, 296, 227, 23);
		updateSection.add(button_1);
		
		JButton button_2 = new JButton("Search");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_2.setBackground(new Color(36, 47, 65));
		button_2.setBounds(405, 106, 89, 23);
		updateSection.add(button_2);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setForeground(Color.BLACK);
		comboBox_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_5.setBorder(null);
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(191, 143, 154, 20);
		updateSection.add(comboBox_5);
		updateSection.setVisible(false);
		
		JPanel updateSchool = new JPanel();
		updateSchool.setBounds(249, 153, 704, 442);
		contentPane.add(updateSchool);
		updateSchool.setLayout(null);
		updateSchool.setPreferredSize(new Dimension(704, 550));
		updateSchool.setBackground(Color.BLACK);
		
		JLabel label_75 = new JLabel("Update School");
		label_75.setForeground(Color.WHITE);
		label_75.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_75.setBounds(33, 11, 213, 35);
		updateSchool.add(label_75);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setBounds(33, 48, 154, 2);
		updateSchool.add(separator_18);
		
		textField_41 = new JTextField();
		textField_41.setForeground(Color.WHITE);
		textField_41.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_41.setColumns(10);
		textField_41.setBorder(null);
		textField_41.setBackground(new Color(36, 47, 65));
		textField_41.setBounds(206, 152, 154, 20);
		updateSchool.add(textField_41);
		
		JButton button_14 = new JButton("Update");
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_14.setBackground(new Color(36, 47, 65));
		button_14.setBounds(73, 229, 227, 23);
		updateSchool.add(button_14);
		
		JLabel label_76 = new JLabel("Updated Name");
		label_76.setForeground(Color.WHITE);
		label_76.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_76.setBounds(33, 148, 122, 27);
		updateSchool.add(label_76);
		
		JLabel label_77 = new JLabel("School");
		label_77.setForeground(Color.WHITE);
		label_77.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_77.setBounds(33, 108, 122, 27);
		updateSchool.add(label_77);
		
		JComboBox comboBox_18 = new JComboBox();
		comboBox_18.setBounds(206, 111, 138, 22);
		updateSchool.add(comboBox_18);
		
		JPanel updateCourse = new JPanel();
		updateCourse.setBounds(249, 152, 704, 442);
		contentPane.add(updateCourse);
		updateCourse.setLayout(null);
		updateCourse.setPreferredSize(new Dimension(704, 550));
		updateCourse.setBackground(Color.BLACK);
		
		JScrollPane updateFaculty = new JScrollPane();
		updateFaculty.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		updateFaculty.setBackground(Color.BLACK);
		updateFaculty.setBounds(0, 0, 704, 442);
		updateCourse.add(updateFaculty);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(704, 600));
		panel_4.setBackground(Color.BLACK);
		updateFaculty.setViewportView(panel_4);
		
		JLabel label_61 = new JLabel("Update Faculty Details");
		label_61.setForeground(Color.WHITE);
		label_61.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_61.setBounds(33, 11, 227, 35);
		panel_4.add(label_61);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBounds(33, 48, 227, 2);
		panel_4.add(separator_17);
		
		JLabel label_62 = new JLabel("Name");
		label_62.setForeground(Color.WHITE);
		label_62.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_62.setBounds(33, 102, 54, 27);
		panel_4.add(label_62);
		
		textField_30 = new JTextField();
		textField_30.setText("Mustafa");
		textField_30.setForeground(Color.WHITE);
		textField_30.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_30.setColumns(10);
		textField_30.setBorder(null);
		textField_30.setBackground(new Color(36, 47, 65));
		textField_30.setBounds(364, 106, 130, 20);
		panel_4.add(textField_30);
		
		JLabel label_63 = new JLabel("Date of Birth");
		label_63.setForeground(Color.WHITE);
		label_63.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_63.setBounds(33, 140, 99, 27);
		panel_4.add(label_63);
		
		textField_31 = new JTextField();
		textField_31.setText("12");
		textField_31.setForeground(Color.WHITE);
		textField_31.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_31.setColumns(10);
		textField_31.setBorder(null);
		textField_31.setBackground(new Color(36, 47, 65));
		textField_31.setBounds(364, 144, 40, 20);
		panel_4.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setText("1980");
		textField_32.setForeground(Color.WHITE);
		textField_32.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_32.setColumns(10);
		textField_32.setBorder(null);
		textField_32.setBackground(new Color(36, 47, 65));
		textField_32.setBounds(414, 144, 80, 20);
		panel_4.add(textField_32);
		
		JLabel label_64 = new JLabel("Phone");
		label_64.setForeground(Color.WHITE);
		label_64.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_64.setBounds(33, 178, 54, 27);
		panel_4.add(label_64);
		
		textField_33 = new JTextField();
		textField_33.setText("+923123456789");
		textField_33.setForeground(Color.WHITE);
		textField_33.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_33.setColumns(10);
		textField_33.setBorder(null);
		textField_33.setBackground(new Color(36, 47, 65));
		textField_33.setBounds(191, 182, 154, 20);
		panel_4.add(textField_33);
		
		JLabel label_65 = new JLabel("Email");
		label_65.setForeground(Color.WHITE);
		label_65.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_65.setBounds(33, 214, 54, 27);
		panel_4.add(label_65);
		
		textField_34 = new JTextField();
		textField_34.setText("ahmad.mustafa@myschool.com");
		textField_34.setForeground(Color.WHITE);
		textField_34.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_34.setColumns(10);
		textField_34.setBorder(null);
		textField_34.setBackground(new Color(36, 47, 65));
		textField_34.setBounds(191, 214, 154, 20);
		panel_4.add(textField_34);
		
		JLabel label_66 = new JLabel("CNIC");
		label_66.setForeground(Color.WHITE);
		label_66.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_66.setBounds(33, 252, 54, 27);
		panel_4.add(label_66);
		
		textField_35 = new JTextField();
		textField_35.setText("12345-6789123-4");
		textField_35.setForeground(Color.WHITE);
		textField_35.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_35.setColumns(10);
		textField_35.setBorder(null);
		textField_35.setBackground(new Color(36, 47, 65));
		textField_35.setBounds(191, 256, 154, 20);
		panel_4.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("+923123456788");
		textField_36.setForeground(Color.WHITE);
		textField_36.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_36.setColumns(10);
		textField_36.setBorder(null);
		textField_36.setBackground(new Color(36, 47, 65));
		textField_36.setBounds(191, 295, 154, 20);
		panel_4.add(textField_36);
		
		JLabel label_67 = new JLabel("Gender");
		label_67.setForeground(Color.WHITE);
		label_67.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_67.setBounds(33, 328, 61, 27);
		panel_4.add(label_67);
		
		JLabel label_68 = new JLabel("Emergency Contact");
		label_68.setForeground(Color.WHITE);
		label_68.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_68.setBounds(33, 290, 148, 27);
		panel_4.add(label_68);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setForeground(Color.BLACK);
		comboBox_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_14.setBorder(null);
		comboBox_14.setBackground(Color.WHITE);
		comboBox_14.setBounds(191, 331, 154, 20);
		panel_4.add(comboBox_14);
		
		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.addItem("HAHA0");
		//comboBox_15.setSelectedIndex(5);
		comboBox_15.setBounds(191, 145, 154, 20);
		panel_4.add(comboBox_15);
		
		textField_37 = new JTextField();
		textField_37.setText("Ahmad");
		textField_37.setForeground(Color.WHITE);
		textField_37.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_37.setColumns(10);
		textField_37.setBorder(null);
		textField_37.setBackground(new Color(36, 47, 65));
		textField_37.setBounds(191, 105, 154, 22);
		panel_4.add(textField_37);
		
		JLabel label_69 = new JLabel("Address");
		label_69.setForeground(Color.WHITE);
		label_69.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_69.setBounds(33, 366, 61, 27);
		panel_4.add(label_69);
		
		textField_38 = new JTextField();
		textField_38.setText("test addr");
		textField_38.setForeground(Color.WHITE);
		textField_38.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_38.setColumns(10);
		textField_38.setBorder(null);
		textField_38.setBackground(new Color(36, 47, 65));
		textField_38.setBounds(191, 371, 303, 20);
		panel_4.add(textField_38);
		
		JLabel label_70 = new JLabel("School");
		label_70.setForeground(Color.WHITE);
		label_70.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_70.setBounds(33, 404, 61, 27);
		panel_4.add(label_70);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setForeground(Color.BLACK);
		comboBox_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_16.setBorder(null);
		comboBox_16.setBackground(Color.WHITE);
		comboBox_16.setBounds(191, 409, 154, 20);
		panel_4.add(comboBox_16);
		
		JLabel label_71 = new JLabel("Picture");
		label_71.setForeground(Color.WHITE);
		label_71.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_71.setBounds(33, 447, 61, 27);
		panel_4.add(label_71);
		
		JButton button_11 = new JButton("Upload Photo");
		button_11.setForeground(Color.BLACK);
		button_11.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_11.setBackground(new Color(36, 47, 65));
		button_11.setBounds(191, 447, 130, 23);
		panel_4.add(button_11);
		
		JLabel label_72 = new JLabel("Degrees");
		label_72.setForeground(Color.WHITE);
		label_72.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_72.setBounds(33, 485, 61, 27);
		panel_4.add(label_72);
		
		textField_39 = new JTextField();
		textField_39.setForeground(Color.WHITE);
		textField_39.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_39.setColumns(10);
		textField_39.setBorder(null);
		textField_39.setBackground(new Color(36, 47, 65));
		textField_39.setBounds(191, 485, 303, 20);
		panel_4.add(textField_39);
		
		JLabel label_73 = new JLabel("Position");
		label_73.setForeground(Color.WHITE);
		label_73.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_73.setBounds(33, 523, 61, 27);
		panel_4.add(label_73);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setForeground(Color.BLACK);
		comboBox_17.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_17.setBorder(null);
		comboBox_17.setBackground(Color.WHITE);
		comboBox_17.setBounds(191, 523, 154, 20);
		panel_4.add(comboBox_17);
		
		JButton button_12 = new JButton("Update");
		button_12.setForeground(Color.BLACK);
		button_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_12.setBackground(new Color(36, 47, 65));
		button_12.setBounds(191, 561, 130, 23);
		panel_4.add(button_12);
		
		JLabel label_74 = new JLabel("Search Employee by ID");
		label_74.setForeground(Color.WHITE);
		label_74.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_74.setBounds(54, 60, 179, 17);
		panel_4.add(label_74);
		
		textField_40 = new JTextField();
		textField_40.setText("1234");
		textField_40.setForeground(Color.WHITE);
		textField_40.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_40.setColumns(10);
		textField_40.setBorder(null);
		textField_40.setBackground(new Color(36, 47, 65));
		textField_40.setBounds(245, 58, 282, 22);
		panel_4.add(textField_40);
		
		JButton button_13 = new JButton("Search");
		button_13.setForeground(Color.BLACK);
		button_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_13.setBackground(new Color(36, 47, 65));
		button_13.setBounds(539, 59, 130, 23);
		panel_4.add(button_13);
		
		JLabel label_55 = new JLabel("Update Course");
		label_55.setForeground(Color.WHITE);
		label_55.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_55.setBounds(33, 11, 154, 35);
		updateCourse.add(label_55);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(33, 48, 154, 2);
		updateCourse.add(separator_16);
		
		JLabel label_56 = new JLabel("Code");
		label_56.setForeground(Color.WHITE);
		label_56.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_56.setBounds(33, 102, 54, 27);
		updateCourse.add(label_56);
		
		JLabel label_57 = new JLabel("Name");
		label_57.setForeground(Color.WHITE);
		label_57.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_57.setBounds(33, 140, 54, 27);
		updateCourse.add(label_57);
		
		textField_27 = new JTextField();
		textField_27.setForeground(Color.WHITE);
		textField_27.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_27.setColumns(10);
		textField_27.setBorder(null);
		textField_27.setBackground(new Color(36, 47, 65));
		textField_27.setBounds(191, 106, 154, 20);
		updateCourse.add(textField_27);
		
		JLabel label_58 = new JLabel("Credit Hours");
		label_58.setForeground(Color.WHITE);
		label_58.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_58.setBounds(33, 178, 99, 27);
		updateCourse.add(label_58);
		
		textField_28 = new JTextField();
		textField_28.setForeground(Color.WHITE);
		textField_28.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_28.setColumns(10);
		textField_28.setBorder(null);
		textField_28.setBackground(new Color(36, 47, 65));
		textField_28.setBounds(191, 182, 154, 20);
		updateCourse.add(textField_28);
		
		JLabel label_59 = new JLabel("Description");
		label_59.setForeground(Color.WHITE);
		label_59.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_59.setBounds(33, 252, 82, 27);
		updateCourse.add(label_59);
		
		textField_29 = new JTextField();
		textField_29.setForeground(Color.WHITE);
		textField_29.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_29.setColumns(10);
		textField_29.setBorder(null);
		textField_29.setBackground(new Color(36, 47, 65));
		textField_29.setBounds(191, 143, 303, 22);
		updateCourse.add(textField_29);
		
		JLabel label_60 = new JLabel("School");
		label_60.setForeground(Color.WHITE);
		label_60.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_60.setBounds(33, 216, 61, 27);
		updateCourse.add(label_60);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setForeground(Color.BLACK);
		comboBox_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_13.setBorder(null);
		comboBox_13.setBackground(Color.WHITE);
		comboBox_13.setBounds(191, 220, 154, 20);
		updateCourse.add(comboBox_13);
		
		JButton button_9 = new JButton("Update Course");
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_9.setBackground(new Color(36, 47, 65));
		button_9.setBounds(191, 348, 154, 23);
		updateCourse.add(button_9);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textArea_1.setBorder(null);
		textArea_1.setBackground(new Color(36, 47, 65));
		textArea_1.setBounds(191, 255, 303, 82);
		updateCourse.add(textArea_1);
		
		JButton button_10 = new JButton("Search");
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_10.setBackground(new Color(36, 47, 65));
		button_10.setBounds(405, 106, 89, 23);
		updateCourse.add(button_10);
		
		JPanel removeStudent = new JPanel();
		removeStudent.setBounds(249, 152, 704, 442);
		contentPane.add(removeStudent);
		removeStudent.setLayout(null);
		removeStudent.setPreferredSize(new Dimension(704, 550));
		removeStudent.setBackground(Color.BLACK);
		
		JLabel label_53 = new JLabel("Remove Student");
		label_53.setForeground(Color.WHITE);
		label_53.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_53.setBounds(33, 11, 170, 35);
		removeStudent.add(label_53);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(33, 48, 170, 2);
		removeStudent.add(separator_15);
		
		JLabel label_54 = new JLabel("Roll Number");
		label_54.setForeground(Color.WHITE);
		label_54.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_54.setBounds(104, 96, 87, 27);
		removeStudent.add(label_54);
		
		textField_25 = new JTextField();
		textField_25.setText("15L-1234");
		textField_25.setForeground(Color.WHITE);
		textField_25.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_25.setColumns(10);
		textField_25.setBorder(null);
		textField_25.setBackground(new Color(36, 47, 65));
		textField_25.setBounds(218, 100, 198, 20);
		removeStudent.add(textField_25);
		
		JButton button_8 = new JButton("Delete");
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_8.setBackground(SystemColor.menu);
		button_8.setBounds(442, 98, 130, 23);
		removeStudent.add(button_8);
		
		textField_26 = new JTextField();
		textField_26.setText("Student Deleted Successfully");
		textField_26.setForeground(Color.RED);
		textField_26.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_26.setColumns(10);
		textField_26.setBorder(null);
		textField_26.setBackground(Color.BLACK);
		textField_26.setBounds(218, 66, 198, 20);
		removeStudent.add(textField_26);
		
		JScrollPane removeCourse = new JScrollPane();
		removeCourse.setBounds(249, 152, 704, 442);
		contentPane.add(removeCourse);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(704, 430));
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		removeCourse.setViewportView(panel_3);
		
		JLabel label_50 = new JLabel("Remove Course");
		label_50.setForeground(Color.WHITE);
		label_50.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_50.setBounds(33, 11, 227, 35);
		panel_3.add(label_50);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(33, 48, 227, 2);
		panel_3.add(separator_14);
		
		JLabel label_51 = new JLabel("Search Course by ID");
		label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_51.setBounds(54, 60, 179, 17);
		panel_3.add(label_51);
		
		textField_24 = new JTextField();
		textField_24.setText("CS 101");
		textField_24.setForeground(Color.WHITE);
		textField_24.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_24.setColumns(10);
		textField_24.setBorder(null);
		textField_24.setBackground(new Color(36, 47, 65));
		textField_24.setBounds(245, 58, 282, 22);
		panel_3.add(textField_24);
		
		JButton button_7 = new JButton("Search");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_7.setBackground(new Color(36, 47, 65));
		button_7.setBounds(539, 59, 130, 23);
		panel_3.add(button_7);
		
		JLabel label_52 = new JLabel("Do you want to remove \"Introduction to Computing\"?");
		label_52.setForeground(Color.WHITE);
		label_52.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_52.setBounds(167, 171, 399, 17);
		panel_3.add(label_52);
		
		JPanel removeSection = new JPanel();
		removeSection.setBounds(249, 152, 704, 442);
		contentPane.add(removeSection);
		removeSection.setLayout(null);
		removeSection.setPreferredSize(new Dimension(704, 550));
		removeSection.setBackground(Color.BLACK);
		
		JLabel label_17 = new JLabel("Remove Section");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_17.setBounds(33, 11, 213, 35);
		removeSection.add(label_17);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(33, 48, 154, 2);
		removeSection.add(separator_10);
		
		JLabel label_18 = new JLabel("Code");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_18.setBounds(33, 155, 54, 27);
		removeSection.add(label_18);
		
		JLabel label_19 = new JLabel("Section");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_19.setBounds(33, 225, 54, 27);
		removeSection.add(label_19);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(36, 47, 65));
		textField.setBounds(191, 159, 154, 20);
		removeSection.add(textField);
		
		JButton button = new JButton("Remove Section");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button.setBackground(new Color(36, 47, 65));
		button.setBounds(95, 320, 227, 23);
		removeSection.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(191, 232, 154, 20);
		removeSection.add(comboBox);
		
		JLabel label_20 = new JLabel("School");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_20.setBounds(33, 112, 54, 27);
		removeSection.add(label_20);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(191, 115, 154, 20);
		removeSection.add(comboBox_1);
		
		JLabel label_21 = new JLabel("Semester");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_21.setBounds(33, 185, 89, 27);
		removeSection.add(label_21);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_3.setBorder(null);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(191, 192, 154, 20);
		removeSection.add(comboBox_3);
		removeSection.setVisible(false);
		
		JScrollPane registerStudent = new JScrollPane();
		registerStudent.setBounds(249, 152, 704, 442);
		contentPane.add(registerStudent);
		registerStudent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		registerStudent.setBackground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(704, 550));
		panel_1.setBackground(Color.BLACK);
		registerStudent.setViewportView(panel_1);
		
		JLabel label_40 = new JLabel("Student Registration");
		label_40.setForeground(Color.WHITE);
		label_40.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_40.setBounds(33, 11, 212, 35);
		panel_1.add(label_40);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(33, 48, 197, 2);
		panel_1.add(separator_13);
		
		JLabel label_41 = new JLabel("Name");
		label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_41.setBounds(33, 102, 54, 27);
		panel_1.add(label_41);
		
		textField_15 = new JTextField();
		textField_15.setText("Last");
		textField_15.setForeground(Color.WHITE);
		textField_15.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_15.setColumns(10);
		textField_15.setBorder(null);
		textField_15.setBackground(new Color(36, 47, 65));
		textField_15.setBounds(364, 106, 130, 20);
		panel_1.add(textField_15);
		
		JLabel label_42 = new JLabel("Date of Birth");
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_42.setBounds(33, 140, 99, 27);
		panel_1.add(label_42);
		
		textField_16 = new JTextField();
		textField_16.setForeground(Color.WHITE);
		textField_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_16.setColumns(10);
		textField_16.setBorder(null);
		textField_16.setBackground(new Color(36, 47, 65));
		textField_16.setBounds(364, 144, 40, 20);
		panel_1.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setForeground(Color.WHITE);
		textField_17.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_17.setColumns(10);
		textField_17.setBorder(null);
		textField_17.setBackground(new Color(36, 47, 65));
		textField_17.setBounds(414, 144, 80, 20);
		panel_1.add(textField_17);
		
		JLabel label_43 = new JLabel("Phone");
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_43.setBounds(33, 178, 54, 27);
		panel_1.add(label_43);
		
		textField_18 = new JTextField();
		textField_18.setForeground(Color.WHITE);
		textField_18.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(null);
		textField_18.setBackground(new Color(36, 47, 65));
		textField_18.setBounds(191, 182, 154, 20);
		panel_1.add(textField_18);
		
		JLabel label_44 = new JLabel("Email");
		label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_44.setBounds(33, 214, 54, 27);
		panel_1.add(label_44);
		
		textField_19 = new JTextField();
		textField_19.setForeground(Color.WHITE);
		textField_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_19.setColumns(10);
		textField_19.setBorder(null);
		textField_19.setBackground(new Color(36, 47, 65));
		textField_19.setBounds(191, 218, 154, 20);
		panel_1.add(textField_19);
		
		JLabel label_45 = new JLabel("CNIC");
		label_45.setForeground(Color.WHITE);
		label_45.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_45.setBounds(33, 252, 54, 27);
		panel_1.add(label_45);
		
		textField_20 = new JTextField();
		textField_20.setForeground(Color.WHITE);
		textField_20.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_20.setColumns(10);
		textField_20.setBorder(null);
		textField_20.setBackground(new Color(36, 47, 65));
		textField_20.setBounds(191, 256, 154, 20);
		panel_1.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setForeground(Color.WHITE);
		textField_21.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_21.setColumns(10);
		textField_21.setBorder(null);
		textField_21.setBackground(new Color(36, 47, 65));
		textField_21.setBounds(191, 295, 154, 20);
		panel_1.add(textField_21);
		
		JLabel label_46 = new JLabel("Gender");
		label_46.setForeground(Color.WHITE);
		label_46.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_46.setBounds(33, 328, 61, 27);
		panel_1.add(label_46);
		
		JLabel label_47 = new JLabel("Emergency Contact");
		label_47.setForeground(Color.WHITE);
		label_47.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_47.setBounds(33, 290, 148, 27);
		panel_1.add(label_47);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setForeground(Color.BLACK);
		comboBox_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_10.setBorder(null);
		comboBox_10.setBackground(Color.WHITE);
		comboBox_10.setBounds(191, 331, 154, 20);
		panel_1.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(191, 145, 154, 20);
		panel_1.add(comboBox_11);
		
		textField_22 = new JTextField();
		textField_22.setText("First");
		textField_22.setForeground(Color.WHITE);
		textField_22.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_22.setColumns(10);
		textField_22.setBorder(null);
		textField_22.setBackground(new Color(36, 47, 65));
		textField_22.setBounds(191, 105, 154, 22);
		panel_1.add(textField_22);
		
		JLabel label_48 = new JLabel("Address");
		label_48.setForeground(Color.WHITE);
		label_48.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_48.setBounds(33, 366, 61, 27);
		panel_1.add(label_48);
		
		textField_23 = new JTextField();
		textField_23.setForeground(Color.WHITE);
		textField_23.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_23.setColumns(10);
		textField_23.setBorder(null);
		textField_23.setBackground(new Color(36, 47, 65));
		textField_23.setBounds(191, 371, 303, 20);
		panel_1.add(textField_23);
		
		JLabel label_49 = new JLabel("School");
		label_49.setForeground(Color.WHITE);
		label_49.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_49.setBounds(33, 404, 61, 27);
		panel_1.add(label_49);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setForeground(Color.BLACK);
		comboBox_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_12.setBorder(null);
		comboBox_12.setBackground(Color.WHITE);
		comboBox_12.setBounds(191, 409, 154, 20);
		panel_1.add(comboBox_12);
		
		JButton button_5 = new JButton("Upload Photo");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_5.setBackground(new Color(36, 47, 65));
		button_5.setBounds(191, 447, 130, 23);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("Register");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_6.setBackground(new Color(36, 47, 65));
		button_6.setBounds(191, 485, 130, 23);
		panel_1.add(button_6);
		
		JScrollPane registerFaculty = new JScrollPane();
		registerFaculty.setBounds(249, 152, 704, 442);
		contentPane.add(registerFaculty);
		registerFaculty.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		registerFaculty.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 600));
		panel.setBackground(Color.BLACK);
		registerFaculty.setViewportView(panel);
		
		JLabel label_27 = new JLabel("Faculty Registration");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_27.setBounds(33, 11, 212, 35);
		panel.add(label_27);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(33, 48, 197, 2);
		panel.add(separator_12);
		
		JLabel label_28 = new JLabel("Name");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_28.setBounds(33, 102, 54, 27);
		panel.add(label_28);
		
		textField_3 = new JTextField();
		textField_3.setText("Last");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(36, 47, 65));
		textField_3.setBounds(364, 106, 130, 20);
		panel.add(textField_3);
		
		JLabel label_29 = new JLabel("Date of Birth");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_29.setBounds(33, 140, 99, 27);
		panel.add(label_29);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(36, 47, 65));
		textField_6.setBounds(364, 144, 40, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(36, 47, 65));
		textField_7.setBounds(414, 144, 80, 20);
		panel.add(textField_7);
		
		JLabel label_30 = new JLabel("Phone");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_30.setBounds(33, 178, 54, 27);
		panel.add(label_30);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(36, 47, 65));
		textField_8.setBounds(191, 182, 154, 20);
		panel.add(textField_8);
		
		JLabel label_31 = new JLabel("Email");
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_31.setBounds(33, 214, 54, 27);
		panel.add(label_31);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(new Color(36, 47, 65));
		textField_9.setBounds(191, 218, 154, 20);
		panel.add(textField_9);
		
		JLabel label_32 = new JLabel("CNIC");
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_32.setBounds(33, 252, 54, 27);
		panel.add(label_32);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(new Color(36, 47, 65));
		textField_10.setBounds(191, 256, 154, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(new Color(36, 47, 65));
		textField_11.setBounds(191, 295, 154, 20);
		panel.add(textField_11);
		
		JLabel label_33 = new JLabel("Gender");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_33.setBounds(33, 328, 61, 27);
		panel.add(label_33);
		
		JLabel label_34 = new JLabel("Emergency Contact");
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_34.setBounds(33, 290, 148, 27);
		panel.add(label_34);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setForeground(Color.BLACK);
		comboBox_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_6.setBorder(null);
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(191, 331, 154, 20);
		panel.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(191, 145, 154, 20);
		panel.add(comboBox_7);
		
		textField_12 = new JTextField();
		textField_12.setText("First");
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_12.setColumns(10);
		textField_12.setBorder(null);
		textField_12.setBackground(new Color(36, 47, 65));
		textField_12.setBounds(191, 105, 154, 22);
		panel.add(textField_12);
		
		JLabel label_35 = new JLabel("Address");
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_35.setBounds(33, 366, 61, 27);
		panel.add(label_35);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.WHITE);
		textField_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_13.setColumns(10);
		textField_13.setBorder(null);
		textField_13.setBackground(new Color(36, 47, 65));
		textField_13.setBounds(191, 371, 303, 20);
		panel.add(textField_13);
		
		JLabel label_36 = new JLabel("School");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_36.setBounds(33, 404, 61, 27);
		panel.add(label_36);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setForeground(Color.BLACK);
		comboBox_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_8.setBorder(null);
		comboBox_8.setBackground(Color.WHITE);
		comboBox_8.setBounds(191, 409, 154, 20);
		panel.add(comboBox_8);
		
		JLabel label_37 = new JLabel("Picture");
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_37.setBounds(33, 447, 61, 27);
		panel.add(label_37);
		
		JButton button_3 = new JButton("Upload Photo");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_3.setBackground(new Color(36, 47, 65));
		button_3.setBounds(191, 447, 130, 23);
		panel.add(button_3);
		
		JLabel label_38 = new JLabel("Degrees");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_38.setBounds(33, 485, 61, 27);
		panel.add(label_38);
		
		textField_14 = new JTextField();
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_14.setColumns(10);
		textField_14.setBorder(null);
		textField_14.setBackground(new Color(36, 47, 65));
		textField_14.setBounds(191, 485, 303, 20);
		panel.add(textField_14);
		
		JLabel label_39 = new JLabel("Position");
		label_39.setForeground(Color.WHITE);
		label_39.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_39.setBounds(33, 523, 61, 27);
		panel.add(label_39);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setForeground(Color.BLACK);
		comboBox_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_9.setBorder(null);
		comboBox_9.setBackground(Color.WHITE);
		comboBox_9.setBounds(191, 523, 154, 20);
		panel.add(comboBox_9);
		
		JButton button_4 = new JButton("Register");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_4.setBackground(new Color(36, 47, 65));
		button_4.setBounds(191, 561, 130, 23);
		panel.add(button_4);
		
		JScrollPane addCourse = new JScrollPane();
		addCourse.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		addCourse.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(addCourse);
		addCourse.setBackground(Color.BLACK);
		addCourse.setBounds(249, 152, 704, 442);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(249, 152, 704, 442);
		addCourse.setViewportView(panel_2);
		panel_2.setPreferredSize(new Dimension(704, 550));
		panel_2.setLayout(null);
		
		JLabel lblProfile = new JLabel("Add Course");
		lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(33, 11, 123, 35);
		panel_2.add(lblProfile);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 48, 123, 2);
		panel_2.add(separator);
		
		JLabel lblName = new JLabel("Code");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(33, 102, 54, 27);
		panel_2.add(lblName);
		
		JLabel lblPhone = new JLabel("Name");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPhone.setBounds(33, 140, 54, 27);
		panel_2.add(lblPhone);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(36, 47, 65));
		textField_4.setBounds(191, 106, 154, 20);
		panel_2.add(textField_4);
		
		JLabel lblEmail = new JLabel("Credit Hours");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmail.setBounds(33, 178, 99, 27);
		panel_2.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(36, 47, 65));
		textField_5.setBounds(191, 182, 154, 20);
		panel_2.add(textField_5);
		
		JLabel lblCnic_1 = new JLabel("Description");
		lblCnic_1.setForeground(Color.WHITE);
		lblCnic_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic_1.setBounds(33, 252, 82, 27);
		panel_2.add(lblCnic_1);
		
		txtFirst = new JTextField();
		txtFirst.setForeground(Color.WHITE);
		txtFirst.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtFirst.setColumns(10);
		txtFirst.setBorder(null);
		txtFirst.setBackground(new Color(36, 47, 65));
		txtFirst.setBounds(191, 143, 303, 22);
		panel_2.add(txtFirst);
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool.setBounds(33, 216, 61, 27);
		panel_2.add(lblSchool);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Computer Science"}));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_2.setBorder(null);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(191, 220, 154, 20);
		panel_2.add(comboBox_2);
		
		JButton btnUploadPhoto = new JButton("Add Course");
		btnUploadPhoto.setForeground(Color.WHITE);
		btnUploadPhoto.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUploadPhoto.setBackground(new Color(36, 47, 65));
		btnUploadPhoto.setBounds(191, 348, 154, 23);
		panel_2.add(btnUploadPhoto);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textArea.setBorder(null);
		textArea.setBackground(new Color(36, 47, 65));
		textArea.setBounds(191, 255, 303, 82);
		panel_2.add(textArea);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(AMFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(AMFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(AMFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 258, 152);
		topPanel.add(label_6);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageFaculty = new JLabel("Manage Faculty");
		lblManageFaculty.setForeground(Color.WHITE);
		lblManageFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageFaculty.setBounds(57, 137, 182, 27);
		
		sidePanel.add(lblManageFaculty);
		
		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(57, 189, 182, 27);
		sidePanel.add(lblManageStudents);
		
		JLabel lblManageSections = new JLabel("Manage Sections");
		lblManageSections.setForeground(Color.WHITE);
		lblManageSections.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageSections.setBounds(57, 243, 182, 22);
		sidePanel.add(lblManageSections);
		
		JLabel lblManageCourses = new JLabel("Manage Courses");
		lblManageCourses.setForeground(Color.WHITE);
		lblManageCourses.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageCourses.setBounds(57, 295, 182, 27);
		sidePanel.add(lblManageCourses);
		
		JLabel lblManageRegistrations = new JLabel("Manage Registrations");
		lblManageRegistrations.setForeground(Color.WHITE);
		lblManageRegistrations.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageRegistrations.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageRegistrations);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AMFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 189, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(13, 137, 33, 32);
		sidePanel.add(label);
		label.setIcon(new ImageIcon(AMFrame.class.getResource("/images/faculty.png")));
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AMFrame.class.getResource("/images/course2.png")));
		label_3.setBounds(12, 295, 40, 32);
		sidePanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(AMFrame.class.getResource("/images/registration.png")));
		label_4.setBounds(12, 87, 40, 30);
		sidePanel.add(label_4);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(AMFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("Academic Manager");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AMFrame.class.getResource("/images/section2.png")));
		label_2.setBounds(12, 243, 33, 27);
		sidePanel.add(label_2);
		addCourse.setVisible(false);
		
		
		
		
		
		
	}
}
