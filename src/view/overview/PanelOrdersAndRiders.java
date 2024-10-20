package view.overview;

import java.awt.GridLayout;
import controller.Controller;
import model.Order;
import model.Rider;
import view.MyPanel;
import view.orders.PanelOrdersTable;
import view.riders.PanelRidersTable;

public class PanelOrdersAndRiders extends MyPanel {
	private Controller controller;
	private PanelOrdersTable ordersPanel;
	private PanelRidersTable ridersPanel;
	
	public PanelOrdersAndRiders() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(1,2));
		
		this.ordersPanel = new PanelOrdersTable();
		this.ridersPanel = new PanelRidersTable();
		
		this.getContentPane().add(ordersPanel);
		this.getContentPane().add(ridersPanel);
	}
	
	public PanelOrdersTable getOrdersPanel() {
		return this.ordersPanel;
	}
	
	public Order getSelectedOrder() {
		return this.ordersPanel.getTable().getSelected();
		
	}
	
	public Rider getSelectedRider() {
		return this.ridersPanel.getTable().getSelected();
	}
	
	public PanelRidersTable getRidersPanel() {
		return this.ridersPanel;
	}

	@Override
	public void updateFields() {
		this.ordersPanel.updateFields();
		this.ridersPanel.updateFields();
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
