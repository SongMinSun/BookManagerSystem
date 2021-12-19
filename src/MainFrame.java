import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도서관리 시스템");
		setSize(800, 500);
		
		createMenu();
		
		setVisible(true);
		
		setLocationRelativeTo(null);
	}
	
	private void createMenu() {
		
		JMenuBar mb = new JMenuBar();
		mb.setBackground(new Color(221, 160, 221));
		JMenu personMenu = new JMenu("설정");
		JMenu BookMenu = new JMenu("도서");
		JMenuItem searchMenuItem = new JMenuItem("도서찾기");
		JMenuItem loginMenuItem = new JMenuItem("로그인");
		JMenuItem logoutMenuItem = new JMenuItem("로그아웃");
		JMenuItem MyBookMenuItem = new JMenuItem("마이페이지");
		JMenuItem AddBookMenuItem = new JMenuItem("도서추가");
		JMenuItem BookListMenuItem = new JMenuItem("도서목록");
		JMenuItem DelBookMenuItem = new JMenuItem("도서목록 지우기");
		JMenuItem BorBookMenuItem = new JMenuItem("대출");
		JMenuItem RetBookMenuItem = new JMenuItem("반납");
		personMenu.add(loginMenuItem);
		personMenu.add(logoutMenuItem);
		personMenu.add(MyBookMenuItem);
		BookMenu.add(AddBookMenuItem);
		BookMenu.add(BookListMenuItem);
		BookMenu.add(DelBookMenuItem);
		BookMenu.add(BorBookMenuItem);
		BookMenu.add(RetBookMenuItem);
		BookMenu.add(searchMenuItem);




		
		JMenu memberMenu = new JMenu("회원");
		JMenuItem membersMenuItem = new JMenuItem("회원목록");
		memberMenu.add(membersMenuItem);
		
		mb.add(personMenu);
		mb.add(memberMenu);
		mb.add(BookMenu);
		
		MenuActionListener menuListener = new MenuActionListener(this);
		membersMenuItem.addActionListener(menuListener);
		AddBookMenuItem.addActionListener(menuListener);
		BookListMenuItem.addActionListener(menuListener);
		loginMenuItem.addActionListener(menuListener);
		logoutMenuItem.addActionListener(menuListener);
		DelBookMenuItem.addActionListener(menuListener);
		BorBookMenuItem.addActionListener(menuListener);
		MyBookMenuItem.addActionListener(menuListener);
		RetBookMenuItem.addActionListener(menuListener);
		searchMenuItem.addActionListener(menuListener);



		setJMenuBar(mb);
	}
}
