import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search extends JFrame {
   private static final long serialVersionUID = 1L;
   

   private JTextField idField = null;
   private JTextField isbnField = null;
   private JTextField numberField = null;
   private JTextField authorsField = null;
   private JTextField titleField = null;
   private JTextField publisherField = null;
   private JTextField book_dateField = null;
   private JCheckBox statusField = null;
   private JTextField regist_dateField = null;
   
   public JTextField getIdField() {
      return idField;
   }
   public JTextField getisbnField() {
      return isbnField;
   }
   public JTextField getnumberField() {
      return numberField;
   }
   public JTextField getauthorField() {
      return authorsField;
   }
   public JTextField gettitleField() {
      return titleField;
   }
   public JTextField getpublisherField() {
      return publisherField;
   }
   public JTextField getbook_dateField() {
      return book_dateField;
   }
   public JCheckBox getstattusField() {
      return statusField;
   }
   public JTextField getregist_dateField() {
      return regist_dateField;
   }
   

   
   
   public search(DefaultTableModel model,MainFrame mainWindow, MenuActionListener ma) {
      setTitle("도서찾기");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      getContentPane().setLayout(new FlowLayout());
      
      getContentPane().add(new JLabel("저자         ", JLabel.CENTER));
      authorsField = new JTextField(20); 
      getContentPane().add(authorsField);
      
      getContentPane().add(new JLabel("제목        ", JLabel.CENTER));
      titleField = new JTextField(20); 
      getContentPane().add(titleField);
      
      getContentPane().add(new JLabel("출판사    ", JLabel.CENTER));
      publisherField = new JTextField(20); 
      getContentPane().add(publisherField);
      

      JButton okButton = new JButton(Const.OK);
      okButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		Database.getInstance().searchbook(model,authorsField.getText(),titleField.getText(),publisherField.getText());
			dispose();
			
			mainWindow.revalidate();
			mainWindow.repaint();
      	}
      });
      getContentPane().add(okButton);
      JButton cancelButton = new JButton(Const.CANCEL);
      cancelButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dispose();
      	}
      });
      getContentPane().add(cancelButton);
      
      setLocationRelativeTo(null);
      setSize(272, 250);
      setVisible(true);
   }
}