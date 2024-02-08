package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import auth.Validation;
import courses.Courses;
import exception.InvalidFormat;
import exception.NullException;
import users.Instructor;
import users.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateAcc {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField phone;
	private JComboBox rolesSelect;
	private JComboBox course;
	private JButton btnCreate;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Create the application.
	 */
	public CreateAcc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 825, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
//		panel = amppnew JPanel();
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 0, 128));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		username = new JTextField();
		username.setBounds(27, 67, 211, 34);
		username.setToolTipText("");
		username.setColumns(10);
		username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		email = new JTextField();
		email.setBounds(300, 67, 207, 34);
		email.setToolTipText("");
		email.setColumns(10);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		password = new JPasswordField();
		password.setBounds(27, 191, 207, 34);
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		phone = new JTextField();
		phone.setBounds(300, 191, 207, 34);
		phone.setToolTipText("");
		phone.setColumns(10);
		phone.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		rolesSelect = new JComboBox(new Object[] { "Student", "Instructor" });
		rolesSelect.setBounds(574, 64, 207, 34);
		rolesSelect.setForeground(Color.BLACK);
		rolesSelect.setFont(new Font("Poppins", Font.PLAIN, 14));
		rolesSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rolesSelect.setBackground(new Color(248, 248, 248));

		ArrayList<Courses> cor = new ArrayList<Courses>();
		Courses c = new Courses();
		cor = c.getCourse();
		// cor.toArray();

		course = new JComboBox(new Object[] {});
		course.setBounds(574, 188, 207, 34);
		for (int i = 0; i < cor.size(); i++) {
			course.addItem(cor.get(i).course_name);
		}
		course.setForeground(Color.BLACK);
		course.setFont(new Font("Poppins", Font.PLAIN, 14));
		course.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		course.setBackground(new Color(248, 248, 248));

		Student s = new Student();
		btnCreate = new JButton("Create");
		btnCreate.setBounds(55, 385, 158, 65);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructor i = new Instructor();
				String uname = username.getText();
				String p = new String(password.getPassword());
				String em = email.getText();
				String ph = phone.getText();
				Validation v = new Validation();
				int courseId = c.getCourseId(course.getSelectedItem().toString());
				try {
					if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)){
						if(rolesSelect.getSelectedItem().equals("Student")) {
						s.studentRegister(uname,courseId, em, p, ph, 1);
						}else {
							i.addInstructor(uname, em, ph, p);
						}
					}
					
				} catch (NullException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				} catch (InvalidFormat ex1) {
					JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
				}

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.setBackground(new Color(117, 191, 67));

		btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(624, 385, 146, 65);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
			}
		});
		btnNewButton.setForeground(new Color(248, 248, 248));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(117, 191, 67));

		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setBounds(27, 24, 186, 22);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

		JLabel lblNewLabel_1_1 = new JLabel("Enter Email:");
		lblNewLabel_1_1.setBounds(300, 26, 152, 22);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

		JLabel lblNewLabel_1_2 = new JLabel("Enter Password:\r\n");
		lblNewLabel_1_2.setBounds(27, 136, 207, 22);
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

		JLabel lblNewLabel_1_3 = new JLabel("Enter Pnone Number:");
		lblNewLabel_1_3.setBounds(300, 136, 261, 22);
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

		lblNewLabel_2 = new JLabel("Select Role:");
		lblNewLabel_2.setBounds(614, 26, 139, 22);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

		lblNewLabel_3 = new JLabel("Select Course:");
		lblNewLabel_3.setBounds(591, 138, 190, 22);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		
		lblNewLabel_4 = new JLabel("*Note: Ignore for Teacher");
		lblNewLabel_4.setBounds(546, 246, 207, 22);
		lblNewLabel_4.setForeground(new Color(117, 191, 165));
		lblNewLabel_4.setFont(new Font("Poppins", Font.ITALIC, 9));
		panel_1.setLayout(null);
		panel_1.add(rolesSelect);
		panel_1.add(lblNewLabel_2);
		panel_1.add(phone);
		panel_1.add(password);
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(email);
		panel_1.add(username);
		panel_1.add(lblNewLabel_1);
		panel_1.add(lblNewLabel_1_2);
		panel_1.add(lblNewLabel_1_3);
		panel_1.add(btnCreate);
		panel_1.add(btnNewButton);
		panel_1.add(course);
		panel_1.add(lblNewLabel_3);
		panel_1.add(lblNewLabel_4);
		frame.setVisible(true);

		String[] roles = { "Teacher", "Student" };
	}
}
