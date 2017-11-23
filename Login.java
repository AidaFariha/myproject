import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(66, 72, 97, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(66, 114, 97, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(180, 69, 173, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(180, 111, 173, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String pword = textField_1.getText();
				
				File inputFile = new File("UsernamePassword.txt");
			     
			     try {
			            Scanner in = new Scanner(new File("UsernamePassword.txt"));
			            while (in.hasNextLine())
			            {
			              String s = in.nextLine();  
			              String[] sArray = s.split(",");
			              
			              System.out.println(sArray[0]); //Just to verify that file is being read
			              System.out.println(sArray[1]);

			              
//			              if (username == sArray[0] && pword == sArray[1])
//			              {
//			                JOptionPane.showMessageDialog(null,
//			                    "Login Successful", "Success",
//			                    JOptionPane.INFORMATION_MESSAGE);
//			                	new MockLandingPage().setVisible(true);
//			              }
//			              else
//			              {
//			                JOptionPane.showMessageDialog(null,
//			                    "Invalid Username / Password Combo", "Error",
//			                    JOptionPane.ERROR_MESSAGE);
//			              }
			            }
			            
			            in.close();
			            
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null,
		                    "User Database Not Found", "Error",
		                    JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(222, 170, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(321, 170, 89, 23);
		contentPane.add(btnCancel);
	}
}
