package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterYourId;
	private JTextField txtEnterYourPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(97, 212, 195));
		panel.setBounds(0, 0, 297, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSchool = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblSchool.setBounds(12, 43, 273, 60);
		panel.add(lblSchool);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/school2.png")));
		label.setBounds(12, 132, 273, 200);
		panel.add(label);
		//ImageIcon img = new ImageIcon(MainActivity.class.getResource("/images/school2"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,47,65));
		panel_1.setBounds(295, 0, 317, 444);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtEnterYourId = new JTextField();
		txtEnterYourId.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtEnterYourId.setText("Enter your ID/Roll Number");
		txtEnterYourId.setForeground(Color.WHITE);
		txtEnterYourId.setBackground(new Color(36,47,65));
		txtEnterYourId.setBounds(79, 149, 175, 22);
		txtEnterYourId.setBorder(null);
		panel_1.add(txtEnterYourId);
		txtEnterYourId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(79, 114, 141, 22);
		panel_1.add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(79, 209, 141, 22);
		panel_1.add(lblPassword);
		
		txtEnterYourPassword = new JTextField();
		txtEnterYourPassword.setText("Enter your password");
		txtEnterYourPassword.setForeground(Color.WHITE);
		txtEnterYourPassword.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtEnterYourPassword.setColumns(10);
		txtEnterYourPassword.setBorder(null);
		txtEnterYourPassword.setBackground(new Color(36,47,65));
		txtEnterYourPassword.setBounds(79, 244, 129, 22);
		panel_1.add(txtEnterYourPassword);
		
		JLabel lblSignIn = new JLabel("SIGN IN");
		lblSignIn.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setBounds(105, 13, 129, 33);
		panel_1.add(lblSignIn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(79, 173, 175, 10);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(79, 266, 175, 10);
		panel_1.add(separator_1);
		
		JButton btnNewButton = new JButton("Staff Login");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(97, 212, 195));
		btnNewButton.setBounds(170, 307, 116, 48);
		panel_1.add(btnNewButton);
		
		JButton btnStudetLogin = new JButton("Student Login");
		btnStudetLogin.setForeground(Color.BLACK);
		btnStudetLogin.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnStudetLogin.setBackground(new Color(97, 212, 195));
		btnStudetLogin.setBounds(34, 307, 126, 48);
		panel_1.add(btnStudetLogin);
	}
}
