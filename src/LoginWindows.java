import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class LoginWindows extends JFrame {
	private static final long serialVersionUID = 1L;
	private LoginButtonListener buttonListener = null;
	
	
	private JTextField nameField = null;
	
	private JPasswordField passField = null;
	
	public JTextField getNameField() {
		return nameField;
	}
	public JPasswordField getPassField() {
		return passField;
	}
	
	public LoginWindows() {
		getContentPane().setBackground(new Color(221, 160, 221));
		buttonListener = new LoginButtonListener(this);
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new FlowLayout());
		JLabel label = new JLabel("이름         ");
		label.setForeground(new Color(255, 250, 250));
		getContentPane().add(label);
		
		nameField = new JTextField(20); 
		getContentPane().add(nameField);
		JLabel label_1 = new JLabel("비밀번호");
		label_1.setForeground(new Color(255, 250, 250));
		getContentPane().add(label_1);
		
		passField = new JPasswordField(20);
		getContentPane().add(passField);
		
		JButton okButton = new JButton(Const.OK);
		okButton.addActionListener(buttonListener);
		getContentPane().add(okButton);
		JButton cancelButton = new JButton(Const.CANCEL);
		cancelButton.addActionListener(buttonListener);
		getContentPane().add(cancelButton);
		JButton joinButton = new JButton(Const.JOIN);
		joinButton.addActionListener(buttonListener);
		getContentPane().add(joinButton);
		
		setLocationRelativeTo(null);
		setSize(300, 153);
		setVisible(true);
	}
}
