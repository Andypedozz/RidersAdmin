package view.orders;

import view.MyPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import controller.Controller;
import model.Order;

public class PanelOrderDett extends MyPanel {
	private Controller controller;
	private PanelOrderDettGeneral panelOrder;
	private PanelOrderDettProducts panelProducts;
	
	public PanelOrderDett() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(1,2));
		this.panelOrder = new PanelOrderDettGeneral();
		this.panelProducts = new PanelOrderDettProducts();
		getContentPane().add(panelOrder);
		getContentPane().add(panelProducts);
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
		panelOrder.clear();
		panelProducts.clear();
	}

	public void loadData(Order order) {
		this.panelOrder.loadData(order);
		this.panelProducts.loadData(order);
		this.revalidate();
	}

}
