package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import courses.CRUDCourse;
import exception.NullException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AddCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(173, 36, 96, 20);
		textField.setFont(new Font("Poppins", Font.PLAIN, 10));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name");
		lblNewLabel_1.setBounds(173, 16, 96, 14);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.setBounds(173, 117, 96, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDCourse c = new CRUDCourse();
				String cn = textField.getText();
				try {
					c.createCourse(cn);
				} catch (NullException e2) {
					JOptionPane.showMessageDialog(null, "Please Fill the Box");
				}
			}
		});
		panel_1.setLayout(null);
		btnNewButton.setBackground(new Color(117, 191, 64));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 10));
		panel_1.add(btnNewButton);
		panel_1.add(lblNewLabel_1);
		panel_1.add(textField);
	}
}
