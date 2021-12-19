import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuActionListener implements ActionListener {

	private MainFrame mainWindow = null;
	private JTable table = null;
	private JTable table2 = null;
	private JScrollPane scroll = null;
	private JScrollPane scroll2 = null;
	JPanel myPanel = new JPanel();
	JPanel delPanel = new JPanel();
	JPanel borPanel = new JPanel();
	JPanel retPanel = new JPanel();
	private JTextField ret_input = new JTextField(10);
	private JTextField bor_input = new JTextField(10);
	private JTextField del_input = new JTextField(10);
	private JTextField book_isbn = new JTextField(10);
	private JTextField book_number = new JTextField(10);
	private JTextField book_authors = new JTextField(10);
	private JTextField book_title = new JTextField(10);
	private JTextField book_publisher = new JTextField(10);
	private JTextField book_date = new JTextField(10);
	private JTextField book_regist_dateregist_date = new JTextField(10);
	public MenuActionListener(MainFrame mainWindow) {
		retPanel.add(new JLabel("ISBN: "));
		retPanel.add(ret_input);
		borPanel.add(new JLabel("ISBN: "));
		borPanel.add(bor_input);
		delPanel.add(new JLabel("ISBN: "));
		delPanel.add(del_input);
		this.mainWindow = mainWindow;
		//createTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("회원목록"))
		{
			System.out.println("members... ok");
			createTable();
			DefaultTableModel model= (DefaultTableModel)table.getModel();
			Database.getInstance().insertJTable(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("도서추가")) {
			new addbook();
		}
		if(e.getActionCommand().equals("도서목록")) {
			System.out.println("Book List... ok");
			createTable2();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			Database.getInstance().insertJTable2(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("로그인")) {
			mainWindow.dispose();
			new LoginWindows();
		}
		if(e.getActionCommand().equals("로그아웃")) {
			int dialogResult = JOptionPane.showConfirmDialog (null,
					"Would you like to Logout?",
					"Warning",
					JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
					 // code here
						mainWindow.dispose();
						new LoginWindows();
					}
		}
		if(e.getActionCommand().equals("도서목록 지우기")) {
			int result =JOptionPane.showConfirmDialog(null, delPanel,"ISBN을 입력해주세요.", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				Database.getInstance().delbook(del_input.getText());				
			}
			createTable2();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			Database.getInstance().insertJTable2(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("대출")) {
			int result =JOptionPane.showConfirmDialog(null, borPanel,"ISBN을 입력해주세요.", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				Database.getInstance().borbook(bor_input.getText());				
			}
			createTable2();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			Database.getInstance().insertJTable2(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("마이페이지")) {
			createTable3();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			Database.getInstance().insertJTable3(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("반납")) {
			int result =JOptionPane.showConfirmDialog(null, retPanel,"ISBN을 입력해주세요.", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				Database.getInstance().retbook(ret_input.getText());				
			}
			createTable3();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			Database.getInstance().insertJTable3(model);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		if(e.getActionCommand().equals("도서찾기")) {
			
			createTable2();
			DefaultTableModel model= (DefaultTableModel)table2.getModel();
			new search(model,mainWindow,this);
	
		}
	}
	
	private void createTable() {
		String []header = {"id", "name", "password"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		table = new JTable(model);
		if(scroll2 != null) {
			mainWindow.remove(scroll2);
		}
		if(scroll != null) {
			mainWindow.remove(scroll);
		}
		scroll = new JScrollPane(table);
		mainWindow.add(scroll);
	}
	
	public void createTable2() {
		String []header = {"id", "ISBN", "등록번호","책의 저자", "책의 제목","출판사","출판일","대출 상태","등록일"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		table2 = new JTable(model);
		if(scroll2 != null) {
			mainWindow.remove(scroll2);
		}
		if(scroll != null) {
			mainWindow.remove(scroll);
		}
		scroll2 = new JScrollPane(table2);
		mainWindow.add(scroll2);     
	}
	private void createTable3() {
		String []header = {"ISBN","책의 저자", "책의 제목","출판사"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		table2 = new JTable(model);
		if(scroll2 != null) {
			mainWindow.remove(scroll2);
		}
		if(scroll != null) {
			mainWindow.remove(scroll);
		}
		scroll2 = new JScrollPane(table2);
		mainWindow.add(scroll2);     
	}

	
}
