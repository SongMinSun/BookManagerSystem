
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Start extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Start() {

		setTitle("도서관리 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton cancelButton = new JButton("종료");
		cancelButton.setBounds(172, 180, 108, 36);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		contentPane.setLayout(null);
		getContentPane().add(cancelButton);
		JButton loginButton = new JButton("로그인");
		loginButton.setBounds(172, 134, 108, 36);
		getContentPane().add(loginButton);
		
		JLabel lblNewLabel = new JLabel("도서관리 시스템");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		lblNewLabel.setBounds(123, 68, 224, 46);
		contentPane.add(lblNewLabel);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginWindows();
				setVisible(false);
			}
		});

		
	

		
	
		
		setLocationRelativeTo(null);
		setVisible(true);
		

	}
}