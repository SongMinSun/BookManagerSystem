import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class MemberJoinDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameTextField = null;
	private JPasswordField pwdTextField = null;
	public MemberJoinDialog() {
		setTitle("회원가입");
		setModal(true);
		setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        getContentPane().add(panel1);
        
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(new Color(221, 160, 221));
        panel1.add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new FlowLayout());
        panelCenter.add(new JLabel("name        "));
        nameTextField = new JTextField(20);
        panelCenter.add(nameTextField);
        panelCenter.add(new JLabel("password"));
        pwdTextField = new JPasswordField(20);
        panelCenter.add(pwdTextField);
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(221, 160, 221));
        panel1.add(panel2, BorderLayout.SOUTH);
        JButton okBtn = new JButton(Const.OK);
        okBtn.addActionListener(this);
        panel2.add(okBtn);
        JButton cancelBtn = new JButton(Const.CANCEL);
        cancelBtn.addActionListener(this);
        panel2.add(cancelBtn);
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose(); //���̾�α� ����
            }
        });
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(Const.OK)) {
			/* 1. name�� password�� ���� �ִ��� üũ�մϴ�. */
			if(nameTextField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "The name is empty");
				nameTextField.requestFocus();
			}
			else if(pwdTextField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "The password is empty");
				pwdTextField.requestFocus();
			}
			else
			{
				/* �����ͺ��̽��� ���� name�� �ִ��� üũ�մϴ�. */
				if( !Database.getInstance().checkName(nameTextField.getText()) ) {
					/* �����ͺ��̽��� ���� �Է��մϴ�. */
					Database.getInstance().insertMemberData(
							nameTextField.getText(),
							pwdTextField.getText());
					
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The name exists");
					//���� ���ԵǾ� �ִٸ� �޽����� ����ϰ� name�� password �ʵ带 ����ݴϴ�.
					nameTextField.setText("");
					pwdTextField.setText("");
					//name�� focus�� ǥ���մϴ�.
					nameTextField.requestFocus();
				}
			}
		}
		else if(e.getActionCommand().equals(Const.CANCEL)) {
			dispose();
		}
	}

}
