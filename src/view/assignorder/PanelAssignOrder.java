package view.assignorder;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Controller;
import model.Order;
import model.Rider;
import view.MyPanel;
import view.overview.PanelOrdersAndRiders;

public class PanelAssignOrder extends MyPanel {
	private Controller controller;
	private PanelOrdersAndRiders panelOrdersAndRiders;
	private PanelOrdersRidersTable panelOrdersRidersTable;
	
	public PanelAssignOrder() {
		this.setTitle("Assegnazione ordini");
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.panelOrdersAndRiders = new PanelOrdersAndRiders();
		this.panelOrdersRidersTable = new PanelOrdersRidersTable();
		this.getContentPane().add(panelOrdersAndRiders);
		this.getContentPane().add(panelOrdersRidersTable);
		updateFields();
		initListeners();
	}
	
	private void initListeners() {
		
		this.panelOrdersAndRiders.getRidersPanel().getTable().addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				Rider rider = panelOrdersAndRiders.getRidersPanel().getTable().getSelected();
				if(rider != null) {
					rider = controller.getRiders().get(rider.getId());
					panelOrdersRidersTable.loadData(rider);
				}
			}
			
		});
		
		this.panelOrdersRidersTable.getRemoveOrder().addActionListener(e -> {
			Order order = panelOrdersRidersTable.getTable().getSelected();
			Rider rider = panelOrdersAndRiders.getSelectedRider();
			if(order != null && rider != null) {
				order = controller.getOrders().get(order.getId());
				rider = controller.getRiders().get(rider.getId());
				rider.removeOrder(order);
				panelOrdersRidersTable.loadData(rider);
			}
		});
		
		this.panelOrdersAndRiders.getOrdersPanel().getAssignOrderBtn().addActionListener(e -> {
			Order order = panelOrdersAndRiders.getSelectedOrder();
			Rider rider = panelOrdersAndRiders.getSelectedRider();
			if(order != null && rider != null) {
				order = controller.getOrders().get(order.getId());
				rider = controller.getRiders().get(rider.getId());
				rider.assignOrder(order);
				panelOrdersRidersTable.loadData(rider);
			}
		});
		
		this.panelOrdersAndRiders.getOrdersPanel().getUpdateOrdersBtn().addActionListener(e -> {
			controller.loadOrders();
			updateFields();
		});
	}
	
	@Override
	public void updateFields() {
		this.panelOrdersAndRiders.getRidersPanel().updateFields();
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
