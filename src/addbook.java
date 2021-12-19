import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addbook extends JFrame {
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
   

   
   
   public addbook() {
      setTitle("도서추가");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      getContentPane().setLayout(new FlowLayout());
      
      getContentPane().add(new JLabel("isbn         "));
      isbnField = new JTextField(20);
      getContentPane().add(isbnField);
      
      getContentPane().add(new JLabel("등록번호   ", JLabel.CENTER));
      numberField = new JTextField(20);
      getContentPane().add(numberField);
      
      getContentPane().add(new JLabel("저자         ", JLabel.CENTER));
      authorsField = new JTextField(20); 
      getContentPane().add(authorsField);
      
      getContentPane().add(new JLabel("제목        ", JLabel.CENTER));
      titleField = new JTextField(20); 
      getContentPane().add(titleField);
      
      getContentPane().add(new JLabel("출판사    ", JLabel.CENTER));
      publisherField = new JTextField(20); 
      getContentPane().add(publisherField);
      
      getContentPane().add(new JLabel("등록일    ", JLabel.CENTER));
      regist_dateField = new JTextField(20); 
      getContentPane().add(regist_dateField);
      

      JButton okButton = new JButton(Const.OK);
      okButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		Database.getInstance().insertBookData(isbnField.getText(), numberField.getText(), authorsField.getText(), titleField.getText(), publisherField.getText(), regist_dateField.getText(), 0);
			dispose();
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
      setSize(272, 450);
      setVisible(true);
   }
}