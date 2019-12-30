package ultility;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.text.*;

/* This work is hereby released into the Public Domain.
 * To view a copy of the public domain dedication, visit
 * http://creativecommons.org/licenses/publicdomain/
 */
public class AutoCompletion extends PlainDocument {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JComboBox<?> comboBox;
	ComboBoxModel<?> model;
	JTextComponent editor;
	// flag to indicate if setSelectedItem has been called: Cờ để chỉ ra nếu setSelectedItem được gọi
	// subsequent calls to remove/insertString should be ignored : tiếp sau các lời gọi để xoá/sửaString nên bị lờ đi
	boolean selecting=false;
	boolean hidePopupOnFocusLoss;
	boolean hitBackspace=false;
	boolean hitBackspaceOnSelection;

	KeyListener editorKeyListener;
	FocusListener editorFocusListener;

	public AutoCompletion(JComboBox<?> comboBox) {
	    this.comboBox = comboBox;
	    model = comboBox.getModel();
	    comboBox.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (!selecting) highlightCompletedText(0);
	        }
	    });
	    comboBox.addPropertyChangeListener(new PropertyChangeListener() {
	        public void propertyChange(PropertyChangeEvent e) {
	            if (e.getPropertyName().equals("editor")) configureEditor((ComboBoxEditor) e.getNewValue());
	            if (e.getPropertyName().equals("model")) model = (ComboBoxModel<?>) e.getNewValue();
	        }
	    });
	    editorKeyListener = new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (comboBox.isDisplayable()) comboBox.setPopupVisible(true);
	            hitBackspace=false;
	            switch (e.getKeyCode()) {
	                // determine if the pressed key is backspace (needed by the remove method): xác định nếu phím backspace được ấn(cần thiết cho phương thức xoá)
	                case KeyEvent.VK_BACK_SPACE : hitBackspace=true;
	                hitBackspaceOnSelection=editor.getSelectionStart()!=editor.getSelectionEnd();
	                break;
	                // ignore delete key: lờ đi phím delete
	                case KeyEvent.VK_DELETE : e.consume();
	                comboBox.getToolkit().beep();
	                break;
	            }
	        }
	    };
	    // Bug 5100422 on Java 1.5: Editable JComboBox won't hide popup when tabbing out : Lỗi bản Java1.5(mình dùng đến 1.7 nên bỏ qua)
	    hidePopupOnFocusLoss=System.getProperty("java.version").startsWith("1.5");
	    // Highlight whole text when gaining focus: Đánh dấu cả đoạn text được chú ý tới
	    editorFocusListener = new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	            highlightCompletedText(0);
	        }
	        public void focusLost(FocusEvent e) {
	            // Workaround for Bug 5100422 - Hide Popup on focus loss: sửa lỗi popup bị ẩn khi việc chú ý bị gián đoạn
	            if (hidePopupOnFocusLoss) comboBox.setPopupVisible(false);
	        }
	    };
	    configureEditor(comboBox.getEditor());
	    // Handle initially selected object: Xử lý đối tượng đầu
	    Object selected = comboBox.getSelectedItem();
	    if (selected!=null) setText(selected.toString());
	    highlightCompletedText(0);
	}

	public static void enable(JComboBox<?> comboBox) {
	    // has to be editable: bắt buộc có thể chỉnh sửa
	    comboBox.setEditable(true);
	    // change the editor's document: thay đổi tài liệu của người sửa
	    new AutoCompletion(comboBox);
	}

	void configureEditor(ComboBoxEditor newEditor) {
	    if (editor != null) {
	        editor.removeKeyListener(editorKeyListener);
	        editor.removeFocusListener(editorFocusListener);
	    }
	
	    if (newEditor != null) {
	        editor = (JTextComponent) newEditor.getEditorComponent();
	        editor.addKeyListener(editorKeyListener);
	        editor.addFocusListener(editorFocusListener);
	        editor.setDocument(this);
	    }
	}

	public void remove(int offs, int len) throws BadLocationException {
	    // return immediately when selecting an item: trả lại ngay lập tức khi chọn item
	    if (selecting) return;
	    if (hitBackspace) {
	        // user hit backspace => move the selection backwards:Người dùng ấn backspace => di chuyển phần chọn ngược lại
	        // old item keeps being selected	=> item cũ vẫn tiếp tục được chọn
	        if (offs>0) {
	            if (hitBackspaceOnSelection) offs--;
	        } else {
	            // User hit backspace with the cursor positioned on the start => beep: Người dùng ấn backspace với con trỏ chỉ định vị trí đầu tiền => tiếng beep vang lên
	            comboBox.getToolkit().beep(); // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);	
	        }
	        highlightCompletedText(offs);
	    } else {
	        super.remove(offs, len);
	    }
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	    // return immediately when selecting an item: Trả lại ngay lập tức item được chọn
	    if (selecting) return;
	    // insert the string into the document: thêm chuỗi kí tự vào trong tài liệu
	    super.insertString(offs, str, a);
	    // lookup and select a matching item: tìm kiếm và lựa chọn item có tương đồng
	    Object item = lookupItem(getText(0, getLength()));
	    if (item != null) {
	        setSelectedItem(item);
	    } else {
	        // keep old item selected if there is no match: giữ lại item đã được chọn nếu không tìm thấy kết quả 
	        item = comboBox.getSelectedItem();
	        // imitate no insert (later on offs will be incremented by str.length(): selection won't move forward): giống với khi không thêm vào(sau đó trong offs sẽ được tăng thêm bởi str.length(): thanh lựa chọn không chuyển tiếp)
	        offs = offs-str.length();
	        // provide feedback to the user that his input has been received but can not be accepted: cung cấp phản hồn cho người dùng rằng dữ liệu nhập của anh ấy đã được nhận nhưng không được chấp nhận
	        comboBox.getToolkit().beep(); // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
	    }
	    setText(item.toString());
	    // select the completed part
	    highlightCompletedText(offs+str.length());
	}

	private void setText(String text) {
	    try {
	        // remove all text and insert the completed string: xoá toàn bộ văn bản và nhập vào một xâu hoàn chỉnh
	        super.remove(0, getLength());
	        super.insertString(0, text, null);
	    } catch (BadLocationException e) {
	        throw new RuntimeException(e.toString());
	    }
	}

	private void highlightCompletedText(int start) {
	    editor.setCaretPosition(getLength());
	    editor.moveCaretPosition(start);
	}

	private void setSelectedItem(Object item) {
	    selecting = true;
	    model.setSelectedItem(item);
	    selecting = false;
	}

	private Object lookupItem(String pattern) {
	    Object selectedItem = model.getSelectedItem();
	    // only search for a different item if the currently selected does not match: chỉ tìm kiếm các item khác nếu item được chọn hiện tại không khớp
	    if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), pattern)) {
	        return selectedItem;
	    } else {
	        // iterate over all items: lặp qua tất cả các item
	        for (int i=0, n=model.getSize(); i < n; i++) {
	            Object currentItem = model.getElementAt(i);
	            // current item starts with the pattern? : item hiện tại bắt đầu với một mẫu
	            if (currentItem != null && startsWithIgnoreCase(currentItem.toString(), pattern)) {
	                return currentItem;
	            }
	        }
	    }
	    // no item starts with the pattern => return null: nếu không có item nào bắt đầu với mẫu => trả về null
	    return null;
	}

// checks if str1 starts with str2 - ignores case: kiểm tra nếu str1 bắt đầu với str2
	private boolean startsWithIgnoreCase(String str1, String str2) {
	    return str1.toUpperCase().startsWith(str2.toUpperCase());
	}

	//test thử không cần quan tâm
	private static void createAndShowGUI() {
	    // the combo box (add/modify items if you like to)
	    final JComboBox<Object> comboBox = new JComboBox<Object>(new Object[] {"Chu Viet Quang", "Le Huy Nhat", "Jordan", "Hảo Bình", "Gao"});
	    enable(comboBox);
	
	    // create and show a window containing the combo box
	    final JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(3);
	    frame.setSize(240, 320);
	    frame.getContentPane().add(comboBox);
	    frame.pack(); 
	    frame.setVisible(true);
	}


	public static void main(String[] args) {
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            createAndShowGUI();
	        }
	    });
	}
}
