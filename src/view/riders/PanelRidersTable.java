package view.riders;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import controller.Controller;
import model.Rider;
import view.MyPanel;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PanelRidersTable extends MyPanel {
	private Controller controller;
	private RidersTable table;
	private JButton viewInfo;

	public PanelRidersTable( ) {
		this.controller = Controller.getInstance();
		this.setTitle("Riders");
		this.getContentPane().setLayout(new BorderLayout());
    	
		table = new RidersTable();
		
    	table.getTableHeader().setReorderingAllowed(false);
    	table.setColumnSelectionAllowed(false);
    	table.setCellSelectionEnabled(false);
    	table.setRowSelectionAllowed(true);
    	
    	
    	JScrollPane scrollPane = new JScrollPane(table);
		
		JToolBar toolbar = new JToolBar();
		viewInfo = new JButton("Info");
		viewInfo.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(toolbar, BorderLayout.SOUTH);
    }
	
	public RidersTable getTable() {
		return this.table;
	}

	@Override
	public void updateFields() {
		HashMap<Integer,Rider> riders = controller.getRiders();
		List<Rider> list = new LinkedList<Rider>();
		riders.forEach((id,rider) -> {
			list.add(rider);
		});
		this.table.loadRows(list);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
