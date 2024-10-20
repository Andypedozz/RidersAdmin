package view.orders;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Controller;
import model.Order;
import view.MyPanel;

public class PanelOrders extends MyPanel {
	private Controller controller;
	private PanelOrderDett panelDett;
	private PanelOrdersTable panelTable;
	
	public PanelOrders() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.panelDett = new PanelOrderDett();
		this.panelTable = new PanelOrdersTable();
		this.getContentPane().add(panelDett);
		this.getContentPane().add(panelTable);
		initListeners();
	}
	
	private void initListeners() {
		this.panelTable.getTable().addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				Order order = panelTable.getTable().getSelected();
				if(order != null) {
					order = controller.getOrders().get(order.getId());
					panelDett.loadData(order);
				}
			}
		
		});
	}
	
	@Override
	public void updateFields() {
		this.panelTable.updateFields();
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
