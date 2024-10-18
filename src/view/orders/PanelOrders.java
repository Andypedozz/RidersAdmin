package view.orders;

import java.awt.GridLayout;

import controller.Controller;
import view.MyPanel;

public class PanelOrders extends MyPanel {
	private Controller controller;
	private PanelOrderDett panelDett;
	private PanelOrdersTable panelTable;
	
	public PanelOrders() {
		this.controller = Controller.getInstance();
		this.setLayout(new GridLayout(2,1));
		this.panelDett = new PanelOrderDett();
		this.panelTable = new PanelOrdersTable();
		this.add(panelDett);
		this.add(panelTable);
	}
	
	@Override
	public void updateFields() {
		// TODO Auto-generated method stub
		
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
