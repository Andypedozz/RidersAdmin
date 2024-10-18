package view.overview;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

public class ConsolePanel extends JPanel {

	private static final String CONSOLE = "CONSOLE: ";
	
	private JToolBar toolBar;
	private JButton clearBtn;
	private JTextArea textArea;
	
	public ConsolePanel() {
		setLayout(new BorderLayout(0, 0));
		
		// TITLE
		JLabel title = new JLabel("Console");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title, BorderLayout.NORTH);
		
		// CENTER
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane, BorderLayout.CENTER);
		
		// TOOLBAR
		toolBar = new JToolBar();
		add(toolBar, BorderLayout.SOUTH);
		
		clearBtn = new JButton("Clear");
		toolBar.add(clearBtn);
		initListeners();
	}
	
	private void initListeners() {
		this.clearBtn.addActionListener(e -> {
			clear();
		});
	}
	
	public void append(String message) {
		this.textArea.setText(this.textArea.getText() + "\n" + CONSOLE + message);
	}
	
	public void clear() {
		this.textArea.setText("");
	}
}
