package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.table.TableModel;

import backend.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FacFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Container> containers;
	private JPanel home;
	private JPanel manageAttendance;
	private JPanel updateAttendance;
	private JPanel addAttendance;
	private JPanel updateGrade;
	ArrayList<CourseSection> cs;
	CourseSection c;
	private JComboBox comboBox_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIManager.put("TableHeader.background", Color.black);
		UIManager.put("TableHeader.foreground", Color.white);
		UIManager.put("TableHeader.font", new Font("Century Gothic", Font.PLAIN, 15) );

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacFrame frame = new FacFrame();
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
		if (a.equals("Manage Attendance"))
		{
			containers.get(1).setVisible(true);
		}
		if (a.equals("Update Attendance"))
		{
			containers.get(2).setVisible(true);
		}
		if (a.equals("Add Attendance"))
		{
			containers.get(3).setVisible(true);
		}
		if (a.equals("Update Grades"))
		{
			containers.get(4).setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public FacFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();
		
		updateAttendance = new JPanel();
		updateAttendance.setLayout(null);
		updateAttendance.setPreferredSize(new Dimension(704, 430));
		updateAttendance.setForeground(Color.WHITE);
		updateAttendance.setBackground(Color.BLACK);
		updateAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(updateAttendance);
		
		JLabel label_3 = new JLabel("Select Section");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(133, 84, 156, 35);
		updateAttendance.add(label_3);
		
		JLabel label_15 = new JLabel("Select Date");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_15.setBounds(133, 176, 149, 35);
		updateAttendance.add(label_15);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(133, 118, 139, 2);
		updateAttendance.add(separator_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(133, 209, 139, 2);
		updateAttendance.add(separator_13);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("HAHA");
		comboBox_2.addItem("@@");
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int sectionIndex = comboBox_2.getSelectedIndex();
				System.out.println("HAHA");
//				c = cs.get(sectionIndex);
//				ArrayList<Date> dates = cs.getDatesOfAttendance();
//				for (int i = 0; i < dates.size(); i++)
//				{
//					comboBox_3.addItem(dates.getDate());
//				}
			}
		});
		comboBox_2.setBounds(305, 93, 156, 26);
		updateAttendance.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(305, 185, 156, 26);
		updateAttendance.add(comboBox_3);
		
		JLabel lblUpdateAttendance_1 = new JLabel("Update Attendance");
		lblUpdateAttendance_1.setForeground(Color.WHITE);
		lblUpdateAttendance_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateAttendance_1.setBounds(22, 13, 201, 35);
		updateAttendance.add(lblUpdateAttendance_1);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(22, 46, 201, 2);
		updateAttendance.add(separator_14);
		
		JButton btnShow = new JButton("Show");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] columnNames = {"Name",
		                "Roll Number",
		                "Status"};
				
				//ArrayList<Attendance> attn = getAttendancesAtDate(Date);
				
				//display all names, roll numbers and attendances in table
				
//				JTable table2 = new JTable();
//				DefaultTableModel dtm = new DefaultTableModel(0, 0);
//				dtm.setColumnIdentifiers(columnNames);
//				table2.setModel(dtm);
//				
//				JScrollPane scrollPane_3 = new JScrollPane(table2);
//				scrollPane_3.setForeground(Color.WHITE);
//				scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
//				scrollPane_3.setBackground(Color.WHITE);
//				scrollPane_3.setAlignmentX(0.0f);
//				scrollPane_3.setBounds(22, yTable, 629, 98);
//				updateAttendance.add(scrollPane_3);
				
				
				
//				for (int i = 0; i < attn.size(); i++)
//				{
//					String name = attn.getStudent.getName();
//					String rollNo = attn.getStudent.getRollNo();
//					String status = attn.getStatus();
//					dtm.addRow(new Object[] {rollNo, name, status});
//				}
				
			}
		});
		btnShow.setBounds(504, 184, 97, 25);
		updateAttendance.add(btnShow);
		
		updateGrade = new JPanel();
		updateGrade.setLayout(null);
		updateGrade.setPreferredSize(new Dimension(704, 430));
		updateGrade.setForeground(Color.WHITE);
		updateGrade.setBackground(Color.BLACK);
		updateGrade.setBounds(249, 152, 704, 442);
		contentPane.add(updateGrade);
		
		JLabel label_16 = new JLabel("Select Section");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_16.setBounds(133, 84, 156, 35);
		updateGrade.add(label_16);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(133, 118, 139, 2);
		updateGrade.add(separator_15);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(305, 93, 156, 26);
		updateGrade.add(comboBox_4);
		
		JLabel lblUpdateGrade = new JLabel("Update Grade");
		lblUpdateGrade.setForeground(Color.WHITE);
		lblUpdateGrade.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateGrade.setBounds(22, 13, 201, 35);
		updateGrade.add(lblUpdateGrade);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBounds(22, 46, 149, 2);
		updateGrade.add(separator_17);
		
		JButton button = new JButton("Update");
		button.setBounds(267, 332, 97, 25);
		updateGrade.add(button);
		
		JLabel lblSelectStudent = new JLabel("Select Student");
		lblSelectStudent.setForeground(Color.WHITE);
		lblSelectStudent.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectStudent.setBounds(133, 166, 182, 35);
		updateGrade.add(lblSelectStudent);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(133, 200, 139, 2);
		updateGrade.add(separator_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(305, 175, 156, 26);
		updateGrade.add(comboBox_5);
		
		JLabel lblSelectStudent_1 = new JLabel("Select Grade");
		lblSelectStudent_1.setForeground(Color.WHITE);
		lblSelectStudent_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectStudent_1.setBounds(133, 250, 182, 35);
		updateGrade.add(lblSelectStudent_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(133, 284, 139, 2);
		updateGrade.add(separator_4);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(305, 259, 156, 26);
		updateGrade.add(comboBox_6);
		
		addAttendance = new JPanel();
		addAttendance.setLayout(null);
		addAttendance.setPreferredSize(new Dimension(704, 430));
		addAttendance.setForeground(Color.WHITE);
		addAttendance.setBackground(Color.BLACK);
		addAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(addAttendance);
		
		JLabel lblSelectSection = new JLabel("Select Section");
		lblSelectSection.setForeground(Color.WHITE);
		lblSelectSection.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectSection.setBounds(133, 127, 182, 35);
		addAttendance.add(lblSelectSection);
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setForeground(Color.WHITE);
		lblSelectDate.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectDate.setBounds(133, 219, 217, 35);
		addAttendance.add(lblSelectDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(133, 161, 139, 2);
		addAttendance.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(133, 252, 139, 2);
		addAttendance.add(separator_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(305, 136, 156, 26);
		addAttendance.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(305, 228, 156, 26);
		addAttendance.add(comboBox_1);
		
		JLabel lblAddAttendance_1 = new JLabel("Add Attendance");
		lblAddAttendance_1.setForeground(Color.WHITE);
		lblAddAttendance_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddAttendance_1.setBounds(22, 13, 170, 35);
		addAttendance.add(lblAddAttendance_1);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(22, 46, 170, 2);
		addAttendance.add(separator_11);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(268, 306, 97, 25);
		addAttendance.add(btnNewButton);
		
								
		home = new JPanel();
		home.setBackground(Color.BLACK);
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		home.setLayout(null);
		
		JLabel label = new JLabel("UserImage");
		label.setIcon(new ImageIcon(StudentFrame.class.getResource("/images/user2.png")));
		label.setBounds(54, 71, 99, 152);
		home.add(label);
		
		JLabel label_2 = new JLabel("Profile");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(69, 25, 93, 16);
		home.add(label_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(70, 50, 61, 2);
		home.add(separator_2);

		viewDetails(new User("A", "B", new Date(1,2,3), "C", "D", "E", 'M', "F", "G"));
		
				
		
		manageAttendance = new JPanel();
		manageAttendance.setLayout(null);
		manageAttendance.setPreferredSize(new Dimension(704, 430));
		manageAttendance.setForeground(Color.WHITE);
		manageAttendance.setBackground(Color.BLACK);
		manageAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(manageAttendance);
		
		JLabel lblAddAttendance = new JLabel("Add Attendance");
		lblAddAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				
//				cs = Session.getUser().getCourseSections();
//				for (int i = 0; i < cs.size(); i++)
//				{
//					comboBox.addItem(cs.get(i).getCourse().getName() + cs.get(i).getSectionID() );
//				}
			}
		});
		lblAddAttendance.setForeground(Color.WHITE);
		lblAddAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddAttendance.setBounds(133, 90, 182, 35);
		manageAttendance.add(lblAddAttendance);
		
		JLabel lblUpdateAttendance = new JLabel("Update Attendance");
		lblUpdateAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
//				ArrayList<CourseSection> Session.getUser().getCourseSections();
				
				showPanel(evlbl.getText());
				
				//ArrayList<CourseSection> cs = Session.getUser().getCourseSections();
//				for (int i = 0; i < cs.size(); i++)
//				{
//					comboBox.addItem(cs.getCourse().getName());
//				}
				
				
			}
		});
		lblUpdateAttendance.setForeground(Color.WHITE);
		lblUpdateAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateAttendance.setBounds(133, 182, 217, 35);
		manageAttendance.add(lblUpdateAttendance);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageGrades = new JLabel("Update Grades");
		lblManageGrades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageGrades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

//				cs = Session.getUser().getCourseSections();
//				for (int i = 0; i < cs.size(); i++)
//				{
//					comboBox.addItem(cs.get(i).getCourse().getName() + cs.get(i).getSectionID() );
//				}

			}
		});
		lblManageGrades.setForeground(Color.WHITE);
		lblManageGrades.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageGrades.setBounds(57, 142, 182, 27);
		sidePanel.add(lblManageGrades);
		
		JLabel lblManageAttendance = new JLabel("Manage Attendance");
		lblManageAttendance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageAttendance.setForeground(Color.WHITE);
		lblManageAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageAttendance.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageAttendance);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HRFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 142, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HRFrame.class.getResource("/images/registration.png")));
		label_4.setBounds(12, 87, 40, 30);
		sidePanel.add(label_4);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(HRFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("Faculty Member");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
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
		label_6.setBounds(362, 0, 213, 152);
		topPanel.add(label_6);
		
		addContainers();
		
		for (int i = 1; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		
	}
	
	public void addContainers()
	{
		containers.add(home);
		containers.add(manageAttendance);
		containers.add(updateAttendance);
		containers.add(addAttendance);
		containers.add(updateGrade);
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
	
	public void fillSections()
	{
		
	}
}
