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
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.table.TableModel;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

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
					StudentFrame frame = new StudentFrame();
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
	public StudentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
						
						JPanel home = new JPanel();
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
						
						JLabel label_7 = new JLabel("Ehtisham-Ul-Haq");
						label_7.setForeground(Color.WHITE);
						label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_7.setBounds(54, 254, 175, 27);
						home.add(label_7);
						
						JSeparator separator_3 = new JSeparator();
						separator_3.setBounds(55, 285, 61, 2);
						home.add(separator_3);
						
						JSeparator separator_4 = new JSeparator();
						separator_4.setBounds(55, 325, 61, 2);
						home.add(separator_4);
						
						JLabel label_8 = new JLabel("0900-78601");
						label_8.setForeground(Color.WHITE);
						label_8.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_8.setBounds(54, 294, 175, 27);
						home.add(label_8);
						
						JLabel label_9 = new JLabel("princess_sid@gmail.com");
						label_9.setForeground(Color.WHITE);
						label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_9.setBounds(54, 336, 205, 27);
						home.add(label_9);
						
						JSeparator separator_5 = new JSeparator();
						separator_5.setBounds(55, 367, 61, 2);
						home.add(separator_5);
						
						JSeparator separator_6 = new JSeparator();
						separator_6.setBounds(55, 407, 61, 2);
						home.add(separator_6);
						
						JLabel label_10 = new JLabel("H#666, Street 1, Road 5, Lahore");
						label_10.setForeground(Color.WHITE);
						label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_10.setBounds(54, 376, 239, 27);
						home.add(label_10);
						
						JSeparator separator_7 = new JSeparator();
						separator_7.setBounds(402, 407, 61, 2);
						home.add(separator_7);
						
						JLabel label_11 = new JLabel("Gender: M");
						label_11.setForeground(Color.WHITE);
						label_11.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_11.setBounds(401, 376, 175, 27);
						home.add(label_11);
						
						JLabel label_12 = new JLabel("DOB: 15/11/1996");
						label_12.setForeground(Color.WHITE);
						label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_12.setBounds(401, 336, 175, 27);
						home.add(label_12);
						
						JSeparator separator_8 = new JSeparator();
						separator_8.setBounds(402, 367, 61, 2);
						home.add(separator_8);
						
						JSeparator separator_9 = new JSeparator();
						separator_9.setBounds(402, 325, 61, 2);
						home.add(separator_9);
						
						JLabel label_13 = new JLabel("CNIC: 35201-8327761-9");
						label_13.setForeground(Color.WHITE);
						label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_13.setBounds(401, 294, 175, 27);
						home.add(label_13);
						
						JSeparator separator_10 = new JSeparator();
						separator_10.setBounds(402, 285, 61, 2);
						home.add(separator_10);
						
						JLabel label_14 = new JLabel("Emergency: 03224077810");
						label_14.setForeground(Color.WHITE);
						label_14.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						label_14.setBounds(401, 254, 192, 27);
						home.add(label_14);
						
						JPanel transcript = new JPanel();
						transcript.setBackground(Color.BLACK);
						transcript.setBounds(249, 152, 704, 442);
						contentPane.add(transcript);
						transcript.setLayout(null);
						
						JSeparator separator_11 = new JSeparator();
						separator_11.setBounds(264, 41, 121, 2);
						transcript.add(separator_11);
						
						JLabel lblAttendance = new JLabel("Transcript");
						lblAttendance.setForeground(Color.WHITE);
						lblAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 25));
						lblAttendance.setBounds(264, 13, 147, 27);
						transcript.add(lblAttendance);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
						scrollPane.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						scrollPane.setForeground(Color.WHITE);
						scrollPane.setBackground(Color.WHITE);
						scrollPane.setBounds(12, 150, 630, 112);
						scrollPane.getViewport().setBackground(Color.BLACK);
						
								transcript.add(scrollPane);
								
								table = new JTable(new DefaultTableModel(
									new Object[][] {
										{"CS 101", "ITC", "P", "A", "4"},
										{"MT 201", "Linear Algebra", "P", "A", "4"},
										{"MT203", "Calculus", "P", "B", "3"},
										{"SS101", "Sociology", "A", "B+", "3.3"},
										{"SS102", "Psychology", "P", "A", "4"},
									},
									new String[] {
										"Code", "Course Name", "Crd Hrs", "Grade", "Points"
									}
								));
								table.setGridColor(Color.LIGHT_GRAY);
								scrollPane.setViewportView(table);
								table.setForeground(Color.WHITE);
								table.setFont(new Font("Century Gothic", Font.PLAIN, 15));
								table.setBackground(Color.BLACK);
								
								JLabel lblPsychology = new JLabel("FALL 2017");
								lblPsychology.setForeground(Color.WHITE);
								lblPsychology.setFont(new Font("Century Gothic", Font.BOLD, 20));
								lblPsychology.setBounds(12, 101, 103, 41);
								transcript.add(lblPsychology);
								
								JLabel lblGpa = new JLabel("GPA: 3.8");
								lblGpa.setForeground(Color.WHITE);
								lblGpa.setFont(new Font("Century Gothic", Font.PLAIN, 15));
								lblGpa.setBounds(161, 118, 84, 27);
								transcript.add(lblGpa);
								
								JLabel lblCgpa = new JLabel("CGPA: 3.8");
								lblCgpa.setForeground(Color.WHITE);
								lblCgpa.setFont(new Font("Century Gothic", Font.PLAIN, 15));
								lblCgpa.setBounds(257, 118, 98, 27);
								transcript.add(lblCgpa);
								
								JLabel lblCrAttempted = new JLabel("Cr. Attempted : 19");
								lblCrAttempted.setForeground(Color.WHITE);
								lblCrAttempted.setFont(new Font("Century Gothic", Font.PLAIN, 15));
								lblCrAttempted.setBounds(364, 118, 170, 27);
								transcript.add(lblCrAttempted);
								
								JLabel lblCrEarned = new JLabel("Cr. Earned: 19");
								lblCrEarned.setForeground(Color.WHITE);
								lblCrEarned.setFont(new Font("Century Gothic", Font.PLAIN, 15));
								lblCrEarned.setBounds(525, 117, 126, 27);
								transcript.add(lblCrEarned);
								scrollPane.getViewport().setBackground(Color.BLACK);
						
						JPanel attendence = new JPanel();
						attendence.setLayout(null);
						attendence.setBackground(Color.BLACK);
						attendence.setBounds(249, 152, 704, 442);
						contentPane.add(attendence);
						
						JSeparator separator_12 = new JSeparator();
						separator_12.setBounds(264, 41, 147, 2);
						attendence.add(separator_12);
						
						JLabel label_15 = new JLabel("Attendance");
						label_15.setForeground(Color.WHITE);
						label_15.setFont(new Font("Century Gothic", Font.PLAIN, 25));
						label_15.setBounds(264, 13, 147, 27);
						attendence.add(label_15);
						
						JScrollPane scrollPane_2 = new JScrollPane();
						scrollPane_2.setForeground(Color.WHITE);
						scrollPane_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						scrollPane_2.setBackground(Color.WHITE);
						scrollPane_2.setAlignmentX(0.0f);
						scrollPane_2.setBounds(37, 150, 292, 98);
						scrollPane_2.getViewport().setBackground(Color.BLACK);

						attendence.add(scrollPane_2);
						
						table_1 = new JTable();
						table_1.setForeground(Color.WHITE);
						table_1.setBackground(Color.BLACK);
						table_1.setModel(new DefaultTableModel(
							new Object[][] {
								{null, null, null},
								{null, null, null},
								{null, null, null},
								{null, null, null},
							},
							new String[] {
								"Date", "Lecture #", "Attendance"
							}
						));
						scrollPane_2.setViewportView(table_1);
						
						JLabel label_16 = new JLabel("Psychology - D");
						label_16.setForeground(Color.WHITE);
						label_16.setFont(new Font("Century Gothic", Font.BOLD, 20));
						label_16.setBounds(38, 110, 208, 41);
						attendence.add(label_16);
				
						JPanel timetable = new JPanel();
						timetable.setBackground(Color.BLACK);
						timetable.setBounds(249, 152, 704, 442);
						contentPane.add(timetable);
						timetable.setLayout(null);
						
						JLabel lblProfile = new JLabel("Timetable\r\n\r\n");
						lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 25));
						lblProfile.setForeground(Color.WHITE);
						lblProfile.setBounds(85, 23, 123, 27);
						timetable.add(lblProfile);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(85, 51, 123, 2);
						timetable.add(separator);
						
						JLabel lblEhtishamulhaq = new JLabel("Choose timetable:");
						lblEhtishamulhaq.setForeground(Color.WHITE);
						lblEhtishamulhaq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						lblEhtishamulhaq.setBounds(70, 127, 175, 27);
						timetable.add(lblEhtishamulhaq);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(70, 152, 137, 2);
						timetable.add(separator_1);
						
						JComboBox comboBox = new JComboBox();
						comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						comboBox.setBounds(237, 130, 221, 30);
						comboBox.addItem("Computer Science");
						comboBox.addItem("Engineering");
						comboBox.addItem("Mathematics");
						comboBox.addItem("Humanities and Social Sciences");
						comboBox.addItem("Law");
						timetable.add(comboBox);
						
						timetable.setVisible(false);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageStudents = new JLabel("Transcript");
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(57, 142, 182, 27);
		sidePanel.add(lblManageStudents);
		
		JLabel lblManageCourses = new JLabel("Attendence");
		lblManageCourses.setForeground(Color.WHITE);
		lblManageCourses.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageCourses.setBounds(57, 199, 182, 27);
		sidePanel.add(lblManageCourses);
		
		JLabel lblManageRegistrations = new JLabel("Timetable");
		lblManageRegistrations.setForeground(Color.WHITE);
		lblManageRegistrations.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageRegistrations.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageRegistrations);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HRFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 142, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(HRFrame.class.getResource("/images/course2.png")));
		label_3.setBounds(12, 199, 40, 32);
		sidePanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HRFrame.class.getResource("/images/registration.png")));
		label_4.setBounds(12, 87, 40, 30);
		sidePanel.add(label_4);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(HRFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("Student");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("");
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
	}
}
