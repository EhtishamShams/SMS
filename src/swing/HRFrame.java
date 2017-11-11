package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import java.awt.Dimension;

public class HRFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
	private ArrayList<Container> containers;

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
		
		if (a.equals("Manage Staff"))
		{
			containers.get(1).setVisible(true);
		}
		if (a.equals("Manage Offices"))
		{
			containers.get(4).setVisible(true);
		}
		if (a.equals("Manage Allotments"))
		{
			containers.get(3).setVisible(true);
		}
		if (a.equals("Home"))
		{
			containers.get(0).setVisible(true);
		}
	}
	/**
	 * Create the frame.
	 */
	public HRFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();
		
		JPanel topPanel = new JPanel();
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		JPanel home = new JPanel();
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
		
		JLabel lblEhtishamulhaq = new JLabel("Ehtisham-Ul-Haq");
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
		
		JLabel label_7 = new JLabel("0900-78601");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7.setBounds(70, 292, 175, 27);
		home.add(label_7);
		
		JLabel lblPrincessshamsgmailcom = new JLabel("princess_sid@gmail.com");
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
		
		JLabel lblHStreet = new JLabel("H#666, Street 1, Road 5, Lahore");
		lblHStreet.setForeground(Color.WHITE);
		lblHStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHStreet.setBounds(70, 374, 239, 27);
		home.add(lblHStreet);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(418, 405, 61, 2);
		home.add(separator_5);
		
		JLabel lblGenderM = new JLabel("Gender: M");
		lblGenderM.setForeground(Color.WHITE);
		lblGenderM.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGenderM.setBounds(417, 374, 175, 27);
		home.add(lblGenderM);
		
		JLabel lblDob = new JLabel("DOB: 15/11/1996");
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDob.setBounds(417, 334, 175, 27);
		home.add(lblDob);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(418, 365, 61, 2);
		home.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(418, 323, 61, 2);
		home.add(separator_7);
		
		JLabel lblCnic = new JLabel("CNIC: 35201-8327761-9");
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic.setBounds(417, 292, 175, 27);
		home.add(lblCnic);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(418, 283, 61, 2);
		home.add(separator_8);
		
		JLabel lblEmergency = new JLabel("Emergency: 03224077810");
		lblEmergency.setForeground(Color.WHITE);
		lblEmergency.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmergency.setBounds(417, 252, 192, 27);
		home.add(lblEmergency);
		//home.setVisible(false);
		home.setVisible(true);
		
		JScrollPane removeStaff = new JScrollPane();
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
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_34.setBounds(33, 11, 227, 35);
		panel_1.add(label_34);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(33, 48, 227, 2);
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
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_9.setBackground(new Color(36, 47, 65));
		button_9.setBounds(539, 59, 130, 23);
		panel_1.add(button_9);
		
		JLabel label_36 = new JLabel("Do you want to remove \"Bilal Qureshi\"?");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_36.setBounds(168, 171, 399, 17);
		panel_1.add(label_36);
		
		JButton button_10 = new JButton("YES");
		button_10.setBounds(180, 239, 117, 29);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("NO");
		button_11.setBounds(354, 239, 117, 29);
		panel_1.add(button_11);
		
		JScrollPane registerStaff = new JScrollPane();
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
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_8.setBackground(new Color(36, 47, 65));
		button_8.setBounds(191, 485, 130, 23);
		panel.add(button_8);
		
		JPanel manageAllotment = new JPanel();
		manageAllotment.setBounds(249, 152, 704, 442);
		contentPane.add(manageAllotment);
		manageAllotment.setLayout(null);
		manageAllotment.setOpaque(true);
		manageAllotment.setBackground(Color.BLACK);
		
		JLabel label_8 = new JLabel("Office Allotments\r\n\r\n");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_8.setBounds(41, 23, 246, 27);
		manageAllotment.add(label_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(41, 55, 225, 5);
		manageAllotment.add(separator_9);
		
		JLabel label_9 = new JLabel("Select Faculty:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(329, 107, 105, 27);
		manageAllotment.add(label_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(329, 129, 95, 5);
		manageAllotment.add(separator_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBox.setBounds(451, 109, 135, 23);
		manageAllotment.add(comboBox);
		
		JLabel label_10 = new JLabel("Office ID:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_10.setBounds(86, 107, 105, 27);
		manageAllotment.add(label_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(86, 129, 65, 2);
		manageAllotment.add(separator_11);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(174, 112, 74, 20);
		manageAllotment.add(textField);
		
		JButton button = new JButton("Add");
		button.setFont(new Font("Century Gothic", Font.BOLD, 11));
		button.setBounds(198, 171, 89, 23);
		manageAllotment.add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		button_1.setBounds(305, 171, 89, 23);
		manageAllotment.add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.setFont(new Font("Century Gothic", Font.BOLD, 11));
		button_2.setBounds(415, 171, 89, 23);
		manageAllotment.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Century Gothic", Font.BOLD, 11));
		scrollPane.setBounds(51, 237, 632, 181);
		manageAllotment.add(scrollPane);
		//manageAllotment.setVisible(false);
		
		JPanel addOffice = new JPanel();
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
		button_3.setFont(new Font("Century Gothic", Font.BOLD, 11));
		button_3.setBounds(304, 160, 89, 23);
		addOffice.add(button_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		scrollPane_1.setBounds(41, 222, 632, 181);
		addOffice.add(scrollPane_1);
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
		
		textField_3 = new JTextField();
		textField_3.setText("12");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(36, 47, 65));
		textField_3.setBounds(364, 144, 40, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("1980");
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(36, 47, 65));
		textField_4.setBounds(414, 144, 80, 20);
		panel_2.add(textField_4);
		
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
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("HAHA");
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(191, 145, 154, 20);
		panel_2.add(comboBox_2);
		
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
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_6.setBackground(new Color(36, 47, 65));
		button_6.setBounds(539, 59, 130, 23);
		panel_2.add(button_6);
		
		JScrollPane updateStaff = new JScrollPane();
		updateStaff.setBounds(249, 152, 704, 442);
		contentPane.add(updateStaff);
		updateStaff.setViewportView(panel_2);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageFaculty = new JLabel("Manage Offices");
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
		updateStaff.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		containers.add(home);
		containers.add(registerStaff);
		containers.add(removeStaff);
		containers.add(manageAllotment);
		containers.add(addOffice);
		containers.add(updateStaff);
		
		for (int i = 1; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		
	}
}
