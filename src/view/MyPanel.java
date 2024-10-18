package view;

import javax.swing.JPanel;

public abstract class MyPanel extends JPanel {
	
	public abstract void updateFields();
	public abstract void save();
	public abstract void clear();
}
